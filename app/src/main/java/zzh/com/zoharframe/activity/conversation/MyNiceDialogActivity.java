package zzh.com.zoharframe.activity.conversation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.utils.ToastUtils;

/**
 * Created by zohar on 2017/9/29.
 *
 * 各种类型的Dialog
 */

public class MyNiceDialogActivity extends BaseActionBarActivity {
    private Button mBtnShare;//分享
    private Button mBtnLoading;//加载
    private Button mBtnRedBag;//红包

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_nice_dialog);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));

        initCurrentView();
        initCurrentEvent();
    }

    private void initCurrentView(){
      mBtnShare = (Button)findViewById(R.id.btn_share);
        mBtnLoading = (Button)findViewById(R.id.btn_loading);
        mBtnRedBag = (Button) findViewById(R.id.btn_red_bag);
    }

    private void initCurrentEvent(){
        //分享
        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog.init().setLayoutId(R.layout.share_layout).setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {
                        viewHolder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ToastUtils.showToast("微信分享成功");
                            }
                        });
                    }
                }).setDimAmount(0.3f).setShowBottom(true).show(getSupportFragmentManager());
            }
        });


        //加载显示
        mBtnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog.init().setLayoutId(R.layout.loading_layout)
                .setDimAmount(0.0f).setWidth(100).setHeight(100).show(getSupportFragmentManager());
            }
        });

        //红包
        mBtnRedBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog.init().setLayoutId(R.layout.layout_red_bag).setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
                        viewHolder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                baseNiceDialog.dismiss();
                            }
                        });
                    }
                }).setOutCancel(false).setAnimStyle(R.style.UP_DOWN_ENTER_EXIT_ANIMATION).show(getSupportFragmentManager());
            }
        });
    }
}
