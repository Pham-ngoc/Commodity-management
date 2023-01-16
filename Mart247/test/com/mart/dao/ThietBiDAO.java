package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.DonHang;
import com.mart.entity.ThietBi;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class ThietBiDAO extends MartDAO<ThietBi, String> {
	
	@Override
	public void insert(ThietBi tb) {
		String sql = "INSERT INTO ThietBi (MaTB, TenTB, NgayBaoTri, Soluong, NoiDung, GhiChu, MaNV) VALUES (?,?,?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				tb.getMaTB(),
				tb.getTenTB(),
				tb.getNgaybaotri(),
				tb.getSoluong(),
				tb.getNoidung(),
				tb.getGhichu(),
				tb.getMaNV()
		});
	}

	@Override
	public void update(ThietBi tb) {
		String sql	= "UPDATE ThietBi SET TenTB = ?, NgayBaoTri = ?, Soluong = ?, NoiDung = ?, GhiChu = ?, MaNV = ? WHERE MaTB = ?";
		XJdbc.update(sql, new Object[] {
				tb.getTenTB(),
				tb.getNgaybaotri(),
				tb.getSoluong(),
				tb.getNoidung(),
				tb.getGhichu(),
				tb.getMaNV(),
				tb.getMaTB()
		});
	}

	@Override
	public void delete(String matb) {
		String sql = "DELETE FROM ThietBi WHERE MaTB = ?";
		XJdbc.update(sql, new Object[] {matb} );
	}

	@Override
	public ThietBi selectById(String matb) {
		String sql = "SELECT * FROM ThietBi WHERE MaTB = ?";
		List<ThietBi> list = selectBySql(sql, new Object[] {matb});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<ThietBi> selectAll() {
		String sql = "SELECT * FROM ThietBi";
		return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<ThietBi> selectBySql(String sql, Object... args) {
		List<ThietBi> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	        	ThietBi entity = new ThietBi();
	        	entity.setMaTB(rs.getString("MaTB"));
	        	entity.setNgaybaotri(Check.getDate(rs.getString(rs.getString("NgayBaoTri")))); //TenTB, NgayBaoTri, Soluong, NoiDung, GhiChu, MaNV
	        	entity.setSoluong(rs.getInt("Soluong"));
	        	entity.setNoidung(rs.getString("NoiDung"));
	        	entity.setGhichu(rs.getString("GhiChu"));
	        	entity.setMaNV(rs.getString("MaNV"));
	          list.add(entity);
	        } 
	      } finally {
	        rs.getStatement().getConnection().close();
	      } 
	    } catch (SQLException ex) {
	      ex.printStackTrace();
	      throw new RuntimeException(ex);
	    } 
	    return list;
	}
	
	public List<ThietBi> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM ThietBi WHERE MaNV LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
	public List<ThietBi> selectByTenTB(String keyword) {
	    String sql = "SELECT * FROM ThietBi WHERE TenTB LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
}
