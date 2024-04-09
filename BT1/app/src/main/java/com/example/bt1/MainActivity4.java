package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText etSoA,etSoB,etKetQua;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView tvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setControl();
    }

    public void PhepTinh(View v){
        int a= Integer.parseInt(etSoA.getText().toString());
        int b= Integer.parseInt(etSoB.getText().toString());
        int c= Integer.parseInt(etKetQua.getText().toString());

        String msg="";
        if(v.getId()==R.id.btnCong){
            Toast.makeText(this, "Cộng", Toast.LENGTH_SHORT).show();
            if(a+b==c){
                msg= a+"+"+b+"="+c+" :Đúng";
            }
            else {
                msg= a+"+"+b+"="+c+" :Sai";
            }

        }
        if(v.getId()==R.id.btnTru){
            Toast.makeText(this, "Trừ", Toast.LENGTH_SHORT).show();
            if(a-b==c){
                msg= a+"-"+b+"="+c+" :Đúng";
            }
            else {
                msg= a+"-"+b+"="+c+" :Sai";
            }
        }
        if(v.getId()==R.id.btnNhan){
            Toast.makeText(this, "Nhân", Toast.LENGTH_SHORT).show();
            if(a*b==c){
                msg= a+"*"+b+"="+c+" :Đúng";
            }
            else {
                msg= a+"*"+b+"="+c+" :Sai";
            }
        }
        if(v.getId()==R.id.btnChia){
            Toast.makeText(this, "Chia", Toast.LENGTH_SHORT).show();
            if(a/b==c){
                msg= a+"/"+b+"="+c+" :Đúng";
            }
            else {
                msg= a+"/"+b+"="+c+" :Sai";
            }
        }
        tvDanhSach.setText(tvDanhSach.getText()+"\n"+msg);
        tvDanhSach.setBackgroundColor(Color.GREEN);
    }

    public void setControl(){
        etSoA= findViewById(R.id.etSoA);
        etSoB= findViewById(R.id.etSoB);
        etKetQua= findViewById(R.id.etKetQua);
        tvDanhSach= findViewById(R.id.tvDanhSach);
    }
}