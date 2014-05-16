package com.example.dbflute.flex.dbflute.whitebox;

import org.dbflute.saflute.db.replication.SlaveDBAccessor;
import org.dbflute.saflute.db.replication.SlaveDBCallback;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.flex.dbflute.cbean.MemberCB;
import com.example.dbflute.flex.dbflute.dtomapper.MemberDtoMapper;
import com.example.dbflute.flex.dbflute.exbhv.MemberBhv;
import com.example.dbflute.flex.dbflute.exentity.Member;
import com.example.dbflute.flex.simpleflute.dto.MemberDto;
import com.example.dbflute.flex.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5F (2014/05/16 Friday)
 */
public class WxSlaveDBAccessorTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private SlaveDBAccessor slaveDBAccessor;

    public void test_select_slave_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        ListResultBean<Member> memberList = slaveDBAccessor
                .accessFixedly(new SlaveDBCallback<ListResultBean<Member>>() {
                    public ListResultBean<Member> callback() {
                        MemberCB cb = new MemberCB();
                        return memberBhv.selectList(cb);
                    }
                });

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            MemberDto dto = mapper.mappingToDto(member);
            log(dto);
            assertNull(dto.getMemberStatus());
        }

        assertEquals(memberList, memberBhv.selectList(new MemberCB()));
    }

    public void test_update_slave_forcedly_master() throws Exception {
        // ## Arrange ##
        final String updatedName = "max goof";
        Member beforeMember = memberBhv.selectByPKValueWithDeletedCheck(3);

        // ## Act ##
        slaveDBAccessor.accessFixedly(new SlaveDBCallback<Void>() {
            public Void callback() {
                Member member = new Member();
                member.setMemberId(3);
                member.setMemberName(updatedName);
                memberBhv.updateNonstrict(member);
                return null;
            }
        });

        // ## Assert ##
        Member masterMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        Member slaveMember = slaveDBAccessor.accessFixedly(new SlaveDBCallback<Member>() {
            public Member callback() {
                return memberBhv.selectByPKValueWithDeletedCheck(3);
            }
        });
        assertEquals(updatedName, masterMember.getMemberName());
        assertEquals(beforeMember.getMemberName(), slaveMember.getMemberName());
    }
}
