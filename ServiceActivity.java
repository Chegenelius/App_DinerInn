package ke.co.dinerinn.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ke.co.dinerinn.Javaclass.MyService;
import ke.co.dinerinn.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        getSupportActionBar().setTitle("DinerInn Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void  movenxt(final View v){
        //Intent
        Intent nxt= new Intent(this, JobschedulerActivity.class);
        startActivity(nxt);
    }
    public void  playmusic(final View v){
        //Intent
        Intent play= new Intent(this, MyService.class);
        startService(play);
    }

}