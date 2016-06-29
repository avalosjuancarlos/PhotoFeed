package edu.galileo.android.photofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by avalo.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
