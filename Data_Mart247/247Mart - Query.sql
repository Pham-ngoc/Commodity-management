use Mart247;
go;
-- proc xem danh sách nhà cung cấp
create proc DanhSachNCC
as
	begin
		select NhaCC.MaNCC as MaNCC, 
				NhaCC.TenNCC as TenNCC, 
				NhaCC.SoDienThoai as SDT, 
				LoaiHang.TenLH as TenLH
		from NhaCC 
		inner join LoaiHang on NhaCC.MaLH = LoaiHang.MaLH
	end
go;
exec DanhSachNCC
go;

-- proc xem danh sách nhà cung cấp theo tên loại hàng
create proc DanhSachNCCtheoTenLH(@tenlh nvarchar(50))
as
	begin
		select NhaCC.MaNCC as MaNCC, 
				NhaCC.TenNCC as TenNCC, 
				NhaCC.SoDienThoai as SDT, 
				LoaiHang.TenLH as TenLH
		from NhaCC 
		inner join LoaiHang on NhaCC.MaLH = LoaiHang.MaLH
		where LoaiHang.TenLH = @tenlh
	end
go;
exec DanhSachNCCtheoTenLH N'Văn phòng phẩm'
go;
--proc danh sách hàng đặt
create proc DanhSachHangDat
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangDat.Soluongdat as Soluongdat, 
				HangDat.NgayDat as NgayDat, 
				(HangDat.Soluongdat*HangHoa.GiaBan) as TongGia
		from HangDat
		inner join HangHoa on HangHoa.MaHH = HangDat.MaHH
		group by HangHoa.MaHH,HangHoa.TenHH, HangDat.Soluongdat, HangDat.NgayDat, HangHoa.GiaBan
	end
go;
exec DanhSachHangDat
go;
Update HangDat Set Soluongdat = 5 where NgayDat = '2022-11-29'
go;
create proc DanhSachHangDattheoTenHH (@tenhh nvarchar(50))
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangDat.Soluongdat as Soluongdat, 
				HangDat.NgayDat as NgayDat, 
				(HangDat.Soluongdat*HangHoa.GiaBan) as TongGia
		from HangDat
		inner join HangHoa on HangHoa.MaHH = HangDat.MaHH
		group by HangHoa.MaHH,HangHoa.TenHH, HangDat.Soluongdat, HangDat.NgayDat, HangHoa.GiaBan
		having HangHoa.TenHH = @tenhh
	end
go;
create proc DanhSachHangDattheoNgay (@ngay date)
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangDat.Soluongdat as Soluongdat, 
				HangDat.NgayDat as NgayDat, 
				(HangDat.Soluongdat*HangHoa.GiaBan) as TongGia
		from HangDat
		inner join HangHoa on HangHoa.MaHH = HangDat.MaHH
		group by HangHoa.MaHH,HangHoa.TenHH, HangDat.Soluongdat, HangDat.NgayDat, HangHoa.GiaBan
		having HangDat.NgayDat = @ngay
	end
go;
exec DanhSachHangDattheoNgay '2022-11-28'
go;
-- proc hàng hủy
create proc DanhSachHangHuy
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangHuy.Soluonghuy as Soluonghuy, 
				HangHuy.NgayHuy as NgayHuy, 
				(HangHuy.Soluonghuy*HangHoa.GiaBan) as TongGia
		from HangHuy
		inner join HangHoa on HangHoa.MaHH = HangHuy.MaHH
	end
go;

create proc DanhSachHangHuytheoTenHH(@tenhh nvarchar(50))
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangHuy.Soluonghuy as Soluonghuy, 
				HangHuy.NgayHuy as NgayDat, 
				(HangHuy.Soluonghuy*HangHoa.GiaBan) as TongGia
		from HangHuy
		inner join HangHoa on HangHoa.MaHH = HangHuy.MaHH
		where HangHoa.TenHH = @tenhh
	end
go;


create proc DanhSachHangHuytheoNgayHuy(@ngay date)
as
	begin
		select HangHoa.MaHH as MaHH, 
				HangHoa.TenHH as TenHH,
				HangHuy.Soluonghuy as Soluonghuy, 
				HangHuy.NgayHuy as NgayHuy, 
				(HangHuy.Soluonghuy*HangHoa.GiaBan) as TongGia
		from HangHuy
		inner join HangHoa on HangHoa.MaHH = HangHuy.MaHH
		where HangHuy.NgayHuy = @ngay
	end
go;

