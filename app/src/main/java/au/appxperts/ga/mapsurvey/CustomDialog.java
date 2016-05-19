package au.appxperts.ga.mapsurvey;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

/**
 * Created by PC on 19-May-16.
 */
public class CustomDialog extends Dialog {


    int progressStatus = 0;

    ProgressBar progressBar;

    private Handler handler = new Handler();
    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        methodStartProgress();

    }


    public void methodStartProgress(){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
