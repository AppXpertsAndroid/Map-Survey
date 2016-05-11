package au.appxperts.ga.mapsurvey.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.activity.BaseActivity;

public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler();
    private final long SPLASH_DURATION = 5000l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(splashRunnable, SPLASH_DURATION);
        findViewById(R.id.aboutUs).setOnClickListener(nextClick(new Intent(getApplicationContext(), HomeActivity.class),true));
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
        }
    };
}
