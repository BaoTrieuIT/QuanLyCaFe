package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.KhachHang;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class KhachHangDAO extends QuanLiCFDAO<KhachHang, Integer> {

    String Insert_SQL = "insert into KhachHang (MaKH, TenKH, GioiTinh, DiaChi, NgaySinh, Email, SoDT)  values (?,?,?,?,?,?,?)";
    String Update_SQL = "update KhachHang set TenKH = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, Email = ?, SoDT = ? where MaKH = ? ";
    String Delete_SQL = "delete from KhachHang where MaKH = ?";
    String SelectAll_SQL = "select * from KhachHang";
    String SelectByID_SQL = "select * from KhachHang where MaKH=?";

    @Override
    public void insert(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<KhachHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public KhachHang selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<KhachHang> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
