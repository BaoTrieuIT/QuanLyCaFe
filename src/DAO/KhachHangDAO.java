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

    String Insert_SQL = "insert into KhachHang (TenKH, GioiTinh, DiaChi, NgaySinh, Email, SoDT)  values (?,?,?,?,?,?)";
    String Update_SQL = "update KhachHang set TenKH = ?, GioiTinh = ?, DiaChi = ?, NgaySinh = ?, Email = ?, SoDT = ? where MaKH = ? ";
    String Delete_SQL = "delete from KhachHang where MaKH = ?";
    String SelectAll_SQL = "select * from KhachHang";
    String SelectByID_SQL = "select * from KhachHang where MaKH=?";

    @Override
    public void insert(KhachHang e) {
        JdbcHelper.update(Insert_SQL,
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
                e.setSDT(rs.getString("SoDT"));
                list.add(e);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang> selectByKeytWord(String keyword) {
        String sql = "Select * from KhachHang where TenKH like N'%" + keyword + "%'  "
                + "OR SoDT like N'%" + keyword + "%' "
                + "Or Email like N'%" + keyword + "%' ";
        return this.selectBySQL(sql);
    }

    public boolean kiemEmail(String Email) {
        String ChuoiDaXuLy = Email.substring(0, Email.indexOf("@"));
        String sql = "SELECT * FROM KhachHang WHERE Email LIKE ?";
        List<KhachHang> list = selectBySQL(sql, ChuoiDaXuLy + "%");
        if (list.size() < 1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean kiemSDT(String SDT){
        String sql = "SELECT * FROM KhachHang WHERE SoDT = ?";
        List<KhachHang> list = selectBySQL(sql, SDT);
        return list.size() < 1;
    }
}
