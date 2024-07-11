/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal.DAO;

import DTO.ProductDTO;
import Dal.DBContext;
import Model.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ProductDAO extends DBContext {

    public ArrayList<ProductDTO> getAllProductInSys() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[TenSanPham]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[GiaBanDau]\n"
                    + "      ,[GiaSanPham]\n"
                    + "      ,[AnhMinhHoa]\n"
                    + "      ,[AnhMoTa]\n"
                    + "      ,[MoTaSanPham]\n"
                    + "      ,sp.[ThuongHieu]\n"
                    + "      ,[MauSac]\n"
                    + "      ,sp.[idPhanLoai]\n"
                    + "	     ,c.ThuongHieu as [TenPhanLoai]\n"
                    + "  FROM [SanPham] sp join [PhanLoai] c on sp.idPhanLoai = c.idPhanLoai";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                ProductDTO s = new ProductDTO();
                s.setIdSanPham(rs.getString("idSanPham"));
                s.setTenSanPham(rs.getString("TenSanPham"));
                s.setTongSoLuong(rs.getInt("TongSoLuong"));
                s.setGiaBanDau(rs.getInt("GiaBanDau"));
                s.setGiaSanPham(rs.getInt("GiaSanPham"));
                s.setAnhMinhHoa(rs.getString("AnhMinhHoa"));
                s.setAnhMoTa(rs.getString("AnhMoTa"));
                s.setMoTaSanPham(rs.getString("MoTaSanPham"));
                s.setThuongHieu(rs.getString("ThuongHieu"));
                s.setMauSac(rs.getString("MauSac"));
                s.setIdPhanLoai(rs.getString("idPhanLoai"));
                s.setTenPhanLoai(rs.getString("TenPhanLoai"));
                list.add(s);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return list;
    }

    public SanPham getProductById(String id) {
        try {
            String sql = "SELECT [idSanPham]\n"
                    + "      ,[TenSanPham]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[GiaBanDau]\n"
                    + "      ,[GiaSanPham]\n"
                    + "      ,[AnhMinhHoa]\n"
                    + "      ,[AnhMoTa]\n"
                    + "      ,[MoTaSanPham]\n"
                    + "      ,[ThuongHieu]\n"
                    + "      ,[MauSac]\n"
                    + "      ,[idPhanLoai]\n"
                    + "  FROM [SanPham] where idSanPham = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setIdSanPham(rs.getString("idSanPham"));
                s.setTenSanPham(rs.getString("TenSanPham"));
                s.setTongSoLuong(rs.getInt("TongSoLuong"));
                s.setGiaBanDau(rs.getInt("GiaBanDau"));
                s.setGiaSanPham(rs.getInt("GiaSanPham"));
                s.setAnhMinhHoa(rs.getString("AnhMinhHoa"));
                s.setAnhMoTa(rs.getString("AnhMoTa"));
                s.setMoTaSanPham(rs.getString("MoTaSanPham"));
                s.setThuongHieu(rs.getString("ThuongHieu"));
                s.setMauSac(rs.getString("MauSac"));
                s.setIdPhanLoai(rs.getString("idPhanLoai"));
                return s;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public void addProduct(SanPham product) {
        try {
            String sql = "INSERT INTO [SanPham]\n"
                    + "           ([idSanPham]\n"
                    + "           ,[TenSanPham]\n"
                    + "           ,[TongSoLuong]\n"
                    + "           ,[GiaBanDau]\n"
                    + "           ,[GiaSanPham]\n"
                    + "           ,[AnhMinhHoa]\n"
                    + "           ,[AnhMoTa]\n"
                    + "           ,[MoTaSanPham]\n"
                    + "           ,[ThuongHieu]\n"
                    + "           ,[MauSac]\n"
                    + "           ,[idPhanLoai])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = ps(sql);
            stm.setString(1, product.getIdSanPham());
            stm.setString(2, product.getTenSanPham());
            stm.setInt(3, product.getTongSoLuong());
            stm.setInt(4, product.getGiaBanDau());
            stm.setInt(5, product.getGiaSanPham());
            stm.setString(6, product.getAnhMinhHoa());
            stm.setString(7, product.getAnhMoTa());
            stm.setString(8, product.getMoTaSanPham());
            stm.setString(9, product.getThuongHieu());
            stm.setString(10, product.getMauSac());
            stm.setString(11, product.getIdPhanLoai());
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
    }

    public void updateProduct(SanPham product) {
        try {
            String sql = "UPDATE [SanPham]\n"
                    + "   SET [TenSanPham] = ?\n"
                    + "      ,[TongSoLuong] = ?\n"
                    + "      ,[GiaBanDau] = ?\n"
                    + "      ,[GiaSanPham] = ?\n"
                    + "      ,[AnhMinhHoa] = ?\n"
                    + "      ,[AnhMoTa] = ?\n"
                    + "      ,[MoTaSanPham] = ?\n"
                    + "      ,[ThuongHieu] = ?\n"
                    + "      ,[MauSac] = ?\n"
                    + "      ,[idPhanLoai] = ?\n"
                    + " WHERE [idSanPham] = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(11, product.getIdSanPham());
            stm.setString(1, product.getTenSanPham());
            stm.setInt(2, product.getTongSoLuong());
            stm.setInt(3, product.getGiaBanDau());
            stm.setInt(4, product.getGiaSanPham());
            stm.setString(5, product.getAnhMinhHoa());
            stm.setString(6, product.getAnhMoTa());
            stm.setString(7, product.getMoTaSanPham());
            stm.setString(8, product.getThuongHieu());
            stm.setString(9, product.getMauSac());
            stm.setString(10, product.getIdPhanLoai());
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
    }

    public boolean deleteProduct(String id) {
        String sql = "DELETE FROM [SanPham]\n"
                + "      WHERE idSanPham = ?";
        if (checkValidDeleteProduct(id) == null) {
            try {
                PreparedStatement ps = ps(sql);
                ps.setString(1, id);
                ps.executeUpdate();
            } catch (Exception ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }

    }

    public SanPham checkValidDeleteProduct(String pid) {
        try {
            String sql = "SELECT s.[idSanPham]\n"
                    + "      ,s.[TenSanPham]\n"
                    + "      ,[TongSoLuong]\n"
                    + "      ,[GiaBanDau]\n"
                    + "      ,[GiaSanPham]\n"
                    + "      ,[AnhMinhHoa]\n"
                    + "      ,[AnhMoTa]\n"
                    + "      ,[MoTaSanPham]\n"
                    + "      ,[ThuongHieu]\n"
                    + "      ,[MauSac]\n"
                    + "      ,[idPhanLoai]\n"
                    + "  FROM [SanPham] s join [HoaDon] hd on s.idSanPham = hd.idSanPham where s.idSanPham = ?";
            PreparedStatement ps = ps(sql);
            ps.setString(1, pid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getString("idSanPham"));
                sp.setTenSanPham(rs.getString("TenSanPham"));
                System.out.println(sp.getTenSanPham());
                return sp;
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
