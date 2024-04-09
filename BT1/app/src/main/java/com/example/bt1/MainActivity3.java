package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private EditText taiKhoan,matKhau,sdt,email;
    private Button btnDangKy,btnNhapLai;
    private TextView tvThongtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        setEvent();
    }

    private void init(){
        taiKhoan= findViewById(R.id.etTaiKhoan);
        matKhau= findViewById(R.id.etPass);
        sdt= findViewById(R.id.etSdt);
        email= findViewById(R.id.etEmail);
        btnDangKy= findViewById(R.id.btnDangKi);
        btnNhapLai= findViewById(R.id.btnNhapLai);
        tvThongtin=findViewById(R.id.tvThongTin);
    }

    private void setEvent(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Thông tin"
                        +"\nTài khoản: "+ taiKhoan.getText()
                        +"\nMật khẩu: "+ matKhau.getText()
                        +"\nSDT: "+ sdt.getText()
                        +"\nEmail: "+ email.getText();

                tvThongtin.setText(msg);
                tvThongtin.setBackgroundColor(Color.GREEN);
            }
        });

        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taiKhoan.setText("");
                matKhau.setText("");
                sdt.setText("");
                email.setText("");
                tvThongtin.setText("");
                tvThongtin.setBackgroundColor(Color.WHITE);
            }
        });
    }
}