package com.mart.entity;

import java.util.Date;

import com.mart.utils.XDate;



public class KhachHang {
	String MaKH;
	String Hoten;
	boolean Gioitinh;
	String Ngaysinh;
	String SDT;
	
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public boolean isGioitinh() {
		return Gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		Gioitinh = gioitinh;
	}
	
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNgaysinh() {
		return Ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		Ngaysinh = ngaysinh;
	}
	
	
}
