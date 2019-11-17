package student.ucsy.shopkeeper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import student.ucsy.shopkeeper.R;
import student.ucsy.shopkeeper.model.OrderCheckListItem;
import student.ucsy.shopkeeper.model.Trascation;

/**
 * Created by root on 2/24/18.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {




    private checkInterface checkInterface;

    List<Trascation> mData;


    public void setCheckInterface(HistoryAdapter.checkInterface checkInterface) {
        this.checkInterface = checkInterface;
    }

    public void setmData(List<Trascation> mData) {
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_in_history,parent,false);
        return new MyViewHolder(view);
    }

    public String getFood(ArrayList<OrderCheckListItem> data){
        StringBuilder sb = new StringBuilder();
        for(OrderCheckListItem d:data){
            sb.append(d.getName());
        }
        return sb.toString();
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.textView.setText(mData.get(position).name);
            holder.textView1.setText(mData.get(position).amount+" coins");

            holder.food.setText(getFood(mData.get(position).orderCheckListItems));
          /*  holder.btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.zXingScannerView.setVisibility(View.VISIBLE);
                }
            });*/

           /* holder.zXingScannerView.startCamera();
            holder.zXingScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
                @Override
                public void handleResult(Result result) {
                   if(result.getText().equals(mData.get(position).trx_id)){
                       holder.zXingScannerView.setVisibility(View.GONE);
                       holder.btnCheck.setVisibility(View.GONE);
                       holder.imageView.setVisibility(View.VISIBLE);
                   }
                }
            });*/

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

//        ZXingScannerView zXingScannerView;
        TextView textView,textView1,food;
//        Button btnCheck;
        public MyViewHolder(View itemView) {
            super(itemView);

            food = itemView.findViewById(R.id.food);
            textView1 = itemView.findViewById(R.id.amount);
            textView = itemView.findViewById(R.id.name);

        }
    }

    public interface  checkInterface{
        void check(String txid);
    }
}
