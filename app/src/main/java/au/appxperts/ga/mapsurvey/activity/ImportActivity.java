package au.appxperts.ga.mapsurvey.activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspsine.multithreaddownload.CallBack;
import com.aspsine.multithreaddownload.DownloadException;
import com.aspsine.multithreaddownload.DownloadManager;
import com.aspsine.multithreaddownload.DownloadRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.GAApp;
import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.ImportDataBundleAdapter;
import au.appxperts.ga.mapsurvey.progressdialog.ProgressDialog;
import au.appxperts.ga.mapsurvey.requestresponse.Bundles;
import au.appxperts.ga.mapsurvey.requestresponse.GABundle;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;

public class ImportActivity extends BaseActivity  implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ImageView emptyView;
    private ImportDataBundleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.importData).setOnClickListener(this);
        findViewById(R.id.emptyView).setOnClickListener(this);

        emptyView = (ImageView) findViewById(R.id.emptyView);
        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mRecyclerView.setHasFixedSize(true);

        emptyView.setVisibility(View.GONE);

        listAllBundles();


    }







    public void showInfoDialog(String message, int type){
        new SweetAlertDialog(this, type)
                .setTitleText("")

                .setContentText(message)
                .show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.importData:
                startFileDownloading();
                break;

            case R.id.emptyView:
                listAllBundles();
                break;

        }
    }





    public void listAllBundles(){
        AsyncHttpClient client = new AsyncHttpClient();
        showProgressDialogDialog();
        client.get("http://projectsonseoxperts.net.au/mapsurvey/", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                hideProgressDialogDialog();
                String data = new String(responseBody);
                mRecyclerView.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);

                if(data!=null){
                    try {
                        JSONObject jsonObject = new JSONObject(data);
                        JSONArray bundlesArray = jsonObject.getJSONArray("bundles");
                        Bundles bundles = new Bundles();
                        for (int i =0 ; i <bundlesArray.length();i++) {
                            GABundle gaBundle = new GABundle();
                            gaBundle.bundleName = bundlesArray.get(i).toString();
                            bundles.getBundles().add(gaBundle);
                        }

                        adapter = new ImportDataBundleAdapter(ImportActivity.this,bundles);
                        mRecyclerView.setAdapter(adapter);

                    }catch (Exception e){
                        mRecyclerView.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                        emptyView.setImageResource(R.drawable.ic_data_found);
                    }
                }else{
                    mRecyclerView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                    emptyView.setImageResource(R.drawable.ic_data_found);
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.print("Error");
                hideProgressDialogDialog();
                mRecyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
                emptyView.setImageResource(R.drawable.ic_error_page);
            }
        });
    }

    ProgressDialog dialog;
    public void startFileDownloading(){
        List<String> urls = new ArrayList<>();
        int index =0;
        if(adapter!=null){
            if(adapter.getFeedItemList().getBundles().size()>0){

                for (GABundle gaBundle:adapter.getFeedItemList().getBundles()) {
                    if(gaBundle.bundleStatus){
                        urls.add(gaBundle.bundleName);
                    }
                }
                if(urls.size()>0){

                }else{
                    showInfoDialog("Please select any file.",SweetAlertDialog.ERROR_TYPE);
                    return;
                }

            }else{
                showInfoDialog("Please select any file.",SweetAlertDialog.ERROR_TYPE);
                return;
            }
        }else{
            showInfoDialog("Please select any file.",SweetAlertDialog.ERROR_TYPE);
            return;
        }
        dialog = ProgressDialog.show(ImportActivity.this);
        setDownLoadManager(urls,0);

    }


    public void setDownLoadManager(final List<String> urls,final int postion){
        final String url = urls.get(postion);
        final String fileName = url.substring(url.lastIndexOf('/') + 1);
        File file = new File(GAApp.FILE_ROOT_PATH+"/MAPSURVEY/BUNDLES/");
        if(!file.exists())file.mkdirs();
        final DownloadRequest request = new DownloadRequest.Builder()
                .setTitle(fileName)
                .setUri(url)
                .setFolder(file)
                .build();

        dialog.setProgress(0);
        dialog.setMessage(fileName+"  Downloading...");


        DownloadManager.getInstance().download(request, url, new CallBack() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onConnecting() {
                dialog.setMessage("Download Starting....");
            }

            @Override
            public void onConnected(long total, boolean isRangeSupport) {
                dialog.setMessage(fileName + "  Downloading....");
            }

            @Override
            public void onProgress(long finished, long total, int progress) {
                dialog.setProgress(progress);
            }

            @Override
            public void onCompleted() {
                dialog.setProgress(100);
                dialog.setMessage(fileName + "  Completed");
                if(postion!=urls.size()-1) {
                    setDownLoadManager(urls, postion + 1);
                }else{
                    for (GABundle gaBundle:adapter.getFeedItemList().getBundles()) {
                        gaBundle.bundleStatus =false;
                        adapter.notifyDataSetChanged();
                    }
                    dialog.dismiss();
                    showInfoDialog("Import Successfully Completed", SweetAlertDialog.SUCCESS_TYPE);
                }
            }

            @Override
            public void onDownloadPaused() {

            }

            @Override
            public void onDownloadCanceled() {

            }

            @Override
            public void onFailed(DownloadException e) {

            }
        });

    }


}
