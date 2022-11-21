
package DAO;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
*/
import EntityClass.HoaDon;
import java.sql.*;
import java.util.Date;
import java.util.List;


public class HoaDonDAO extends QuanLiCFDAO<HoaDon, String>  {

    
    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public HoaDon selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
