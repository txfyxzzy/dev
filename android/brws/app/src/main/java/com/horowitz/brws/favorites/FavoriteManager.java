package com.horowitz.brws.favorites;

import android.content.Context;

import com.horowitz.brws.R;

public class FavoriteManager {

    private static FavoriteManager sFavoriteManager;
    private FavoriteContainer mRoot;
    private int mBookmarksFolderTitleResId;

    public static synchronized FavoriteManager getInstance() {
        if (sFavoriteManager == null) {
            sFavoriteManager =
                    new FavoriteManager(R.string.bookmarks_fragment_title);
        }
        return sFavoriteManager;
    }

    protected FavoriteManager(int bookmarksFolderTitleResId) {
        mBookmarksFolderTitleResId = bookmarksFolderTitleResId;
    }

    public void initialize(Context appContext) {
        mRoot = new FavoriteContainer();
    }
}
