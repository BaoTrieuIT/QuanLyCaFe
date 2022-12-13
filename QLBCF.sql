use master
go
drop DATABASE DuAn1_QuanLyCafe
create database DuAn1_QuanLyCafe
go

use DuAn1_QuanLyCafe
go

create table NHANVIEN
(
	MaNV varchar(10) primary key,
	HoTen nvarchar(100),
	MatKhauNV nvarchar(100),
	GioiTinh bit,
	DiaChi nvarchar(100),
	SoDT varchar(15),
	CCCD varchar(15),
	NgaySinhNV date,
	Vaitro bit,
	Hinh nvarchar(100)
)
go

create table KHACHHANG
(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(100),
	Gioitinh bit,
	DiaChi nvarchar(255),
	NgaySinh date,
	Email varchar(50),
	SoDT varchar(15)
)


go

create table HOADON
(
	MaHD int identity primary key,
	MaNV varchar(10),
	MaKH int,
	NgaylapHD datetime default getdate(),
	TongTienHD money,
	GhiChu nvarchar(255),
	constraint fk_HoaDon_of_NhanVien
	foreign key (MaNV) references NhanVien (MaNV) on update cascade,
	constraint fk_HoaDon_of_KhachHang
	foreign key (MaKH) references KhachHang (MaKH) on update cascade
)
go

create table NHACUNGCAP
(
	MaNhaCC int IDENTITY(1,1) primary key,
	TenNhaCC nvarchar(100),
	SDT varchar(15),
	DiaChi nvarchar(200),
	NguoiLienHe nvarchar(100),
	GhiChu nvarchar(1000)
)
go

--select * from DoUong du inner join NhaCungCap ncc on du.MaNhaCC = ncc.MaNhaCC where ncc.TenNhaCC like '%The Dream of Coffee%'
create table DoUong
(
	MaMon VARCHAR(10) not null PRIMARY KEY,
	MaNhaCC int,
	TenMon nvarchar(100) not NULL,
	Sizemon char(10),
	GiaBan money,
	GiaNhap money not null,
	SoLuong int,
	NgayNhap date,
	NgayHetHan date,
	Hinh nvarchar(100),
	GhichuMon nvarchar (1000),
	constraint fk_DoUong_of_NhaCungCap
	foreign key (MaNhaCC) references NHACUNGCAP (MaNhaCC) on update cascade
)
go

create table HOADONCHITIET
(
	MaHDCT int identity(1,1) primary key,
	MaHD int,
	MaMon varchar(10),
	Soluong int,
	Thanhtien money,
	GHiChu NVARCHAR(100),
	constraint fk_ChiTiet_of_DoUong
	foreign key (MaMon) references DoUong (MaMon) on update cascade,
	constraint fk_ChiTiet_of_HoaDon
	foreign key (MaHD) references HoaDon (MaHD) on DELETE cascade ON UPDATE cascade
)
go






insert into NHANVIEN values ('NV1',N'Sang',N'123456',1,N'46 đường 18, quận Bình Tân, HCM','036345189210','00554432018','12-09-2002',1,N'Sang.jpg'),
							('NV2',N'Teo',N'123456',1,N'46 đường 18, quận Bình Tân, HCM','036345189210','00554432018','1-08-2002',0,N'Teo.jpg'),
							('NV3',N'Bao',N'123456',1,N'46 đường 18, quận Bình Tân, HCM','036345189210','00554432018','12-10-2002',1,N'Bao.jpg'),
							('NV4',N'Khang',N'123456',1,N'46 đường 18, quận Bình Tân, HCM','036345189210','00554432018','2-12-2002',1,N'Khang.jpg'),
							('NV5',N'Minh',N'123456',1,N'46 đường 18, quận Bình Tân, HCM','036345189210','00554432018','5-12-2002',0,N'Minh.jpg')
go

select * from NHANVIEN

