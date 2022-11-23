package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.HoaDon;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonDAO extends QuanLiCFDAO<HoaDon, String> {

    String Insert_SQL = "insert into HOADON (MaHD,MaNV,MaKH,NgayLapHD,TongTienHD,GhiChu) values (?,?,?,?,?,?)";
    String Update_SQL = "update HOADON set MaNV = ?, MaKH = ?, NgayLapHD = ?, TongTienHD = ?, GhiChu = ? where MaHD = ? ";
    String Delete_SQL = "delete from HOADON where MaHD = ?";
    String SelectAll_SQL = "select * from HOADON";
    String SelectByID_SQL = "select * from HOADON where MaHD = ?";

    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(Insert_SQL,
                entity.getMaHD(),
                entity.getMaNV(),
                entity.getMaKH(),
                entity.getNgayLapHD(),
                entity.getTongTienHD(),
                entity.getGhiChu());
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.update(Update_SQL,
                entity.getMaNV(),
                entity.getMaKH(),
                entity.getNgayLapHD(),
                entity.getTongTienHD(),
                entity.getGhiChu(),
                entity.getMaHD());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }

    @Override
    public HoaDon selectById(String key) {
        List<HoaDon> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setNgayLapHD(rs.getDate("NgayLapHD"));
                entity.setTongTienHD(rs.getDouble("TongTienHD"));
                entity.setGhiChu(rs.getString("GhiChu"));
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
