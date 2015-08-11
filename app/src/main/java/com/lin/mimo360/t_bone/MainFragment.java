package com.lin.mimo360.t_bone;


import android.app.ProgressDialog;
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
import com.parse.GetDataCallback;
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
    List<Bitmap>bitmaps = new ArrayList<>();
    ProgressDialog pD;



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
        pD = ProgressDialog.show(getActivity(),"訊息","資料讀取中,請稍後");

    }

    public class Task extends AsyncTask{
        @Override
        protected Object doInBackground(Object[] params) {
            ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("menuitem");
            try {
                todos = parseQuery.find();




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
            myAdapter = new MyAdapter(getActivity(), todos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rv.setAdapter(myAdapter);
            pD.dismiss();
        }
    }


}
