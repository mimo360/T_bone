package com.lin.mimo360.t_bone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mimo360 on 2015/7/21.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoider> {
    Context context;
    TextView textView;
    List<String> list;
    List<Integer> heights;
    public MyAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
        getRandomHeight(this.list);
    }
    private void getRandomHeight(List<String> list){
        heights = new ArrayList<>();
        for (int i=0; i<=list.size(); i++){
            heights.add((int)(300+Math.random()*170));
        }


    }

    @Override
    public ViewHoider onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
       ViewHoider vh = new ViewHoider(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHoider vh, int position) {
        ViewGroup.LayoutParams params = vh.itemView.getLayoutParams();
        params.height = heights.get(position);
        vh.itemView.setLayoutParams(params);
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
