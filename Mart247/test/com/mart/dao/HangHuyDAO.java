package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.HangHuy;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class HangHuyDAO extends MartDAO<HangHuy, String> {

	public void insert(HangHuy hd) {
		String sql = "INSERT INTO HangHuy (MaHH, Soluonghuy, NgayHuy) VALUES (?,?,?)";
		XJdbc.update(sql, new Object[] {
				hd.getMaHH(),
				hd.getSoluongHuy(),
				hd.getNgayhuy()
		});
	}

	
	public void update(HangHuy hd) {
		String sql	= "UPDATE HangHuy SET  Soluonghuy = ?, NgayHuy = ? WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {
				hd.getSoluongHuy(),
				hd.getNgayhuy(),
				hd.getMaHH()
		});
		
	}

	
	public void delete(String mahd) {
		String sql = "DELETE FROM HangHuy WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {mahd} );
		
	}

	
	public HangHuy selectById(String mahd) {
		String sql = "SELECT * FROM HangHuy WHERE MaHH = ?";
		List<HangHuy> list = selectBySql(sql, new Object[] {mahd});
		return (list.size() > 0) ? list.get(0) : null;
	}

	
	public List<HangHuy> selectAll() {
		String sql = "select * from HangHuy";
		return selectBySql(sql, new Object[0]);
	}
	
	protected List<HangHuy> selectBySql(String sql, Object... args) {
		List<HangHuy> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          HangHuy entity = new HangHuy();
	          entity.setMaHH(rs.getString("MaHH"));
	          entity.setSoluongHuy(rs.getInt("Soluonghuy"));
	          entity.setNgayhuy(Check.getDate(rs.getString("NgayHuy")));
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
		
	private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
	    try {
	      List<Object[]> list = new ArrayList<Object[]>();
	      ResultSet rs = XJdbc.query(sql, args);
	      while (rs.next()) {
	        Object[] vals = new Object[cols.length];
	        for (int i = 0; i < cols.length; i++)
	          vals[i] = rs.getObject(cols[i]); 
	        list.add(vals);
	      } 
	      rs.getStatement().getConnection().close();
	      return list;
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    } 
	  }
	
	public List<Object[]> getDanhSachHangHuy() {
	    String sql = "{CALL DanhSachHangHuy}";
	    String[] cols = { "MaHH", "TenHH", "Soluonghuy", "NgayHuy", "TongGia"};
	    return getListOfArray(sql, cols, new Object[0]);
	  }
	
	public List<Object[]> getDanhSachHangHuytheoTenHH(String tenhh) {
	    String sql = "{CALL DanhSachHangHuytheoTenHH (?)}";
	    String[] cols = { "MaHH", "TenHH", "Soluonghuy", "NgayHuy", "TongGia" };
	    return getListOfArray(sql, cols, new Object[] { tenhh });
	  }
	
	public List<Object[]> getDanhSachHangHuytheoNgay(String ngay) {
	    String sql = "{CALL DanhSachHangHuytheoNgayHuy (?)}";
	    String[] cols = { "MaHH", "TenHH", "Soluonghuy", "NgayHuy", "TongGia" };
	    return getListOfArray(sql, cols, new Object[] { ngay});
	  }
}
