package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.DonHang;
import com.mart.entity.NhaCC;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class NhaNCCDAO extends MartDAO<NhaCC, String>{

	@Override
	public void insert(NhaCC ncc) {
		String sql = "INSERT INTO NhaCC (MaNCC, TenNCC, SoDienThoai, MaLH) VALUES (?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				ncc.getMaNCC(),
				ncc.getTenNCC(),
				ncc.getSDT(),
				ncc.getMaLH()
		});
		
	}

	@Override
	public void update(NhaCC ncc) {
		String sql	= "UPDATE NhaCC SET TenNCC = ?, SoDienThoai = ?, MaLH = ? WHERE MaNCC = ?";
		XJdbc.update(sql, new Object[] {
				ncc.getTenNCC(),
				ncc.getSDT(),
				ncc.getMaLH(),
				ncc.getMaNCC()
		});
	}

	@Override
	public void delete(String mancc) {
		String sql = "DELETE FROM NhaCC WHERE MaNCC = ?";
		XJdbc.update(sql, new Object[] {mancc} );
		
	}

	@Override
	public NhaCC selectById(String mancc) {
		String sql = "SELECT * FROM NhaCC WHERE MaNCC = ?";
		List<NhaCC> list = selectBySql(sql, new Object[] {mancc});
		return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<NhaCC> selectAll() {
		String sql = "SELECT * FROM NhaCC";
	    return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<NhaCC> selectBySql(String sql, Object... args) { //MaNCC, TenNCC, SoDienThoai, MaLH
		List<NhaCC> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	        	NhaCC entity = new NhaCC();
	        	entity.setMaNCC(rs.getNString("MaNCC"));
	        	entity.setTenNCC(rs.getString("TenNCC"));
	        	entity.setSDT(rs.getString("SoDienThoai"));
	        	entity.setMaLH(rs.getString("MaLH"));
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
	  
	  public List<Object[]> getDanhSachtheoTenLH(String tenlh) {
	    String sql = "{CALL DanhSachNCCtheoTenLH (?)}";
	    String[] cols = { "MaNCC", "TenNCC", "SDT", "TenLH" };
	    return getListOfArray(sql, cols, new Object[] { tenlh });
	  }
	  
	  public List<Object[]> getDanhSachNCC() {
	    String sql = "{CALL DanhSachNCC}";
	    String[] cols = { "MaNCC", "TenNCC", "SDT", "TenLH" };
	    return getListOfArray(sql, cols, new Object[0]);
	  }
	
//	public List<NhaCC> selectByKeyword(String keyword) {
//	    String sql = "SELECT * FROM DonHang WHERE TenNCC LIKE ?";
//	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
//	  }
	
//	public List<DonHang> selectByPTTT(String keyword) {
//	    String sql = "SELECT * FROM DonHang WHERE PhuongThucTT LIKE ?";
//	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
//	  }

}
