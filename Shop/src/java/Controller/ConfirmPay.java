/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.DonHangDTO;
import DTO.UserDTO;
import Dal.DAO.DonHangDAO;
import Dal.DAO.HoaDonDAO;
import Dal.DAO.UserDAO;
import Model.HoaDon;
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
public class ConfirmPay extends HttpServlet {
    
    DonHangDAO donHangDAO = new DonHangDAO();
    HoaDonDAO hoaDonDAO = new HoaDonDAO();

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
        NguoiDung acc = (NguoiDung) hs.getAttribute("user");
        if (acc != null) {
            String uid = request.getParameter("uid");
            ArrayList<DonHangDTO> donHangs = donHangDAO.getDonHangByUid(uid);
            long sum = 0;
            for (DonHangDTO donHang : donHangs) {
                sum += donHang.getTongThanhTien();
            }
            
            request.setAttribute("list", donHangs);
            request.setAttribute("sum", sum);
            request.getRequestDispatcher("jsp/confirmPay.jsp").forward(request, response);
        } else {
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
        String uid = request.getParameter("uid");
        ArrayList<DonHangDTO> donHangs = donHangDAO.getDonHangByUid(uid);
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        for (DonHangDTO donHang : donHangs) {
            hoaDons.add(hoaDonDAO.getHoaDonByDonHang(donHang.getIdDonHang()));
        }
        String isPay = request.getParameter("pay");
        if (isPay.equals("1")) {
            for (DonHangDTO donHang : donHangs) {
                donHangDAO.updatePayStatus(donHang.getIdDonHang());
            }
            for (HoaDon hoaDon : hoaDons) {
                
                hoaDonDAO.updatePayStatus(hoaDon.getIdHoaDon().trim());
            }
        }
        response.sendRedirect("ListHoaDon?uid=" + uid);
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
