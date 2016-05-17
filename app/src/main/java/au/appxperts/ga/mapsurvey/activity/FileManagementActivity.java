package au.appxperts.ga.mapsurvey.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

import au.appxperts.ga.mapsurvey.R;

public class FileManagementActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);

        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.IDB).setOnClickListener(nextClick(getMIntent(getString(R.string.import_data_bundle),ImportActivity.class),false));
        findViewById(R.id.DDB).setOnClickListener(nextClick(getMIntent(getString(R.string.display_data_bundle),DisplayDataBundleActivity.class),false));
        findViewById(R.id.PDP).setOnClickListener(nextClick(getMIntent(getString(R.string.pdp), PackageDataPoints.class),false));
        findViewById(R.id.ISDP).setOnClickListener(nextClick(getMIntent(getString(R.string.export_data_package), ExportActivity.class),false));
        findViewById(R.id.EDP).setOnClickListener(nextClick(getMIntent(getString(R.string.title_populatetemplateactivity), PopulateTemplateActivity.class),false));
        findViewById(R.id.MGPST).setOnClickListener(nextClick(getMIntent(getString(R.string.manage_gps), ManageGpsTrackActivity.class),false));
    }




}
