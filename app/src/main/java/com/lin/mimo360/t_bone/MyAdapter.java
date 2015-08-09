package com.lin.mimo360.t_bone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mimo360 on 2015/7/21.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoider> {
    Context context;
    //TextView textView;
   // ImageView imageView;
    List<String> list;
    List<Integer> heights;
    List<ParseObject> parseObjectList;
    List<Bitmap> bitmapList;


    public MyAdapter(Context context, List<ParseObject> parseObjectList) {
        this.context = context;
        this.parseObjectList = parseObjectList;
        getRandomHeight(this.parseObjectList);
        //gBitmap();
    }
    private void getRandomHeight(List<ParseObject> parseObjectList){
        heights = new ArrayList<>();
        for (int i=0; i<=parseObjectList.size(); i++){
            heights.add((int)(400+Math.random()*150));
        }
    }

    public void gBitmap(){

        for (int i=0 ; i<=parseObjectList.size(); i++) {
            ParseFile parseFile= (ParseFile)parseObjectList.get(i).get("image01");
            parseFile.getDataInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, ParseException e) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    bitmapList.add(bitmap);
                }
            });
        }

    }
    @Override
    public ViewHoider onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item,parent,false);
       ViewHoider vh = new ViewHoider(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHoider vh, int position) {

        ViewGroup.LayoutParams params = vh.itemView.getLayoutParams();
        params.height = heights.get(position);
        vh.itemView.setLayoutParams(params);
        vh.textView.setText(parseObjectList.get(position).getString("name"));



    }

    @Override
    public int getItemCount() {
        return parseObjectList.size();
    }

    public static class ViewHoider extends RecyclerView.ViewHolder{
        private  TextView textView;
        private ImageView imageView;
        public ViewHoider(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.item1);
            //imageView = (ImageView)view.findViewById(R.id.icon);

        }
    }

}
