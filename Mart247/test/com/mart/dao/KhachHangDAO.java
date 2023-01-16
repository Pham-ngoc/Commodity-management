package com.mart.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.KhachHang;
import com.mart.entity.NhanVien;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class KhachHangDAO extends MartDAO<KhachHang, String>{

	@Override
	public void insert(KhachHang kh) {
		String sql = "INSERT INTO KhachHang (MaKH, HoTen, GioiTinh, NgaySinh, SoDienThoai) VALUES (?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				kh.getMaKH(),
				kh.getHoten(),
				Boolean.valueOf(kh.isGioitinh()),
				kh.getNgaysinh(),
				kh.getSDT()
		});
	}

	@Override
	public void update(KhachHang kh) {
		String sql = "UPDATE KhachHang SET HoTen=?, GioiTinh=?, NgaySinh=?, SoDienThoai=? WHERE MaKH=?";
		XJdbc.update(sql, new Object[] {
				kh.getHoten(),
				Boolean.valueOf(kh.isGioitinh()),
				kh.getNgaysinh(),
				kh.getSDT(),
				kh.getMaKH()
		});
		
	}

	@Override
	public void delete(String makh) {
		String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
		XJdbc.update(sql, new Object[] {makh} );		
	}

	@Override
	public KhachHang selectById(String makh) {
		String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
	    List<KhachHang> list = selectBySql(sql, new Object[] { makh });
	    return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<KhachHang> selectAll() {
		String sql = "SELECT * FROM KhachHang";
	    return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<KhachHang> selectBySql(String sql, Object... args) {
		List<KhachHang> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          KhachHang entity = new KhachHang();
	          entity.setMaKH(rs.getString("MaKH"));
	          entity.setHoten(rs.getString("HoTen"));
	          entity.setGioitinh(rs.getBoolean("GioiTinh"));
	          String d = rs.getString("NgaySinh");
	          entity.setNgaysinh(Check.getDate(d));
	          entity.setSDT(rs.getString("SoDienThoai"));
	          
	          list.add(entity);
	        } 
	      } finally {
	        rs.getStatement().getConnection().close();
	      } 
	    } catch (Exception ex) {
	      ex.printStackTrace();
	      throw new RuntimeException(ex);
	    } 
	    return list;
	  }	
	
	public List<KhachHang> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	 
}
