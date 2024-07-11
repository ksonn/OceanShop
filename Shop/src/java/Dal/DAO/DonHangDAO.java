/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal.DAO;

import DTO.DonHangDTO;
import Dal.DBContext;
import Model.DonHang;
import Model.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DonHangDAO extends DBContext {

    public ArrayList<DonHangDTO> getAllDonHang() {
        ArrayList<DonHangDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idUser]\n"
                    + "      ,[TenKH]\n"
                    + "      ,[SDT]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[NgayBan]\n"
                    + "      ,[TongThanhTien]\n"
                    + "  FROM [DonHang]";
            PreparedStatement ps = ps(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHangDTO d = new DonHangDTO();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                ProductDAO dao = new ProductDAO();
                d.setSanPham(dao.getProductById(d.getIdSanPham()));
                d.setIdUser(rs.getString("idUser"));
                d.setTenKH(rs.getString("TenKH"));
                d.setNgayBan(rs.getDate("NgayBan"));
                d.setSdt(rs.getInt("SDT"));
                d.setTongSoLuong(rs.getInt("TongSoLuong"));
                d.setTongThanhTien(rs.getInt("TongThanhTien"));
                list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addToCard(DonHang d) {
        try {
            String sql = "INSERT INTO [DonHang]\n"
                    + "           ([idSanPham]\n"
                    + "           ,[idDonHang]\n"
                    + "           ,[idUser]\n"
                    + "           ,[TenKH]\n"
                    + "           ,[SDT]\n"
                    + "           ,[TongSoLuong]\n"
                    + "           ,[NgayBan]\n"
                    + "           ,[TongThanhTien]"
                    + "           ,[isPay])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,convert(date,GETDATE())\n"
                    + "           ,?"
                    + "           ,?)";
            PreparedStatement ps = ps(sql);
            ps.setString(1, d.getIdSanPham());
            ps.setString(2, d.getIdDonHang());
            ps.setString(3, d.getIdUser());
            ps.setString(4, d.getTenKH());
            ps.setInt(5, d.getSdt());
            ps.setInt(6, d.getTongSoLuong());
            ps.setInt(7, d.getTongThanhTien());
            ps.setBoolean(8, false);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void updateToCard(DonHang d) {
        try {
            String sql = "UPDATE [DonHang]\n"
                    + "   SET [TongSoLuong] = ?\n"
                    + "      ,[NgayBan] = convert(date,GETDATE())\n"
                    + "      ,[TongThanhTien] = ?\n"
                    + " WHERE idDonHang = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(3, d.getIdDonHang());
            ps.setInt(1, d.getTongSoLuong());
            ps.setInt(2, d.getTongThanhTien());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public DonHang getDonHangByPidAndUid(String pid, String uid) {
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idUser]\n"
                    + "      ,[TenKH]\n"
                    + "      ,[SDT]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[NgayBan]\n"
                    + "      ,[TongThanhTien]\n"
                    + "      ,[isPay]"
                    + "  FROM [DonHang] where idSanPham = ? AND idUser = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, pid);
            ps.setString(2, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHang d = new DonHang();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                d.setIdUser(rs.getString("idUser"));
                d.setTenKH(rs.getString("TenKH"));
                d.setNgayBan(rs.getDate("NgayBan"));
                d.setSdt(rs.getInt("SDT"));
                d.setTongSoLuong(rs.getInt("TongSoLuong"));
                d.setTongThanhTien(rs.getInt("TongThanhTien"));
                d.setIsPay(rs.getBoolean("isPay"));
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<DonHangDTO> getDonHangByUid(String uid) {
        ArrayList<DonHangDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idUser]\n"
                    + "      ,[TenKH]\n"
                    + "      ,[SDT]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[NgayBan]\n"
                    + "      ,[TongThanhTien]\n"
                    + "  FROM [DonHang] where idUser = ? AND [isPay] = 0";
            PreparedStatement ps = ps(sql);
            ps.setString(1, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHangDTO d = new DonHangDTO();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                ProductDAO dao = new ProductDAO();
                d.setSanPham(dao.getProductById(d.getIdSanPham()));
                d.setIdUser(rs.getString("idUser"));
                d.setTenKH(rs.getString("TenKH"));
                d.setNgayBan(rs.getDate("NgayBan"));
                d.setSdt(rs.getInt("SDT"));
                d.setTongSoLuong(rs.getInt("TongSoLuong"));
                d.setTongThanhTien(rs.getInt("TongThanhTien"));
                list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updatePayStatus(String id) {
        try {
            String sql = "UPDATE [DonHang]\n"
                    + "   SET [isPay] = 1\n"
                    + " WHERE [idDonHang] = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public ArrayList<DonHangDTO> getAllDonHangByUid(String uid) {
        ArrayList<DonHangDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idUser]\n"
                    + "      ,[TenKH]\n"
                    + "      ,[SDT]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[NgayBan]\n"
                    + "      ,[TongThanhTien]\n"
                    + "  FROM [DonHang] where idUser = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHangDTO d = new DonHangDTO();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                ProductDAO dao = new ProductDAO();
                d.setSanPham(dao.getProductById(d.getIdSanPham()));
                d.setIdUser(rs.getString("idUser"));
                d.setTenKH(rs.getString("TenKH"));
                d.setNgayBan(rs.getDate("NgayBan"));
                d.setSdt(rs.getInt("SDT"));
                d.setTongSoLuong(rs.getInt("TongSoLuong"));
                d.setTongThanhTien(rs.getInt("TongThanhTien"));
                list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean deleteDonHangToCard(String id) {
        HoaDonDAO dao = new HoaDonDAO();
        HoaDon hd = dao.getHoaDonByDonHang(id);
        DonHangDTO dh = getDonHangByDHId(id);
        if (hd == null && dh != null) {
            try {
                String sql = "DELETE FROM [DonHang]\n"
                        + "      WHERE idDonHang = ?";
                PreparedStatement ps = ps(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (Exception ex) {
                Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }else if (hd != null && dh != null) {
            try {
                String sql = "DELETE FROM [HoaDon]\n"
                        + "      WHERE idHoaDon = ?";
                PreparedStatement ps = ps(sql);
                ps.setString(1, hd.getIdDonHang());
                ps.executeUpdate();
            } catch (Exception ex) {
                Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                String sql = "DELETE FROM [DonHang]\n"
                        + "      WHERE idDonHang = ?";
                PreparedStatement ps = ps(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (Exception ex) {
                Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            return true;
        }
        else{
            return false;
        }
    }
    
    public DonHangDTO getDonHangByDHId(String did) {
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[idDonHang]\n"
                    + "      ,[idUser]\n"
                    + "      ,[TenKH]\n"
                    + "      ,[SDT]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[NgayBan]\n"
                    + "      ,[TongThanhTien]\n"
                    + "  FROM [DonHang] where idDonHang = ? AND [isPay] = 0";
            PreparedStatement ps = ps(sql);
            ps.setString(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHangDTO d = new DonHangDTO();
                d.setIdDonHang(rs.getString("idDonHang"));
                d.setIdSanPham(rs.getString("idSanPham"));
                ProductDAO dao = new ProductDAO();
                d.setSanPham(dao.getProductById(d.getIdSanPham()));
                d.setIdUser(rs.getString("idUser"));
                d.setTenKH(rs.getString("TenKH"));
                d.setNgayBan(rs.getDate("NgayBan"));
                d.setSdt(rs.getInt("SDT"));
                d.setTongSoLuong(rs.getInt("TongSoLuong"));
                d.setTongThanhTien(rs.getInt("TongThanhTien"));
                return d;
            }
        } catch (Exception ex) {
            Logger.getLogger(DonHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
