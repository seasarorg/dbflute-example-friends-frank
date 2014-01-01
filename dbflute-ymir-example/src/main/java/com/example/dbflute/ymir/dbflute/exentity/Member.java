package com.example.dbflute.ymir.dbflute.exentity;

import java.sql.Timestamp;

/**
 * The entity of MEMBER.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class Member extends com.example.dbflute.ymir.dbflute.bsentity.BsMember {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // -----------------------------------------------------
    //                                      SerialVersionUID
    //                                      ----------------    
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------
    //                                       DerivedReferrer
    //                                       ---------------    
    public static final String LATEST_LOGIN_DATETIME = "latestLoginDatetime";
    public static final String COUNT_OF_PURCHASE = "countOfPurchase";
    
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                       DerivedReferrer
    //                                       ---------------    
    /**
     * 最終ログイン日時
     */
    private Timestamp latestLoginDatetime;
    /**
     * 商品購入数
     */
    private Integer countOfPurchase;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * 最終ログイン日時を設定します。
     * @param latestLoginDatetime 最終ログイン日時. (Nullable)
     */
    public void setLatestLoginDatetime(Timestamp latestLoginDatetime) {
        this.latestLoginDatetime = latestLoginDatetime;
    }

    /**
     * 最終ログイン日時を取得します。
     * @return 最終ログイン日時. (Nullable)
     */
    public Timestamp getLatestLoginDatetime() {
        return this.latestLoginDatetime;
    }

    /**
     * 購入数を設定します。
     * @param countOfPurchase 購入数. (Nullable)
     */
    public void setCountOfPurchase(Integer countOfPurchase) {
        this.countOfPurchase = countOfPurchase;
    }

    /**
     * 購入数を返却します。
     * @return 購入数. (Nullable)
     */
    public Integer getCountOfPurchase() {
        return this.countOfPurchase;
    }
}
