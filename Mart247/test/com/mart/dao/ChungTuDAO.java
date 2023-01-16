package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.ChungTu;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class ChungTuDAO extends MartDAO<ChungTu, String> {
	
	@Override
	public void insert(ChungTu ct) {
		String sql = "INSERT INTO ChungTu (MaCT, TenCT, NoiDung, GhiChu, MaNCC) VALUES (?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				ct.getMaCT(),
				ct.getTenCT(),
				ct.getNoidung(),
				ct.getGhichu(),
				ct.getMaNCC()
		});
	}

	@Override
	public void update(ChungTu ct) {
		String sql	= "UPDATE ChungTu SET TenCT = ?, NoiDung = ?, GhiChu = ?, MaNCC = ? WHERE MaCT = ?";
		XJdbc.update(sql, new Object[] {
				ct.getTenCT(),
				ct.getNoidung(),
				ct.getGhichu(),
				ct.getMaNCC(),
				ct.getMaCT()
		});
	}

	@Override
	public void delete(String mact) {
		String sql = "DELETE FROM ChungTu WHERE MaCT = ?";
		XJdbc.update(sql, new Object[] {mact} );
	}

	@Override
	public ChungTu selectById(String mact) {
		String sql = "SELECT * FROM ChungTu WHERE MaCT = ?";
		List<ChungTu> list = selectBySql(sql, new Object[] {mact});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<ChungTu> selectAll() {
		String sql = "SELECT * FROM ChungTu";
	    return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<ChungTu> selectBySql(String sql, Object... args) {
		List<ChungTu> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	        	ChungTu entity = new ChungTu(); //MaCT, TenCT, NoiDung, GhiChu, MaNCC
	        	entity.setMaCT(rs.getString("MaCT"));
	        	entity.setTenCT(rs.getString("TenCT"));
	        	entity.setNoidung(rs.getString("NoiDung"));
	        	entity.setGhichu(rs.getString("GhiChu"));
	        	entity.setMaNCC(rs.getString("MaNCC"));
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
	
//	public List<ChungTu> selectByKeyword(String keyword) {
//	    String sql = "SELECT * FROM ThietBi WHERE MaNCC LIKE ?";
//	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
//	  }
	
	public List<ChungTu> selectByPTTT(String keyword) {
	    String sql = "SELECT * FROM ThietBi WHERE TenCT LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
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
	  
	  public List<Object[]> getDanhSachCTtheoTenNCC(String tenlh) {
	    String sql = "{CALL DanhSachCTtheoTenNCC (?)}";
	    String[] cols = { "MaCT", "TenCT", "NoiDung", "GhiChu", "TenNCC" };
	    return getListOfArray(sql, cols, new Object[] { tenlh });
	  }
	  
	  public List<Object[]> getDanhSachCT() {
	    String sql = "{CALL DanhSachCT}";
	    String[] cols = { "MaCT", "TenCT", "NoiDung", "GhiChu", "TenNCC" };
	    return getListOfArray(sql, cols, new Object[0]);
	  }
}
