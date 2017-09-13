package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import zzh.com.zoharframe.R;
import zzh.com.zoharframe.interfaces.OnRecyclerItemClickListener;

/**
 * Created by zzh on 2017/8/16.
 * <p>
 * RecyclerView的Adapter
 */

public class ConversationRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String[] mStringDatas;
    private LayoutInflater mInflater;
    private ArrayList mListDatas;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public ConversationRecyclerAdapter(Context context, String[] mStringDatas) {
        this.context = context;
        this.mStringDatas = mStringDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    public ConversationRecyclerAdapter(Context context, ArrayList mListDatas) {
        this.context = context;
        this.mListDatas = mListDatas;
        this.mInflater = LayoutInflater.from(context);
    }

    public ConversationRecyclerAdapter(Context context, String[] mStringDatas, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.mStringDatas = mStringDatas;
        this.mInflater = LayoutInflater.from(context);
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public ConversationRecyclerAdapter(Context context, ArrayList mListDatas, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.mListDatas = mListDatas;
        this.mInflater = LayoutInflater.from(context);
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_converstaion,parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRecyclerItemClickListener!=null) {
                    onRecyclerItemClickListener.onItemClick(view, (int) view.getTag());
                }
            }
        });
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).getmTvTitle().setText(mStringDatas[position]);
        ((ViewHolder) holder).itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mStringDatas.length;
    }


    /**
     * ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvTitle;

        public ViewHolder(View view) {
            super(view);
            mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        }


        public TextView getmTvTitle() {
            return mTvTitle;
        }
    }
}
