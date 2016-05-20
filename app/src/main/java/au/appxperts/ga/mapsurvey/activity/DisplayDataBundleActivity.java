package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.GAApp;
import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.DisplayDataBundleAdapter;
import au.appxperts.ga.mapsurvey.adapters.ImportDataBundleAdapter;
import au.appxperts.ga.mapsurvey.requestresponse.Bundles;
import au.appxperts.ga.mapsurvey.requestresponse.GABundle;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DisplayDataBundleActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private DisplayDataBundleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_bundle);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.buttonBack).setOnClickListener(backClick);
        findViewById(R.id.deleteData).setOnClickListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        adapter = new DisplayDataBundleAdapter(this, getList());
        mRecyclerView.setAdapter(adapter);


    }


    public Bundles getList(){
        File file = new File(GAApp.FILE_ROOT_PATH+"/MAPSURVEY/BUNDLES/");
        if(!file.exists())file.mkdirs();
        File f = new File(file.getPath());
        File files[] = f.listFiles();
        Bundles bundles = new Bundles();
        for (int i = 0; i < files.length; i++) {
            GABundle gaBundle = new GABundle();
            gaBundle.bundleName = files[i].toString();
            bundles.getBundles().add(gaBundle);
        }

        return bundles;
    }



    public void showDeleteDialog(){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setCancelText("Cancel")
                .setConfirmText("Delete")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteData:

                showDeleteDialog();

                break;
        }
    }


    public void deleteFiles(){
        for (GABundle gaBundle:adapter.getFeedItemList().getBundles()) {
            if(gaBundle.bundleStatus){
             //   urls.add(gaBundle.bundleName);
            }
        }
//        if(urls.size()>0){
//
//        }else{
//          //  showInfoDialog("Please select any file.",SweetAlertDialog.ERROR_TYPE);
//            return;
//        }
    }
}
