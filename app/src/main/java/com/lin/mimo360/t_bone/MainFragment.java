package com.lin.mimo360.t_bone;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    RecyclerView rv ;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager lm;
    List<ParseObject> todos = new ArrayList<>();
    List<String> strlist = new ArrayList<>();
    List<ParseObject> bittodos = new ArrayList<>();
    List<Bitmap> bitmaptodolist = new ArrayList<>();



    public MainFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Task task = new Task();
        task.execute();


    }

    public class Task extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] params) {
            ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("menuitem");
            try {
                todos = parseQuery.find();
                for(ParseObject p : todos) {
                    String s = p.getString("name");
                    strlist.add(s);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

            ParseQuery<ParseObject> parseQuery1 = ParseQuery.getQuery("menuitem");
            try {
                bittodos = parseQuery1.find();
                for(ParseObject p : bittodos){
                    ParseFile parseFile = (ParseFile)p.get("image01");
                    byte[] bytes = parseFile.getData();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0 , bytes.length);
                    Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap,80,60,false);
                    bitmaptodolist.add(bitmap1);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            rv = (RecyclerView) getActivity().findViewById(R.id.recycleview);
            lm = new StaggeredGridLayoutManager(1,1);
            //lm = new LinearLayoutManager(getActivity());
            rv.setLayoutManager(lm);
            //setdata();
            myAdapter = new MyAdapter(getActivity(), strlist, bitmaptodolist);
            rv.setAdapter(myAdapter);
        }
    }


}
