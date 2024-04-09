package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    Button btnDangKi, btnThoat, btnNhapLai;
    EditText etHoTen, etCCCD;
    RadioButton rdDaiHoc, rdCaoDang, rdTrungCap;
    CheckBox cbChoiGame, cbDocSach, cbDocBao;
    TextView tvDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        init();
        setEnvent();
    }

    public void init() {
        btnDangKi = findViewById(R.id.btnDangKi);
        btnThoat = findViewById(R.id.btnThoat);
        btnNhapLai = findViewById(R.id.btnNhapLai);
        etHoTen = findViewById(R.id.etHoTen);
        etCCCD = findViewById(R.id.etCCCD);
        rdCaoDang = findViewById(R.id.rdCaoDang);
        rdDaiHoc = findViewById(R.id.rdDaiHoc);
        rdTrungCap = findViewById(R.id.rdTrungCap);
        cbChoiGame = findViewById(R.id.cbChoiGame);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocBao = findViewById(R.id.cbDocBao);
        tvDanhSach = findViewById(R.id.tvDanhSach);
    }

    public void setEnvent() {

        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = etHoTen.getText().toString();
                String cccd = etCCCD.getText().toString();
                String msg = "Thông tin"
                        + "\nHọ tên: " + hoTen
                        + "\nCCCD: " + cccd;
                if (rdDaiHoc.isChecked())
                    msg += "\nBằng cấp: " + rdDaiHoc.getText().toString();
                if (rdCaoDang.isChecked())
                    msg += "\nBằng cấp: " + rdCaoDang.getText().toString();
                if (rdTrungCap.isChecked())
                    msg += "\nBằng cấp: " + rdTrungCap.getText().toString();
                msg += "\nSở thích: ";
                if (cbChoiGame.isChecked())
                    msg += cbChoiGame.getText().toString() + " ";
                if (cbDocBao.isChecked())
                    msg += cbDocBao.getText().toString() + " ";
                if (cbDocSach.isChecked())
                    msg += cbDocSach.getText().toString() + " ";


                tvDanhSach.setText(tvDanhSach.getText().toString()+"\n"+msg);
                tvDanhSach.setBackgroundColor(Color.GREEN);
            }
        });
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etCCCD.setText("");
                etHoTen.setText("");
                tvDanhSach.setText("");
            }
        });
    }
}