package com.nzy.zkyt.kudipad.ui;

import android.widget.Button;
import android.widget.EditText;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.presenter.SettingPresenter;
import com.nzy.zkyt.kudipad.ui.view.SettingView;

import butterknife.BindView;

public class SettingActivity extends BaseActivity<SettingView,SettingPresenter> implements SettingView{
    @BindView(R.id.edit_shopid)
    EditText et_shopid;
    @BindView(R.id.edit_ip)
    EditText et_ip;
    @BindView(R.id.edit_port)
    EditText et_port;
    @BindView(R.id.btn_save)
    Button btn_save;

    @Override
    protected void initView() {

    }

    @Override
    protected String getBarTitle() {
        return "设置";
    }
    @Override
    public void initData() {
        btn_save.setOnClickListener(view -> {
            mPresenter.save();
        });
    }

    @Override
    protected SettingPresenter createPresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    public EditText getEtShopid() {
        return et_shopid;
    }

    @Override
    public EditText getEtIP() {
        return et_ip;
    }

    @Override
    public EditText getEtPort() {
        return et_port;
    }
}
