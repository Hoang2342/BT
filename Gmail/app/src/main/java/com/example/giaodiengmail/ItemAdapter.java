package com.example.giaodiengmail;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ItemAdapter extends BaseAdapter {
    List<ItemModel> items;
    Random rd;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;

        if (view == null) {
            view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item_layout, null);
            viewHolder = new MyViewHolder();
            viewHolder.textView1 = view.findViewById(R.id.text_view1);
            viewHolder.textView2 = view.findViewById(R.id.text_view2);
            viewHolder.textView3 = view.findViewById(R.id.text_view3);
            viewHolder.imageView = view.findViewById(R.id.image_view1);

            view.setTag(viewHolder);
        }else {
            viewHolder = (MyViewHolder) view.getTag();
        }

        ItemModel item = items.get(i);
        String text2 = item.getTile2();

        viewHolder.textView1.setText(Character.toString(Character.toUpperCase(text2.charAt(0))));

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageView.setColorFilter(Color.YELLOW);
                Log.v("TAG",item+"is Selected");
                notifyDataSetChanged();
            }
        });

        return view;
    }
    class MyViewHolder{
        TextView textView1 ;
        TextView textView2 ;
        TextView textView3 ;
        ImageView imageView ;
    }
}
