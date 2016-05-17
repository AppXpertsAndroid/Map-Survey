package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.PackageDataPointsAdapter;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by PC on 16-May-16.
 */
public class PackageDataPoints extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private PackageDataPointsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdp);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
       // findViewById(R.id.buttonBack).setOnClickListener(backClick);
        findViewById(R.id.packageData).setOnClickListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PackageDataPointsAdapter(this, getList());
        mRecyclerView.setAdapter(adapter);


    }


    public List<String> getList() {
        int i = 0;
        List<String> strings = new ArrayList<>();
        strings.add("data1 " + ++i);
        strings.add("data1 " + ++i);
        strings.add("data1 " + ++i);
        strings.add("data1 " + ++i);
        strings.add("data1 " + ++i);
        strings.add("data1 " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);
        strings.add("data " + ++i);


        return strings;
    }


    public void packageDataDialog() {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Package")
                .setContentText("Package is Clicked!")
                .setCancelText("No,cancel plz!")
                .setConfirmText("Yes,Package chosen!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();

                       startActivity(getMIntent(getString(R.string.package_data_points_successful),SuccessfulPackageOperationActivity.class));
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.packageData:

                packageDataDialog();

                break;
        }
    }
}

