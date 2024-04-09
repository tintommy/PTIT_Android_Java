package com.example.bt1.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String maSP, giaSP, tenSP, loaiSp;

    public SanPham() {
    }

    public SanPham(String maSP, String giaSP, String tenSP) {
        this.maSP = maSP;
        this.giaSP = giaSP;
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }


    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", giaSP='" + giaSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", loaiSp='" + loaiSp + '\'' +
                '}';
    }
}
