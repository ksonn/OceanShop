/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal.DAO;

import DTO.UserDTO;
import Dal.DBContext;
import Model.Admin;
import Model.NguoiDung;
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
public class UserDAO extends DBContext {

    public Set<UserDTO> getAllUserInSystem(String search, String gender, String roleSearch) {
        Set<UserDTO> listAll = new HashSet<>();
        String sql;
        try {
            if (roleSearch != null) {
                sql = "SELECT u.[idUser]\n"
                        + "      ,[TenUser]\n"
                        + "      ,[GioiTinh]\n"
                        + "      ,u.[Email]\n"
                        + "      ,u.[MatKhau]\n"
                        + "      ,[SDT]\n"
                        + "	  ,a.[Role]\n"
                        + "  FROM [NguoiDung] u join [ADMIN] a on u.idUser = a.idUser";
            } else {
                sql = "Select * From NguoiDung";
            }
            ResultSet rs = rs(sql);
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setIdUser(rs.getString("idUser"));
                user.setEmail(rs.getString("Email"));
                user.setGioiTinh(rs.getString("GioiTinh"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setSdt(rs.getInt("SDT"));
                user.setTenUser(rs.getString("TenUser"));
                if (roleSearch != null) {
                    user.setRole(rs.getString("Role"));
                }
                listAll.add(user);
            }

            if (search != null || gender != null || roleSearch != null) {
                search = search.trim();
                Set<UserDTO> list = new HashSet<>();
                for (UserDTO addUserDTO : listAll) {

                    if (search.length() > 0 && search != null
                            && (addUserDTO.getEmail().contains(search)
                            || addUserDTO.getTenUser().contains(search))) {
                        list.add(addUserDTO);
                    }

                    if (gender != null && gender.length() > 0
                            && gender.equals(addUserDTO.getGioiTinh())) {
                        list.add(addUserDTO);
                    }

                    if (roleSearch != null && roleSearch.length() > 0
                            && roleSearch.equals(addUserDTO.getRole())) {
                        list.add(addUserDTO);
                    }
                }
                if (list.isEmpty()) {
                    return listAll;
                } else {
                    return list;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return listAll;
    }

    public ArrayList<NguoiDung> getAllUser() {
        ArrayList<NguoiDung> list = new ArrayList<>();
        try {
            String sql = "SELECT *  FROM [NguoiDung]";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                NguoiDung user = new NguoiDung();
                user.setIdUser(rs.getString("idUser"));
                user.setEmail(rs.getString("Email"));
                user.setGioiTinh(rs.getString("GioiTinh"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setSdt(rs.getInt("SDT"));
                user.setTenUser(rs.getString("TenUser"));
                list.add(user);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return list;
    }

    public NguoiDung getUser(String email, String pass) {
        try {
            String sql = "SELECT [idUser]\n"
                    + "      ,[TenUser]\n"
                    + "      ,[GioiTinh]\n"
                    + "      ,[Email]\n"
                    + "      ,[MatKhau]\n"
                    + "      ,[SDT]\n"
                    + "  FROM [NguoiDung] where Email = ? And MatKhau = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, email);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDung user = new NguoiDung();
                user.setIdUser(rs.getString("idUser"));
                user.setEmail(rs.getString("Email"));
                user.setGioiTinh(rs.getString("GioiTinh"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setSdt(rs.getInt("SDT"));
                user.setTenUser(rs.getString("TenUser"));
                return user;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public UserDTO getUserWithAllObject(String userId) {
        try {
            UserDTO u = new UserDTO();
            String sql = "SELECT [idUser]\n"
                    + "      ,[TenUser]\n"
                    + "      ,[GioiTinh]\n"
                    + "      ,[Email]\n"
                    + "      ,[MatKhau]\n"
                    + "      ,[SDT]\n"
                    + "  FROM [NguoiDung] where idUser = ? ";
            PreparedStatement stm = ps(sql);
            stm.setString(1, userId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                u.setIdUser(rs.getString("idUser"));
                u.setEmail(rs.getString("Email"));
                u.setGioiTinh(rs.getString("GioiTinh"));
                u.setTenUser(rs.getString("TenUser"));
                u.setSdt(rs.getInt("SDT"));
                Admin a = getUserWithRole(userId);
                if (a != null) {
                    u.setRole(a.getRole());
                }
                return u;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public Admin getUserWithRole(String userId) {
        try {
            String sql = "SELECT [idUser]\n"
                    + "      ,[Email]\n"
                    + "      ,[MatKhau]\n"
                    + "      ,[Role]\n"
                    + "  FROM [ADMIN] where idUser = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, userId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Admin emp = new Admin();
                emp.setIdUser(rs.getString("idUser"));
                emp.setEmail(rs.getString("Email"));
                emp.setMatKhau(rs.getString("MatKhau"));
                emp.setRole(rs.getString("Role"));
                return emp;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
        return null;
    }

    public void addUser(UserDTO user) {
        try {
            if (user != null) {
                if (user.getRole() != null) {
                    addNguoiDung(user);
                    String sql = "INSERT INTO [ADMIN]\n"
                            + "           ([idUser]\n"
                            + "           ,[Email]\n"
                            + "           ,[MatKhau]\n"
                            + "           ,[Role])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?)";
                    PreparedStatement stm = ps(sql);
                    stm.setString(1, user.getIdUser());
                    stm.setString(2, user.getEmail());
                    stm.setString(3, user.getMatKhau());
                    stm.setString(4, user.getRole());
                    stm.executeUpdate();
                } else {
                    addNguoiDung(user);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            close();
        }
    }

    private void addNguoiDung(UserDTO acc) {
        try {
            String sql = "INSERT INTO [NguoiDung]\n"
                    + "           ([idUser]\n"
                    + "           ,[TenUser]\n"
                    + "           ,[GioiTinh]\n"
                    + "           ,[Email]\n"
                    + "           ,[MatKhau]\n"
                    + "           ,[SDT])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = ps(sql);
            stm.setString(1, acc.getIdUser());
            stm.setString(2, acc.getTenUser());
            stm.setString(3, acc.getGioiTinh());
            stm.setString(4, acc.getEmail());
            stm.setString(5, acc.getMatKhau());
            stm.setInt(6, acc.getSdt());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void changePass(UserDTO acc) {
        String sql;
        try {
            if (acc.getRole() == null) {
                sql = "UPDATE [NguoiDung]\n"
                        + "   SET [MatKhau] = ?\n"
                        + " WHERE idUser = ?";
            } else {
                sql = "UPDATE [NguoiDung]\n"
                        + "   SET [MatKhau] = ?\n"
                        + " WHERE idUser = ?";
                PreparedStatement stm = ps(sql);
                stm.setString(2, acc.getIdUser());
                stm.setString(1, acc.getMatKhau());
                stm.executeUpdate();
                sql = "UPDATE [ADMIN]\n"
                        + "   SET [MatKhau] = ?\n"
                        + " WHERE [idUser] = ?";
            }
            PreparedStatement stm = ps(sql);
            stm.setString(2, acc.getIdUser());
            stm.setString(1, acc.getMatKhau());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void changeProfile(UserDTO acc) {
        String sql;
        try {
            if (acc.getRole() == null) {
                sql = "UPDATE [NguoiDung]\n"
                        + "   SET [TenUser] = ?\n"
                        + "      ,[GioiTinh] = ?\n"
                        + "      ,[SDT] = ?\n"
                        + " WHERE [idUser] = ?";
                PreparedStatement stm = ps(sql);
                stm.setString(1, acc.getTenUser());
                stm.setString(2, acc.getGioiTinh());
                stm.setInt(3, acc.getSdt());
                stm.setString(4, acc.getIdUser());
                stm.executeUpdate();
            } else {
                sql = "UPDATE [NguoiDung]\n"
                        + "   SET [TenUser] = ?\n"
                        + "      ,[GioiTinh] = ?\n"
                        + "      ,[SDT] = ?\n"
                        + " WHERE [idUser] = ?";
                PreparedStatement stm = ps(sql);
                stm.setString(1, acc.getTenUser());
                stm.setString(2, acc.getGioiTinh());
                stm.setInt(3, acc.getSdt());
                stm.setString(4, acc.getIdUser());
                stm.executeUpdate();
                updateAdmin(acc);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    private void updateAdmin(UserDTO acc) {
        try {
            String sql = "UPDATE [ADMIN]\n"
                    + "   SET [Role] = ?\n"
                    + " WHERE [idUser] = ?";
            PreparedStatement stm = ps(sql);
            stm.setString(1, acc.getRole());
            stm.setString(2, acc.getIdUser());
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

}
