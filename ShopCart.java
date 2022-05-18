package ke.co.dinerinn.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ke.co.dinerinn.Fragments.ShopcartFragment;
import ke.co.dinerinn.R;

public class ShopCart extends AppCompatActivity implements View.OnClickListener {
    Button addcart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_cart);

        getSupportActionBar().setTitle("Add to Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        addcart = findViewById(R.id.buttonaddcart);
        addcart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonaddcart){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new ShopcartFragment()).commit();
                addcart.setVisibility(View.GONE);

        }
    }
}