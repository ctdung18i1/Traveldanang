package com.example.traveldanang.model;

public class data_recyclerview_nav {
    public int Hinhanh;
    public String ten;

    public data_recyclerview_nav(int hinhanh, String ten) {
        Hinhanh = hinhanh;
        this.ten = ten;
    }

    public int getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        Hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
