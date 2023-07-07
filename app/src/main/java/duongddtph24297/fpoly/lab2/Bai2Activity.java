package duongddtph24297.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2Activity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.0.102/thaiduong_ph24297/rectangle_POST.php";
    EditText ed_width,ed_length;
    Button btn_send2;
    TextView tv_result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        ed_width = findViewById(R.id.ed_width);
        ed_length = findViewById(R.id.ed_length);
        btn_send2 = findViewById(R.id.btn_send2);
        tv_result2 = findViewById(R.id.tv_result2);
        btn_send2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strWidth = ed_width.getText().toString();
        String strLength = ed_length.getText().toString();
        BackgroundTask_POST backgroundTask_post = new BackgroundTask_POST(tv_result2,strWidth,strLength,this);
        backgroundTask_post.execute();
    }
}