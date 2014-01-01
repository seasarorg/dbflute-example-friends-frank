package com.example.dbflute.ymir.interceptor;

import java.sql.Timestamp;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.dbflute.AccessContext;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

public class AccessContextSetupInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            // [アクセス日時]
            // 例えば、アプリで日時を取得する統一したインターフェースからの日時を利用。
            Timestamp accessTimestamp = currentTimestamp();

            // [アクセスユーザ]
            // 例えば、セッション上のログインユーザを利用。
            // ログインしていない場合のことも考慮すること。
            String accessUser = getLoginUser();

            // [アクセスプロセス]
            // 例えば、Pageクラスの名前をそのまま利用。
            // アプリケーションでプロセスを判別できる適切な名前を設定すること。
            // DBのカラムサイズに注意(サイズオーバーしないように)
            String accessProcess = getTargetClass(invocation).getName();

            AccessContext context = new AccessContext();
            context.setAccessTimestamp(accessTimestamp);
            context.setAccessUser(accessUser);
            context.setAccessProcess(accessProcess);
            AccessContext.setAccessContextOnThread(context);

            return invocation.proceed();
        } finally {
            // 最後はしっかりクリアすること。
            AccessContext.clearAccessContextOnThread();
        }
    }

    protected Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected String getLoginUser() {
        return "dummyUser"; // actually get from session
    }
}
