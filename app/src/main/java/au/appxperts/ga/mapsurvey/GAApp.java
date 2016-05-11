package au.appxperts.ga.mapsurvey;

import android.app.Application;

/**
 * Created by PRAKASH SINGH on 11/05/16.
 */
public class GAApp extends Application {



    private  static GAApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }



    /*
    Invoke Singleton instance for app context
     */
    public static GAApp instance(){
        return instance;
    }

}
