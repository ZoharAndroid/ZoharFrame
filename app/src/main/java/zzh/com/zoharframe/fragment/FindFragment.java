package zzh.com.zoharframe.fragment;

import android.os.Bundle;
import android.view.View;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseFragment;

/**
 * Created by zzh on 2017/8/15.
 *
 * 会话：Fragment
 */

public class FindFragment extends BaseFragment {

    public static FindFragment newInstance(){

        Bundle args = new Bundle();
        FindFragment fragment = new FindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initFragmentView() {
       View conversationView =  View.inflate(getContext(), R.layout.fragment_find,null);
        return conversationView;
    }
}
