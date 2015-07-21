package com.lin.mimo360.t_bone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mimo360 on 2015/7/21.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoider> {
   TextView textView;
    List<String> list;
    public MyAdapter(List list) {
        this.list = list;
    }

    @Override
    public ViewHoider onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
       ViewHoider vh = new ViewHoider(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHoider vh, int position) {
    vh.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHoider extends RecyclerView.ViewHolder{
        private  TextView textView;

        public ViewHoider(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.item1);

        }
    }

}
