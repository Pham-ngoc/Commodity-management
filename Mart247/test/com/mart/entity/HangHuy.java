package com.mart.entity;

import java.util.Date;

public class HangHuy extends HangHoa {
	String MaHH;
	int SoluongHuy;
	String Ngayhuy;
	
	public String getMaHH() {
		return MaHH;
	}
	public void setMaHH(String maHH) {
		MaHH = maHH;
	}
	public int getSoluongHuy() {
		return SoluongHuy;
	}
	public void setSoluongHuy(int soluongHuy) {
		SoluongHuy = soluongHuy;
	}
	public String getNgayhuy() {
		return Ngayhuy;
	}
	public void setNgayhuy(String ngayhuy) {
		Ngayhuy = ngayhuy;
	}
}
