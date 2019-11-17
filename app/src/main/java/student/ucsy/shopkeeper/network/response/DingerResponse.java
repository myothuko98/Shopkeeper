package student.ucsy.shopkeeper.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 1/23/18.
 */

public class DingerResponse {
    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("private_key")
    @Expose
    private String private_key;


    @SerializedName("public_key")
    @Expose
    private String public_key;

    @SerializedName("result")
    @Expose
    private boolean result;






}
