package com.lin.mimo360.t_bone;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by mimo360 on 2015/7/23.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this,"ilQVgYAHNJohPs9JDJq7ERWJj6vQFe2ASvBRvkSL","J8QFDWCyeCZqWeUsvwUzmenoQrIaj95QFDbQSFNT");

    }
}
