package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;

import au.appxperts.ga.mapsurvey.R;

/**
 * Created by PC on 17-May-16.
 */
public class PopulateTemplateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate_template);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
    }
}
