/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.UserDTO;
import Dal.DAO.UserDAO;
import Model.Admin;
import Model.NguoiDung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class AddUser extends HttpServlet {
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
        HttpSession hs = request.getSession();
        Admin a = (Admin)hs.getAttribute("emp");
        if (a != null) {
            request.getRequestDispatcher("jsp/addUser.jsp").forward(request, response);
        } else{
            response.getWriter().print("Access Denied");
        }
        
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
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String admin = request.getParameter("isAdmin");
        String pass = request.getParameter("pass");
        
        ArrayList<NguoiDung> list = dao.getAllUser();
        UserDTO user = new UserDTO();
        user.setIdUser(String.valueOf(list.size() + 1));
        user.setEmail(email);
        user.setMatKhau(pass);
        user.setGioiTinh((gender == null || gender.length() == 0) ? "" : gender);
        user.setTenUser((fullname == null || fullname.length() == 0) ? "" : fullname);
        user.setSdt((phone == null || phone.length() == 0) ? 0 : Integer.parseInt(phone));
        if (admin != null && admin.length() > 0) {
            user.setRole(admin);
        }
        dao.addUser(user);
        response.sendRedirect("ManageUser");
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
