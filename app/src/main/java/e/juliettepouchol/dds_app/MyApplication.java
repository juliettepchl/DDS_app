package e.juliettepouchol.dds_app;

import android.app.Application;
import android.content.Context;

/**
 * Created by juliettepouchol on 13/05/2018.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}