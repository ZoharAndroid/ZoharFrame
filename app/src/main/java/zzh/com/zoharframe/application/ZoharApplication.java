package zzh.com.zoharframe.application;

import android.app.Application;
import android.content.Context;

import com.mob.MobSDK;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by zzh on 2017/7/24.
 *
 * App的Application类
 */

public class ZoharApplication extends Application {

    private  static Context mContext;

    private  static ZoharApplication application;


    public static ZoharApplication  getApplicationInstance (){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = getApplicationContext();
        //初始化Zxing二维码库
        ZXingLibrary.initDisplayOpinion(this);
        // 通过代码注册你的AppKey和AppSecret
        MobSDK.init(application, "2255dcd9fb000", "a793cb4deb8937fb3fa5f863e8bfcebe");
    }


    /**
     * 获取上下文
     *
     * @return
     */
    public static Context getContext(){
        return mContext;
    }


}
