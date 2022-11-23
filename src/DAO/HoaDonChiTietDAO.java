package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
 */
import EntityClass.HoaDonChiTiet;
import Utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonChiTietDAO extends QuanLiCFDAO<HoaDonChiTiet, Integer> {

    String Insert_SQL = "insert into HOADONCHITIET (MaHDCT, MaHD, MaMon, Soluong, ThanhTien, GhiChu) values (?,?,?,?,?,?)";
    String Update_SQL = "update HOADONCHITIET set MaHD = ?, MaMon = ?, Soluong = ?, ThanhTien = ?, GhiChu = ? where MaHDCT = ? ";
    String Delete_SQL = "delete from HOADONCHITIET where MaHDCT = ?";
    String SelectAll_SQL = "select * from HOADONCHITIET";
    String SelectByID_SQL = "select * from HOADONCHITIET where MaHDCT = ?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        JdbcHelper.update(Insert_SQL,
                entity.getMaHDCT(),
                entity.getMaHD(),
                entity.getMaMon(),
                entity.getSoLuong(),
                entity.getThanhTien(),
                entity.getGhiChu());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        JdbcHelper.update(Update_SQL,
                entity.getMaHD(),
                entity.getMaMon(),
                entity.getSoLuong(),
                entity.getThanhTien(),
                entity.getGhiChu(),
                entity.getMaHDCT());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }

    @Override
    public HoaDonChiTiet selectById(Integer key) {
        List<HoaDonChiTiet> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySQL(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getInt("MaHDCT"));
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaMon(rs.getString("MaMon"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setThanhTien(rs.getDouble("ThanhTien"));
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
