package com.horowitz.brws.startpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class StartPageViewProvider {

    public abstract View createStartPageView(LayoutInflater inflater, ViewGroup container);
    public void destroyStartPageView(View view) {
    }
    public void onStartPageVisibilityChanged(boolean visible) {
    }
    public void startPageViewConnected(View view) {
    }
    public void onPause(boolean shown) {
    }
    public void onResume(boolean shown) {
    }
    public void onActive(boolean shown) {
    }
    public void onDeactive(boolean shown) {
    }
}
