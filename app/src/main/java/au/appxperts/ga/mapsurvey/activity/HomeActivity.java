package au.appxperts.ga.mapsurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import au.appxperts.ga.mapsurvey.R;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.startSurvey).setOnClickListener(nextClick(new Intent(getApplicationContext(), HomeActivity.class), true));
        findViewById(R.id.fileManagment).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));


    }

}
