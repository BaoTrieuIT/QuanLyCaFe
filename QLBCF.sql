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
	MaHD varchar(10) primary key,
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

Create table LOAIHANG
(
	MaLoaiHang int identity(1,1) primary key,
	TenLoaiHang nvarchar(100) not null,
)
go

create table HANGHOA
(
	MaHang varchar(10) not null primary key ,
	TenHang nvarchar(100) not null,
	MaLoaiHang int not null,
	NhaSX nvarchar(50),
	SoLuong varchar(15),
	NgayNhap date,
	Hinh nvarchar(200),
	constraint fk_HangHoa_of_LoaiHang
	foreign key (MaLoaiHang) references LoaiHang (MaLoaiHang) on update cascade
)
go

create table MENU
(
	MaMon VARCHAR(10) not null PRIMARY KEY,
	TenMon nvarchar(100) not NULL,
	Sizemon char(10),
	GiaBan money,
	GhichuMon nvarchar (1000),
)
go

create table HOADONCHITIET
(
	MaHDCT int identity(1,1) primary key,
	MaHD varchar(10),
	MaMon varchar(10),
	Soluong int,
	Thanhtien money,
	GHiChu NVARCHAR(100),
	constraint fk_ChiTiet_of_Menu
	foreign key (MaMon) references Menu (MaMon) on update cascade,
	constraint fk_ChiTiet_of_HoaDon
	foreign key (MaHD) references HoaDon (MaHD) on DELETE cascade ON UPDATE cascade
)
go

create table KHOHANG
(
	MaHang varchar(10) primary key,
	SoLuongHang int not null,
	GiaNhap money not null,
	GiaBan money not null,
	TinhTrang nvarchar(100),
	constraint fk_KhoHang_of_HangHoa
	foreign key (MaHang) references HangHoa (MaHang) on update cascade on delete cascade
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

Create table PHIEUNHAP
(
	MaPhieuNhap varchar(10) primary key,
	MaNV varchar(10),
	MaNhaCC INT,
	NgayNhap date,
	TongTien money,
	GhiChu nvarchar(255)
	constraint fk_PhieuNhap_by_NhanVien
	foreign key (MaNV) references NhanVien (MaNV) on update cascade,
	constraint fk_NhapHang_by_NhaCungCap
	foreign key (MaNhaCC) references NhaCungCap (MaNhaCC) on update cascade
)
go

Create table PHIEUNHAPCHITIET
(
	MaPNCT int identity(1,1) primary key,
	MaPhieuNhap varchar(10),
	MaHang varchar(10),
	SoLuongNhap int,
	GiaNhap money,
	ThanhTien money,
	constraint fk_ChiTiet_of_PhieuNhap
	foreign key (MaPhieuNhap) references PhieuNhap (MaPhieuNhap) on update cascade ,
	constraint fk_PhieuNhap_of_HangHoa
	foreign key (MaHang) references HangHoa (MaHang) on update cascade
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
select * from KHACHHANG

where MaKH = 17

insert into HOADON values ('HD1','NV1',4,'11-11-2022',20000,''),
						('HD2','NV3',1,'10-11-2022',30000,''),
						('HD3','NV4',3,'1-11-2022',50000,''),
						('HD4','NV2',5,'9-11-2022',20000,''),
						('HD5','NV5',2,'5-11-2022',25000,'')
go
select * from HOADON

insert into LOAIHANG values (N'Coffee Chồn Kopi Luwak'),
							(N'Coffee Typica Ethiopia'),
							(N'Coffee Trung Nguyên'),
							(N'Coffee Sữa'),
							(N'Bạc Xĩu')
go
select * from LOAIHANG

insert into HANGHOA values ('H1',N'Coffee Trung Nguyên',3,N'Trung Nguyên',100,'11-11-2022','cafe.jpg'),
						('H2',N'Coffee Sữa',4,N'Art Coffee',50,'6-11-2022','cafe.jpg'),
						('H3',N'Coffee Chồn Kopi Luwak',1,N'Bajaland Coffee',70,'2-11-2022','cafe.jpg'),
						('H4',N'Coffee Typica Ethiopia',2,N'The Dream Of Coffee',80,'11-11-2022','cafe.jpg'),
						('H5',N'Bạc Xĩu',5,N'Milano Coffee',90,'1-11-2022','cafe.jpg')
go
select * from HANGHOA

insert into MENU values ('#1',N'Coffee Chồn Kopi Luwak','M',25000,''),
						('#2',N'Coffee Typica Ethiopia','S',20000,''),
						('#3',N'Coffee Trung Nguyên','S',25000,''),
						('#4',N'Coffee Sữa','L',18000,''),
						('#5',N'Bạc Xĩu','M',18000,'')
go
select * from MENU

insert into HOADONCHITIET values ('HD1','#1',2,50000,''),
								('HD2','#2',3,60000,''),
								('HD3','#3',1,25000,''),
								('HD4','#4',4,72000,''),
								('HD5','#5',2,36000,'')
go
select * from HOADONCHITIET

insert into KHOHANG values ('H1',50,15000,20000,N'Còn Hàng'),
							('H2',100,15000,20000,N'Còn Hàng'),
							('H3',10,40000,50000,N'Hết Hàng'),
							('H4',90,15000,20000,N'Còn Hàng'),
							('H5',10,15000,20000,N'Hết Hàng')
go

select * from KHOHANG

insert into NHACUNGCAP values (N'Trung Nguyên','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Tạ Hồ Phi Phụng',''),
							(N'The Dream Of Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Tống Phạm Hoàng Huy',''),
							(N'Bajaland Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Lê Nhật Tân',''),
							(N'Art Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Nguyễn Văn Thuận',''),
							(N'Milano Coffee','0159633348201',N'46 đường 18, quận Bình Tân, HCM',N'Trần Văn Minh','')
go
select * from NHACUNGCAP

insert into PHIEUNHAP values ('p1','NV1',1,'10-11-2022',10000,''),
							('p2','NV2',2,'09-11-2022',18000,''),
							('p3','NV3',3,'12-10-2022',20000,''),
							('p4','NV4',4,'08-10-2022',25000,''),
							('p5','NV5',5,'10-10-2022',15000,'')
go
select * from PHIEUNHAP

insert into PHIEUNHAPCHITIET values ('p1','H1',150,15000,2250000),
									('p2','H2',100,15000,1500000),
									('p3','H3',200,40000,8000000),
									('p4','H4',150,15000,2250000),
									('p5','H5',80,15000,1200000)
go
select * from PHIEUNHAPCHITIET