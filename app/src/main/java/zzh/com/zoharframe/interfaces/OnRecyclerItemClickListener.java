package zzh.com.zoharframe.interfaces;

import android.view.View;

/**
 * Created by zzh on 2017/8/16.
 *
 * RecyclerView的Item点击事件
 */

public interface OnRecyclerItemClickListener {

    /**
     * item 的点击事件
     *
     * @param view
     * @param position
     */
    void onItemClick(View view ,int position);

    /**
     * item 的长按点击事件
     *
     * @param view
     * @param position
     */
    void onItemLongClick(View view ,int position);
}
