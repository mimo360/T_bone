package com.lin.mimo360.t_bone;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mimo360 on 2015/7/23.
 */
public class MyApplication extends Application {
    public static List<ParseObject> todos = new  ArrayList<>();
    public static List<String> parseId= new ArrayList<>();
    public static List<Bitmap> bitmapArrayList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this,"ilQVgYAHNJohPs9JDJq7ERWJj6vQFe2ASvBRvkSL","J8QFDWCyeCZqWeUsvwUzmenoQrIaj95QFDbQSFNT");
        new task().execute();
    }

    private class task extends AsyncTask {
        @Override
        protected Object doInBackground(final Object[] params) {
            ParseQuery<ParseObject> query = ParseQuery.getQuery("menuitem");
            try {
                todos = query.find();
//
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
            }


            return null;
        }
    }

}
