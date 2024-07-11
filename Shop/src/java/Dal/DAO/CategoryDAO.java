/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal.DAO;

import Dal.DBContext;
import Model.PhanLoai;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CategoryDAO extends DBContext{
    public ArrayList<PhanLoai> getAllCategory(){
        ArrayList<PhanLoai> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PhanLoai";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                PhanLoai c = new PhanLoai();
                c.setIdPhanLoai(rs.getString("idPhanLoai"));
                c.setThuongHieu(rs.getString("ThuongHieu"));
                list.add(c);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return list;
    }
}
