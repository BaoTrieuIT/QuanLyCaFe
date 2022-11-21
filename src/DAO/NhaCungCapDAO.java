package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.NhaCungCap;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class NhaCungCapDAO extends QuanLiCFDAO<NhaCungCap, Integer> {

    String Insert_SQL = "insert into NhaCungCap (MaNhaCC, TenNhaCC, SDT, DiaChi, NguoiLienHe, GhiChu)  values (?,?,?,?,?,?)";
    String Update_SQL = "update NhaCungCap set  TenNhaCC, SDT, DiaChi, NguoiLienHe, GhiChu where MaNhaCC = ? ";
    String Delete_SQL = "delete from NhaCungCap where MaNhaCC = ?";
    String SelectAll_SQL = "select * from NhaCungCap";
    String SelectByID_SQL = "select * from NhaCungCap where MaNhaCC=?";

    @Override
    public void insert(NhaCungCap entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(NhaCungCap entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<NhaCungCap> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NhaCungCap selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<NhaCungCap> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
