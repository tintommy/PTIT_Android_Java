package com.example.bt1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.bt1.adapter.CustomAdapterDanhSach;
import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;


public class DanhSachFragment extends Fragment {

    GridView gvDanhSach;
    List<SanPham> data = new ArrayList<>();
    CustomAdapterDanhSach customAdapterDs;
    DatabaseSP databaseSP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        databaseSP = new DatabaseSP(getActivity());
        data.addAll(databaseSP.DocDL());

        customAdapterDs = new CustomAdapterDanhSach(getContext(), R.layout.layout_item_sp_ds, data);
//        customAdapterDs.setOnItemClickListener(new CustomAdapterDanhSach.OnItemClickListener() {
//            @Override
//            public void onBtnClick(SanPham sp) {
//                databaseSP.ThemDLGioHang(sp);
//                Log.e("Mytag", "124");
//                Toast.makeText(getContext(), "Đã thêm " + sp.getTenSP() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
//            }
//        });
        gvDanhSach.setAdapter(customAdapterDs);

    }

    private void setControl(View view) {
        gvDanhSach = view.findViewById(R.id.gvDanhSach);
    }
}