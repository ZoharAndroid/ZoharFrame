package zzh.com.zoharframe.activity.conversation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import java.util.ArrayList;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.RefreshAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;

/**
 * Created by zzh on 2017/8/21.
 * <p>
 * RecyclerView中包含SwipeRefreshLayout的上下拉刷新
 */

public class SwipeRefreshLayoutActivity extends BaseActionBarActivity {

    private SwipeRefreshLayout mSrlayoutView;
    private RecyclerView mRcView;
    private ArrayList<String> strings = new ArrayList<String>();
    private RefreshAdapter mAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));
        mSrlayoutView = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRcView = (RecyclerView) findViewById(R.id.recycler_view_refresh);

        initSwipeRefreshLayoutView();
        initRecyclerView();

        initRefreshListener();
    }

    private void initSwipeRefreshLayoutView() {
        //设置progress的背景颜色
        mSrlayoutView.setProgressBackgroundColorSchemeColor(Color.WHITE);
        //设置刷新旋转的颜色，最多只能4中
        mSrlayoutView.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_red_light), getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_green_light));
        mSrlayoutView.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));
    }

    private void initRecyclerView() {
        mRcView.setHasFixedSize(true);
        mRcView.addItemDecoration(new DividerItemDecoration(this, OrientationHelper.HORIZONTAL));
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRcView.setLayoutManager(layoutManager);


        for (int i = 0; i < 30; i++) {
            String string = "item " + i;
            strings.add(string);
        }

        mAdapter = new RefreshAdapter(this, strings);
        mRcView.setAdapter(mAdapter);

    }

    /**
     * 设置刷新
     */
    private void initRefreshListener() {
        mSrlayoutView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //造数据
                        for (int i = 0; i < 5; i++) {
                            String string = "新添加 " + i;
                            strings.add(string);
                        }
                        mAdapter.addItem(strings);
                        //停止刷新
                        mSrlayoutView.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        mRcView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastVisibleItemCount = layoutManager.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemCount + 1 ==mAdapter.getItemCount()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList<String> list = new ArrayList<String>();
                            for (int i=0;i<5;i++){
                                list.add("加载更多 "+i);
                            }
                            mAdapter.addMoreItem(list);
                        }
                    },2000);
                }
            }
        });
    }

    private int lastVisibleItemCount;

}
