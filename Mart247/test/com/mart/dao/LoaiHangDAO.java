package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.LoaiHang;
import com.mart.entity.NhanVien;
import com.mart.utils.XJdbc;

public class LoaiHangDAO extends MartDAO<LoaiHang, String>{

	@Override
	public void insert(LoaiHang lh) {
		String sql = "insert into LoaiHang (MaLH, TenLH) values (?,?)";
		XJdbc.update(sql, new Object[] {
				lh.getMaLH(),
				lh.getTenLH()
		});
		
	}

	@Override
	public void update(LoaiHang lh) {
		String sql = "update LoaiHang set TenLH = ? where MaLH = ?";
		XJdbc.update(sql, new Object[] {
				lh.getTenLH(),
				lh.getMaLH()
		});
		
	}

	@Override
	public void delete(String malh) {
		String sql = "delete from LoaiHang where MaLH =?";
		XJdbc.update(sql, new Object[] { malh });
		
	}

	@Override
	public LoaiHang selectById(String malh) {
		String sql = "select * from LoaiHang where MaLH=?";
		List<LoaiHang> list = selectBySql(sql, new Object[] { malh });
	    return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<LoaiHang> selectAll() {
		String sql = "select * from LoaiHang";
		return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<LoaiHang> selectBySql(String sql, Object... args) {
		List<LoaiHang> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          LoaiHang entity = new LoaiHang();
	          entity.setMaLH(rs.getString(1));
	          entity.setTenLH(rs.getString(2));
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
	
	public List<LoaiHang> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM LoaiHang WHERE TenLH LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
}
