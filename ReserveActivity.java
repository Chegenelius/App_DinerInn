package ke.co.dinerinn.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ke.co.dinerinn.models.ReserveModel;
import ke.co.dinerinn.R;
import ke.co.dinerinn.adapters.ReserveAdapter;

public class ReserveActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ReserveModel>reserveModels;
    ReserveAdapter reserveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        recyclerView =findViewById(R.id.recycler_v);
        Integer[] langimage = {R.drawable.menu1,R.drawable.menu2,R.drawable.menu3
                ,R.drawable.menu1,R.drawable.menu4,R.drawable.menu5,R.drawable.menu6};
        String[] langname = {"menuone","menutwo","menuthree","","menufour","menufive","menusix"};

        reserveModels =new ArrayList<>();
        for (int i = 0; i<langimage.length; i++) {
            ReserveModel model = new ReserveModel(langimage[i],langname[i]);
            reserveModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                ReserveActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        reserveAdapter = new ReserveAdapter(ReserveActivity.this,reserveModels);
        recyclerView.setAdapter(reserveAdapter);
    }

}