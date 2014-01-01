package com.example.dbflute.ymir.web.member.purchase;

import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.Response;

import com.example.dbflute.ymir.dbflute.cbean.MemberCB;
import com.example.dbflute.ymir.dbflute.cbean.PurchaseCB;
import com.example.dbflute.ymir.dbflute.exbhv.MemberBhv;
import com.example.dbflute.ymir.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.ymir.dbflute.exentity.Member;
import com.example.dbflute.ymir.dbflute.exentity.Purchase;
import com.example.dbflute.ymir.ymir.util.Redirect;

/**
 * @author moon51
 * @author jflute
 * @since 0.8.8.2 (2009/01/16 Friday)
 */
public class ListPage extends ListPageBase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                              Behavior
    //                                              --------
    @Binding(bindingType = BindingType.MUST)
    protected MemberBhv memberBhv;

    @Binding(bindingType = BindingType.MUST)
    protected PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                                 Get
    //                                                                                 ===
    @Override
    public Response _get() {
        if (memberId == null) {
            return Redirect.to(com.example.dbflute.ymir.web.member.search.ListPage.class);
        }
        return passthrough();
    }

    // ===================================================================================
    //                                                                                Post
    //                                                                                ====
    @Override
    public Response _post_delete(int index) {
        // ここでは排他制御なしで問答無用で削除している。
        // VERSION_NOカラムが設定されているテーブルを排他制御なしで
        // 削除する場合は「deleteNonstrict()」を利用する。
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(Long.valueOf(index));
        purchaseBhv.deleteNonstrict(purchase);
        return super._post_delete(index);
    }

    // ===================================================================================
    //                                                                          Pre-render
    //                                                                          ==========
    @Override
    public void _prerender() {
        setupMemberInformation();
        setupPurchaseList();
    }

    // ===================================================================================
    //                                                                              Set up
    //                                                                              ======
    /**
     * 会員情報を設定します。
     */
    protected void setupMemberInformation() {
        MemberCB cb = new MemberCB();
        cb.specify().columnMemberName(); // 取得カラムを明示的に指定
        cb.query().setMemberId_Equal(memberId);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        memberName = member.getMemberName();
    }

    /**
     * 会員購入リストを設定します。
     * @return The list of purchase DTO. (NotNUll)
     */
    protected void setupPurchaseList() {
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Product(); // Productを取得対象に
        cb.query().setMemberId_Equal(memberId); // 会員IDが一致する
        cb.query().addOrderBy_PurchaseDatetime_Desc(); // 購入日時の降順でソート
        List<Purchase> purchasePage = purchaseBhv.selectList(cb);
        purchaseItems = purchaseConverter.toDtoList(purchasePage);
    }
}
