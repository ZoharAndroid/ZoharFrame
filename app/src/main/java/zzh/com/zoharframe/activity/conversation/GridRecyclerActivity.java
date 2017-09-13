package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.GridRecyclerAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.view.DividerGridItemDecoration;

/**
 * Created by zzh on 2017/8/18.
 * <p>
 * Grid 包含分隔线的Activity
 */

public class GridRecyclerActivity extends BaseActionBarActivity {
    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));
    }

    @Override
    protected void initView() {
        super.initView();
        mRvGrid = (RecyclerView) findViewById(R.id.recycler_view_grid);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRvGrid.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRvGrid.setLayoutManager(layoutManager);
        mRvGrid.addItemDecoration(new DividerGridItemDecoration(this));

        String[] strings = new String[59];
        //造数据
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "item" + i;
        }

        mRvGrid.setAdapter(new GridRecyclerAdapter(this, strings));
    }
}
