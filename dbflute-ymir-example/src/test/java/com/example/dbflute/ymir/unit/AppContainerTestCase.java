package com.example.dbflute.ymir.unit;

import org.seasar.dbflute.BehaviorSelector;
import org.seasar.dbflute.unit.seasar.ContainerTestCase;

import com.example.dbflute.ymir.dbflute.exbhv.MemberAddressBhv;
import com.example.dbflute.ymir.dbflute.exbhv.MemberLoginBhv;
import com.example.dbflute.ymir.dbflute.exbhv.MemberSecurityBhv;
import com.example.dbflute.ymir.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.ymir.dbflute.exbhv.PurchaseBhv;

/**
 * The test base of the application.
 * @author jflute
 * @since 0.5.6 (2007/10/22 Monday)
 */
public abstract class AppContainerTestCase extends ContainerTestCase {

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    @Override
    protected String prepareConfigFile() {
        return "dbflute.dicon";
    }

    // ===================================================================================
    //                                                                         Data Helper
    //                                                                         ===========
    private BehaviorSelector _behaviorSelector;

    protected void deleteMemberReferrers() {
        {
            PurchaseBhv bhv = _behaviorSelector.select(PurchaseBhv.class);
            bhv.queryDelete(bhv.newMyConditionBean());
        }
        {
            MemberWithdrawalBhv bhv = _behaviorSelector.select(MemberWithdrawalBhv.class);
            bhv.queryDelete(bhv.newMyConditionBean());
        }
        {
            MemberSecurityBhv bhv = _behaviorSelector.select(MemberSecurityBhv.class);
            bhv.queryDelete(bhv.newMyConditionBean());
        }
        {
            MemberLoginBhv bhv = _behaviorSelector.select(MemberLoginBhv.class);
            bhv.queryDelete(bhv.newMyConditionBean());
        }
        {
            MemberAddressBhv bhv = _behaviorSelector.select(MemberAddressBhv.class);
            bhv.queryDelete(bhv.newMyConditionBean());
        }
    }
}