insert into KHACHHANG values (N'Nguyễn Văn Tài',1,N'46 đường 18, quận Bình Tân, HCM','05-05-2000','TaiVN123@gmail.com','0159633348201'),
							(N'Nguyễn Ngọc Linh',0,N'46 đường 18, quận Bình Tân, HCM','10-08-1998','LinhNN123@gmail.com','0159633348201'),
							(N'Nguyễn Thị Kim Linh',0,N'46 đường 18, quận Bình Tân, HCM','06-05-2001','LinhNTK123@gmail.com','0159633348201'),
							(N'Trần Mạnh Toàn',1,N'46 đường 18, quận Bình Tân, HCM','05-10-1995','ToanTM123@gmail.com','0159633348201'),
							(N'Lê Ngọc Ánh',0,N'46 đường 18, quận Bình Tân, HCM','09-11-2000','AnhLN123@gmail.com','0159633348201')
go

insert into NHACUNGCAP values (N'Trung Nguyên','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Tạ Hồ Phi Phụng',''),
							(N'The Dream Of Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Tống Phạm Hoàng Huy',''),
							(N'Bajaland Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Lê Nhật Tân',''),
							(N'Art Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Nguyễn Văn Thuận',''),
							(N'Milano Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Trần Văn Minh','')
go
select * from NHACUNGCAP




insert into DoUong values ('#1',2,N'Coffee Chồn Kopi Luwak','M',25000,20000,100,'11-18-2022','11-18-2024','anh1.jpg',''),
						('#2',4,N'Coffee Typica Ethiopia','S',20000,15000,100,'11-18-2022','11-18-2024','anh2.jpg',''),
						('#3',1,N'Coffee Trung Nguyên','S',25000,20000,100,'11-18-2022','11-18-2024','anh3.jpg',''),
						('#4',3,N'Coffee Sữa','L',18000,14000,100,'11-18-2022','11-18-2024','anh4.jpg',''),
						('#5',5,N'Bạc Xĩu','M',18000,14000,100,'11-18-2022','11-18-2024','anh5.jpg','')

select * from DoUong



  DBCC CHECKIDENT ('HoaDOn', RESEED, 0);
GO

-- create proc sp_ThongKeDoanhThuTheoNam(@Year int)
-- as
-- begin
-- 	select  a.MaHD, 
-- 		SUM (b.ThanhTien)TongTien , 
-- 		MIN(b.ThanhTien)MonThapNhat ,
-- 		MAX(b.ThanhTien)MonCaoNhat 
-- 		from HoaDon a
-- 		join HoaDonChiTiet b on a.MaHD=b.MaHD
-- 		where year(a.NgayLapHD) = @Year
-- 		Group by a.MaHD
-- end
-- create proc sp_ThongKeDoanhThuTheoThang(@Month int)
-- as
-- begin
-- 	select  a.MaHD, 
-- 		SUM (b.ThanhTien)TongTien , 
-- 		MIN(b.ThanhTien)MonThapNhat ,
-- 		MAX(b.ThanhTien)MonCaoNhat 
-- 		from HoaDon a
-- 		join HoaDonChiTiet b on a.MaHD=b.MaHD
-- 		where month(a.NgayLapHD) = @Month
-- 		Group by a.MaHD
-- end
-- create proc sp_ThongKeDoanhThuTheoNgay(@Day int)
-- as
-- begin
-- 	select  a.MaHD, 
-- 		SUM (b.ThanhTien)TongTien , 
-- 		MIN(b.ThanhTien)MonThapNhat ,
-- 		MAX(b.ThanhTien)MonCaoNhat 
-- 		from HoaDon a
-- 		join HoaDonChiTiet b on a.MaHD=b.MaHD
-- 		where Day(a.NgayLapHD) = @Day
-- 		Group by a.MaHD
-- end


create trigger trg_capnhatsoluong on HoaDonChiTiet after insert as
begin
update DoUong
set DoUong.SoLuong = DoUong.Soluong-
(select SoLuong from inserted where MaMon = DoUong.MaMon ) 
from DoUong
Join inserted on DoUong.MaMon = inserted.MaMon
end