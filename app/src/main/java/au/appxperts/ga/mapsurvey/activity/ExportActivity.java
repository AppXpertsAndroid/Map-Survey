package au.appxperts.ga.mapsurvey.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.ExportDataPackageAdapter;
import au.appxperts.ga.mapsurvey.adapters.ImportDataBundleAdapter;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ExportActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ExportDataPackageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edp);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.exportpackageData).setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExportDataPackageAdapter(this, getList());
        mRecyclerView.setAdapter(adapter);



    }



    public List<String> getList(){
        int i = 0;
        List<String> strings = new ArrayList<>();
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);



        return  strings;
    }



    SweetAlertDialog pDialog;
    public void showProgressDialogDialog(){
        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(pDialog!=null)pDialog.hide();
                showInfoDialog();
            }
        },3000);
        pDialog.show();
    }


    public void showInfoDialog(){
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setContentText("Export Completed Successfully!")

                .show();

        startActivity(getMIntent(getString(R.string.export_data_package),ExportDataPackageActivity.class));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exportpackageData:
                showProgressDialogDialog();
                break;
        }
    }
}
