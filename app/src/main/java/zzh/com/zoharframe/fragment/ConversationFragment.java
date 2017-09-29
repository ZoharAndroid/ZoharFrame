package zzh.com.zoharframe.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.activity.conversation.CardRecyclerActivity;
import zzh.com.zoharframe.activity.conversation.GridRecyclerActivity;
import zzh.com.zoharframe.activity.conversation.ImmersiveModeActivity;
import zzh.com.zoharframe.activity.conversation.ItemSlideMenuRecyclerActivity;
import zzh.com.zoharframe.activity.conversation.MyNiceDialogActivity;
import zzh.com.zoharframe.activity.conversation.RecyclerActivity;
import zzh.com.zoharframe.activity.conversation.RecyclerGalleryActivity;
import zzh.com.zoharframe.activity.conversation.SwipeRefreshLayoutActivity;
import zzh.com.zoharframe.activity.conversation.ZxingCodeActivity;
import zzh.com.zoharframe.adapter.ConversationRecyclerAdapter;
import zzh.com.zoharframe.base.BaseFragment;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;
import zzh.com.zoharframe.view.RecyclerItemDecoration;

/**
 * Created by zzh on 2017/8/15.
 * <p>
 * 会话：Fragment
 */

public class ConversationFragment extends BaseFragment {

    private View conversationView;
    private RecyclerView mRcView;
    private String[] dataNameList = new String[]{"RecyclerView显示", "RecyclerView的Gallery效果", "CardView与RecyclerView结合使用", "RecyclerView的GridLayout/分割线", "沉浸式模式",
            "SwipeRefresh上下拉刷新", "RecyclerView侧滑菜单", "Zxing二维码","NiceDialog各种类型Dialog"};
    private Class<?>[] activities = new Class<?>[]{RecyclerActivity.class, RecyclerGalleryActivity.class, CardRecyclerActivity.class, GridRecyclerActivity.class, ImmersiveModeActivity.class,
            SwipeRefreshLayoutActivity.class, ItemSlideMenuRecyclerActivity.class, ZxingCodeActivity.class,MyNiceDialogActivity.class};

    public static ConversationFragment newInstance() {
        Bundle args = new Bundle();
        ConversationFragment fragment = new ConversationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initFragmentView() {
        conversationView = View.inflate(getContext(), R.layout.fragment_conversation, null);
        initView();
        return conversationView;
    }


    private void initView() {
        mRcView = (RecyclerView) conversationView.findViewById(R.id.rc_list_content);
        //设置固定大小
        mRcView.setHasFixedSize(true);
        //创建线性布局
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        // 设置方向
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        // 设置分割线
        mRcView.addItemDecoration(new RecyclerItemDecoration(getContext(), OrientationHelper.HORIZONTAL));
        // 将LayoutManager布局管理器设置给RecyclerView
        mRcView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void initData() {
        // 设置Adapter
        ConversationRecyclerAdapter mAdapter = new ConversationRecyclerAdapter(getContext(), dataNameList, new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 跳转到新的Activity
                Intent intent = new Intent(getActivity(), activities[position]);
                intent.putExtra(Constants.INTENT_START_ACTIVITY, dataNameList[position]);
                startActivity(intent);
                //getContext().overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRcView.setAdapter(mAdapter);
    }
}
