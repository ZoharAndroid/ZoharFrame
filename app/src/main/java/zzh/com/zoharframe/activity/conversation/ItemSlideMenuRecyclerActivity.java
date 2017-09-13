package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.SlidingMenuAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;

/**
 * Created by zohar on 2017/9/12.
 * <p>
 * RecyclerView 的侧滑菜单
 */

public class ItemSlideMenuRecyclerActivity extends BaseActionBarActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_slide_menu);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));


        initData();
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_item_sliding_menu);
        //设置RecyclerView控件
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, OrientationHelper.VERTICAL));
    }

    private void initData() {
        //造数据
        String[] strings = new String[50];
        for (int i = 0; i < 50; i++) {
             strings[i] = "当前item " + i;
        }

        SlidingMenuAdapter adapter = new SlidingMenuAdapter(this,strings);
        mRecyclerView.setAdapter(adapter);
    }
}
