package edu.galileo.android.photofeed;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;

import edu.galileo.android.photofeed.domain.di.DomainModule;
import edu.galileo.android.photofeed.libs.di.LibsModule;
import edu.galileo.android.photofeed.login.di.DaggerLoginComponent;
import edu.galileo.android.photofeed.login.di.LoginComponent;
import edu.galileo.android.photofeed.login.di.LoginModule;
import edu.galileo.android.photofeed.login.ui.LoginView;
import edu.galileo.android.photofeed.main.di.DaggerMainComponent;
import edu.galileo.android.photofeed.main.di.MainComponent;
import edu.galileo.android.photofeed.main.di.MainModule;
import edu.galileo.android.photofeed.main.ui.MainView;
import edu.galileo.android.photofeed.photolist.di.DaggerPhotoListComponent;
import edu.galileo.android.photofeed.photolist.di.PhotoListComponent;
import edu.galileo.android.photofeed.photolist.di.PhotoListModule;
import edu.galileo.android.photofeed.photolist.ui.PhotoListFragment;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;
import edu.galileo.android.photofeed.photolist.ui.adapters.OnItemClickListener;
import edu.galileo.android.photofeed.photomap.di.DaggerPhotoMapComponent;
import edu.galileo.android.photofeed.photomap.di.PhotoMapComponent;
import edu.galileo.android.photofeed.photomap.di.PhotoMapModule;
import edu.galileo.android.photofeed.photomap.ui.PhotoMapFragment;
import edu.galileo.android.photofeed.photomap.ui.PhotoMapView;

/**
 * Created by avalo.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "https://android-photo-feed-j.firebaseio.com/";

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        photoFeedAppModule = new PhotoFeedAppModule(this);
        domainModule = new DomainModule(FIREBASE_URL);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public String getEmailKey() {
        return EMAIL_KEY;
    }

    public String getSharedPreferencesName() {
        return SHARED_PREFERENCES_NAME;
    }

    public LoginComponent getLoginComponent(LoginView view){
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .loginModule(new LoginModule(view))
                .build();
    }

    public MainComponent getMainComponent(MainView view, String[] titles, Fragment[] fragments, FragmentManager manager){
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .mainModule(new MainModule(view, titles, fragments, manager))
                .build();
    }

    public PhotoListComponent getPhotoListComponent(PhotoListFragment fragment, PhotoListView view, OnItemClickListener onItemClickListener){
        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(fragment))
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();
    }

    public PhotoMapComponent getPhotoMapComponent(PhotoMapFragment fragment, PhotoMapView view) {
        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(fragment))
                .photoMapModule(new PhotoMapModule(view))
                .build();
    }
}
