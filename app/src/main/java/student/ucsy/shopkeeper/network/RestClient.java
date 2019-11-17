package student.ucsy.shopkeeper.network;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 11/23/17.
 */

public class RestClient {


    private static ApiService mRestService = null;


    public static ApiService getApiService(Context context) {
        if (mRestService == null) {
            final OkHttpClient client = new OkHttpClient
                    .Builder()
                    .build();

            final Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("http://www.sdaforum.org/")
                    .client(client)
                    .build();

            mRestService = retrofit.create(ApiService.class);
        }
        return mRestService;

    }

}