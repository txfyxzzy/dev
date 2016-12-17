package com.horowitz.brws.favorites;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.horowitz.brws.R;

public class FavoritesAdapter extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {

    private final FavoriteContainer mRoot;

    public FavoritesAdapter() {
        mRoot = null;
    }

    public FavoritesAdapter(FavoriteContainer favoriteContainer) {
        mRoot = favoriteContainer;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Favorite favorite = (Favorite) getItem(i);
        View v = view;
        Favorite.Type viewType = favorite.getType();
        if (v == null) {
            v = inflateView(viewGroup.getContext(), viewGroup, viewType);
        }
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        return v;
    }

    protected View inflateView(Context context, ViewGroup parent, Favorite.Type viewType) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(viewType.layoutResId, parent, false);

        final Resources r = context.getResources();
        if (viewType.thumbnailViewId != 0) {
            final ImageView iv = (ImageView) view.findViewById(viewType.thumbnailViewId);
            //iv.setThumbnailResource(viewType.thumbnailResId);
            iv.setImageResource(viewType.thumbnailResId);
        }

        final TextView tv = (TextView) view.findViewById(R.id.title);
        //tv.setTextColor(mTitleColor);
        tv.setTextSize(
                TypedValue.COMPLEX_UNIT_PX, r.getDimension(R.dimen.grid_item_title_size));

        return view;
    }


    @Override
    public void onClick(View view) {
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}
