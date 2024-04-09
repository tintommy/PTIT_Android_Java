package com.example.bt1.db;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bt1.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSP extends SQLiteOpenHelper {

    public DatabaseSP(@Nullable Context context) {
        super(context, "dbSanPham", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbSanPham (masp text,tensp text,giasp text,loaisp text)";
        db.execSQL(sql);

    }


    public void ThemDL(SanPham sp) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into tbSanPham values(?,?,?,?)";
        db.execSQL(sql, new String[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaSP(), sp.getLoaiSp()});
    }
    public void ThemDLGioHang(SanPham sp) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into tbGioHang values(?,?,?,?)";
        db.execSQL(sql, new String[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaSP(), sp.getLoaiSp()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql1 = "Create table tbGioHang (masp text,tensp text,giasp text,loaisp text)";
        db.execSQL(sql1);

    }

    public List<SanPham> DocDL() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "Select * from tbSanPham";
        List<SanPham> data = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setGiaSP(cursor.getString(2));
                sp.setLoaiSp(cursor.getString(3));
                data.add(sp);
            } while (cursor.moveToNext());
        }
        return data;
    }
    public List<SanPham> DocDLGioHang() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "Select * from tbGioHang";
        List<SanPham> data = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setGiaSP(cursor.getString(2));
                sp.setLoaiSp(cursor.getString(3));
                data.add(sp);
            } while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaDL(SanPham sp){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Delete from tbSanPham where maSp=?";
        db.execSQL(sql,new String[]{sp.getMaSP()});
    }

    public void SuaDL(SanPham sp){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Update tbSanPham set tenSp=?, giaSp=?, loaiSp=? where maSp=?";
        db.execSQL(sql,new String[]{sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSp(),sp.getMaSP()});
    }
}
