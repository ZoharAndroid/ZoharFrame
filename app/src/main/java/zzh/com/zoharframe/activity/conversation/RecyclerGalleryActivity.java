package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.RecyclerGalleryAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;
import zzh.com.zoharframe.model.GalleryModel;
import zzh.com.zoharframe.utils.ToastUtils;
import zzh.com.zoharframe.view.RecyclerItemDecoration;

/**
 * Created by zzh on 2017/8/17.
 * <p>
 * RecyclerView的Gallery效果
 */

public class RecyclerGalleryActivity extends BaseActionBarActivity {
    private RecyclerView mRvGallery;
    private TextView mTvAdd;
    private TextView mTvRemove;
    private RecyclerGalleryAdapter mAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_gallery);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));
    }

    @Override
    protected void initView() {
        super.initView();
        mRvGallery = (RecyclerView) findViewById(R.id.rv_gallery);
        mTvAdd = (TextView) findViewById(R.id.tv_add_item);
        mTvRemove = (TextView) findViewById(R.id.tv_remove_item);
        initRecyclerView();
        initData();
        initEvent();
    }

    private void initRecyclerView() {
        mRvGallery.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        mRvGallery.addItemDecoration(new RecyclerItemDecoration(this, OrientationHelper.HORIZONTAL));
        mRvGallery.addItemDecoration(new RecyclerItemDecoration(this, OrientationHelper.VERTICAL));
        mRvGallery.setLayoutManager(layoutManager);
        // 设置item默认动画
        mRvGallery.setItemAnimator(new DefaultItemAnimator());
    }


    private void initData() {
        ArrayList<GalleryModel> modelList = new ArrayList<GalleryModel>();
        //人造数据
        for (int i = 0; i < 20; i++) {
            GalleryModel model = new GalleryModel(R.drawable.icon_gallery_example, "item" + i);
            modelList.add(model);
        }

        //设置适配器
        mAdapter = new RecyclerGalleryAdapter(this, modelList, new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.show(getContext(), "位置:" + position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvGallery.setAdapter(mAdapter);
    }


    private void initEvent() {
        mTvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
            }
        });

        mTvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem();
            }
        });
    }

    private int clickCount = 0;

    private void addItem() {
        clickCount++;
        mAdapter.addItem(new GalleryModel(R.drawable.icon_gallery_delete, "add " + clickCount), layoutManager.findLastCompletelyVisibleItemPosition());

    }

    private void removeItem() {
        if (clickCount != 0) {
            clickCount--;
        }
        mAdapter.remove(layoutManager.findLastCompletelyVisibleItemPosition());
    }
}