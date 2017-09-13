package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;

/**
 * Created by zzh on 2017/8/16.
 * <p>
 * RecyclerActivity的 recyclerView 的Adapter
 */

public class RecyclerShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] datas;
    private LayoutInflater mInflater;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public RecyclerShowAdapter(Context context, String[] datas) {
        this.datas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    public RecyclerShowAdapter(Context context, String[] datas, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.datas = datas;
        this.mInflater = LayoutInflater.from(context);
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ShowViewHolder) holder).getTvTitle().setText(datas[position]);
        ((ShowViewHolder)holder).itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_converstaion, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRecyclerItemClickListener!=null) {
                    onRecyclerItemClickListener.onItemClick(view, (int) view.getTag());
                }
            }
        });
        ShowViewHolder holder = new ShowViewHolder(view);
        return holder;
    }


    public class ShowViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;

        public ShowViewHolder(View view) {
            super(view);
            mTvTitle = view.findViewById(R.id.tv_title);
        }

        public TextView getTvTitle() {
            return mTvTitle;
        }
    }

}
