package edu.galileo.android.photofeed.login.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.photofeed.domain.FirebaseAPI;
import edu.galileo.android.photofeed.libs.base.EventBus;
import edu.galileo.android.photofeed.login.LoginInteractor;
import edu.galileo.android.photofeed.login.LoginInteractorImpl;
import edu.galileo.android.photofeed.login.LoginPresenter;
import edu.galileo.android.photofeed.login.LoginPresenterImpl;
import edu.galileo.android.photofeed.login.LoginRepository;
import edu.galileo.android.photofeed.login.LoginRepositoryImpl;
import edu.galileo.android.photofeed.login.ui.LoginView;

/**
 * Created by avalo.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView(){
        return this.view;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor){
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository loginRepository){
        return new LoginInteractorImpl(loginRepository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseAPI firebaseAPI){
        return new LoginRepositoryImpl(eventBus, firebaseAPI);
    }
}
