package com.lin.mimo360.t_bone;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
FloatingActionButton fab;
    TabLayout tab;
    private  MainFragment mf = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settoolbar();
        setFragment();

       //setupFab();
       // setTab();
    }




    private void setFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
         mf =new MainFragment();
        ft.add(R.id.flay,mf,"MainFragment");
        ft.addToBackStack(null);
        ft.commit();

    }

//    private void setTab() {
//        tab = (TabLayout)findViewById(R.id.tab);
//        tab.setTabGravity(TabLayout.GRAVITY_FILL);
//        tab.addTab(tab.newTab().setText("療癒系"));
//        tab.addTab(tab.newTab().setText("盆栽系"));
//    }

//    private void setupFab() {
//        fab = (FloatingActionButton)findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(findViewById(R.id.drawer),
//                        "這是訊息",
//                        Snackbar.LENGTH_LONG )
//                        .show();
//            }
//        });
//    }

    private void settoolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toobar);
        toolbar.setTitle("丁骨工作室T-bone");
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        toggle1.syncState();
        drawer.setDrawerListener(toggle1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
