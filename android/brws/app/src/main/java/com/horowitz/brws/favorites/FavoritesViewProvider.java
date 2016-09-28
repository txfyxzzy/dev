package com.horowitz.brws.favorites;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.horowitz.brws.R;
import com.horowitz.brws.startpage.StartPageViewProvider;

public class FavoritesViewProvider extends StartPageViewProvider {

    private FavoriteGridView mGrid;
    private ScrollView mScrollView;

    public View createStartPageView(LayoutInflater inflater, ViewGroup container) {
        final ViewGroup v = (ViewGroup) inflater.inflate(R.layout.favorites_view, container, false);
        createGrid(container.getResources(), v);
        return v;
    }

    private void createGrid(Resources resources, View v) {
        mGrid = (FavoriteGridView) v.findViewById(R.id.grid);
        FavoritesAdapter adapter = new FavoritesAdapter();
        mGrid.setAdapter(adapter);
        mScrollView = (ScrollView) v.findViewById(R.id.scroll_view);
    }

    public void onStartPageVisibilityChanged(boolean visible) {
    }
    public void startPageViewConnected(View view) {
    }
    public void destroyStartPageView(View view) {
        mScrollView = null;
        mGrid = null;
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
