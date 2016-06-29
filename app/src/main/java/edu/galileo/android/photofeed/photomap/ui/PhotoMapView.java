package edu.galileo.android.photofeed.photomap.ui;

import edu.galileo.android.photofeed.entities.Photo;

/**
 * Created by avalo.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
