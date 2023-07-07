package duongddtph24297.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.0.102/thaiduong_ph24297/canh.php";
    EditText ed_canh;
    Button btn_send3;
    TextView tv_result3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        ed_canh = findViewById(R.id.ed_canh);
        btn_send3 = findViewById(R.id.btn_gui);
        tv_result3 = findViewById(R.id.tv_result3);
        btn_send3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strCanh = ed_canh.getText().toString();
        BackgroundTask_POST_Bai3 backgroundTask_post_bai3 = new BackgroundTask_POST_Bai3(tv_result3,this);
        backgroundTask_post_bai3.execute(strCanh);
    }
    }
