package com.nzy.zkyt.kudipad.ui.presenter;

import android.text.TextUtils;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.model.Setting;
import com.nzy.zkyt.kudipad.ui.MainActivity;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.base.BasePresenter;
import com.nzy.zkyt.kudipad.ui.view.SettingView;
import com.nzy.zkyt.kudipad.util.UIUtils;

/**
 * 作者：宁震宇on 2017/11/22.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class SettingPresenter extends BasePresenter<SettingView> {

    public SettingPresenter(BaseActivity context) {
        super(context);
    }

    public void save(){
        String shopid = getView().getEtShopid().getText().toString().trim();
        String ip = getView().getEtIP().getText().toString().trim();
        String port = getView().getEtPort().getText().toString().trim();

        if (TextUtils.isEmpty(shopid)) {
            UIUtils.showToast(UIUtils.getString(R.string.shopid_not_empty));
            return;
        }
        if (TextUtils.isEmpty(ip)) {
            UIUtils.showToast(UIUtils.getString(R.string.ip_not_empty));
            return;
        }
        if (TextUtils.isEmpty(port)) {
            UIUtils.showToast(UIUtils.getString(R.string.port_not_empty));
            return;
        }
        Setting.save(shopid, ip,port);
        mContext.jumpToActivityAndClearTask(MainActivity.class);
    }
}
