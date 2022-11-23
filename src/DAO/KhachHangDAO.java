package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.KhachHang;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHangDAO extends QuanLiCFDAO<KhachHang, Integer> {

    String Insert_SQL = "insert into KhachHang (MaKH, TenKH, GioiTinh, DiaChi, NgaySinh, Email, SoDT)  values (?,?,?,?,?,?,?)";
    String Update_SQL = "update KhachHang set TenKH = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, Email = ?, SoDT = ? where MaKH = ? ";
    String Delete_SQL = "delete from KhachHang where MaKH = ?";
    String SelectAll_SQL = "select * from KhachHang";
    String SelectByID_SQL = "select * from KhachHang where MaKH=?";

    @Override
    public void insert(KhachHang e) {
        JdbcHelper.update(Insert_SQL,
                e.getMaKH(),
                e.getTenKH(),
                e.getGioiTinh(),
                e.getDiaChi(),
                e.getNgaySinh(),
                e.getEmail(),
                e.getSDT()
        );
    }

    @Override
    public void update(KhachHang e) {
        JdbcHelper.update(Update_SQL,
                e.getTenKH(),
                e.getGioiTinh(),
                e.getDiaChi(),
                e.getNgaySinh(),
                e.getEmail(),
                e.getSDT(),
                e.getMaKH()
        );
    }

    @Override
    public void delete(Integer key) {
       JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<KhachHang> selectAll() {
          return selectBySQL(SelectAll_SQL);
    }

    @Override
    public KhachHang selectById(Integer key) {
       List<KhachHang> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySQL(String sql, Object... args) {
       List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang e = new KhachHang();
               e.setMaKH(rs.getInt("MaKH"));
               e.setTenKH(rs.getString("TenKH"));
               e.setGioiTinh(rs.getBoolean("GioiTinh"));
               e.setDiaChi(rs.getString("DiaChi"));
               e.setNgaySinh(rs.getDate("NgaySinh"));
               e.setEmail(rs.getString("Email"));
               e.setSDT(rs.getString("SDT"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
