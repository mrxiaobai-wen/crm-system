package com.crm.member.dao;

import com.crm.member.service.pojo.MemberVO;
import org.springframework.stereotype.Repository;

import static com.crm.member.db.Tables.MEMBER;

/**
 * 会员数据库层
 */
@Repository
public class MemberDao extends BaseDao {

    /**
     * 查询指定ID会员
     */
    public MemberVO getById(Integer memberId) {
        return db.selectFrom(MEMBER)
                .where(MEMBER.ID.eq(memberId))
                .fetchOneInto(MemberVO.class);
    }
}
