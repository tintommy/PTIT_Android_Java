package com.example.bt1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.bt1.MainActivity7;
import com.example.bt1.MainActivity8;
import com.example.bt1.MainChiTietSP;
import com.example.bt1.R;
import com.example.bt1.model.SanPham;

import java.util.List;

public class CustomAdapter_SP extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;

    public CustomAdapter_SP(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, null);
        View mainView = LayoutInflater.from(context).inflate(R.layout.activity_main7, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTen);
        Button btnChiTiet= convertView.findViewById(R.id.btnChiTiet);
        EditText etMaSP = mainView.findViewById(R.id.etMa);
        EditText etTenSP = mainView.findViewById(R.id.etTen);
        EditText etGiaSp = mainView.findViewById(R.id.etGia);

        Spinner spLoaiSp = mainView.findViewById(R.id.spLoaiSp);
        Button btnThem = mainView.findViewById(R.id.btnThem7);
        Button btnSua = mainView.findViewById(R.id.btnSua7);
        Button btnXoa = mainView.findViewById(R.id.btnXoa7);
        Button btnThoat = mainView.findViewById(R.id.btnThoat);
        ListView lvDanhSach = mainView.findViewById(R.id.lvDanhSach7);

        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if (sp.getLoaiSp().equals("Samsung"))
            ivHinh.setImageResource(R.drawable.samsung);
        if (sp.getLoaiSp().equals("Iphone"))
            ivHinh.setImageResource(R.drawable.iphone);
        if (sp.getLoaiSp().equals("Nokia"))
            ivHinh.setImageResource(R.drawable.nokia);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, sp.getTenSP() , Toast.LENGTH_SHORT).show();
                etMaSP.setText(sp.getMaSP());
                etTenSP.setText(sp.getTenSP());
                etGiaSp.setText(sp.getGiaSP());
                if (sp.getLoaiSp().equals("Samsung"))
                    spLoaiSp.setSelection(0);
                if (sp.getLoaiSp().equals("Iphone"))
                    spLoaiSp.setSelection(1);
                if (sp.getLoaiSp().equals("Nokia"))
                    spLoaiSp.setSelection(2);
                MainActivity7.index = position;
                MainActivity8.index = position;
            }
        });

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainChiTietSP.class);
                intent.putExtra("sp", sp);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
