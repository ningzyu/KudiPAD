package com.nzy.zkyt.kudipad.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.InputType;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.nzy.zkyt.kudipad.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MaterialDialog {
	private Context context;
	private Dialog dialog;
	@BindView(R.id.lLayout_bg)//根部局
	protected LinearLayout lLayout_bg;
	@BindView(R.id.txt_title)//标题
	protected TextView txt_title;
	@BindView(R.id.txt_msg)//内容
	protected TextView txt_msg;

	@BindView(R.id.editlog_layout)
	protected LinearLayout etlayout;
	@BindView(R.id.editlog_txt)
	protected TextView et_txt;
	@BindView(R.id.editlog_msg)
	protected EditText et_msg;

	@BindView(R.id.btn_neg)//取消按钮
	protected Button btn_neg;
	@BindView(R.id.btn_pos)//确定按钮
	protected Button btn_pos;
	@BindView(R.id.img_line)//分割线
	protected ImageView img_line;
	private Display display;
	private boolean showTitle = false;
	private boolean showMsg = false;
	private boolean showPosBtn = false;
	private boolean showNegBtn = false;
	private boolean showEdit = false;

	public MaterialDialog(Context context) {
		this.context = context;
		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		display = windowManager.getDefaultDisplay();
	}

	public MaterialDialog builder() {
		// 获取Dialog布局
		View view = LayoutInflater.from(context).inflate(R.layout.view_alertdialog, null);
		ButterKnife.bind(this,view);
		// 获取自定义Dialog布局中的控件
		txt_title.setVisibility(View.GONE);//标题
		txt_msg.setVisibility(View.GONE);//内容
		btn_neg.setVisibility(View.GONE);//取消
		btn_pos.setVisibility(View.GONE);//确定
		img_line.setVisibility(View.GONE);//
		etlayout.setVisibility(View.GONE);//输入框
		et_msg.setInputType(InputType.TYPE_CLASS_NUMBER);
		// 定义Dialog布局和参数
		dialog = new Dialog(context, R.style.AlertDialogStyle);
		dialog.setContentView(view);
		// 调整dialog背景大小
		lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.85), LayoutParams.WRAP_CONTENT));
		return this;
	}

	public MaterialDialog setTitle(String title) {
		showTitle = true;
		if ("".equals(title)) {
			txt_title.setText("标题");
		} else {
			txt_title.setText(title);
		}
		return this;
	}
	//
	public MaterialDialog setEdit(String hint) {
		showEdit = true;
		if ("".equals(hint)) {
			et_txt.setVisibility(View.GONE);
		} else {
			et_txt.setText(hint);
		}
		return this;
	}
	public MaterialDialog setMsg(String msg) {
		showMsg = true;
		if ("".equals(msg)) {
			txt_msg.setText("内容");
		} else {
			txt_msg.setText(msg);
		}
		return this;
	}

	public MaterialDialog setCancelable(boolean cancel) {
		dialog.setCancelable(cancel);
		return this;
	}


	//编辑框时的确认按钮
	public MaterialDialog setPositiveButton(final MyListener myListener){
		showPosBtn = true;
		btn_pos.setText("确定");
		this.myListener=myListener;
		btn_pos.setOnClickListener(v -> {
            myListener.getData(et_msg.getText().toString().trim());
            dialog.dismiss();
        });
		return this;
	}
	MyListener myListener;
	public interface MyListener {
		void getData(String res);
	}

//	右侧按钮
	public MaterialDialog setPositiveButton(String text, final OnClickListener listener) {
		showPosBtn = true;
		if ("".equals(text)) {
			btn_pos.setText("确定");
		} else {
			btn_pos.setText(text);
		}
		btn_pos.setOnClickListener(v -> {
            listener.onClick(v);
            dialog.dismiss();
        });
		return this;
	}

	public MaterialDialog setNegativeButton(String text, final OnClickListener listener) {
		showNegBtn = true;
		if ("".equals(text)) {
			btn_neg.setText("取消");
		} else {
			btn_neg.setText(text);
		}
		btn_neg.setOnClickListener(v -> {
            listener.onClick(v);
            dialog.dismiss();
        });
		return this;
	}

	private void setLayout() {
		if (!showTitle && !showMsg) {
			txt_title.setText("提示");
			txt_title.setVisibility(View.VISIBLE);
		}

		if (showTitle) {
			txt_title.setVisibility(View.VISIBLE);
		}

		if (showMsg) {
			txt_msg.setVisibility(View.VISIBLE);
		}
		if (showEdit){
			etlayout.setVisibility(View.VISIBLE);
		}
		if (!showPosBtn && !showNegBtn) {
			btn_pos.setText("确定");
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
			btn_pos.setOnClickListener(v -> dialog.dismiss());
		}

		if (showPosBtn && showNegBtn) {
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
			img_line.setVisibility(View.VISIBLE);
		}

		if (showPosBtn && !showNegBtn) {//显示确定按钮不显示取消按钮
			btn_pos.setVisibility(View.VISIBLE);
			btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}

		if (!showPosBtn && showNegBtn) {
			btn_neg.setVisibility(View.VISIBLE);
			btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
		}
	}

	public void show() {
		setLayout();
		dialog.show();
	}
}
