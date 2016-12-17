package com.horowitz.brws.favorites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horowitz.brws.R;

public class FavoriteItemView {

    public enum TypeInfo {

        SINGLE_FAVORITE_VIEW_TYPE(R.layout.grid_item,
                R.id.grid_image_folder,
                R.drawable.folder_preview_bg,
                true) {},
        FOLDER_VIEW_TYPE(R.layout.grid_folder_item,
                R.id.folder_bg_image,
                R.drawable.folder_preview_bg,
                true) {},
        SAVED_PAGE_FOLDER_VIEW_TYPE(R.layout.grid_iconed_folder_item,
                                    R.id.folder_bg_image,
                                    R.drawable.saved_pages_folder_bg,
                                    true) {},
        BOOKMARK_FOLDER_VIEW_TYPE(R.layout.grid_iconed_folder_item,
                                  R.id.folder_bg_image,
                                  R.drawable.bookmark_folder_bg,
                                  true) {};

        public final int layoutResId;
        public final int thumbnailViewId;
        public final int thumbnailResId;
        public final boolean hapticFeedbackEnabled;

        TypeInfo(int layoutResId, int thumbnailViewId, int thumbnailResId,
             boolean hapticFeedbackEnabled) {
            this.layoutResId = layoutResId;
            this.thumbnailViewId = thumbnailViewId;
            this.thumbnailResId = thumbnailResId;
            this.hapticFeedbackEnabled = hapticFeedbackEnabled;
        }
    }

    public FavoriteItemView() {
    }

    public View getView(Favorite favorite, View convertView, ViewGroup parent) {
        return null;
    }

}
