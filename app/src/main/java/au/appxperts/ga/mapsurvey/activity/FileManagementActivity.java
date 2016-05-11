package au.appxperts.ga.mapsurvey.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.appxperts.ga.mapsurvey.R;

public class FileManagementActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);

        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.IDB).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
        findViewById(R.id.DDB).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
        findViewById(R.id.PDP).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
        findViewById(R.id.EDP).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
        findViewById(R.id.ISDP).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
        findViewById(R.id.MGPST).setOnClickListener(nextClick(new Intent(getApplicationContext(), FileManagementActivity.class),false));
    }
}
