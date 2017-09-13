package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.adapter.CardRecyclerAdapter;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;

/**
 * Created by zzh on 2017/8/17.
 *
 * CardView与RecyclerView结合使用
 */

public class CardRecyclerActivity extends BaseActionBarActivity {
    private RecyclerView mRcCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));
    }

    @Override
    protected void initView() {
        super.initView();
        mRcCard = (RecyclerView)findViewById(R.id.rv_card);
        initRecyclerView();
        initData();
    }

    private void initRecyclerView(){
        mRcCard.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRcCard.setLayoutManager(layoutManager);
    }

    private void initData(){
        //造数据
        String[] strings = new String[10];
        for (int i =0 ;i<strings.length;i++){
            strings[i]="卡片"+i;
        }

        mRcCard.setAdapter(new CardRecyclerAdapter(this,strings));
    }
}
