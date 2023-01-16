package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.ChiTieu;
import com.mart.entity.KhachHang;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class ChiTieuDAO extends MartDAO<ChiTieu, String>{

	@Override
	public void insert(ChiTieu chitieu) {
		String sql = "INSERT INTO ChiTieu (MaHangMuc, TenHangMuc, NgayTao, MaNV, GiaTien, GhiChu) VALUES (?,?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				chitieu.getMaHangmuc(),
				chitieu.getTenHangmuc(),
				chitieu.getNgaytao(),
				chitieu.getMaNV(),
				chitieu.getGiatien(),
				chitieu.getGhichu()
		});
	}

	@Override
	public void update(ChiTieu chitieu) {
		String sql	= "UPDATE ChiTieu SET TenHangMuc = ?, NgayTao = ?, MaNV = ?, GiaTien = ?, GhiChu = ? WHERE MaHangMuc = ?";
		XJdbc.update(sql, new Object[] {
				chitieu.getTenHangmuc(),
				chitieu.getNgaytao(),
				chitieu.getMaNV(),
				chitieu.getGiatien(),
				chitieu.getGhichu(),
				chitieu.getMaHangmuc()
		});
	}

	@Override
	public void delete(String mahm) {
		String sql = "DELETE FROM ChiTieu WHERE MaHangMuc = ?";
		XJdbc.update(sql, new Object[] {mahm} );
	}

	@Override
	public ChiTieu selectById(String mahm) {
		String sql = "SELECT * FROM ChiTieu WHERE MaHangMuc = ?";
		List<ChiTieu> list = selectBySql(sql, new Object[] {mahm});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<ChiTieu> selectAll() {
		String sql = "SELECT * FROM ChiTieu";
		return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<ChiTieu> selectBySql(String sql, Object... args) {
		List<ChiTieu> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          ChiTieu entity = new ChiTieu();
	          entity.setMaHangmuc(rs.getString("MaHangMuc"));
	          entity.setTenHangmuc(rs.getString("TenHangMuc"));
	          String ngaytao = rs.getString("NgayTao");
	          entity.setNgaytao(Check.getDate(ngaytao));
	          entity.setMaNV(rs.getString("MaNV"));
	          entity.setGiatien(rs.getFloat("GiaTien"));
	          entity.setGhichu(rs.getString("GhiChu"));
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
	
	public List<ChiTieu> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM ChiTieu WHERE TenHangMuc LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
}
