package edu.galileo.android.photofeed.photomap.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.photofeed.PhotoFeedAppModule;
import edu.galileo.android.photofeed.domain.di.DomainModule;
import edu.galileo.android.photofeed.libs.di.LibsModule;
import edu.galileo.android.photofeed.photomap.ui.PhotoMapFragment;

/**
 * Created by avalo.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment target);
}
