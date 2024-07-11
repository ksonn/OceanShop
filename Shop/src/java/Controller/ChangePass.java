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

/**
 *
 * @author Administrator
 */
public class ChangePass extends HttpServlet {
    
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
        request.getRequestDispatcher("jsp/changepass.jsp").forward(request, response);
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
        String pass = request.getParameter("logpass");
        String repass = request.getParameter("relogpass");
        HttpSession hs = request.getSession();
        NguoiDung user = (NguoiDung) hs.getAttribute("user");
        if (user != null) {
            if (pass.equals(repass)) {
                if (pass.replaceAll("\\s+", "").length() > 6) {
                    Admin a = (Admin) hs.getAttribute("emp");
                    UserDTO u = new UserDTO();
                    u.setIdUser(user.getIdUser());
                    u.setMatKhau(pass);
                    if (a != null) {
                        u.setRole(a.getRole());
                    }
                    dao.changePass(u);
                    request.setAttribute("message", "Đổi Mật Khẩu Thành Công Cho " + user.getTenUser());
                    request.getRequestDispatcher("jsp/changepass.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Mật khẩu không hợp lệ");
                    request.getRequestDispatcher("jsp/changepass.jsp").forward(request, response);
                }
                
            } else {
                request.setAttribute("message", "Mật Khẩu Xác Thực Không Trùng Khớp");
                request.getRequestDispatcher("jsp/changepass.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Vui lòng đăng nhập lại để đổi mật khẩu");
            request.getRequestDispatcher("jsp/changepass.jsp").forward(request, response);
        }
        
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
