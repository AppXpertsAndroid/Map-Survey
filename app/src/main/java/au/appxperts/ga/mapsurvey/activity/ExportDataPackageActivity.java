package au.appxperts.ga.mapsurvey.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.ExportDataPackageGridAdapter;
import au.appxperts.ga.mapsurvey.adapters.ImportDataBundleAdapter;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by PC on 17-May-16.
 */
public class ExportDataPackageActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ExportDataPackageGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exportdatapackagegrid);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.exportData).setOnClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        adapter = new ExportDataPackageGridAdapter(this, getList());
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
                .setContentText("Import Completed Successfully!")

                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exportData:
                showProgressDialogDialog();
                break;
        }
    }
}
