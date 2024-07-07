package Controller;

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
public class LoginController extends HttpServlet {
    String loginURL = "jsp/login.jsp";
    UserDAO dao = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(loginURL).forward(request, response);
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
        String username = request.getParameter("logemail");
        String pass = request.getParameter("logpass");
        NguoiDung user = dao.getUser(username, pass);
        HttpSession hs = request.getSession();
        if(user != null){
            Admin emp = dao.getUserWithRole(user.getIdUser());
            if(emp != null){
                hs.setAttribute("emp", emp);
                hs.setAttribute("user", user);
                response.sendRedirect("home");
            } else{
                hs.setAttribute("user", user);
                response.sendRedirect("home");
            }
        }else{
            request.setAttribute("error", "Login Failed!");
            request.getRequestDispatcher(loginURL).forward(request, response);
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
