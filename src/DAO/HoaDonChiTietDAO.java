
package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
*/
import EntityClass.HoaDonChiTiet;
import java.sql.*;
import java.util.Date;
import java.util.List;


public class HoaDonChiTietDAO extends QuanLiCFDAO<HoaDonChiTiet, Integer>{

    @Override
    public void insert(HoaDonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HoaDonChiTiet selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<HoaDonChiTiet> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
