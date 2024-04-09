package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity7 extends AppCompatActivity {

    private EditText etMaSP, etTenSP, etGiaSP;
    private Spinner spLoaiSp;
    private ImageView ivHinh;
    private Button btnThem, btnXoa, btnSua, btnThoat;
    private ListView lvDanhSach;

    private List<String> data_lsp = new ArrayList<>();
    private ArrayAdapter adapter_lsp;
    private List<SanPham> data_sp = new ArrayList<>();
    private ArrayAdapter adapter_sp;

    public static int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        setControl();
        setEvent();
    }

    private void setEvent() {
        khoiTao();
        adapter_lsp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data_lsp);
        spLoaiSp.setAdapter(adapter_lsp);
        spLoaiSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spLoaiSp.getSelectedItem().equals("Samsung"))
                    ivHinh.setImageResource(R.drawable.samsung);
                if (spLoaiSp.getSelectedItem().equals("Iphone"))
                    ivHinh.setImageResource(R.drawable.iphone);
                if (spLoaiSp.getSelectedItem().equals("Nokia"))
                    ivHinh.setImageResource(R.drawable.nokia);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        adapter_sp = new CustomAdapter_SP(this, R.layout.layout_item_sp, data_sp);
        lvDanhSach.setAdapter(adapter_sp);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "item click", Toast.LENGTH_SHORT).show();
                SanPham sp = data_sp.get(i);
                etMaSP.setText(sp.getMaSP());
                etTenSP.setText(sp.getTenSP());
                etGiaSP.setText(sp.getGiaSP());
                if (sp.getLoaiSp().equals("Samsung"))
                    spLoaiSp.setSelection(0);
                if (sp.getLoaiSp().equals("Iphone"))
                    spLoaiSp.setSelection(1);
                if (sp.getLoaiSp().equals("Nokia"))
                    spLoaiSp.setSelection(2);
                index = i;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < 0)
                    Toast.makeText(MainActivity7.this, "Hãy chọn 1 item", Toast.LENGTH_SHORT).show();
                else {
                    data_sp.remove(index);
                    adapter_sp.notifyDataSetChanged();
                }

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sp = data_sp.get(index);
                sp.setMaSP(etMaSP.getText().toString());
                sp.setTenSP(etTenSP.getText().toString());
                sp.setGiaSP(etGiaSP.getText().toString());
                sp.setLoaiSp(spLoaiSp.getSelectedItem().toString());
                data_sp.set(index, sp);
                adapter_sp.notifyDataSetChanged();

            }
        });




        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                data_sp.remove(i);
                adapter_sp.notifyDataSetChanged();

                return false;
            }
        });
    }

    private void themDL() {
        SanPham sp = new SanPham();
        sp.setTenSP(etTenSP.getText().toString());
        sp.setGiaSP(etGiaSP.getText().toString());
        sp.setMaSP(etMaSP.getText().toString());
        sp.setLoaiSp(spLoaiSp.getSelectedItem().toString());
        data_sp.add(sp);
        adapter_sp.notifyDataSetChanged();
    }

    private void khoiTao() {
        data_lsp.add("Samsung");
        data_lsp.add("Iphone");
        data_lsp.add("Nokia");
    }

    private void setControl() {
        etMaSP = findViewById(R.id.etMa);
        etTenSP = findViewById(R.id.etTen);
        etGiaSP = findViewById(R.id.etGia);
        spLoaiSp = findViewById(R.id.spLoaiSp);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem7);
        btnSua = findViewById(R.id.btnSua7);
        btnXoa = findViewById(R.id.btnXoa7);
        btnThoat = findViewById(R.id.btnThoat);
        lvDanhSach = (ListView) findViewById(R.id.lvDanhSach7);
    }
}