package com.mart.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mart.utils.XJdbc;

public class DoanhThuDAO {
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
	
	public List<Object[]> getDSDoanhThutheoThang(int month) {
	    String sql = "{CALL DoanhThubangThang (?)}";
	    String[] cols = {"SoluongDH", "TongGia"};
	    return getListOfArray(sql, cols, new Object[] {month});
	  }
	
	public List<Object[]> getDSDoanhThu() {
	    String sql = "{CALL DoanhThu}";
	    String[] cols = {"SoluongDH", "TongGia"};
	    return getListOfArray(sql, cols, new Object[0]);
	  }

}
