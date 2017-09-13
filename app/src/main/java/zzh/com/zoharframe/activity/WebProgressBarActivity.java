package zzh.com.zoharframe.activity;

import android.os.Bundle;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseWebViewActivity;
import zzh.com.zoharframe.interimpl.ProgressBarImpl;

/**
 * Created by zzh on 2017/8/2.
 *
 *  网页加载连接：带渐变进度条
 */

public class WebProgressBarActivity extends BaseWebViewActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_progress_bar_content);
        //初始化
        initBaseWebView();
        initCurrentData();
    }

    private void initCurrentData() {
        // 加载地址
        ProgressBarImpl progressBarImpl = new ProgressBarImpl();
        progressBarImpl.setActionBarTitle(mTvActionBarTitle, "标题栏");
        progressBarImpl.setProgressBarUrl(mWebView, "https://www.baidu.com");
    }
}
