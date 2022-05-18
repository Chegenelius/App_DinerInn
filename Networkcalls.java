package ke.co.dinerinn.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import ke.co.dinerinn.adapters.VehicleMakesAdapter;
import ke.co.dinerinn.R;
import ke.co.dinerinn.models.Payload;
import ke.co.dinerinn.models.VehiclemakeResponsemodel;
import ke.co.dinerinn.repository.Vehiclerepository;

public class Networkcalls extends AppCompatActivity {
    TextView make;
    RecyclerView recyclerView;
    private static final String TAG = "Networkcalls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_calls);

        getSupportActionBar().setTitle("DinerInn Networkcalls");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        make = findViewById(R.id.make);

        recyclerView = findViewById(R.id.recycler);
        getVehiclemakes();
    }
    private void getVehiclemakes(){
        Vehiclerepository vehiclerepository = new Vehiclerepository();
        vehiclerepository.getVehiclemake((result, t) -> {
            Log.e(TAG,"getVehiclemake: make" + new Gson().toJson(result.body()));
            VehiclemakeResponsemodel vehiclemakeResponsemodel = result.body();
            if (vehiclemakeResponsemodel != null){
                List<Payload> payloadList = vehiclemakeResponsemodel.getPayload();
                //make.setText(payloadList.get(4).getMake());
                setUpRecycler(payloadList);
            }

        });
    }

    private void setUpRecycler(List<Payload> payloadList) {
        VehicleMakesAdapter vehicleMakesAdapter = new VehicleMakesAdapter(payloadList);
        recyclerView.setAdapter(vehicleMakesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,LinearLayoutManager.VERTICAL ,false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}