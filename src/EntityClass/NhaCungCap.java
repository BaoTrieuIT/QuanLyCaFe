
package EntityClass;


/*
* Author : Triệu Phan Thiên Bảo - PS22325
*/
import java.sql.*;
import java.util.Date;


public class NhaCungCap {
    private int MaNhaCC;
    private String TenNhaCC;
    private String SDT;
    private String DiaChi;
    private String NguoiLienHe;
    private String GhiChu;

    @Override
    public String toString() {
        return this.TenNhaCC;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    
    
    public int getMaNhaCC() {
        return MaNhaCC;
    }

    public void setMaNhaCC(int MaNhaCC) {
        this.MaNhaCC = MaNhaCC;
    }

    public String getTenNhaCC() {
        return TenNhaCC;
    }

    public void setTenNhaCC(String TenNhaCC) {
        this.TenNhaCC = TenNhaCC;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNguoiLienHe() {
        return NguoiLienHe;
    }

    public void setNguoiLienHe(String NguoiLienHe) {
        this.NguoiLienHe = NguoiLienHe;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
