package com.lin.mimo360.t_bone;


import android.content.Context;
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

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    RecyclerView rv ;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager lm= null;
    List<ParseObject> todos = new ArrayList<>();
    List<String> strmenuList = new ArrayList<>();
    List<ParseFile> fileList = new ArrayList<>();


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new task().execute();
        test();

        // parseQuery();
        //test();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRV();

    }

        private void setRV() {
        rv = (RecyclerView) getView().findViewById(R.id.recyclerview);
       //rv.addItemDecoration();
        lm = new StaggeredGridLayoutManager(2,1);

        //lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);

        myAdapter = new MyAdapter(getActivity(),strmenuList);
        rv.setAdapter(myAdapter);
    }




    public class task extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("menuitem");
            try {
                todos = query.find();

            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
            }
            strmenuList.clear();
            for (ParseObject todo : todos){
                strmenuList.add(todo.getString("name"));
                fileList.add(todo.getParseFile("image01"));
            }

           return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
//            myAdapter = new MyAdapter(getActivity(),strmenuList);
//            rv.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }
    }

    private void test(){
        for (int i= 0 ;i<=5; i++){
            strmenuList.add("");
        }
    }
}
