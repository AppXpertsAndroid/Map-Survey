package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.view.View;

import au.appxperts.ga.mapsurvey.R;

/**
 * Created by PC on 17-May-16.
 */
public class PopulateTemplateActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populate_template);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.content_populate_template_ll_btm_secondchild).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.content_populate_template_ll_btm_firstchild:

                break;
            case R.id.content_populate_template_ll_btm_secondchild:
                    startActivity(getMIntent(getString(R.string.title_pointphotos),PointPhotos.class));
                break;
            case R.id.content_populate_template_ll_btm_thirdchild:

                break;
            case R.id.content_populate_template_ll_btm_fourthchild:

                break;
        }

    }
}
