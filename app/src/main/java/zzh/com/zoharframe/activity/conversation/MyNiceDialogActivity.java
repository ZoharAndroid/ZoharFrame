package zzh.com.zoharframe.activity.conversation;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    private Button mBtnFriend;//好友设置
    private Button mBtnComment;//評論
    private Button mBtnConfrim1;
    private Button mBtnConfrim2;

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
        mBtnFriend = (Button) findViewById(R.id.btn_friend);
        mBtnComment = (Button) findViewById(R.id.btn_comment);
        mBtnConfrim1 = (Button) findViewById(R.id.btn_confirm_one);
        mBtnConfrim2 = (Button) findViewById(R.id.btn_confirm_two);
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

        //好友設置
        mBtnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog.init().setLayoutId(R.layout.friend_set_layout).setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, BaseNiceDialog baseNiceDialog) {

                    }
                }).setOutCancel(true).setShowBottom(true).show(getSupportFragmentManager());
            }
        });

        //評論
        mBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog.init().setLayoutId(R.layout.commit_layout).setConvertListener(new ViewConvertListener() {
                    @Override
                    protected void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
                        final EditText editText = viewHolder.getView(R.id.edit_input);
                        TextView textView = viewHolder.getView(R.id.tv_send_commit);

                        editText.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.showSoftInput(editText,0);
                            }
                        });

                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String commit = editText.getText().toString().trim();
                                if (commit.isEmpty()){
                                    ToastUtils.showToast("未输入评论内容");
                                    return;
                                }else{
                                    baseNiceDialog.dismiss();
                                    ToastUtils.showToast(commit);
                                }
                            }
                        });
                    }
                }).setShowBottom(true).show(getSupportFragmentManager());
            }
        });


        mBtnConfrim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDialog.newInstance("1").setOutCancel(false).setMargin(60).show(getSupportFragmentManager());
            }
        });

        mBtnConfrim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDialog.newInstance("2").setOutCancel(false).setMargin(60).show(getSupportFragmentManager());
            }
        });
    }




    public static class ConfirmDialog extends BaseNiceDialog{
        private String type;

        public static ConfirmDialog newInstance(String type){
            Bundle bundle = new Bundle();
            bundle.putString("type",type);
            ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.setArguments(bundle);
            return confirmDialog;
        }


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getArguments();
            if (bundle == null){
                return ;
            }
           type =  bundle.getString("type");
        }

        @Override
        public int intLayoutId() {
            return R.layout.confirm_layout;
        }

        @Override
        public void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
            TextView tvTitle = viewHolder.getView(R.id.tv_confirm_title);
            TextView tvMessage = viewHolder.getView(R.id.tv_confirm_message);
            TextView tvCancel = viewHolder.getView(R.id.tv_confirm_cancel);
            TextView tvOk = viewHolder.getView(R.id.tv_confirm_ok);

            if ("1".equals(type)){
                //确定1
                tvTitle.setText("提示");
                tvMessage.setText("您已支付成功");
            }else if ("2".equals(type)){
                //确定2
                tvTitle.setText("警告");
                tvMessage.setText("您的账号已被冻结");
            }

            tvCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    baseNiceDialog.dismiss();
                }
            });

            tvOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    baseNiceDialog.dismiss();
                }
            });
        }
    }
}
