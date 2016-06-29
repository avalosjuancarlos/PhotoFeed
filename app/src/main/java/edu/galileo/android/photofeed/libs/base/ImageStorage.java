package edu.galileo.android.photofeed.libs.base;

import java.io.File;

/**
 * Created by avalo.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
