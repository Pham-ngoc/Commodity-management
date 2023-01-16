package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.NestingKind;

import com.mart.entity.HangHoa;
import com.mart.entity.LoaiHang;
import com.mart.entity.NhaCC;
import com.mart.entity.NhanVien;
import com.mart.utils.XJdbc;

public class HangHoaDAO extends MartDAO<HangHoa, String>{

	
	public void insert(HangHoa hh) {
		String sql = "INSERT INTO HangHoa (MaHH, TenHH, DonViTinh, GiaBan, TonKho, MaLH) VALUES (?,?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				hh.getMaHH(),
				hh.getTenHH(), 
				hh.getDVT(),
				hh.getGia(),
				hh.getTonkho(),
				hh.getMaLH()
		});
	}

	
	public void update(HangHoa hh) {
		String sql	= "UPDATE HangHoa SET  TenHH = ?, DonViTinh = ?, GiaBan = ?, TonKho = ?, MaLH = ? WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {
				hh.getTenHH(), 
				hh.getDVT(),
				hh.getGia(),
				hh.getTonkho(),
				hh.getMaLH(),
				hh.getMaHH()
		});
		
	}

	
	public void delete(String mahh) {
		String sql = "DELETE FROM HangHoa WHERE MaHH = ?";
		XJdbc.update(sql, new Object[] {mahh} );
		
	}

	
	public HangHoa selectById(String mahh) {
		String sql = "SELECT * FROM HangHoa WHERE MaHH = ?";
		List<HangHoa> list = selectBySql(sql, new Object[] {mahh});
		return (list.size() > 0) ? list.get(0) : null;
	}

	
	public List<HangHoa> selectAll() {
		String sql = "select * from HangHoa";
		return selectBySql(sql, new Object[0]);
	}

	
	public List<HangHoa> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM HangHoa WHERE TenHH LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
	protected List<HangHoa> selectBySql(String sql, Object... args) {
		List<HangHoa> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          HangHoa entity = new HangHoa();
	          entity.setMaHH(rs.getString("MaHH"));
	          entity.setTenHH(rs.getString("TenHH"));
	          entity.setDVT(rs.getString("DonViTinh"));
	          entity.setGia(rs.getFloat("GiaBan"));
	          entity.setTonkho(rs.getInt("TonKho"));
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
	
	public List<Object[]> getDanhSach() {
	    String sql = "{CALL XemDanhSachHangHoa}";
	    String[] cols = { "MaHH", "TenHH", "DonViTinh", "GiaBan", "TonKho", "TenLH" };
	    return getListOfArray(sql, cols, new Object[0]);
	  }
	
	public List<Object[]> getDSTheoLoai(String tenlh) {
	    String sql = "{CALL DanhSachHangHoa (?)}";
	    String[] cols = { "MaHH", "TenHH", "DonViTinh", "GiaBan", "TonKho", "TenLH" };
	    return getListOfArray(sql, cols, new Object[] { tenlh });
	  }
	
	public List<Object[]> getDSTheoHH(String tenhh) {
	    String sql = "{CALL DanhSachHangHoatheoTenHH (?)}";
	    String[] cols = { "MaHH", "TenHH", "DonViTinh", "GiaBan", "TonKho", "TenLH" };
	    return getListOfArray(sql, cols, new Object[] { tenhh });
	  }
}
