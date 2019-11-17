package student.ucsy.shopkeeper.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 2/23/18.
 */

public class DingerSendResponse {

    /* {"amount": "10",
             "destination_address":
         "1a1mP9mLQFmPc3wXwoQLLSaBEgxsbPqH56syBb",
                 "error": "",
             "origin_address":
         "1a1vDdo2skGtYJr2M7TEFGMaUzPeXuMbkUnBTW",
                 "result": "true",
             "trx_id":
         "bd1d6a56bd56496a7b99106aba8910f6af5b59fa8d6dea7ac651785
         1ac9b1ee7" }*/
    @SerializedName("amount")
    @Expose
    public int amount;
    @SerializedName("destination_address")
    @Expose
    public String destinatin_address;
    @SerializedName("origin_address")
    @Expose
    public String origin_address;
    @SerializedName("trx_id")
    @Expose
    public String trx_id;

    @SerializedName("error")
    @Expose
    public String error;

    public DingerSendResponse(int amount, String destinatin_address, String origin_address, String trx_id, String error, boolean result) {
        this.amount = amount;
        this.destinatin_address = destinatin_address;
        this.origin_address = origin_address;
        this.trx_id = trx_id;
        this.error = error;
        this.result = result;
    }

    @SerializedName("result")
    @Expose
    public boolean result;



    public int getAmount() {
        return amount;
    }

    public String getDestinatin_address() {
        return destinatin_address;
    }

    public String getOrigin_address() {
        return origin_address;
    }

    public String getTrx_id() {
        return trx_id;
    }
}
