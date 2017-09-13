package zzh.com.zoharframe.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zzh.com.zoharframe.R;

/**
 * Created by zzh on 2017/8/17.
 * <p>
 * CardView 与 RecyclerView相结合的Adapter
 */

public class CardRecyclerAdapter extends RecyclerView.Adapter {
    private String[] strings;
    private LayoutInflater mInflater;
    private Context context;

    public CardRecyclerAdapter(Context context, String[] strings) {
        this.strings = strings;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_card_recycler, parent, false);
        CardViewHolder holder = new CardViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CardViewHolder) holder).item_textView.setText(strings[position]);
//        ((CardViewHolder) holder).item_cardView.setCardBackgroundColor(0xF06292);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    private class CardViewHolder extends RecyclerView.ViewHolder {
        TextView item_textView;
        CardView item_cardView;

        public CardViewHolder(View itemView) {
            super(itemView);
            item_cardView = (CardView) itemView.findViewById(R.id.card_view_item);
            item_textView = (TextView) itemView.findViewById(R.id.text_view_item);
        }

    }
}
