package student.ucsy.shopkeeper.model;

import java.util.ArrayList;


/**
 * Created by root on 2/24/18.
 */

public class Trascation {

    public int amount;
    public String destinatin_address;
    public String origin_address;
    public String trx_id;
    public boolean result;
    public ArrayList<OrderCheckListItem> orderCheckListItems;
    public String error;
    public String name;
    public String rcid;

    public Trascation(int amount, String destinatin_address, String origin_address, String trx_id, boolean result, ArrayList<OrderCheckListItem> orderCheckListItems, String error, String name, String rcid) {
        this.amount = amount;
        this.destinatin_address = destinatin_address;
        this.origin_address = origin_address;
        this.trx_id = trx_id;
        this.result = result;
        this.orderCheckListItems = orderCheckListItems;
        this.error = error;
        this.name = name;
        this.rcid = rcid;
    }

    public Trascation(){

    }
}
