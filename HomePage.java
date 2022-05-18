package ke.co.dinerinn.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ke.co.dinerinn.R;

public class HomePage extends AppCompatActivity {
    Button nextpagebtn;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

         nextpagebtn = findViewById(R.id.nextpage);
         nextpagebtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent thisint= new Intent(HomePage.this, ServiceActivity.class);
                 startActivity(thisint);
             }
         });

        ImageButton menubtn = (ImageButton)findViewById(R.id.menu_btn);
        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intenti = new Intent(HomePage.this, Networkcalls.class);
               startActivity(intenti);

            }

        });
        ImageButton cartbtn = (ImageButton)findViewById(R.id.cart_btn);
        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentc = new Intent(HomePage.this,ShopCart.class);
                startActivity(intentc);

            }
        });
        ImageButton bookbtn = (ImageButton)findViewById(R.id.bking_btn);
        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti = new Intent(HomePage.this,ReserveActivity.class);
                startActivity(inti);
            }
        });
        ImageButton orderbtn = (ImageButton)findViewById(R.id.order_btn);
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void makePhoneCall(){
        if(ContextCompat.checkSelfPermission(HomePage.this,
                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(HomePage.this,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
        else {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0796405653"));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ourmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.call:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0796405653"));
                startActivity(intent);
                return true;
            case R.id.notify:
                Toast.makeText(this,"Notification",Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://mukaminelius.wixsite.com/dinerinn"));
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}