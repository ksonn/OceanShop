/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.UserDTO;
import Dal.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class ProfileManage extends HttpServlet {

    UserDAO dao = new UserDAO();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDTO user = dao.getUserWithAllObject(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String admin = request.getParameter("isAdmin");
        UserDTO user = new UserDTO();
        user.setIdUser(id);
        user.setEmail(email);
        user.setGioiTinh((gender == null || gender.length() == 0) ? "" : gender);
        user.setTenUser((fullname == null || fullname.length() == 0) ? "" : fullname);
        user.setSdt((phone == null || phone.length() == 0) ? 0 : Integer.parseInt(phone));
        if (admin != null && admin.length() > 0) {
            user.setRole(admin);
        }
        dao.changeProfile(user);
        request.setAttribute("user", user);
        request.setAttribute("message", "Cập Nhật Thông Tin Thành Công");
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
