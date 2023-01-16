package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mart.entity.HangDat;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class HangDatDAO extends MartDAO<HangDat, String> {

	public void insert(HangDat hd) {
		String sql = "INSERT INTO HangDat (MaHH, Soluongdat, NgayDat) VALUES (?,?,?)";
		XJdbc.update(sql, new Object[] {
				hd.getMaHH(),
				hd.getSoluongDat(),
				hd.getNgaydat()
		});
	}

	
	public void update(HangDat hd) {
		String sql	= "UPDATE HangDat SET  Soluongdat = ?, NgayDat = ? WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {
				hd.getSoluongDat(),
				hd.getNgaydat(),
				hd.getMaHH()
		});
		
	}

	
	public void delete(String mahd) {
		String sql = "DELETE FROM HangDat WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {mahd} );
		
	}

	
	public HangDat selectById(String mahd) {
		String sql = "SELECT * FROM HangDat WHERE MaHH = ?";
		List<HangDat> list = selectBySql(sql, new Object[] {mahd});
		return (list.size() > 0) ? list.get(0) : null;
	}

	
	public List<HangDat> selectAll() {
		String sql = "select * from HangDat";
		return selectBySql(sql, new Object[0]);
	}
	
	protected List<HangDat> selectBySql(String sql, Object... args) {
		List<HangDat> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          HangDat entity = new HangDat();
	          entity.setMaHH(rs.getString("MaHH"));
	          entity.setSoluongDat(rs.getInt("Soluongdat"));
	          entity.setNgaydat(Check.getDate(rs.getString("NgayDat")));
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
	
	public List<Object[]> getDanhSachHangDat() {
	    String sql = "{CALL DanhSachHangDat}";
	    String[] cols = { "MaHH", "TenHH", "Soluongdat", "NgayDat", "TongGia"};
	    return getListOfArray(sql, cols, new Object[0]);
	  }
	
	public List<Object[]> getDanhSachHangDattheoTenHH(String tenhh) {
	    String sql = "{CALL DanhSachHangDattheoTenHH (?)}";
	    String[] cols = { "MaHH", "TenHH", "Soluongdat", "NgayDat", "TongGia" };
	    return getListOfArray(sql, cols, new Object[] { tenhh });
	  }
	
	public List<Object[]> getDanhSachHangDattheoNgay(String ngay) {
	    String sql = "{CALL DanhSachHangDattheoNgay (?)}";
	    String[] cols = { "MaHH", "TenHH", "Soluongdat", "NgayDat", "TongGia" };
	    return getListOfArray(sql, cols, new Object[] {ngay});
	  }

}
