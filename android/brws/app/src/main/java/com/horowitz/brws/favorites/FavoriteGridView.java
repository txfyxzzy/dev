package com.horowitz.brws.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

public class FavoriteGridView extends AdapterView<FavoritesAdapter> {

    public FavoriteGridView(Context context) {
        super(context);
    }

    public FavoriteGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FavoriteGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public FavoritesAdapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(FavoritesAdapter favoritesAdapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int i) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private View obtainView(int position) {
        return null;
    }
}
