package edu.galileo.android.photofeed.login.ui;

/**
 * Created by avalo.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void hangleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
    void setUserEmail(String email);
}
