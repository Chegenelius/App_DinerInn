package ke.co.dinerinn.webservice;

import ke.co.dinerinn.models.VehiclemakeResponsemodel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IVehiclewebservice {
    @GET("/motor/vehicle/makes")
    Call<VehiclemakeResponsemodel>getVehiclemake();
}
