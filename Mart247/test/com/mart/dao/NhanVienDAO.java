package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.KhachHang;
import com.mart.entity.NhanVien;
import com.mart.utils.XJdbc;

public class NhanVienDAO extends MartDAO<NhanVien, String> {

	@Override
	public void insert(NhanVien nv) {
		String sql = "INSERT INTO NhanVien (MaNV, HoTen, Email, MatKhau, VaiTro) VALUES (?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				nv.getMaNV(),
				nv.getHoten(),
				nv.getEmail(),
				nv.getMaNV(),
				Boolean.valueOf(nv.isVaitro())
		});
	}

	@Override
	public void update(NhanVien nv) {
		String sql = "UPDATE NhanVien SET HoTen = ?, Email = ?, MatKhau = ?, VaiTro = ? WHERE MaNV = ?";
		XJdbc.update(sql, new Object[] {
				nv.getHoten(),
				nv.getEmail(),
				nv.getMatkhau(),
				Boolean.valueOf(nv.isVaitro()),
				nv.getMaNV()
		});
		
	}

	@Override
	public void delete(String manv) {
		String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
		XJdbc.update(sql, new Object[] {manv} );
	}

	@Override
	public NhanVien selectById(String manv) {
		String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
	    List<NhanVien> list = selectBySql(sql, new Object[] { manv });
	    return (list.size() > 0) ? list.get(0) : null;
	}

	@Override
	public List<NhanVien> selectAll() {
		String sql = "SELECT * FROM NhanVien";
	    return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<NhanVien> selectBySql(String sql, Object... args) {
		List<NhanVien> list = new ArrayList<>();
	    try {
	      ResultSet rs = null;
	      try {
	        rs = XJdbc.query(sql, args);
	        while (rs.next()) {
	          NhanVien entity = new NhanVien();
	          entity.setMaNV(rs.getString("MaNV"));
	          entity.setHoten(rs.getString("HoTen"));
	          entity.setEmail(rs.getString("Email"));
	          entity.setMatkhau(rs.getString("MatKhau"));
	          entity.setVaitro(rs.getBoolean("VaiTro"));
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
	
	public List<NhanVien> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }
	
	public List<NhanVien> selectByTruongphong() {
	    String sql = "SELECT * FROM NhanVien WHERE VaiTro = 1 ";
	    return selectBySql(sql, new Object[0]);
	  }
}
