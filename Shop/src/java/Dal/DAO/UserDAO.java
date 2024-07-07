/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal.DAO;

import DTO.AddUserDTO;
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

    public ArrayList<AddUserDTO> getAllUserInSystem(String search, String gender, String roleSearch) {
        ArrayList<AddUserDTO> listAll = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [NguoiDung]";
            ResultSet rs = rs(sql);
            while (rs.next()) {
                AddUserDTO user = new AddUserDTO();
                user.setIdUser(rs.getString("idUser"));
                user.setEmail(rs.getString("Email"));
                user.setGioiTinh(rs.getString("GioiTinh"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setSdt(rs.getInt("SDT"));
                user.setTenUser(rs.getString("TenUser"));
                listAll.add(user);
            }
            rs = rs("SELECT * FROM [ADMIN]");
            while (rs.next()) {
                String id = rs.getString("idUser");
                String role = rs.getString("Role");
                for (AddUserDTO user : listAll) {
                    if (user.getIdUser().equals(id)) {
                        user.setRole(role);
                    }
                }
            }

            if (search != null || gender != null || roleSearch != null) {
                ArrayList<AddUserDTO> list = new ArrayList<>();
                Set<String> ids = new HashSet<>();
                for (AddUserDTO addUserDTO : listAll) {

                    if (search != null
                            && (addUserDTO.getEmail().contains(search)
                            || addUserDTO.getTenUser().contains(search))
                            || addUserDTO.getSdt() == Integer.parseInt(search)) {
                        if (!ids.contains(addUserDTO.getIdUser())) {
                            ids.add(addUserDTO.getIdUser());
                            list.add(addUserDTO);
                        }
                    }

                    if (gender != null && gender.equals(addUserDTO.getGioiTinh())) {
                        if (!ids.contains(addUserDTO.getIdUser())) {
                            ids.add(addUserDTO.getIdUser());
                            list.add(addUserDTO);
                        }
                    }

                    if (roleSearch != null && roleSearch.equals(addUserDTO.getRole())) {
                        if (!ids.contains(addUserDTO.getIdUser())) {
                            ids.add(addUserDTO.getIdUser());
                            list.add(addUserDTO);
                        }
                    }
                }
                return list;
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

    public AddUserDTO getUserWithAllObject(String userId) {
        try {
            AddUserDTO u = new AddUserDTO();
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

    public void addUser(AddUserDTO user) {
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

    private void addNguoiDung(AddUserDTO acc) {
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
            int executeUpdate = stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public void changePass(AddUserDTO acc) {
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

    public void changeProfile(AddUserDTO acc) {
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

    private void updateAdmin(AddUserDTO acc) {
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
