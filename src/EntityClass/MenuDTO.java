/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

/**
 *
 * @author Admin
 */
public class MenuDTO  {
    private Menu mn;
    private int soLuong;

    public MenuDTO() {
    }

    public MenuDTO(Menu mn, int soLuong) {
        this.mn = mn;
        this.soLuong = soLuong;
    }

    
    public Menu getMn() {
        return mn;
    }

    public void setMn(Menu mn) {
        this.mn = mn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
