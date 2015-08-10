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
import android.widget.TextView;

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
    RecyclerView.LayoutManager lm;
    List<ParseObject> todos = new ArrayList<>();
    List<String> strlist = new ArrayList<>();




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
        rv = (RecyclerView)getView().findViewById(R.id.recycleview);
        lm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(lm);
        setdata();
        myAdapter = new MyAdapter(getActivity(),todos);
        rv.setAdapter(myAdapter);


    }

        private void setRV() {
        rv = (RecyclerView) getActivity().findViewById(R.id.recycleview);
        lm = new StaggeredGridLayoutManager(2,1);
        //lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
            //setdata();
        myAdapter = new MyAdapter(getActivity(),todos);
        rv.setAdapter(myAdapter);
    }

    private void setdata() {
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("menuitem");
        try {
            todos = parseQuery.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
