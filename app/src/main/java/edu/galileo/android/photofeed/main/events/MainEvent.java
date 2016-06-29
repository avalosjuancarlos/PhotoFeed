package edu.galileo.android.photofeed.main.events;

/**
 * Created by avalo.
 */
public class MainEvent {
    private int type;
    private String error;
    public static final int UPLOAD_INIT = 0;
    public static final int UPLOAD_COMPLETE = 1;
    public static final int UPLOAD_ERROR = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
