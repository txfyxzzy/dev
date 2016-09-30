package com.horowitz.brws.favorites;

import android.support.v4.util.LongSparseArray;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class FavoriteContainer extends Favorite implements Iterable<Favorite> {
    private final List<Favorite> mEntries = new Vector<>();
    private final LongSparseArray<Favorite> mIDEntries = new LongSparseArray<Favorite>();

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getThumbnail() {
        return null;
    }

    public Favorite.Type getType() {
        return Favorite.Type.FOLDER_VIEW_TYPE;
    }

    @Override
    public Iterator<Favorite> iterator() {
        return mEntries.iterator();
    }

    public int getItemCount() {
        return mEntries.size();
    }

    public Favorite getFavorite(int position) {
        return mEntries.get(position);
    }

    public Favorite getFavoriteFromId(long id) {
        return mIDEntries.get(id);
    }

    public void addFavorite(int position, Favorite favorite) {
        internalAddFavorite(position, favorite);
    }

    private void internalAddFavorite(int position, Favorite favorite) {
        if (position >= 0) {
            this.mEntries.add(position, favorite);
        } else {
            this.mEntries.add(favorite);
        }
        mIDEntries.put(favorite.getId(), favorite);
    }

}