package ke.co.dinerinn.repository;

import retrofit2.Response;

public interface IExecute<T> {
    void run(Response<T> result,Throwable t );
}
