package zzh.com.zoharframe.fragment;

import android.os.Bundle;
import android.view.View;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseFragment;

/**
 * Created by zzh on 2017/8/15.
 *
 * 我的Fragment
 */

public class MyFragment extends BaseFragment {

    public static MyFragment newInstance(){
        Bundle args = new Bundle();
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initFragmentView() {
       View myView =  View.inflate(getContext(), R.layout.fragment_my,null);
        return myView;
    }
}
