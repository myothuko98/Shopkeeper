package student.ucsy.shopkeeper.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wp on 2/24/2018.
 */

public class OrderCheckListItem implements Serializable {

    private String name;
    private int price;
    private int count;
    private String date;
    private String time;
    private ArrayList<String> nList;
    private ArrayList<Integer> pList;
    private ArrayList<Integer> cList;


    public OrderCheckListItem(){

    }
    public OrderCheckListItem(String name, int price, int count){
        this.name=name;
        this.price=price;
        this.count=count;
    }

    public ArrayList<String> getnList() {
        return nList;
    }

    public ArrayList<Integer> getpList() {
        return pList;
    }

    public ArrayList<Integer> getcList() {
        return cList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
