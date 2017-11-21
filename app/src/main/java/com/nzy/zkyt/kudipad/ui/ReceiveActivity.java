package com.nzy.zkyt.kudipad.ui;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.presenter.ReceivePresenter;
import com.nzy.zkyt.kudipad.ui.view.ReceiveView;
import com.nzy.zkyt.kudipad.util.UIUtils;

import butterknife.BindView;

public class ReceiveActivity  extends BaseActivity<ReceiveView,ReceivePresenter> implements ReceiveView,View.OnClickListener{
    @BindView(R.id.edit_receive)
    EditText et_receive;
    @BindView(R.id.iv_scan)
    ImageView iv_scan;
    @BindView(R.id.btn_receive1)
    Button btn_Receive1;
    @BindView(R.id.btn_receive2)
    Button btn_Receive2;
    @BindView(R.id.btn_receive3)
    Button btn_Receive3;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_scan:
                //开启扫码
                break;
            case R.id.btn_receive1:
                //
                break;
            case R.id.btn_receive2:
                break;
            case R.id.btn_receive3:
                break;
            default:
                break;
        }
    }

    @Override
    protected void initView() {
        setTopLeftButton();
        setTopRightButton(R.drawable.menu_settings, view -> UIUtils.showToast("点击了设置"));
        iv_scan.setOnClickListener(this);
        btn_Receive1.setOnClickListener(this);
        btn_Receive2.setOnClickListener(this);
        btn_Receive3.setOnClickListener(this);
    }

    @Override
    protected String getBarTitle() {
        return "收货";
    }

    @Override
    public void initData() {
        mPresenter.LoadMessage();
    }

    @Override
    protected ReceivePresenter createPresenter() {
        return new ReceivePresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_receive;
    }

    @Override
    public EditText getCodeEdit() {
        return et_receive;
    }


}
