package student.ucsy.shopkeeper.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import student.ucsy.shopkeeper.model.OrderCheckListItem;
import student.ucsy.shopkeeper.model.Trascation;

/**
 * Created by root on 2/24/18.
 */

public class CheckActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    public static void start(Context context) {
        Intent starter = new Intent(context, CheckActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        this.setContentView(scannerView);

        scannerView.startCamera();
        scannerView.setResultHandler(this);


    }

    @Override
    public void handleResult(final Result result) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("dinger_transcation");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try{
                    Trascation d = dataSnapshot.getValue(Trascation.class);


                    if(result.getText().equals(d.trx_id)){
                        showAlert(d.name,getFood(d.orderCheckListItems));
                    }

                }catch (Exception e){
                    Log.d("error",e.toString());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    void showAlert(String name,String food){
        AlertDialog.Builder builder = new AlertDialog.Builder(scannerView.getContext());

        builder.setMessage(name+" ordered "+food);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();


        alertDialog.show();
    }

    public String getFood(ArrayList<OrderCheckListItem> data){
        StringBuilder sb = new StringBuilder();
        for(OrderCheckListItem d:data){
            sb.append(d.getName());
        }
        return sb.toString();
    }
}
