package com.example.bt1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.bt1.adapter.CustomAdapterDanhSach;
import com.example.bt1.adapter.CustomAdapterGioHang;
import com.example.bt1.adapter.CustomAdapter_SP;
import com.example.bt1.db.DatabaseSP;
import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;


public class GioHangFragment extends Fragment {



    ListView lvDanhSach;
    //List<SanPham> data = new ArrayList<>();
    CustomAdapterGioHang customAdapterSp;
    DatabaseSP databaseSP;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        databaseSP=new DatabaseSP(getContext());
     //   data=databaseSP.DocDLGioHang();
        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        customAdapterSp = new CustomAdapterGioHang(getActivity(), R.layout.layout_item_sp, Navigation.ghList);
        lvDanhSach.setAdapter(customAdapterSp);
    }

    private void setControl(View view) {
        lvDanhSach = view.findViewById(R.id.lvDanhSach);
    }
}