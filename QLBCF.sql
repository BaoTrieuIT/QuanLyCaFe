use master
go

drop database DuAn1_QuanLyCafe

create database DuAn1_QuanLyCafe
go

use DuAn1_QuanLyCafe
go


create table NHANVIEN
(
	MaNV varchar(5) primary key,
	HoTen nvarchar(50),
	MatKhauNV nvarchar(100),
	GioiTinh bit,
	DiaChi nvarchar(50),
	SoDT varchar(15),
	CCCD varchar(15),
	NgaySinhNV date,
	Vaitro bit,
	Hinh nvarchar(50)
)
go

create table KHACHHANG
(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(100),
	Gioitinh bit,
	DiaChi nvarchar(255),
	NgaySinh date,
	Email varchar(15),
	SoDT varchar(10),
)

create table HOADON
(
	MaHD varchar(5) primary key,
	MaNV varchar(5),
	MaKH int,
	NgaylapHD datetime default getdate(),
	TongTienHD money,
	GhiChu nvarchar(255),
	constraint fk_HoaDon_of_NhanVien
	foreign key (MaNV) references NhanVien (MaNV) on update cascade,
	constraint fk_HoaDon_of_KhachHang
	foreign key (MaKH) references KhachHang (MaKH) on update cascade
)

Create table LOAIHANG
(
	MaLoaiHang int identity(1,1) primary key,
	TenLoaiHang nvarchar(50) not null,
)

create table HANGHOA
(
	MaHang varchar(10) not null primary key ,
	TenHang nvarchar(50) not null,
	MaLoaiHang int not null,
	NhaSX nvarchar(50),
	SoLuong varchar(15),
	NgayNhap date,
	Hinh nvarchar(200),
	constraint fk_HangHoa_of_LoaiHang
	foreign key (MaLoaiHang) references LoaiHang (MaLoaiHang) on update cascade
)

create table MENU
(
	MaMon VARCHAR(5) not null PRIMARY KEY,
	TenMon nvarchar(50) not NULL,
	Sizemon char(5),
	GiaBan money,
	GhichuMon nvarchar (1000),
)

create table HOADONCHITIET
(
	MaHDCT int identity(1,1) primary key,
	MaHD varchar(5),
	MaMon varchar(5),
	Soluong int,
	Thanhtien money,
	GHiChu NVARCHAR(50),
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
	TinhTrang nvarchar(25),
	constraint fk_KhoHang_of_HangHoa
	foreign key (MaHang) references HangHoa (MaHang) on update cascade on delete cascade
)


create table NHACUNGCAP
(
	MaNhaCC int IDENTITY(1,1) primary key,
	TenNhaCC nvarchar(100),
	SDT varchar(10),
	DiaChi nvarchar(200),
	NguoiLienHe nvarchar(55),
	GhiChu nvarchar(55),
)

Create table PHIEUNHAP
(
	MaPhieuNhap varchar(5) primary key,
	MaNV varchar(5),
	MaNhaCC INT,
	NgayNhap datetime,
	TongTien money,
	GhiChu nvarchar(255)
	constraint fk_PhieuNhap_by_NhanVien
	foreign key (MaNV) references NhanVien (MaNV) on update cascade,
	constraint fk_NhapHang_by_NhaCungCap
	foreign key (MaNhaCC) references NhaCungCap (MaNhaCC) on update cascade
)

Create table PHIEUNHAPCHITIET
(
	MaPNCT int identity(1,1) primary key,
	MaPhieuNhap varchar(5),
	MaHang varchar(10),
	SoLuongNhap int,
	GiaNhap money,
	ThanhTien money,
	constraint fk_ChiTiet_of_PhieuNhap
	foreign key (MaPhieuNhap) references PhieuNhap (MaPhieuNhap) on update cascade ,
	constraint fk_PhieuNhap_of_HangHoa
	foreign key (MaHang) references HangHoa (MaHang) on update cascade
)

