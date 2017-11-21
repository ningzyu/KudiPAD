package com.nzy.zkyt.kudipad.ui.presenter;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.nzy.zkyt.kudipad.R;
import com.nzy.zkyt.kudipad.base.AppConst;
import com.nzy.zkyt.kudipad.base.BaseApp;
import com.nzy.zkyt.kudipad.db.GoodsCall;
import com.nzy.zkyt.kudipad.db.LouSQLite;
import com.nzy.zkyt.kudipad.db.manager.GoodsDao;
import com.nzy.zkyt.kudipad.db.manager.IGoodsManager;
import com.nzy.zkyt.kudipad.model.GoodItem;
import com.nzy.zkyt.kudipad.ui.ReceiveActivity;
import com.nzy.zkyt.kudipad.ui.adapter.recycleradapter.BaseRecyclerAdapter;
import com.nzy.zkyt.kudipad.ui.adapter.recycleradapter.BaseRecyclerHolder;
import com.nzy.zkyt.kudipad.ui.base.BaseActivity;
import com.nzy.zkyt.kudipad.ui.base.BasePresenter;
import com.nzy.zkyt.kudipad.ui.view.MainView;
import com.nzy.zkyt.kudipad.util.ExcelUtil;
import com.nzy.zkyt.kudipad.util.UIUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.nzy.zkyt.kudipad.db.DBConstant.TABLE_USER;

/**
 * 作者：宁震宇on 2017/11/16.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class MainPresenter extends BasePresenter<MainView> {
    private BaseRecyclerAdapter<Item> adapter;
    private List<Item> mData = new ArrayList<>();
    private IGoodsManager goodManager;
    public MainPresenter(BaseActivity context) {
        super(context);
    }

    @Override
    public void LoadMessage() {
        loadData();
        setAdapter();
    }

    private void setAdapter() {
        if (adapter == null) {
            adapter = new BaseRecyclerAdapter<Item>(mContext, mData, R.layout.main_item) {
                @Override
                public void convert(BaseRecyclerHolder holder, Item item, int position, boolean isScrolling) {
                    holder.setImageResource(R.id.img_item_main, item.img);
                    holder.setText(R.id.tv_item_main, item.name);
                }
            };
            adapter.setOnItemClickListener((parent, view, position) -> {
                switch (position){
                    case 0:
                        //导入数据
                        File file=new File(AppConst.GOODS_PATH);
                        if (file.exists()) {
                            List<GoodItem> goodItemList = ExcelUtil.getInstance().getGoods(file);
                            Log.i("1117",goodItemList.size()+"条数据");
                            //删除并添加
//                            goodManager.delete();
                            LouSQLite.deleteFrom(TABLE_USER);//删除
//                            long i=goodManager.addAllUser(goodItemList);
                            LouSQLite.insert(TABLE_USER, goodItemList);
                            LouSQLite.query(TABLE_USER , "", null);
//                            Log.i("1117","添加结果-----"+goodManager.queryGoodsUsers().size());
                            Log.i("1117","添加结果-----"+LouSQLite.query(TABLE_USER , "", null).size());
//                            if (i==0) {
//                                UIUtils.showToast("导入成功！");
//                            } else {
//                                UIUtils.showToast("导入失败！");
//                            }
                        } else {
                            UIUtils.showToast("文件不存在！");
                        }
                        break;
                    case 1:
                        //导出数据
                        break;
                    case 2:
                        //盘点
                        break;
                    case 3:
                        //收货
                        mContext.jumpToActivity(ReceiveActivity.class);

                        break;
                    case 4:
                        //

                        break;
                    case 5:

                        break;
                    default:
                        break;
                }
            });
            adapter.setOnItemLongClickListener((parent, view, position) -> {
                adapter.delete(position);
                return true;
            });
//            getView().getRecycler().setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
//            GridLayoutManager layoutManager=new GridLayoutManager(mContext,2);
//            layoutManager.setOrientation(GridLayoutManager.VERTICAL);
            getView().getRecycler().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            getView().getRecycler().setAdapter(adapter);
        }
    }
//    private void initData() {
//
//        // 更新一个数据
//        phrase.setContent(phrase.getContent() + " 嘿嘿嘿");
//        LouSQLite.update(MyCallBack.TABLE_NAME_PHRASE
//                , phrase
//                , PhraseEntry.COLEUM_NAME_ID + "=?"
//                , new String[]{phrase.getId()});
//        query();
//

//        query();
//
//    }

    private void loadData() {
        goodManager = new GoodsDao(mContext);
        LouSQLite.init(mContext, new GoodsCall());//初始化
        List<Item> Items = Arrays.asList(new Item("导入数据", R.mipmap.bg_import), new Item("导出", R.mipmap.bg_export)
                , new Item("盘点", R.mipmap.bg_goods), new Item("收货", R.mipmap.bg_calculate),
                new Item("查询", R.mipmap.bg_query), new Item("数据", R.mipmap.bg_data));
        mData.addAll(Items);
    }

    class Item {
        String name;
        int img;

        public Item(String name, int img) {
            this.name = name;
            this.img = img;
        }
    }
    public void toBack(){
        long exitTime = 0;
        if((System.currentTimeMillis()-exitTime) > 2000){
            UIUtils.showToast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            BaseApp.exit();
        }
    }
}
