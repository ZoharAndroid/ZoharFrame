package zzh.com.zoharframe.utils;

import android.content.Context;
import android.widget.Toast;

import zzh.com.zoharframe.application.ZoharApplication;

/**
 * Created by zzh on 2017/8/3.
 * <p>
 * Toast工具类
 */

public class ToastUtils {

    private static Toast toast;

    /**
     * Toast
     *
     * @param context
     * @param content
     */
    public static void show(Context context, CharSequence content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    /**
     * 显示Toast :默认
     *
     * @param content
     */
    public static void showToast(CharSequence content) {
        if (toast == null) {
            toast = Toast.makeText(ZoharApplication.getContext(), content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    /**
     * 显示Toast :短时间
     *
     * @param content
     */
    public static void showToastShort(CharSequence content) {
        if (toast == null) {
            toast = Toast.makeText(ZoharApplication.getContext(), content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    /**
     * 显示Toast :长时间
     *
     * @param content
     */
    public static void showToastLong(CharSequence content) {
        if (toast == null) {
            toast = Toast.makeText(ZoharApplication.getContext(), content, Toast.LENGTH_LONG);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
