package com.example.traveldanang.model;

import com.squareup.moshi.Json;

public class DataShow {

	@Json(name = "hinhanh")
	private String hinhanh;

	@Json(name = "vitri")
	private String vitri;

	@Json(name = "id")
	private int id;

	@Json(name = "ten")
	private String ten;

	@Json(name = "thongtin")
	private String thongtin;

	@Json(name = "danhgia")
	private String danhgia;

	public void setHinhanh(String hinhanh){
		this.hinhanh = hinhanh;
	}

	public String getHinhanh(){
		return hinhanh;
	}

	public void setVitri(String vitri){
		this.vitri = vitri;
	}

	public String getVitri(){
		return vitri;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTen(String ten){
		this.ten = ten;
	}

	public String getTen(){
		return ten;
	}

	public void setThongtin(String thongtin){
		this.thongtin = thongtin;
	}

	public String getThongtin(){
		return thongtin;
	}

	public void setDanhgia(String danhgia){
		this.danhgia = danhgia;
	}

	public String getDanhgia(){
		return danhgia;
	}

	@Override
 	public String toString(){
		return 
			"Tungdich{" + 
			"hinhanh = '" + hinhanh + '\'' + 
			",vitri = '" + vitri + '\'' + 
			",id = '" + id + '\'' + 
			",ten = '" + ten + '\'' + 
			",thongtin = '" + thongtin + '\'' + 
			",danhgia = '" + danhgia + '\'' + 
			"}";
		}
}