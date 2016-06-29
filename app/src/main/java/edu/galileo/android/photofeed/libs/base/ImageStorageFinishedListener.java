package edu.galileo.android.photofeed.libs.base;

/**
 * Created by avalo.
 */
public interface ImageStorageFinishedListener {
    void onSuccess();
    void onError(String error);
}