select * from HangHoa
go;
-- proc hàng hóa
create proc DanhSachHangHoa (@tenlh nvarchar(20)) 
as
begin
	select HangHoa.MaHH as MaHH, 
			HangHoa.TenHH as TenHH, 
			HangHoa.DonViTinh as DonViTinh, 
			HangHoa.GiaBan as GiaBan, 
			HangHoa.TonKho as TonKho, 
			LoaiHang.TenLH as TenLH
	from HangHoa
	inner join LoaiHang on HangHoa.MaLH = LoaiHang.MaLH
	where LoaiHang.TenLH = @tenlh
end
go;

exec DanhSachHangHoa N'Văn phòng phẩm'
go;
create proc XemDanhSachHangHoa
as
begin
	select HangHoa.MaHH as MaHH, 
			HangHoa.TenHH as TenHH, 
			HangHoa.DonViTinh as DonViTinh, 
			HangHoa.GiaBan as GiaBan, 
			HangHoa.TonKho as TonKho, 
			LoaiHang.TenLH as TenLH
	from HangHoa
	inner join LoaiHang on HangHoa.MaLH = LoaiHang.MaLH
end
go;
create proc DanhSachHangHoatheoTenHH (@tenhh nvarchar(20)) 
as
begin
	select HangHoa.MaHH as MaHH, 
			HangHoa.TenHH as TenHH, 
			HangHoa.DonViTinh as DonViTinh, 
			HangHoa.GiaBan as GiaBan, 
			HangHoa.TonKho as TonKho, 
			LoaiHang.TenLH as TenLH
	from HangHoa
	inner join LoaiHang on HangHoa.MaLH = LoaiHang.MaLH
	where HangHoa.TenHH = @tenhh
end
go;
exec XemDanhSachHangHoa


select * from NhanVien where VaiTro = 1
select * from ChiTieu
go;
--proc chứng từ
create proc DanhSachCT
as
	begin
		select ChungTu.MaCT as MaCT,
				ChungTu.TenCT as TenCT,
				ChungTu.NoiDung as NoiDung,
				ChungTu.GhiChu as GhiChu,
				NhaCC.TenNCC as TenNCC
		from ChungTu
		inner join NhaCC on ChungTu.MaNCC = NhaCC.MaNCC
	end
	go;
exec DanhSachCT
go;
--proc chứng từ theo tên nhà cung cấp
create proc DanhSachCTtheoTenNCC(@tenncc nvarchar(50))
as
	begin
		select ChungTu.MaCT as MaCT,
				ChungTu.TenCT as TenCT,
				ChungTu.NoiDung as NoiDung,
				ChungTu.GhiChu as GhiChu,
				NhaCC.TenNCC as TenNCC
		from ChungTu
		inner join NhaCC on ChungTu.MaNCC = NhaCC.MaNCC
		where NhaCC.TenNCC = @tenncc
	end
	go;
exec DanhSachCTtheoTenNCC N'Nhà phân phối Bút bi Thiên Long'
go;

--proc Doanh thu
create proc DoanhThubangThang(@thang int)
as
	begin
		select count(DonHang.MaDH) as SoluongDH,
				sum(DonHang.TongGia) as TongGia
		from DonHang
		where Month(DonHang.NgayBan) = @thang
 				
	end 
go;
create proc DoanhThu
as
	begin
		select count(DonHang.MaDH) as SoluongDH,
				sum(DonHang.TongGia) as TongGia
		from DonHang
 				
	end 
go;
exec DoanhThubangThang '1'
exec DoanhThu;



SELECT * FROM KhachHang
SELECT DISTINCT month(NgayBan) month FROM DonHang ORDER BY month DESC


--create proc DoanhThubangNam(@nam int)
--as
--	begin
--		select count(DonHang.MaDH) as SoluongDH,
--				sum(DonHang.TongGia) as TongGia,
--
--		from DonHang
--		where Year(DonHang.NgayBan) = @nam
-- 				
--	end 

SELECT * FROM ChuongTrinh WHERE NoiDung LIKE N'Giảm '
select * from ChuongTrinh;

--Bảng nhân viên
INSERT INTO NhanVien (MaNV, HoTen, Email, MatKhau, VaiTro) VALUES (?,?,?,?,?)
UPDATE NhanVien SET HoTen = ?, Email = ?, MatKhau = ?, VaiTro = ? WHERE MaNV = ?
DELETE FROM NhanVien WHERE MaNV = ?
SELECT * FROM NhanVien WHERE MaNV = ?
SELECT * FROM NhanVien


--Bảng nhà cung cấp
INSERT INTO NhaCC(MaNCC, TenNCC, SoDienThoai, MaLH) VALUES (?,?,?,?)
UPDATE NhaCC SET MaNCC = ?, TenNCC = ?, SoDienThoai = ?, MaLH = ? WHERE MaNCC = ?
DELETE FROM NhaCC WHERE MaNCC = ?
SELECT * FROM NhaCC WHERE MaNCC = ?
SELECT * FROM NhaCC


