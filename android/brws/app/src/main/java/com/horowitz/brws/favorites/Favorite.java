package com.horowitz.brws.favorites;

import com.horowitz.brws.R;

public abstract class Favorite {

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getUrl();

    public abstract long getId();

    public abstract String getThumbnail();

    public abstract Type getType();

    public enum Type {

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

        Type(int layoutResId, int thumbnailViewId, int thumbnailResId,
             boolean hapticFeedbackEnabled) {
            this.layoutResId = layoutResId;
            this.thumbnailViewId = thumbnailViewId;
            this.thumbnailResId = thumbnailResId;
            this.hapticFeedbackEnabled = hapticFeedbackEnabled;
        }
    }

}
