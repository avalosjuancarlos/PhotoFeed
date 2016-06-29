package edu.galileo.android.photofeed.main;

import android.location.Location;

/**
 * Created by avalo.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
