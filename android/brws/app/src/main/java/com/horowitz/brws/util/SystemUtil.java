package com.horowitz.brws.util;

import android.content.Context;

/**
 * Created by benz on 16-12-17.
 */
public class SystemUtil {
    private static Context sAppContext;
    public static void setAppContext (Context context) {
        sAppContext = context;
    }
    public static Context getAppContext() {
        return sAppContext;
    }
}
