package com.mart.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mart.entity.ChuongTrinh;
import com.mart.entity.KhachHang;
import com.mart.utils.Check;
import com.mart.utils.XDate;
import com.mart.utils.XJdbc;

public class ChuongTrinhDAO extends MartDAO<ChuongTrinh, String> {

	@Override
	public void insert(ChuongTrinh ct) {
		String sql = "INSERT INTO ChuongTrinh (MaCTrinh, NoiDung, GiaTri, Soluong, NgayTao, HanSuDung) VALUES (?,?,?,?,?,?)";
		XJdbc.update(sql, new Object[] {
				ct.getMaCT(),
				ct.getNoidung(),
				ct.getGiatri(),
				ct.getSoluong(),
				ct.getNgaytao(),
				ct.getHSD()
		});
		
	}

	@Override
	public void update(ChuongTrinh ct) {
		String sql = "UPDATE ChuongTrinh SET NoiDung =?, GiaTri = ?, Soluong = ?, NgayTao = ?, HanSuDung = ? WHERE MaCTrinh = ?";
		XJdbc.update(sql, new Object[] {
				ct.getNoidung(),
				ct.getGiatri(),
				ct.getSoluong(),
				ct.getNgaytao(),
				ct.getHSD(),
				ct.getMaCT()
		});
		
	}

	@Override
	public void delete(String mact) {
		String sql = "DELETE FROM ChuongTrinh WHERE MaCTrinh = ?";
		XJdbc.update(sql, new Object[] { mact });
		
	}

	@Override
	public ChuongTrinh selectById(String mact) {
		String sql = "SELECT * FROM ChuongTrinh WHERE MaCTrinh = ?";
		List<ChuongTrinh> list = selectBySql(sql, new Object[] {mact});
		return (list.size() > 0) ? list.get(0) : null ;
	}

	@Override
	public List<ChuongTrinh> selectAll() {
		String sql = "SELECT * FROM ChuongTrinh";
		return selectBySql(sql, new Object[0]);
	}

	@Override
	protected List<ChuongTrinh> selectBySql(String sql, Object... args) {
		List<ChuongTrinh> list = new ArrayList<>();
		try {
			ResultSet rs = null;
			try {
				rs = XJdbc.query(sql, args);
				while (rs.next()) {
					ChuongTrinh entity	= new ChuongTrinh();
					entity.setMaCT(rs.getString("MaCTrinh"));
					entity.setNoidung(rs.getString("NoiDung"));
					entity.setGiatri(Float.parseFloat(rs.getString("GiaTri")));
					entity.setSoluong(Integer.parseInt(rs.getString("Soluong")));
					entity.setNgaytao(Check.getDate(rs.getString("NgayTao")));
					entity.setHSD(Check.getDate(rs.getString("HanSuDung")));
					list.add(entity);
				}
			} finally {
				rs.getStatement().getConnection().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<ChuongTrinh> selectByKeyword(String keyword) {
	    String sql = "SELECT * FROM ChuongTrinh WHERE NoiDung LIKE ?";
	    return selectBySql(sql, new Object[] { "%" + keyword + "%" });
	  }

}
