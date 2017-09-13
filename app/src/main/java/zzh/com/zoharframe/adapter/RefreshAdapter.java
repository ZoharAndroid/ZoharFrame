package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import zzh.com.zoharframe.R;

/**
 * Created by zzh on 2017/8/21.
 */

public class RefreshAdapter extends RecyclerView.Adapter {

    private ArrayList<String> strings = new ArrayList<>();
    private LayoutInflater mInflater;

    public RefreshAdapter(Context context, ArrayList<String> strings) {
        this.strings = strings;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SwipeRefreshViewHolder) holder).item_textview.setText(strings.get(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_converstaion, parent, false);
        SwipeRefreshViewHolder holder = new SwipeRefreshViewHolder(view);
        return holder;
    }


    public class SwipeRefreshViewHolder extends RecyclerView.ViewHolder {
        TextView item_textview;

        public SwipeRefreshViewHolder(View itemView) {
            super(itemView);
            this.item_textview = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public void addItem(ArrayList<String> newDatas) {
        strings = newDatas;
        notifyDataSetChanged();
    }

    public void addMoreItem(ArrayList<String> newDatas) {
        strings.addAll(newDatas);
        notifyDataSetChanged();
    }

}
