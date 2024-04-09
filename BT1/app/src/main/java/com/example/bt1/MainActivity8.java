package com.example.bt1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity8 extends AppCompatActivity {

    private EditText etMaSP, etTenSP, etGiaSP;
    private Spinner spLoaiSp;
    private ImageView ivHinh;
    private Button btnThem, btnXoa, btnSua, btnThoat;
    private ListView lvDanhSach;

    private List<String> data_lsp = new ArrayList<>();
    private ArrayAdapter adapter_lsp;
    private List<SanPham> data_sp = new ArrayList<>();
    public static ArrayAdapter adapter_sp;

    public static int index = -1;

    DatabaseSP db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        setControl();
        setEvent();
    }

    private void setEvent() {
        khoiTao();
        db = new DatabaseSP(this);

        adapter_lsp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data_lsp);
        spLoaiSp.setAdapter(adapter_lsp);

        DocDL();
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
                    Toast.makeText(MainActivity8.this, "Hãy chọn 1 item", Toast.LENGTH_SHORT).show();
                else {

                    SanPham sp = new SanPham();
                    sp.setMaSP(etMaSP.getText().toString());
                    db.XoaDL(sp);
                 DocDL();
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
                db.SuaDL(sp);
                adapter_sp.notifyDataSetChanged();

            }
        });
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SanPham sp = data_sp.get(position);
                etMaSP.setText(sp.getMaSP());
                etTenSP.setText(sp.getTenSP());
                etGiaSP.setText(sp.getGiaSP());
                if (sp.getLoaiSp().equals("Samsung"))
                    spLoaiSp.setSelection(0);
                if (sp.getLoaiSp().equals("Iphone"))
                    spLoaiSp.setSelection(1);
                if (sp.getLoaiSp().equals("Nokia"))
                    spLoaiSp.setSelection(2);
                index = position;
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

    private void DocDL() {
        data_sp.clear();
        data_sp.addAll(db.DocDL());

    }

    private void themDL() {
        SanPham sp = new SanPham();
        sp.setTenSP(etTenSP.getText().toString());
        sp.setGiaSP(etGiaSP.getText().toString());
        sp.setMaSP(etMaSP.getText().toString());
        sp.setLoaiSp(spLoaiSp.getSelectedItem().toString());
        data_sp.add(sp);
        adapter_sp.notifyDataSetChanged();
        db.ThemDL(sp);
        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
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
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnThoat = findViewById(R.id.btnThoat);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}