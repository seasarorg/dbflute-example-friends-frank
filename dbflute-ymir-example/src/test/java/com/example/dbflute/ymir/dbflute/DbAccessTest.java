package com.example.dbflute.ymir.dbflute;

import java.util.List;

import com.example.dbflute.ymir.dbflute.cbean.MemberCB;
import com.example.dbflute.ymir.dbflute.exbhv.MemberBhv;
import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.unit.AppContainerTestCase;

/**
 * @author jflute
 */
public class DbAccessTest extends AppContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_basic_Tx() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberName_PrefixSearch("S");
        cb.query().addOrderBy_Birthdate_Desc();

        // ## Act ##
        List<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            log(member.toString());
            assertTrue(member.getMemberName().startsWith("S"));
        }
    }
}
