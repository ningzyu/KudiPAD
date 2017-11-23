package com.nzy.zkyt.kudipad.ui;

import android.os.Bundle;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.presenter.CountingPresenter;
import com.nzy.zkyt.kudipad.ui.view.CountingView;

/**
 * 盘点记录页
 */
public class CountingActivity  extends BaseActivity<CountingView,CountingPresenter> implements CountingView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected String getBarTitle() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    protected CountingPresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_counting;
    }
}
