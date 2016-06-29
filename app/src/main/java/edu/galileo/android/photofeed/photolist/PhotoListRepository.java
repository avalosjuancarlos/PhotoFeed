package edu.galileo.android.photofeed.photolist;

import edu.galileo.android.photofeed.entities.Photo;

/**
 * Created by avalo.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
