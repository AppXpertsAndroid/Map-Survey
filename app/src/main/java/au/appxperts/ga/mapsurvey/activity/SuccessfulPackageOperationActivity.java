package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.PackageDataPointsAdapter;
import au.appxperts.ga.mapsurvey.adapters.SuccessfulPackageOperationAdapter;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;

/**
 * Created by PC on 17-May-16.
 */
public class SuccessfulPackageOperationActivity  extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private SuccessfulPackageOperationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdp_successful);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);



        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        adapter = new SuccessfulPackageOperationAdapter(this, getList());
//        mRecyclerView.setAdapter(adapter);

        listAllBundles();

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


                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.packageData:

                //packageDataDialog();

                break;
        }
    }


   public void listAllBundles(){
       AsyncHttpClient client = new AsyncHttpClient();
       client.get("http://projectsonseoxperts.net.au/mapsurvey", new AsyncHttpResponseHandler() {
           @Override
           public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

               System.out.print(new String(responseBody));

           }

           @Override
           public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

           }
       });
   }

}
