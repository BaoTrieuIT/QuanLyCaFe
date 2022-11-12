package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.NhanVien;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVienDAO extends QuanLiCFDAO<NhanVien, String> {

     String Insert_SQL = "insert into NhanVien (MaNV,HoTen,MatKhauNV,GioiTinh,DiaChi,SoDT,CCCD, NgaySinhNV Vaitro,Hinh) values (?,?,?,?,?,?,?,?,?,?)";
     String Update_SQL = "update NhanVien set HoTen=?,MatKhauNV=?,GioiTinh=?,DiaChi=? , SoDT=?, CCCD = ?, NgaySinhNV = ? ,Vaitro=?,Hinh=? where MaNV = ? ";
     String Delete_SQL = "delete from NhanVien where MaNV = ?";
     String SelectAll_SQL = "select * from NhanVien";
     String SelectByID_SQL = "select * from NhanVien where MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(Insert_SQL,
                entity.getMaNV(),
                entity.getTenNV(),
                entity.getMatKhau(),
                entity.getGioiTinh(),
                entity.getDiaChi(),
                entity.getSDT(),
                entity.getCCCD(),
                entity.getNgaySinhNV(),
                entity.getVaiTro(),
                entity.getHinh());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(Update_SQL,
                entity.getTenNV(),
                entity.getMatKhau(),
                entity.getGioiTinh(),
                entity.getDiaChi(),
                entity.getSDT(),
                entity.getCCCD(),
                entity.getNgaySinhNV(),
                entity.getVaiTro(),
                entity.getHinh(),
                entity.getMaNV()
        );
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("HoTen"));
                entity.setMatKhau(rs.getString("MatKhauNV"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setSDT(rs.getString("SoDT"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setNgaySinhNV(rs.getDate("NgaySinhNV"));
                entity.setVaiTro(rs.getBoolean("Vaitro"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
    }

}
