package zzh.com.zoharframe.model;

/**
 * Created by zzh on 2017/8/17.
 *
 * RecycylerView的Gallery效果Model
 */

public class GalleryModel {

    private int mImageUrl;
    private String mTvtContent;

    public GalleryModel(int mImageUrl, String mTvtContent) {
        this.mImageUrl = mImageUrl;
        this.mTvtContent = mTvtContent;
    }

    public int getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(int mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmTvtContent() {
        return mTvtContent;
    }

    public void setmTvtContent(String mTvtContent) {
        this.mTvtContent = mTvtContent;
    }
}
