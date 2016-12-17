package com.horowitz.brws;

import android.app.Application;

import com.horowitz.brws.util.SystemUtil;

/**
 * Created by benz on 16-12-17.
 */
public class BrwsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemUtil.setAppContext(this);
    }
}
