package zzh.com.zoharframe.application;

import android.app.Application;
import android.content.Context;

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
