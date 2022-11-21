package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.DoUong;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class DoUongDAO extends QuanLiCFDAO<DoUong, String> {

    String Insert_SQL = "insert into DoUong (MaMon, MaNhaCC, TenMon, SizeMon, GiaBan, GiaNhap, SoLuong, NgayNhap, NgayHetHan, Hinh, GhiChuMon)  values (?,?,?,?,?,?,?,?,?,?,?)";
    String Update_SQL = "update DoUong set MaNhaCC = ?, TenMon = ?, SizeMon = ?, GiaBan = ?, GiaNhap = ?, SoLuong = ?, NgayNhap = ?, NgayHetHan = ?, Hinh = ?, GhiChuMon = ? where MaMon = ? ";
    String Delete_SQL = "delete from DoUong where MaMon = ?";
    String SelectAll_SQL = "select * from DoUong";
    String SelectByID_SQL = "select * from DoUong where MaMon=?";

    @Override
    public void insert(DoUong e) {
        JdbcHelper.update(Insert_SQL, 
                e.getMaMon(),
                e.getMaNhaCC(),
                e.getTenMon(),
                e.getSizeMon(),
                e.getGiaBan());
    }

    @Override
    public void update(DoUong entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DoUong> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DoUong selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<DoUong> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
