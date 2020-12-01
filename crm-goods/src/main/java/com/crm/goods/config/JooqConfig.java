package com.crm.goods.config;

import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * jooq配置
 */
@Configuration
@EnableConfigurationProperties({JooqProperties.class})
public class JooqConfig {

    public JooqConfig() {

    }

    @Bean
    public DefaultDSLContext dslContext(org.jooq.Configuration configuration) {
        org.jooq.Configuration configuration1 = new DefaultConfiguration()
                .set(configuration.connectionProvider())
                .set(configuration.dialect());
        return new DefaultDSLContext(configuration1);
    }

    @Bean
    @ConditionalOnMissingBean({org.jooq.Configuration.class})
    public DefaultConfiguration jooqConfiguration(JooqProperties properties, ConnectionProvider connectionProvider,
            DataSource dataSource, ObjectProvider<TransactionProvider> transactionProvider,
            ObjectProvider<RecordMapperProvider> recordMapperProvider,
            ObjectProvider<RecordUnmapperProvider> recordUnmapperProvider, ObjectProvider<Settings> settings,
            ObjectProvider<RecordListenerProvider> recordListenerProviders,
            ObjectProvider<ExecuteListenerProvider> executeListenerProviders,
            ObjectProvider<VisitListenerProvider> visitListenerProviders,
            ObjectProvider<TransactionListenerProvider> transactionListenerProviders,
            ObjectProvider<ExecutorProvider> executorProvider) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(properties.determineSqlDialect(dataSource));
        configuration.set(connectionProvider);
        transactionProvider.ifAvailable(configuration::set);
        recordMapperProvider.ifAvailable(configuration::set);
        recordUnmapperProvider.ifAvailable(configuration::set);
        settings.ifAvailable(configuration::set);
        executorProvider.ifAvailable(configuration::set);
        configuration.set(recordListenerProviders.orderedStream().toArray(
                RecordListenerProvider[]::new));
        configuration.set(executeListenerProviders.orderedStream().toArray(
                ExecuteListenerProvider[]::new));
        configuration.set(visitListenerProviders.orderedStream().toArray(
                VisitListenerProvider[]::new));
        configuration.setTransactionListenerProvider(
                transactionListenerProviders.orderedStream().toArray(
                        TransactionListenerProvider[]::new));
        return configuration;
    }
}
