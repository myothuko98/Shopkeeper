package student.ucsy.shopkeeper.network;



import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import student.ucsy.shopkeeper.network.response.DingerGetResponse;
import student.ucsy.shopkeeper.network.response.DingerSendResponse;

/**
 * Created by root on 11/23/17.
 */

public interface ApiService {


    @GET("api/v1/createrandomaddress")
    Observable<Void> create();

    @GET("api/v1/getbalance/{address}")
    Single<DingerGetResponse> data(@Path("address") String address);

    @GET("api/v1/sendkudo/{from}/{to}/{amount}/{privateKey}")
    Observable<DingerSendResponse> send(@Path("from") String from, @Path("to") String to, @Path("amount") int amount, @Path("privateKey") String privateKey);



}
