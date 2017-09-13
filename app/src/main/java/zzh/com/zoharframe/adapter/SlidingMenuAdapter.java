package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

import zzh.com.zoharframe.R;

/**
 * Created by zohar on 2017/9/12.
 */

public class SlidingMenuAdapter extends RecyclerView.Adapter {

    private String[] strings;
    private LayoutInflater mInflater;

    public SlidingMenuAdapter(Context context,String[] strings){
        this.strings = strings;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //填充布局文件
        View view = mInflater.inflate(R.layout.item_converstaion,parent,false);
        SlidingViewHolder viewholder = new SlidingViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SlidingViewHolder)holder).item_textview.setText(strings[position]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }


    class SlidingViewHolder extends RecyclerView.ViewHolder{
        TextView item_textview;

        public SlidingViewHolder(View itemView){
            super(itemView);
            item_textview = (TextView)itemView.findViewById(R.id.tv_title);
        }
    }

}
