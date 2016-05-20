package au.appxperts.ga.mapsurvey;

import android.app.Application;
import android.os.Environment;

import com.aspsine.multithreaddownload.DownloadConfiguration;
import com.aspsine.multithreaddownload.DownloadManager;

/**
 * Created by PRAKASH SINGH on 11/05/16.
 */
public class GAApp extends Application {


    public static String FILE_ROOT_PATH = "";

    private  static GAApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDownloader();
        FILE_ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
    }



    /*
    Invoke Singleton instance for app context
     */
    public static GAApp instance(){
        return instance;
    }


    private void initDownloader() {
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(3);
        DownloadManager.getInstance().init(getApplicationContext(), configuration);
    }

}
