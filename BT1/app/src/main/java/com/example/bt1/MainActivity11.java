package com.example.bt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity11 extends AppCompatActivity {
    EditText etThongBao, etTenSP, etGiaSP;
    Button btnThongBao, btnThem;
    ListView lvDanhSach;
    CustomAdapter_SP adapterSp;
    List<SanPham> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        setControl();
        setEvent();


    }

    private void setEvent() {
        adapterSp = new CustomAdapter_SP(this, R.layout.layout_item_sp, data);
        lvDanhSach.setAdapter(adapterSp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        DatabaseReference myRefSP = database.getReference("sanPham");
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue(etThongBao.getText().toString());
            }
        });


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()){
                    String value = dataSnapshot.getValue(String.class);
                    Toast.makeText(MainActivity11.this, value, Toast.LENGTH_SHORT).show();
                    etThongBao.setText(value);
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(MainActivity11.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        myRefSP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                if (snapshot.exists()) {
                    for (DataSnapshot item : snapshot.getChildren()) {
                        SanPham sp = new SanPham();
                        sp.setMaSP(item.child("maSP").getValue().toString());
                        sp.setTenSP(item.child("tenSP").getValue().toString());
                        sp.setGiaSP(item.child("maSP").getValue().toString());
                        sp.setLoaiSp(item.child("loaiSp").getValue().toString());
                        data.add(sp);
                    }
                }
                adapterSp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sp = new SanPham();
                sp.setMaSP(myRefSP.push().getKey());
                sp.setTenSP(etTenSP.getText().toString());
                sp.setGiaSP(etGiaSP.getText().toString());
                sp.setLoaiSp("Samsung");
                myRefSP.child(sp.getMaSP()).setValue(sp);
               // data.add(sp);
                adapterSp.notifyDataSetChanged();
                Toast.makeText(MainActivity11.this, "Đã thêm", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setControl() {
        etThongBao = findViewById(R.id.etThongBao);
        btnThongBao = findViewById(R.id.btnThongBao);
        etTenSP = findViewById(R.id.etTen);
        etGiaSP = findViewById(R.id.etGia);
        btnThem = findViewById(R.id.btnThem);
        lvDanhSach= findViewById(R.id.lvDanhSach);
    }
}