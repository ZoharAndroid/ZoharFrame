package zzh.com.zoharframe.activity.conversation;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.base.BaseActionBarActivity;
import zzh.com.zoharframe.config.Constants;
import zzh.com.zoharframe.utils.ToastUtils;

/**
 * Created by zohar on 2017/9/29.
 * <p>
 * Zxing二维码
 */

public class ZxingCodeActivity extends BaseActionBarActivity {
    public final int REQUEST_CODE = 1;//请求码
    public final int REQUSET_IMAGE=2;//请求打开手机图库

    private Button mBtnStartScape;//扫描二维码
    private Button mBtnSeeCore;//识别二维码
    private Button mBtnCreateCode;// 生成二维码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing_code);
        initActionBarTitle(getIntent().getStringExtra(Constants.INTENT_START_ACTIVITY));

    }

    @Override
    protected void initView() {
        super.initView();
        mBtnStartScape = (Button) findViewById(R.id.btn_zxing_code);
        mBtnSeeCore = (Button) findViewById(R.id.btn_see_zxing_code);
        mBtnCreateCode=(Button)findViewById(R.id.btn_create_zxing_code);

        initEvent();
    }


    private void initEvent() {
        mBtnStartScape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZxingCodeActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mBtnSeeCore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUSET_IMAGE);
            }
        });

        mBtnCreateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZxingCodeActivity.this,CreateCodeActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    ToastUtils.showToast("解析结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    ToastUtils.showToast("解析失败");
                }
            }
        }


        if (requestCode == REQUSET_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                ContentResolver cr = getContentResolver();
                Cursor cursor = cr.query(uri, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                //picturePath就是图片在储存卡所在的位置
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                try {
                    Bitmap mBitmap = MediaStore.Images.Media.getBitmap(cr, uri);//显得到bitmap图片

                    CodeUtils.analyzeBitmap(picturePath, new CodeUtils.AnalyzeCallback() {
                        @Override
                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                            ToastUtils.showToast("解析结果:" + result);
                        }

                        @Override
                        public void onAnalyzeFailed() {
                            ToastUtils.showToast("解析失败");
                        }
                    });

                    if (mBitmap != null) {
                        mBitmap.recycle();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
