package com.nzy.zkyt.kudipad.ui.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.data.Para;
import com.nzy.zkyt.kudipad.model.ResultQuery;
import com.nzy.zkyt.kudipad.network.ApiRetrofit;
import com.nzy.zkyt.kudipad.ui.InputCodeActivity;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.base.BasePresenter;
import com.nzy.zkyt.kudipad.ui.view.ReceiveView;
import com.nzy.zkyt.kudipad.util.UIUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：宁震宇on 2017/11/21.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class ReceivePresenter extends BasePresenter<ReceiveView> {
    public ReceivePresenter(BaseActivity context) {
        super(context);
    }
    public void Request(String bill) {
        String code=getView().getCodeEdit().getText().toString().trim();
        if (TextUtils.isEmpty(code)) {
            UIUtils.showToast(UIUtils.getString(R.string.code_not_empty));
            return;
        }
        ApiRetrofit.getInstance().Request(Para.getInstance().getParaQuery(bill,code,"1"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    Observer<ResultQuery> observer = new Observer<ResultQuery>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i("aaaaaaaaaaa", "返回1" + d.toString());
        }

        @Override
        public void onNext(ResultQuery value) {
//            Log.i("aaaaaaaaaaa", "返回2" + value.getCode());
            mContext.jumpToActivity(InputCodeActivity.class);
        }

        @Override
        public void onError(Throwable e) {
            Log.i("aaaaaaaaaaa", "返回3" + e.toString());
            mContext.jumpToActivity(InputCodeActivity.class);
        }

        @Override
        public void onComplete() {
            Log.i("aaaaaaaaaaa", "返回4");
        }
    };

}
