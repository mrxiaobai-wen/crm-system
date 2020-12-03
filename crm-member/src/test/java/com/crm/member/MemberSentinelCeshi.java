package com.crm.member;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemberSentinelCeshi {

    public static void main(String[] args) {
        // 临时解决方案，关闭HttpClient中的debug日志
        Set<String> loggers = new HashSet<>(Arrays.asList("org.apache.http"));
        for (String log : loggers) {
            Logger logger = (Logger) LoggerFactory.getLogger(log);
            logger.setLevel(Level.INFO);
        }

        long MILLIS = 1000;
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8081/member/getByIdAndControlFlow/1");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 5;i++) {
                    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
                        CloseableHttpResponse response = httpClient.execute(httpGet);
                        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                        System.out.println("请求结果------->"
                                                   + " time = " + (System.currentTimeMillis())
                                                   + " status = " + response.getStatusLine()
                                                   + " content = " + content);
                    } catch (Exception e) {
                        System.out.println((System.currentTimeMillis() / MILLIS) + "-" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        };
        System.out.println("请求结果-------> time = " + System.currentTimeMillis());
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
