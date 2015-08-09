package com.lin.mimo360.t_bone;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ProgressCallback;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyCardFragment extends Fragment {


    public MoneyCardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money_card, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("menuitem");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                TextView textView = (TextView)getView().findViewById(R.id.textView2);
                textView.setText(list.get(0).getObjectId());
            }
        });

//        parseQuery.getInBackground("NMSyKRZgoB", new GetCallback<ParseObject>() {
//            @Override
//            public void done(ParseObject parseObject, ParseException e) {
//                ParseFile i = (ParseFile)parseObject.get("image01");
//                i.getDataInBackground(new GetDataCallback() {
//                    @Override
//                    public void done(byte[] bytes, ParseException e) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0 , bytes.length);
//                        ImageView imageView = (ImageView)getView().findViewById(R.id.imageView2);
//                        imageView.setImageBitmap(bitmap);
//
//                    }
//                });
//            }
//        });
    }
}