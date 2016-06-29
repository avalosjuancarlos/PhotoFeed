package edu.galileo.android.photofeed.main.ui;

/**
 * Created by avalo.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
