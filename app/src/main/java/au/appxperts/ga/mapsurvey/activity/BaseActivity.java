package au.appxperts.ga.mapsurvey.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import au.appxperts.ga.mapsurvey.GAApp;
import au.appxperts.ga.mapsurvey.R;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    public static void showToast(String message){
        Toast.makeText(GAApp.instance(),message+"",Toast.LENGTH_SHORT).show();
    }





    protected View.OnClickListener backClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             finish();
        }
    };


    protected View.OnClickListener nextClick = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View v) {
           startActivity(intent);
        }
    };

    public View.OnClickListener nextClick(final Intent intent){

        View.OnClickListener click = new View.OnClickListener() {
            Intent mIntent = intent;
            @Override
            public void onClick(View v) {
                startActivity(mIntent);
            }
        };

        return click;
    }


    public View.OnClickListener nextClick(final Intent intent,final boolean isFinisable){

        View.OnClickListener click = new View.OnClickListener() {
            Intent mIntent = intent;
            @Override
            public void onClick(View v) {
                startActivity(mIntent);
                if(isFinisable)finish();
            }
        };

        return click;
    }

    protected Intent getMIntent(String title,Class<?> activity){
        Intent intent = new Intent(getApplicationContext(),activity);
        intent.putExtra("title",title);
        return intent;
    }



    protected void setMTitle(CharSequence title) {
        ( (TextView)findViewById(R.id.headerTitle)).setText(title+"");
    }
}
