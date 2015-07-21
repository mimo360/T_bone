package com.lin.mimo360.t_bone;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    RecyclerView rv ;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager lm;
    List<String> list = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
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
        test();
        setRV();

    }

    private void setRV() {
        rv = (RecyclerView) getView().findViewById(R.id.recyclerview);
        lm = new StaggeredGridLayoutManager(2,1);
        //lm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);
        myAdapter = new MyAdapter(list);
        rv.setAdapter(myAdapter);
    }

    private void test() {
        for(int i=0; i<50; i++){
            list.add(""+i);
        }
    }

}
