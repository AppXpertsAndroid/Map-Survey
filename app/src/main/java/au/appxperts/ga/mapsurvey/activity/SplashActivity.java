package au.appxperts.ga.mapsurvey.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.activity.BaseActivity;
import au.appxperts.ga.mapsurvey.htmldialog.HtmlDialog;
import au.appxperts.ga.mapsurvey.htmldialog.HtmlDialogListener;

public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler();
    private final long SPLASH_DURATION = 5000l;
    private final long SPLASH_SHORT_DURATION = 1000l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(splashRunnable, SPLASH_DURATION);
        findViewById(R.id.aboutUs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutUs();
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(splashRunnable);
    }

    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
           startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }
    };



    public void showAboutUs(){
        handler.removeCallbacks(splashRunnable);
        new HtmlDialog.Builder(getFragmentManager())
                .setListener(listener)
                .setHtmlResId(R.raw.licenses)
                .setTitle(getResources().getString(R.string.about_us_title))
                .setShowNegativeButton(true)
                .setNegativeButtonText(getResources().getString(R.string.cancel))
                .setShowPositiveButton(true)
                .setPositiveButtonText(getResources().getString(R.string.next))
                        //.setCancelable(false)
                .build()
                .show();
    }


    HtmlDialogListener listener = new HtmlDialogListener() {
        @Override
        public void onNegativeButtonPressed() {
           // handler.postDelayed(splashRunnable, SPLASH_SHORT_DURATION);
        }

        @Override
        public void onPositiveButtonPressed() {
            handler.postDelayed(splashRunnable, SPLASH_SHORT_DURATION);
        }
        @Override
        public void onDialogCancel()
        {
            handler.postDelayed(splashRunnable, SPLASH_SHORT_DURATION);
        }
    };


}
