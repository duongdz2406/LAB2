
package duongddtph24297.fpoly.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button bai1 ,bai2,bai3 , bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bai1 = findViewById(R.id.btn_bai1);
        bai2 = findViewById(R.id.btn_bai2);
        bai3 = findViewById(R.id.btn_bai3);
        bai4 = findViewById(R.id.btn_bai4);

        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Bai2Activity.class);
                startActivity(intent);
            }
        });
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Bai3Activity.class);
                startActivity(intent);
            }
        });
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,Bai4Activity.class);
                startActivity(intent);
            }
        });

    }
}