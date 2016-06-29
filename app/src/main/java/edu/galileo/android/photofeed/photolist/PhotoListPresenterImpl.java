package edu.galileo.android.photofeed.photolist;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.photofeed.entities.Photo;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.photolist.events.PhotoListEvent;
import edu.galileo.android.photofeed.photolist.ui.PhotoListView;

/**
 * Created by avalo.
 */
public class PhotoListPresenterImpl implements PhotoListPresenter {
    private EventBus eventbus;
    private PhotoListView view;
    private PhotoListInteractor interactor;
    private static final String EMPTY_LIST = "Listado vacío";

    public PhotoListPresenterImpl(EventBus eventbus, PhotoListView view, PhotoListInteractor interactor) {
        this.eventbus = eventbus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventbus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventbus.unregister(this);
    }

    @Override
    public void subscribe() {
        if(view != null){
            view.hideList();
            view.showProgress();
        }
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        interactor.removePhoto(photo);
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoListEvent event) {
        if(view != null){
            view.hideProgress();
            view.showList();
        }
        String error = event.getError();
        if(error != null){
            if(error.isEmpty()){
                view.onPhotosError(EMPTY_LIST);
            } else {
                view.onPhotosError(error);
            }
        } else {
            if(event.getType() == PhotoListEvent.READ_EVENT){
                view.addPhoto(event.getPhoto());
            } else if(event.getType() == PhotoListEvent.DELETE_EVENT){
                view.removePhoto(event.getPhoto());
            }
        }
    }
}
