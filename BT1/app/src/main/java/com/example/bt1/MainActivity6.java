package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity6 extends AppCompatActivity {

    Switch swBongDen;
    LinearLayout llBongDen;
    ToggleButton tgBongDen;
    ImageView ivBongDen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        init();
        setControl();
    }
    public void init(){
        swBongDen = findViewById(R.id.swBongDen);
        llBongDen= findViewById(R.id.llBongDen);
        tgBongDen= findViewById(R.id.tgBongDen);
        ivBongDen= findViewById(R.id.ivBongDen);
    }
    public void setControl(){
        swBongDen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    llBongDen.setVisibility(View.VISIBLE);}
                else llBongDen.setVisibility(View.GONE);
            }
        });




        tgBongDen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    ivBongDen.setImageResource(R.drawable.lamp2);
                else ivBongDen.setImageResource(R.drawable.lamp);
            }
        });
    }
}