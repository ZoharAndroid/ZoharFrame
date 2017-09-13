package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;
import zzh.com.zoharframe.model.GalleryModel;

/**
 * Created by zzh on 2017/8/17.
 * <p>
 * RecyclerView的Gallery效果Adapter
 */

public class RecyclerGalleryAdapter extends RecyclerView.Adapter {

    private ArrayList<GalleryModel> listData;
    private LayoutInflater mInflater;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public RecyclerGalleryAdapter(Context context, ArrayList<GalleryModel> listData) {
        this.listData = listData;
        mInflater = LayoutInflater.from(context);
    }

    public RecyclerGalleryAdapter(Context context, ArrayList<GalleryModel> listData, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.listData = listData;
        mInflater = LayoutInflater.from(context);
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GalleryViewHolder) holder).mTvTitle.setText(listData.get(position).getmTvtContent());
        ((GalleryViewHolder) holder).mIvImag.setImageResource(listData.get(position).getmImageUrl());
        ((GalleryViewHolder) holder).itemView.setTag(position);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_gallery, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRecyclerItemClickListener != null) {
                    onRecyclerItemClickListener.onItemClick(view, (int) view.getTag());
                }
            }
        });
        GalleryViewHolder holder = new GalleryViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvImag;
        TextView mTvTitle;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            mIvImag = (ImageView) itemView.findViewById(R.id.iv_item_image);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
        }
    }


    /**
     * 添加Item
     *
     * @param model
     * @param position
     */
    public void addItem(GalleryModel model, int position) {
        listData.add(position,model);
        notifyItemInserted(position);
    }

    /**
     * 删除Item
     *
     * @param position
     */
    public void remove(int position){
        if (!listData.isEmpty()) {
            listData.remove(position);
            notifyItemRemoved(position);
        }

    }

}
