package com.nzy.zkyt.kudipad.ui;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.presenter.MainPresenter;
import com.nzy.zkyt.kudipad.ui.view.MainView;
import com.nzy.zkyt.kudipad.util.UIUtils;

import butterknife.BindView;
public class MainActivity extends BaseActivity<MainView,MainPresenter> implements MainView{
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    @Override
    protected void initView(){
        setTopLeftButton();
        setTopRightButton(R.drawable.menu_settings, view -> UIUtils.showToast("点击了设置"));
    }
    @Override
    protected String getBarTitle() {
        return "标题";
    }

    @Override
    public void initData() {
        mPresenter.LoadMessage();

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public RecyclerView getRecycler() {
        return rv_main;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            mPresenter.toBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
