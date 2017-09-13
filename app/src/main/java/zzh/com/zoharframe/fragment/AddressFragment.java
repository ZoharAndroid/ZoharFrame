package zzh.com.zoharframe.fragment;

import android.os.Bundle;
import android.view.View;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseFragment;

/**
 * Created by zzh on 2017/8/15.
 *
 * 通讯录Fragment
 */

public class AddressFragment extends BaseFragment {

    public static AddressFragment newInstance(){
        Bundle args = new Bundle();
        AddressFragment fragment = new AddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View initFragmentView() {
        View addressView = View.inflate(getContext(),R.layout.fragment_address,null);
        return addressView;
    }
}
