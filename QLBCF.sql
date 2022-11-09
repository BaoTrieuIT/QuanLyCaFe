use master
go
	
drop database DON

create database DON
go

use DON
go


create table NHANVIEN(
	MaNV varchar(5) primary key,
	HoTen nvarchar(50),
	SoDT varchar(15),
	GioiTinh bit,
	CCCD varchar(15),
	DiaChi nvarchar(50),
	NgaySinhNV date,
	MatKhauNV nvarchar(10),
	Vaitro varchar(50),
	hinh nvarchar(50)
)
go


create table HoaDonChiTiet(
	MaHDCT varchar(5) primary key,
	MaHD varchar(5),
	TenMon varchar(5),
	Soluong int,
	Size varchar(2),
	Thanhtien money
)
go

create table HOADON(
	MaHD varchar(5) primary key,
	MaNV varchar(5),
	MaKH varchar(5),
	NgaylapHD date,
	TongTienHD money,
	Chietkhau money
)
go


create table MENU(
	TenMon varchar(5)primary key,
	Sizemon varchar(2),
	Giaban	money,
	GhichuMon nvarchar (1000),
)
go

Create table Phieunhap(
	MaPhieuNhap varchar(5) primary key,
	MaNV varchar(5),
	MaNhaCC varchar(5),
	NgayNhap date,
	TongTien money
)
go 

Create table PhieuNhapChitiet(
	MaPNCT varchar(8) primary key,
	MaPhieuNhap varchar(5),
	MaHang varchar(6),
	SoLuongNhap int,
	GiaNhap money,
	ThanhTien money,
)
go


create table HANGHOA(
	MaHang varchar(6) primary key ,
	TenHang nvarchar(15),
	MaLoaiHang varchar(6),
	SoLuong varchar(15),
	NgayNhap varchar(15),
	hinh nvarchar(50),
	MaMatHang varchar(25),
	NhaSX varchar(50)
)
go
 


create table Khohang(
	MaHang varchar(6) primary key,
	SoLuongHang int,
	GiaNhap money,
	TinhTrang nvarchar(25)
)
go

Create table LoaiHang(
	MaLoaiHang varchar(6) primary key,
	TenLoaiHang nvarchar(50)
)
go

create table KHACHHANG(
	MaKH varchar(5) primary key,
	TenKH nvarchar(50),
	NS date,
	SoDT varchar(10),
	Email varchar(15),
	Gioitinh varchar(5)
)
go

create table NhapCungCap(
	MaNhaCC varchar(5) primary key,
	TenNhaCC nvarchar(100),
	DiaChiNhaCC nvarchar(200),
	SdtNhaCC varchar(10),
	NguoiLienHe nvarchar(55),
	GhiChu nvarchar(55),
)
go

alter table HOADON
Add CONSTRAINT FK_NV_HD FOREIGN KEY (MaNV)REFERENCES NHANVIEN(MaNV);

alter table HOADON
Add CONSTRAINT FK_HD_KH FOREIGN KEY (MaKH)REFERENCES KHACHHANG(MaKH);
----
alter table Phieunhap
Add CONSTRAINT FK_NCC_PN FOREIGN KEY (MaNhaCC)REFERENCES NhapCungCap(MaNhaCC);

alter table Phieunhap
Add CONSTRAINT FK_NV_PN FOREIGN KEY (MANV)REFERENCES NHANVIEN(MANV);

alter table PhieuNhapChiTiet
Add CONSTRAINT FK_PNCT_PN FOREIGN KEY (MaPhieuNhap)REFERENCES Phieunhap(MaPhieuNhap);

alter table PhieuNhapChiTiet
Add CONSTRAINT FK_PNCT_HH FOREIGN KEY (MaHang)REFERENCES HANGHOA(MaHang);

alter table HANGHOA
add constraint Fk_HH_LH foreign key (MaLoaiHang) references LoaiHang(MaLoaiHang);

alter table HoaDonChiTiet
Add CONSTRAINT FK_HD_HDCT FOREIGN KEY (MaHD)REFERENCES HOADON(MaHD);

alter table HoaDonChiTiet
Add CONSTRAINT FK_MN_HDCT FOREIGN KEY (TenMon)REFERENCES MENU(TenMon);

alter table KhoHang
add constraint fk_kh_HH foreign key (MaHang) references HangHoa(MaHang);