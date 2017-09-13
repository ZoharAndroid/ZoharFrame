package zzh.com.zoharframe.interimpl;

import android.webkit.WebView;
import android.widget.TextView;

import zzh.com.zoharframe.interfaces.OnSetProgressBarLisenter;

/**
 * Created by zzh on 2017/8/8.
 */

public class ProgressBarImpl implements OnSetProgressBarLisenter {

    @Override
    public void setProgressBarUrl(WebView webView, String Url) {
        webView.loadUrl(Url);
    }

    @Override
    public void setActionBarTitle(TextView view, CharSequence title) {
        view.setText(title);
    }
}
