package com.example.bt1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bt1.MainChiTietSP;
import com.example.bt1.MainChiTietSpGH;
import com.example.bt1.R;
import com.example.bt1.model.SanPham;

import java.util.List;

public class CustomAdapterGioHang extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;

    public CustomAdapterGioHang(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTen);
        Button btnChiTiet = convertView.findViewById(R.id.btnChiTiet);
        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if (sp.getLoaiSp().equals("Samsung"))
            ivHinh.setImageResource(R.drawable.samsung);
        if (sp.getLoaiSp().equals("Iphone"))
            ivHinh.setImageResource(R.drawable.iphone);
        if (sp.getLoaiSp().equals("Nokia"))
            ivHinh.setImageResource(R.drawable.nokia);

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainChiTietSpGH.class);
                intent.putExtra("sp", sp);
                context.startActivity(intent);
            }
        });


        return convertView;
    }
}
