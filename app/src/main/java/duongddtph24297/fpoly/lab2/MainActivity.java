package duongddtph24297.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME = "http://192.168.0.102/thaiduong_ph24297/student_GET.php";
    EditText ed_name,ed_score;
    Button btn_send;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_name);
        ed_score = findViewById(R.id.ed_score);
        btn_send = findViewById(R.id.btn_send);
        tv_result = findViewById(R.id.tv_result);
        btn_send.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String strName = ed_name.getText().toString();
        String strScore = ed_score.getText().toString();
        BackgroundTask_GET backgroundTask_get = new BackgroundTask_GET(tv_result,strName,strScore,this);
        backgroundTask_get.execute();

    }
}