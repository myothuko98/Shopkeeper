package student.ucsy.shopkeeper.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/23/18.
 */

public class DingerGetResponse {

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("balance")
    @Expose
    private double balance;

    public DingerGetResponse(String address, double balance, String coin, String error, boolean result) {
        this.address = address;
        this.balance = balance;
        this.coin = coin;
        this.error = error;
        this.result = result;
    }

    @SerializedName("coin")
    @Expose
    private String coin;


    @SerializedName("error")
    @Expose
    private String error;


    @SerializedName("result")
    @Expose
    private boolean result;

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public String getCoin() {
        return coin;
    }

    public String getError() {
        return error;
    }

    public boolean isResult() {
        return result;
    }


    /*{"address": "1a1vDdo2skGtYJr2M7TEFGMaUzPeXuMbkUnBTW",
            "balance": 424.0,
            "coin": "KUDO",
            "error": "",
            "result": "true"}*/


}
