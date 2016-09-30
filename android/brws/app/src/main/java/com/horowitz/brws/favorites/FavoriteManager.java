package com.horowitz.brws.favorites;

import android.content.Context;

import com.horowitz.brws.R;

public class FavoriteManager {

    private static FavoriteManager sFavoriteManager;
    private FavoriteContainer mRoot;

    public static synchronized FavoriteManager getInstance() {
        if (sFavoriteManager == null) {
            sFavoriteManager =
                    new FavoriteManager(true, R.string.bookmarks_fragment_title);
        }
        return sFavoriteManager;
    }

    public void initialize(Context appContext) {
        mRoot = new FavoriteContainer();
    }
}
