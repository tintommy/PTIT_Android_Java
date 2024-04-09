package com.example.bt1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bt1.Navigation;
import com.example.bt1.R;
import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterDanhSach extends ArrayAdapter {

    Context context;
    int resource;
    List<SanPham> data;
    List<SanPham> gioHang = new ArrayList<>();
    DatabaseSP databaseSP;





    public CustomAdapterDanhSach(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        databaseSP = new DatabaseSP(getContext());
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTen);
        Button btnGioHang = convertView.findViewById(R.id.btnGiohang);
        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSP());
        if (sp.getLoaiSp().equals("Samsung"))
            ivHinh.setImageResource(R.drawable.samsung);
        if (sp.getLoaiSp().equals("Iphone"))
            ivHinh.setImageResource(R.drawable.iphone);
        if (sp.getLoaiSp().equals("Nokia"))
            ivHinh.setImageResource(R.drawable.nokia);
        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                databaseSP.ThemDLGioHang(sp);
//                notifyDataSetChanged();

                Navigation.ghList.add(sp);
                Toast.makeText(context, "Đã thêm "+sp.getTenSP()+" vào giỏ hàng", Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }

    public List<SanPham> getGioHang() {
        return gioHang;
    }
}
