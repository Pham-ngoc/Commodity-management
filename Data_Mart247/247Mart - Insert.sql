use Mart247;

insert into NhanVien (MaNV, HoTen, Email, MatKhau, VaiTro) values
('ngocptn', N'Phạm Thị Như Ngọc', 'ngocptn@gmail.com', 'ngocptn', '1'),
('chauthong', N'Châu Thống', 'thongc@gmail.com', 'chauthong', '0'),
('mynlk', N'Nguyễn Lê Kiêu My', 'mynlk@gmail.com', 'mynlk', '0');
select * from NhanVien

select * from KhachHang
insert into KhachHang values
('KH05', 'FSDFSDF', 0, '2003-01-01', '0123456789')

--loại hàng
insert into LoaiHang values 
('MLH01', N'Văn phòng phẩm'),
('MLH02', N'Nước có ga'),
('MLH03', N'Kẹo - singum'),
('MLH04', N'Mì ly - tô'),
('MLH05', N'Cháo'),
('MLH06', N'Mì gói'),
('MLH07', N'Gia vị nhà bếp'),
('MLH08', N'Dụng cụ nhà bếp'),
('MLH09', N'Dụng cụ y tế'),
('MLH10', N'Mỹ phẩm nữ'),
('MLH11', N'Mỹ phẫm nam'),
('MLH12', N'Dụng cụ vệ sinh cá nhân'),
('MLH13', N'Nước lọc'),
('MLH14', N'Trà'),
('MLH15', N'Nước ngọt không ga'),
('MLH16', N'Bia'),
('MLH17', N'Chocolate'),
('MLH18', N'Snack');
select * from LoaiHang
select TenLH from LoaiHang


select * from HangHoa;
insert into HangHoa (MaHH, TenHH, DonViTinh, GiaBan, TonKho, MaLH) Values
('MHH01', N'Bút bi Thiên Long TL-027 xanh', N'1 cây', '3000', '0', 'MLH01'),
('MHH02', N'Bút bi Thiên Long TL-027 đỏ', N'1 cây', '3000', '0', 'MLH01'),
('MHH03', N'Bút bi Thiên Long TL-027 đen', N'1 cây', '3000', '0', 'MLH01'),
('MHH04', N'Bút bi Thiên Long TL-027 xanh', N'1 cây', '3000', '0', 'MLH01'),
('MHH05', N'Coca Cola nguyên bản 355ml (lon)', N'1 lon', '9000', '0', 'MLH02'),
('MHH06', N'Coca Cola zero 355ml (lon)', N'1 lon', '9000', '0', 'MLH02'),
('MHH07', N'Coca Cola nguyên bản 390ml (chai)', N'1 chai', '9000', '0', 'MLH02'),
('MHH08', N'Coca Cola nguyên bản 500ml (chai)', N'1 chai', '11000', '0', 'MLH02'),
('MHH09', N'Pesi 355ml (lon)', N'1 lon', '9000', '0', 'MLH02'),
('MHH10', N'Pesi 500ml (chai)', N'1 chai', '11000', '0', 'MLH02'),
('MHH11', N'Kẹo Play More vị dưa hấu', N'1 hộp', '32000', '0', 'MLH03'),
('MHH12', N'Singum Xilytor', N'1 hộp', '28000', '0', 'MLH03'),
('MHH13', N'Singum CoolAir', N'1 hộp', '28000', '0', 'MLH03'),
('MHH14', N'Kẹo dẻo Chupa Chups Panda Bear', N'1 bịch', '15000', '0', 'MLH03'),
('MHH15', N'Kẹo dẻo Chupa Chups Cool Coca', N'1 bịch', '15000', '0', 'MLH03'),
('MHH16', N'Kẹo dẻo Yupi Buger 96g ', N'1 bịch', '25000', '0', 'MLH03'),
('MHH17', N'Mì ly Cung đình', N'1 ly', '10000', '0', 'MLH04'),
('MHH18', N'Mì tô JinJin', N'1 tô', '33000', '0', 'MLH04'),
('MHH19', N'Mì ly Hảo Hảo chua cay', N'1 ly', '10000', '0', 'MLH04'),
('MHH20', N'Mì ly Moden chua cay', N'1 ly', '10000', '0', 'MLH04'),
('MHH21', N'Cháo Gấu đỏ thịt bằm', N'1 gói', '9000', '0', 'MLH05'),
('MHH22', N'Cháo Vifon', N'1 gói', '9000', '0', 'MLH05'),
('MHH23', N'Mì Hảo Hảo chua cay (gói)', N'1 gói', '5000', '0', 'MLH06'),
('MHH24', N'Mì SiuKay hải sản', N'1 gói', '15000', '0', 'MLH06'),
('MHH25', N'Tương ớt Cholimex 270g (chai nhựa)', N'1 chai', '12000', '0', 'MLH07'),
('MHH26', N'Tương cà CHolimex 270g (chai nhựa)', N'1 chai', '12000', '0', 'MLH07');

insert into HangDat (MaHH, Soluongdat, NgayDat) values
('MHH01', '2', '11-30-2022'),
('MHH01', '3', '12-02-2022'),
('MHH02', '1', '11-29-2022'),
('MHH02', '2', '11-01-2022');
select * from HangDat

insert into HangHuy (MaHH, Soluonghuy, NgayHuy) values
('MHH22', '2', '11-30-2022'),
('MHH22', '3', '12-02-2022'),
('MHH24', '1', '11-29-2022'),
('MHH16', '2', '11-01-2022');
select * from HangHuy

insert into ChuongTrinh (MaCTrinh, NoiDung, GiaTri, Soluong, NgayTao, HanSuDung) values
('CT01', N'Giảm 5000 cho mỗi hóa đơn từ 20000', '5000', '100000', '12-4-2022', '12-4-2023')
select * from ChuongTrinh

select * from DonHang

insert into NhaCC values
('NCC01', N'Nhà phân phối Bút bi Thiên Long', '0954673218', 'MLH01')

insert into NhaCC values
('NCC02', N'Nhà phân phối Bút bi Hồng Hà', '0954673218', 'MLH01'),
('NCC03', N'Nhà phân phối Coca Cola', '0954673218', 'MLH02'),
('NCC04', N'Nhà phân phối Pesi', '0954673218', 'MLH02'),
('NCC05', N'Nhà phân phối Lotte', '0954673218', 'MLH03')
select * from NhaCC

insert into ChungTu values
('0276583', N'Phiếu giao hàng bút Thiên Long', N'Giao 2 hộp bút bi Thiên Long TL-027 xanh (40 cây)', null ,'NCC01')
select * from ChungTu


()
select *from DonHang