--Bảng hàng hóa
INSERT INTO HangHoa (MaHH, TenHH, DonViTinh, GiaBan, TonKho, MaLH) VALUES (?,?,?,?,?,?)
UPDATE HangHoa SET TenHH  = ?, DonViTinh = ?, GiaBan = ?, TonKho = ?, MaLH =? WHERE MaHH = ?
DELETE FROM HangHoa WHERE MaHH = ?
SELECT * FROM HangHoa WHERE MaHH = ?
SELECT * FROM HangHoa

--Bảng loại hàng
INSERT INTO LoaiHang(MaLH, TenLH) VALUES (?,?)
UPDATE LoaiHang SET TenLH = ? WHERE MaLH = ?
DELETE FROM LoaiHang WHERE MaLH = ?
SELECT * FROM LoaiHang WHERE MaLH = ?
SELECT * FROM LoaiHang


--Bảng hàng đặt
INSERT INTO HangDat (MaHH, Soluongdat, NgayDat) VALUES (?,?,?)
UPDATE HangDat SET Soluongdat = ?, NgayDat = ? WHERE MaHH = ?
DELETE FROM HangDat WHERE MaHH = ?
SELECT * FROM HangDat WHERE MaHH = ?
SELECT * FROM HangDat


--Bảng hàng hủy
INSERT INTO HangHuy (MaHH, Soluonghuy, NgayHuy) VALUES (?,?,?)
UPDATE HangHuy SET Soluonghuy = ?, NgayHuy = ? WHERE MaHH = ?
DELETE FROM HangHuy WHERE MaHH = ?
SELECT * FROM HangHuy WHERE MaHH = ?
SELECT * FROM HangHuy


--Bảng chứng từ
INSERT INTO ChungTu(MaCT, TenCT, NoiDung, GhiChu, MaNCC) VALUES (?,?,?,?,?)
UPDATE ChungTu SET TenCT = ?, NoiDung = ?, GhiChu = ?, MaNCC = ? WHERE MaCT = ?
DELETE FROM ChungTu WHERE MaCT = ?
SELECT * FROM ChungTu WHERE MaCT = ?
SELECT * FROM ChungTu


--Bảng Đơn hàng
INSERT INTO DonHang(MaDH, NgayBan, TongGia, PhuongThucTT, MaNV) VALUES (?,?,?,?,?)
UPDATE DonHang SET NgayBan = ?, TongGia = ?, PhuongThucTT = ?, MaNV = ? WHERE MaDH = ?
DELETE FROM DonHang WHERE MaDH = ?
SELECT * FROM DonHang WHERE MaDH = ?
SELECT * FROM DonHang


--Bảng Thiết bị
INSERT INTO ThietBi(MaTB, TenTB, NgayBaoTri, Soluong, NoiDung, GhiChu, MaNV) VALUES (?,?,?,?,?,?,?)
UPDATE ThietBi SET TenTB = ?, NgayBaoTri = ?, Soluong = ?, NoiDung = ?, GhiChu = ?, MaNV = ? WHERE MaTB = ?
DELETE FROM ThietBi WHERE MaTB = ?
SELECT * FROM ThietBi WHERE MaTB = ?
SELECT * FROM ThietBi

--Bảng chương trình khuyến mãi
INSERT INTO ChuongTrinh(MaCTrinh, NoiDung, GiaTri, Soluong, NgayTao, HanSuDung) VALUES (?,?,?,?,?)
UPDATE ChuongTrinh SET MaCTrinh = ?, NoiDung = ?, GiaTri = ?, Soluong = ?, NgayTao = ?, HanSuDung = ? WHERE MaCTrinh = ?
DELETE FROM ChuongTrinh WHERE MaCTrinh = ?
SELECT * FROM ChuongTrinh WHERE MaCTrinh = ?
SELECT * FROM ChuongTrinh


--Bảng Chi tiêu
INSERT INTO ChiTieu(MaHangMuc, TenHangMuc, NgayTao, MaNV, GiaTien, GhiChu) VALUES (?,?,?,?,?,?)
UPDATE ChiTieu SET TenHangMuc = ?, NgayTao = ?, GiaTien = ?, GhiChu = ? WHERE MaHangMuc = ?
DELETE FROM ChiTieu WHERE MaHangMuc = ?
SELECT * FROM ChiTieu WHERE MaHangMuc = ?
SELECT * FROM ChiTieu
