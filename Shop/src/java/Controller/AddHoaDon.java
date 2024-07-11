/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.DonHangDTO;
import Dal.DAO.DonHangDAO;
import Dal.DAO.HoaDonDAO;
import Model.DonHang;
import Model.HoaDon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class AddHoaDon extends HttpServlet {
    DonHangDAO donHangDAO = new DonHangDAO();
    HoaDonDAO hoaDonDAO = new HoaDonDAO();
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
        String uid = request.getParameter("uid");
        ArrayList<DonHangDTO> list = donHangDAO.getDonHangByUid(uid);
        int max = 0;
        ArrayList<HoaDon> lists = hoaDonDAO.listAll();
        for (HoaDon list1 : lists) {
            if(Integer.parseInt(list1.getIdHoaDon().trim()) > max){
                max = Integer.parseInt(list1.getIdHoaDon().trim());
            }
        }
        System.out.println(max);
        if(list.size() >0){
            for (DonHangDTO donHangDTO : list) {
                HoaDon hd = new HoaDon();
                
                
                // lay ra thang hoa don cuoi cung va lay ra id cua no cong them 1
                hd.setIdHoaDon(String.valueOf(max+1));
                hd.setIdDonHang(donHangDTO.getIdDonHang());
                hd.setIdSanPham(donHangDTO.getIdSanPham());
                hd.setSoLuong(donHangDTO.getTongSoLuong());
                hd.setTenSanPham(donHangDTO.getSanPham().getTenSanPham());
                hd.setGiaTien(donHangDTO.getSanPham().getGiaSanPham());
                hd.setThanhTien(donHangDTO.getTongThanhTien());
                hd.setIsPay(false);
                hoaDonDAO.addHoaDon(hd);
            }
        }
        request.getRequestDispatcher("ConfirmPay?uid="+uid).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
