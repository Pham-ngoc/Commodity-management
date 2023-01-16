package com.mart.entity;

public class NhanVien {
	String MaNV;
	String Hoten;
	String Email;
	String Matkhau;
	boolean Vaitro = false;
	
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMatkhau() {
		return Matkhau;
	}
	public void setMatkhau(String matkhau) {
		Matkhau = matkhau;
	}
	public boolean isVaitro() {
		return Vaitro;
	}
	public void setVaitro(boolean vaitro) {
		Vaitro = vaitro;
	}
	
	
	
}
