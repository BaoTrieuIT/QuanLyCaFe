package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.DoUong;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
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
                e.getGiaBan(),
                e.getGiaNhap(),
                e.getSoLuong(),
                e.getNgayNhap(),
                e.getNgayHetHan(),
                e.getHinh(),
                e.getGhiChuMon()
        );
    }

    @Override
    public void update(DoUong e) {
        JdbcHelper.update(Update_SQL,
                e.getMaNhaCC(),
                e.getTenMon(),
                e.getSizeMon(),
                e.getGiaBan(),
                e.getGiaNhap(),
                e.getSoLuong(),
                e.getNgayNhap(),
                e.getNgayHetHan(),
                e.getHinh(),
                e.getGhiChuMon(),
                e.getMaMon()
        );
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<DoUong> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }

    @Override
    public DoUong selectById(String key) {
        List<DoUong> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DoUong> selectBySQL(String sql, Object... args) {
        List<DoUong> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DoUong e = new DoUong();
                e.setMaMon(rs.getString("MaMon"));
                e.setMaNhaCC(rs.getInt("MaNhaCC"));
//                e.setTenNhaCC(rs.getString("TenNhaCC"));
                e.setTenMon(rs.getString("TenMon"));
                e.setSizeMon(rs.getString("Sizemon"));
                e.setGiaBan(rs.getDouble("GiaBan"));
                e.setGiaNhap(rs.getDouble("GiaNhap"));
                e.setSoLuong(rs.getInt("SoLuong"));
                e.setNgayNhap(rs.getDate("NgayNhap"));
                e.setNgayHetHan(rs.getDate("NgayHetHan"));
                e.setHinh(rs.getString("Hinh"));
                e.setGhiChuMon(rs.getString("GhiChuMon"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    protected List<DoUong> selectBySQLInnerJoin(String sql, Object... args) {
        List<DoUong> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DoUong e = new DoUong();
                e.setMaMon(rs.getString("MaMon"));
                e.setMaNhaCC(rs.getInt("MaNhaCC"));
                e.setTenNhaCC(rs.getString("TenNhaCC"));
                e.setTenMon(rs.getString("TenMon"));
                e.setSizeMon(rs.getString("Sizemon"));
                e.setGiaBan(rs.getDouble("GiaBan"));
                e.setGiaNhap(rs.getDouble("GiaNhap"));
                e.setSoLuong(rs.getInt("SoLuong"));
                e.setNgayNhap(rs.getDate("NgayNhap"));
                e.setNgayHetHan(rs.getDate("NgayHetHan"));
                e.setHinh(rs.getString("Hinh"));
                e.setGhiChuMon(rs.getString("GhiChuMon"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    

    public List<DoUong> selectByKeytWord(String keyword) {
        String sql = "Select * from DoUong where TenMon like ?";
        return this.selectBySQL(sql, "%" + keyword + "%");
    }

    public List<DoUong> selectByKeytWordInnerJoin(String keyword) {
        String sql = "select * from DoUong du inner join NhaCungCap ncc on du.MaNhaCC = ncc.MaNhaCC where ncc.TenNhaCC like ?";
        return this.selectBySQLInnerJoin(sql, "%" + keyword + "%");
    }

}
