package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;

public class MainChiTietSpGH extends AppCompatActivity {
    private EditText edtMaSP, edtTenSP, edtGiaSP;
    private Button btnXoa, btnSua, btnBack;
    private DatabaseSP dbSanPham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chi_tiet_sp_gh);
        Init();
        setControl();
        setEvent();
    }
    public void Init(){
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnBack = findViewById(R.id.btnBack);
    };
    public void setControl(){
        SanPham sp = (SanPham) getIntent().getSerializableExtra("sp");
        edtTenSP.setText(sp.getTenSP());
        edtMaSP.setText(sp.getMaSP());
        edtGiaSP.setText(sp.getGiaSP());
    }
    public void setEvent(){

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }
}