package student.ucsy.shopkeeper.activity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import student.ucsy.shopkeeper.R;
import student.ucsy.shopkeeper.network.RestClient;
import student.ucsy.shopkeeper.network.response.DingerGetResponse;
import student.ucsy.shopkeeper.utils.Contents;
import student.ucsy.shopkeeper.utils.QRCodeEncoder;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.balance)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        RestClient.getApiService(this).data("1MCXjaysCZsVjm8GmapRGWURxxFTRBJnPM6Kn5").toObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<DingerGetResponse>() {
                    @Override
                    public void accept(DingerGetResponse dingerGetResponse) throws Exception {
                        textView.setText(dingerGetResponse.getBalance()+"");
                        generateQrcode(dingerGetResponse.getAddress());
                    }
                });
    }

    @OnClick(R.id.btnCheck)
    void btnCheck(){
        CheckActivity.start(this);
    }

    @OnClick(R.id.btnHistory)
    void btnHistory(){
        HistoryActivity.start(this);
    }
    public void generateQrcode(String data) {
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        //Encode with a QR Code image
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(data,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                smallerDimension);
        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            imageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
