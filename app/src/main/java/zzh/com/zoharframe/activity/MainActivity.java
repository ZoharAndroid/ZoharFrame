package zzh.com.zoharframe.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseActivity;
import zzh.com.zoharframe.fragment.AddressFragment;
import zzh.com.zoharframe.fragment.ConversationFragment;
import zzh.com.zoharframe.fragment.FindFragment;
import zzh.com.zoharframe.fragment.MyFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private ConversationFragment conversationFragment = ConversationFragment.newInstance();
    private AddressFragment addressFragment = AddressFragment.newInstance();
    private FindFragment findFragment = FindFragment.newInstance();
    private MyFragment myFragment = MyFragment.newInstance();


    private RadioGroup mRgTabRoot;
    private RadioButton mRbFind; //发现
    private RadioButton mRbConversation;//会话
    private RadioButton mRbMy;//我的
    private RadioButton mRbAddress;//通讯录
    private FrameLayout mFlContent;//内容

    private int mCurrentIndex = 0;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCurrentView();
        initCurrentData();
        initFragments();
    }

    private void initCurrentView() {
        //控件初始化
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);
        mRgTabRoot = (RadioGroup) findViewById(R.id.rg_tab_root);
        mRbFind = (RadioButton) findViewById(R.id.rb_tab_find);
        mRbConversation = (RadioButton) findViewById(R.id.rb_tab_conversation);
        mRbAddress = (RadioButton) findViewById(R.id.rb_tab_address);
        mRbMy = (RadioButton) findViewById(R.id.rb_tab_my);

        mRgTabRoot.setOnCheckedChangeListener(this);

    }

    private void initCurrentData() {

    }

    private void initFragments() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl_content, conversationFragment);
        transaction.add(R.id.fl_content, findFragment);
        transaction.add(R.id.fl_content, addressFragment);
        transaction.add(R.id.fl_content, myFragment);
        transaction.commit();
        switchToFragment(mCurrentIndex);
        mRbConversation.setChecked(true);
    }

    /**
     * 隐藏所有的fragment，并且取消所有的底部导航栏的icon的高亮状态
     */
    private void hideAllExculdeFragments(FragmentTransaction transaction) {
        transaction.hide(conversationFragment);
        transaction.hide(findFragment);
        transaction.hide(addressFragment);
        transaction.hide(myFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.rb_tab_conversation:
                //会话
                switchToFragment(0);
                break;
            case R.id.rb_tab_address:
                // 通讯录
                switchToFragment(1);
                break;
            case R.id.rb_tab_find:
                switchToFragment(2);
                //发现
                break;
            case R.id.rb_tab_my:
                switchToFragment(3);
                //我的
                break;
        }
    }


    /**
     * 切换Fragment
     *
     * @param index
     */
    private void switchToFragment(int index) {
        mCurrentIndex = index;
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        hideAllExculdeFragments(ft);
        switch (index) {
            case 0:
                ft.show(conversationFragment);
                break;
            case 1:
                ft.show(addressFragment);
                break;
            case 2:
                ft.show(conversationFragment);
                break;
            case 3:
                ft.show(myFragment);
                break;
        }

        ft.commit();

    }

}
