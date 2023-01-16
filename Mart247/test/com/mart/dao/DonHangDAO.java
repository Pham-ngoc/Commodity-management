package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.DonHang;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class DonHangDAO extends MartDAO<DonHang, String> {
	
	@Override
	public void insert(DonHang dh) {
		String sql = "INSERT INTO DonHang (MaDH, NgayBan, TongGia, PhuongThucTT, MaNV) VALUES (?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				dh.getMaDH(),
				dh.getNgayban(),
				dh.getTonggia(),
				dh.getPTTT(),
				dh.getMaNV()
		});
	}

	@Override
	public void update(DonHang dh) {
		String sql	= "UPDATE DonHang SET NgayBan = ?, TongGia = ?, PhuongThucTT = ?, MaNV = ? WHERE MaDH = ?";
		XJdbc.update(sql, new Object[] {
				dh.getNgayban(),
				dh.getTonggia(),
				dh.getPTTT(),
				dh.getMaNV(), 
				dh.getMaDH()
		});
	}

	@Override
	public void delete(String madh) {
		String sql = "DELETE FROM DonHang WHERE MaDH = ?";
		XJdbc.update(sql, new Object[] {madh} );
	}

	@Override
	public DonHang selectById(String madh) {
		String sql = "SELECT * FROM DonHang WHERE MaDH = ?";
		List<DonHang> list = selectBySql(sql, new Object[] {madh});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<DonHang> selectAll() {
		String sql = "SELECT * FROM DonHang";
		return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<DonHang> selectBySql(String sql, Object... args) {
		List<DonHang> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	        	DonHang entity = new DonHang();
	        	entity.setMaDH(rs.getString("MaDH"));
	        	entity.setNgayban(Check.getDate(rs.getString("NgayBan")));
	        	entity.setTonggia(rs.getFloat("TongGia"));
	        	entity.setPTTT(rs.getString("PhuongThucTT"));
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
	
	public List<DonHang> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM DonHang WHERE MaNV LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
	public List<DonHang> selectByPTTT(String keyword) {
	    String sql = "SELECT * FROM DonHang WHERE PhuongThucTT LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
	public List<Integer> selectMonth() {
	    String sql = "SELECT DISTINCT month(NgayBan) month FROM DonHang ORDER BY month DESC";
	    List<Integer> list = new ArrayList<>();
	    try {
	      ResultSet rs = XJdbc.query(sql, new Object[0]);
	      while (rs.next())
	        list.add(Integer.valueOf(rs.getInt(1))); 
	      rs.getStatement().getConnection().close();
	      return list;
	    } catch (SQLException ex) {
	      throw new RuntimeException(ex);
	    } 
	  }
}
