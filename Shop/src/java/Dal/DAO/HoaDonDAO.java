/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal.DAO;

import DTO.HoaDonDTO;
import Dal.DBContext;
import Model.HoaDon;
import Model.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO extends DBContext {

    public ArrayList<HoaDonDTO> getTop3HotProduct() {
        ArrayList<HoaDonDTO> list = new ArrayList<>();
        try {

            String sql = "SELECT TOP 3\n"
                    + "    idSanPham,\n"
                    + "    SUM(ThanhTien) AS TongThanhTien\n"
                    + "FROM HoaDon\n"
                    + "GROUP BY idSanPham\n"
                    + "ORDER BY TongThanhTien DESC";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                HoaDonDTO o = new HoaDonDTO();
                o.setIdSanPham(rs.getString("idSanPham"));
                ProductDAO dao = new ProductDAO();
                o.setSanPham(dao.getProductById(o.getIdSanPham().trim()));
                list.add(o);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalHoaDon() {
        try {
            String sql = "select Count(*) as total from HoaDon";
            ResultSet rs = rs(sql);
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return 0;
    }

    public HoaDon getHoaDonByDonHang(String did) {
        try {
            String sql = "SELECT [idHoaDon]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idSanPham]\n"
                    + "      ,[TenSanPham]\n"
                    + "      ,[SoLuong]\n"
                    + "      ,[GiaTien]\n"
                    + "      ,[ThanhTien]\n"
                    + "      ,[isPay]\n"
                    + "  FROM [HoaDon] where idDonHang = ? AND [isPay] = 0";
            PreparedStatement ps = ps(sql);
            ps.setString(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                d.setIdHoaDon(rs.getString("idHoaDon"));
                d.setTenSanPham(rs.getString("TenSanPham"));
                d.setSoLuong(rs.getInt("SoLuong"));
                d.setGiaTien(rs.getInt("GiaTien"));
                d.setThanhTien(rs.getInt("ThanhTien"));
                d.setIsPay(false);
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addHoaDon(HoaDon hd) {
        try {
            String sql = "INSERT INTO [HoaDon]\n"
                    + "           ([idHoaDon]\n"
                    + "           ,[idDonHang]\n"
                    + "           ,[idSanPham]\n"
                    + "           ,[TenSanPham]\n"
                    + "           ,[SoLuong]\n"
                    + "           ,[GiaTien]\n"
                    + "           ,[ThanhTien]\n"
                    + "           ,[isPay])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,0)";
            PreparedStatement ps = ps(sql);
            ps.setString(1, hd.getIdHoaDon().trim());
            ps.setString(2, hd.getIdDonHang().trim());
            ps.setString(3, hd.getIdSanPham().trim());
            ps.setString(4, hd.getTenSanPham().trim());
            ps.setInt(5, hd.getSoLuong());
            ps.setInt(6, hd.getGiaTien());
            ps.setInt(7, hd.getThanhTien());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void updatePayStatus(String id) {
        try {
            String sql = "UPDATE [HoaDon]\n"
                    + "   SET [isPay] = 1\n"
                    + " WHERE [idHoaDon] = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, id.trim());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public HoaDon getHoaDons(String did) {
        try {
            String sql = "SELECT [idHoaDon]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idSanPham]\n"
                    + "      ,[TenSanPham]\n"
                    + "      ,[SoLuong]\n"
                    + "      ,[GiaTien]\n"
                    + "      ,[ThanhTien]\n"
                    + "      ,[isPay]\n"
                    + "  FROM [HoaDon] where idDonHang = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                d.setIdHoaDon(rs.getString("idHoaDon"));
                d.setTenSanPham(rs.getString("TenSanPham"));
                d.setSoLuong(rs.getInt("SoLuong"));
                d.setGiaTien(rs.getInt("GiaTien"));
                d.setThanhTien(rs.getInt("ThanhTien"));
                d.setIsPay(rs.getBoolean("isPay"));
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HoaDon getLast() {
        try {
            String sql = "SELECT * \n"
                    + "FROM HoaDon \n"
                    + "ORDER BY id DESC \n"
                    + "LIMIT 1";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                d.setIdHoaDon(rs.getString("idHoaDon"));
                d.setTenSanPham(rs.getString("TenSanPham"));
                d.setSoLuong(rs.getInt("SoLuong"));
                d.setGiaTien(rs.getInt("GiaTien"));
                d.setThanhTien(rs.getInt("ThanhTien"));
                d.setIsPay(rs.getBoolean("isPay"));
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> listAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            String sql = "Select * From HoaDon";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                HoaDon d = new HoaDon();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                d.setIdHoaDon(rs.getString("idHoaDon"));
                d.setTenSanPham(rs.getString("TenSanPham"));
                d.setSoLuong(rs.getInt("SoLuong"));
                d.setGiaTien(rs.getInt("GiaTien"));
                d.setThanhTien(rs.getInt("ThanhTien"));
                d.setIsPay(rs.getBoolean("isPay"));
                list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
