package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btn;
    private EditText tieuDe,noiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setControl();
        setEvent();
    }


    private void setControl(){
        btn = findViewById(R.id.button);
        tieuDe= findViewById(R.id.edTieuDe);
        noiDung= findViewById(R.id.edNoiDung);
    }

    private void setEvent(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Tiêu đề : "+ tieuDe.getText() +"\n"
                                +"Nội dung: "+ noiDung.getText();

                Toast.makeText(MainActivity2.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }

}