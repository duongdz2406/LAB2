package duongddtph24297.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.0.102/thaiduong_ph24297/giaiphuongtrinh_POST.php";
    EditText ed_a,ed_b,ed_c;
    Button btn_send4;
    TextView tv_result4;
    String strA,strB,strC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        ed_a = findViewById(R.id.ed_a);
        ed_b = findViewById(R.id.ed_b);
        ed_c = findViewById(R.id.ed_c);
        btn_send4 = findViewById(R.id.btn_send4);
        tv_result4 = findViewById(R.id.tv_result4);
        btn_send4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        strA = ed_a.getText().toString();
        strB = ed_b.getText().toString();
        strC = ed_c.getText().toString();
        BackgroundTask_POST_bai4 backgroundTask_post_bai4 = new BackgroundTask_POST_bai4(tv_result4,this);
        backgroundTask_post_bai4.execute(strA,strB,strC);
    }
}