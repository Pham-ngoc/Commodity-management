create database Mart247;
use Mart247;
--Tạo bảng
--Bảng khách hàng
create table KhachHang(
	MaKH nvarchar(20) primary key,
	Hoten nvarchar(50),
	GioiTinh bit,
	NgaySinh date,
	SoDienThoai nvarchar(15)
	);
-- Bảng nhân viên
create table NhanVien(
	MaNV nvarchar(20) primary key,
	HoTen nvarchar(50),
	Email nvarchar(20),
	MatKhau nvarchar(10),
	VaiTro bit not null -- 0 là nhân viên, 1 là trưởng cửa hàng
	);
--Bảng NCC
create table NhaCC(
	MaNCC nvarchar(20) primary key,
	TenNCC nvarchar(50),
	SoDienThoai nvarchar(15),
	MaLH nvarchar(20)
	);

-- Bảng hàng hóa
create table HangHoa(
	MaHH nvarchar(20) primary key,
	TenHH nvarchar(50),
	DonViTinh nvarchar(25),
	GiaBan float,
	TonKho int,
	MaLH nvarchar(20)
	);
-- Foreign
alter table HangHoa
add constraint FK_hanghoa_loaihang
foreign key (MaLH) references LoaiHang(MaLH);

--Bảng loại hàng
create table LoaiHang(
	MaLH nvarchar(20) primary key,
	TenLH nvarchar(50)
	);
--Bảng hàng đặt
create table HangDat(
	MaHH nvarchar(20),
	Soluongdat int,
	NgayDat date
	);
--Foreign
alter table HangDat
add constraint FK_hangdat_hanghoa
foreign key (MaHH) references HangHoa(MaHH);

--Bảng hàng hủy
create table HangHuy(
	MaHH nvarchar(20),
	Soluonghuy int,
	NgayHuy date
	);
--Foreign
alter table HangHuy
add constraint FK_hanghuy_hanghoa
foreign key (MaHH) references HangHoa(MaHH);

--Bảng chứng từ
create table ChungTu(
	MaCT nvarchar(20) primary key,
	TenCT nvarchar(50),
	NoiDung nvarchar(50),
	GhiChu nvarchar(200),
	MaNCC nvarchar(20)
	);
--Foreign
alter table ChungTu
add constraint FK_chungtu_nhacc
foreign key (MaNCC) references NhaCC(MaNCC);

--Bảng đơn hàng
create table DonHang(
	MaDH nvarchar(20) primary key,
	NgayBan date,
	TongGia float,
	PhuongThucTT nvarchar(30),
	MaNV nvarchar(20)
	);
--Foreign
alter table DonHang
add constraint FK_donhang_nhanvien
foreign key (MaNV) references NhanVien(MaNV);

--Bảng thiết bị
create table ThietBi(
	MaTB nvarchar(20) primary key,
	TenTB nvarchar(50),
	NgayBaoTri date,
	Soluong int,
	NoiDung nvarchar(50),
	GhiChu nvarchar(50),
	MaNV nvarchar(20)
	);
--Foreign
alter table ThietBi
add constraint FK_thietbi_nhanvien
foreign key (MaNV) references NhanVien(MaNV);



--Bảng chương trình khuyến mại
create table ChuongTrinh(
	MaCTrinh nvarchar(20) primary key,
	NoiDung nvarchar(50),
	GiaTri float,
	Soluong int,
	NgayTao date,
	HanSuDung date
	);
	
-- Bảng Chi tiêu
create table ChiTieu(
	MaHangMuc nvarchar(20) primary key,
	TenHangMuc nvarchar(50),
	NgayTao date,
	MaNV nvarchar(20),
	GiaTien float,
	GhiChu nvarchar(50)
	);
--Foreign
alter table ChiTieu
add constraint FK_chitieu_nhanvien
foreign key (MaNV) references NhanVien(MaNV);


