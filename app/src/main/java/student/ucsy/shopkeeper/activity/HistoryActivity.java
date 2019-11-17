package student.ucsy.shopkeeper.activity;

import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import student.ucsy.shopkeeper.R;
import student.ucsy.shopkeeper.adapter.HistoryAdapter;
import student.ucsy.shopkeeper.model.Trascation;

/**
 * Created by root on 2/24/18.
 */

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.checkInterface {


    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    HistoryAdapter adapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, HistoryActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_history);
        ButterKnife.bind(this);


        adapter = new HistoryAdapter();


        loadData();
        





    }

    private void loadData(){

        final List<Trascation> data = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                .child("dinger_transcation");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try{
                    Trascation d = dataSnapshot.getValue(Trascation.class);
                    data.add(d);

                    adapter.setCheckInterface(HistoryActivity.this);
                    adapter.setmData(data);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this,LinearLayoutManager.VERTICAL,false));



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

    @Override
    public void check(String txid) {

    }
}
