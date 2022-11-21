package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.NhaCungCap;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhaCungCapDAO extends QuanLiCFDAO<NhaCungCap, Integer> {
    
    String Insert_SQL = "insert into NhaCungCap (MaNhaCC, TenNhaCC, SDT, DiaChi, NguoiLienHe, GhiChu)  values (?,?,?,?,?,?)";
    String Update_SQL = "update NhaCungCap set  TenNhaCC, SDT, DiaChi, NguoiLienHe, GhiChu where MaNhaCC = ? ";
    String Delete_SQL = "delete from NhaCungCap where MaNhaCC = ?";
    String SelectAll_SQL = "select * from NhaCungCap";
    String SelectByID_SQL = "select * from NhaCungCap where MaNhaCC=?";
    
    @Override
    public void insert(NhaCungCap e) {
        JdbcHelper.update(Insert_SQL,
                e.getMaNhaCC(),
                e.getTenNhaCC(),
                e.getSDT(),
                e.getDiaChi(),
                e.getNguoiLienHe(),
                e.getGhiChu()
        );
    }
    
    @Override
    public void update(NhaCungCap e) {
        JdbcHelper.update(Update_SQL,
                e.getTenNhaCC(),
                e.getSDT(),
                e.getDiaChi(),
                e.getNguoiLienHe(),
                e.getGhiChu(),
                e.getMaNhaCC()
        );
    }
    
    @Override
    public void delete(Integer key) {
        JdbcHelper.update(Delete_SQL, key);
    }
    
    @Override
    public List<NhaCungCap> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }
    
    @Override
    public NhaCungCap selectById(Integer key) {
        List<NhaCungCap> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    protected List<NhaCungCap> selectBySQL(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaCungCap e = new NhaCungCap();
                e.setMaNhaCC(rs.getInt("MaNhaCC"));
                e.setTenNhaCC(rs.getString("TenNhaCC"));
                e.setSDT(rs.getString("SDT"));
                e.setNguoiLienHe(rs.getString("NguoiLienHe"));
                e.setGhiChu(rs.getString("GhiChu"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
