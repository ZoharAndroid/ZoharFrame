package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.RecyclerShowAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;
import zzh.com.zoharframe.utils.ToastUtils;
import zzh.com.zoharframe.view.RecyclerItemDecoration;

/**
 * Created by zzh on 2017/8/16.
 * <p>
 * RecyclerView显示
 */

public class RecyclerActivity extends BaseActionBarActivity {
    private String mTitle;//ConverstaionFragment点击item传递过来的字符串
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_show);
        mTitle = getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY);
        initActionBarTitle(mTitle);

        initData();
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_show);
        //设置RecyclerView相关属性
        //保持每个item 是固定大小
        mRecyclerView.setHasFixedSize(true);
        //设置layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置方向
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置分隔线
        mRecyclerView.addItemDecoration(new RecyclerItemDecoration(this, OrientationHelper.HORIZONTAL));

        mRecyclerView.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        //人造数据
        String[] strings = new String[50];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "当前位置为：" + i;
        }

        //填充Adapter
        //调用item不点击 的构造方法
        //RecyclerShowAdapter mAdapter = new RecyclerShowAdapter(this, strings);
        //调用item可点击的构造方法
        RecyclerShowAdapter mAdapter = new RecyclerShowAdapter(this, strings, new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.show(getContext(),"点击:"+position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

}
