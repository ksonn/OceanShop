/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AddUserDTO;
import Dal.DAO.UserDAO;
import Model.NguoiDung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class RegisterController extends HttpServlet {

    UserDAO dao = new UserDAO();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
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
        String logname = request.getParameter("lognamee");
        String password = request.getParameter("logpasss");
        String logemail = request.getParameter("logemaill");

        logname = (logname == null || logname.length() == 0) ? null : logname.trim();
        password = (password == null || password.length() == 0) ? null : password.trim();
        logemail = (logemail == null || logemail.length() == 0) ? null : logemail.trim();

        if (logname != null && logemail != null && password != null) {
            ArrayList<NguoiDung> list = dao.getAllUser();
            AddUserDTO user = new AddUserDTO();
            user.setIdUser(String.valueOf(list.size() + 1));
            user.setEmail(logemail);
            user.setTenUser(logname);
            user.setMatKhau(password);
            if (!checkExistInList(user, list)) {
                dao.addUser(user);
                response.sendRedirect("login");
            } else{
                request.setAttribute("error", "Email already registed!");
                request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Missing required fields");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
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

    private boolean checkExistInList(AddUserDTO user, ArrayList<NguoiDung> list) {
        for (NguoiDung nguoiDung : list) {
            if (nguoiDung.getEmail().equalsIgnoreCase(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

}
