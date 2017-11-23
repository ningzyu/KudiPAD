package com.nzy.zkyt.kudipad.ui;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.presenter.InputCodePresenter;
import com.nzy.zkyt.kudipad.ui.view.InputCodeView;

public class InputCodeActivity extends BaseActivity<InputCodeView,InputCodePresenter> implements InputCodeView{
    @Override
    protected void initView() {

    }

    @Override
    protected String getBarTitle() {
        return "收货";
    }

    @Override
    protected InputCodePresenter createPresenter() {
        return new InputCodePresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_input;
    }
}
