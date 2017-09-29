package zzh.com.zoharframe.activity.conversation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.utils.ToastUtils;

/**
 * Created by zohar on 2017/9/29.
 *
 * 生成二维码
 *
 */

public class CreateCodeActivity extends BaseActionBarActivity {

    private Button mBtnLogoCode;
    private Button mBtnCode;
    private EditText mEtContent;
    private ImageView mIvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_code);
        initActionBarTitle("生成二维码");

        initCurrentView();
        initCurrentEvent();
    }

    private void initCurrentView(){
        mBtnCode = (Button)findViewById(R.id.btn_create_code_no_logo);
        mBtnLogoCode = (Button)findViewById(R.id.btn_create_code_logo);
        mEtContent = (EditText)findViewById(R.id.et_code_content);
        mIvCode = (ImageView)findViewById(R.id.iv_create_code);
    }

    private void initCurrentEvent(){
        mBtnLogoCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textContent = mEtContent.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    ToastUtils.showToast("您输入的内容为空");
                    return;
                }
                mEtContent.setText("");
                Bitmap mBitmap  = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                mIvCode.setImageBitmap(mBitmap);

            }
        });

        mBtnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textContent = mEtContent.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    ToastUtils.showToast("您输入的内容为空");
                    return;
                }
                mEtContent.setText("");
                Bitmap mBitmap = CodeUtils.createImage(textContent, 400, 400, null);
                mIvCode.setImageBitmap(mBitmap);
            }
        });
    }
}
