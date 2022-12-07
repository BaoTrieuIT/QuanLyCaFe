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

public class HoaDonDAO extends QuanLiCFDAO<HoaDon, Integer> {

    String Insert_SQL = "insert into HOADON ( MaNV,MaKH,NgayLapHD,TongTienHD,GhiChu) values (?,?,?,?,?)";
    String InsertKhachVangLai_SQL = "insert into HOADON ( MaNV,NgayLapHD,TongTienHD,GhiChu) values (?,?,?,?)";

    String Update_SQL = "update HOADON set MaNV = ?, MaKH = ?, NgayLapHD = ?, TongTienHD = ?, GhiChu = ? where MaHD = ? ";
    String Delete_SQL = "delete from HOADON where MaHD = ?";
    String SelectAll_SQL = "select * from HOADON";
    String SelectByID_SQL = "select * from HOADON where MaHD = ?";
    String ResetHoaDon = "DBCC CHECKIDENT ('HoaDOn', RESEED, 0)";
    
    
    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.update(Insert_SQL,
                entity.getMaNV(),
                entity.getMaKH(),
                entity.getNgayLapHD(),
                entity.getTongTienHD(),
                entity.getGhiChu());
    }

    public void insertKhachVangLai(HoaDon entity) {
        JdbcHelper.update(InsertKhachVangLai_SQL,
                entity.getMaNV(),
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

    public void delete(Integer key) {
        JdbcHelper.update(Delete_SQL, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySQL(SelectAll_SQL);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getInt("MaHD"));
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
        }
    }

    public List<HoaDon> selectByKeytWord(String keyword) {
        String sql = "Select * from HoaDon where MaNV like '%" + keyword + "%'  ";
        return this.selectBySQL(sql);
    }

    public int demHoaDon() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon";
        ResultSet rs = JdbcHelper.query(sql);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }

    @Override
    public HoaDon selectById(Integer key) {
        List<HoaDon> list = selectBySQL(SelectByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Integer> selectYears() {
        String sql = "Select DISTINCT year(NgayLapHD) Year from HoaDon order by year desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> selectDay() {
        String sql = "Select DISTINCT day(NgayLapHD) day from HoaDon order by day desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> selectMonth() {
        String sql = "Select DISTINCT month(NgayLapHD) month from HoaDon order by month desc";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ResetHoaDon() throws SQLException{
        JdbcHelper.query(ResetHoaDon);
    }
}
