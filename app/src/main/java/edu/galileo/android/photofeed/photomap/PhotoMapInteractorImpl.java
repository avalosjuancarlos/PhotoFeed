package edu.galileo.android.photofeed.photomap;

/**
 * Created by avalo.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor {
    private PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}
