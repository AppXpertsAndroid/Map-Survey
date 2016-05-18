package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.DisplayDataBundleAdapter;
import au.appxperts.ga.mapsurvey.adapters.PointPhotosAdapter;

/**
 * Created by PC on 18-May-16.
 */
public class PointPhotos extends BaseActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    private PointPhotosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pointphotos);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);


        recyclerView = (RecyclerView) findViewById(R.id.bundles);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setHasFixedSize(true);

        adapter = new PointPhotosAdapter(this, getList());
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onClick(View v) {

    }
}
