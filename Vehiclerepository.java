package ke.co.dinerinn.repository;

import ke.co.dinerinn.models.VehiclemakeResponsemodel;
import ke.co.dinerinn.webservice.IVehiclewebservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Vehiclerepository {
    private IVehiclewebservice webservice;
    private String BASE_URL = "https://test.hillcroftinsurance.com";
    public Vehiclerepository(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.webservice = retrofit.create(IVehiclewebservice.class);
    }
    public  void getVehiclemake(IExecute<VehiclemakeResponsemodel> callback){
        this.webservice.getVehiclemake().enqueue(new Callback<VehiclemakeResponsemodel>() {
            @Override
            public void onResponse(Call<VehiclemakeResponsemodel> call, Response<VehiclemakeResponsemodel> response) {
                callback.run(response,null);
            }

            @Override
            public void onFailure(Call<VehiclemakeResponsemodel> call, Throwable t) {
                callback.run(null,t);

            }
        });
    }
}
