package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import zzh.com.zoharframe.R;

/**
 * Created by zzh on 2017/8/8.
 * <p>
 * IntroduceActivity的ViewPager适配器
 */

public class IntroducePagerAdapter extends PagerAdapter {

    private int[] imageIds = new int[]{R.mipmap.introduce_1, R.mipmap.introduce_2, R.mipmap.introduce_3};
    private ArrayList<ImageView> mImageViewList = new ArrayList<>();

    public IntroducePagerAdapter(Context context) {

        //生成图片
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIds[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViewList.add(imageView);
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mImageViewList.get(position));
        return mImageViewList.get(position);
    }
}
