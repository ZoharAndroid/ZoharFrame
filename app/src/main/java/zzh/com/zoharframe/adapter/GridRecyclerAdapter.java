package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zzh.com.zoharframe.R;

/**
 * Created by zzh on 2017/8/18.
 *
 */

public class GridRecyclerAdapter extends RecyclerView.Adapter {
    private String[] strings;
    private LayoutInflater mInflater;

    public GridRecyclerAdapter(Context context,String[] strings){
        this.strings = strings;
        this.mInflater = LayoutInflater.from(context);
        for (int i=0;i<strings.length;i++){
            Log.d("接收过来的数据",strings[i]);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).item_textview.setText(strings[position]);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_converstaion,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_textview;
        public ViewHolder(View itemView) {
            super(itemView);
            item_textview = itemView.findViewById(R.id.tv_title);
        }
    }

}
