/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.DonHangDTO;
import Dal.DAO.DonHangDAO;
import Model.DonHang;
import Model.NguoiDung;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class AddToCart extends HttpServlet {

    DonHangDAO dao = new DonHangDAO();

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
        HttpSession hs = request.getSession();
        NguoiDung acc = (NguoiDung) hs.getAttribute("user");
        if (acc != null) {

            String uid = request.getParameter("uid");
            String pid = request.getParameter("pid");
            String sdt = request.getParameter("sdt");
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");

            uid = (uid == null || uid.length() == 0) ? null : uid.trim();
            pid = (pid == null || pid.length() == 0) ? null : pid.trim();
            sdt = (sdt == null || sdt.length() == 0) ? "0" : sdt.trim();
            name = (name == null || name.length() == 0) ? "Unknown" : name.trim();
            price = (price == null || price.length() == 0) ? "0" : price.trim();
            quantity = (quantity == null || quantity.length() == 0) ? "0" : quantity.trim();

            ArrayList<DonHangDTO> dhs = dao.getAllDonHang();
            int maxId = 0;
            for (DonHangDTO donHangDTO : dhs) {
                if(maxId < Integer.parseInt(donHangDTO.getIdDonHang().trim())){
                    maxId = Integer.parseInt(donHangDTO.getIdDonHang().trim());
                }
            }
            
            if (uid != null && pid != null) {
                DonHang d = dao.getDonHangByPidAndUid(pid, uid);
                int soluong = Integer.parseInt(quantity);
                int gia = Integer.parseInt(price);
                if (d != null && d.isIsPay() == false) {
                    d.setTongSoLuong(d.getTongSoLuong() + soluong);
                    d.setTongThanhTien(gia * d.getTongSoLuong());
                    dao.updateToCard(d);
                } else {
                    DonHang dh = new DonHang();
                    int id = maxId + 1;
                    dh.setIdDonHang(String.valueOf(id));
                    dh.setIdSanPham(pid);
                    dh.setIdUser(uid);
                    dh.setSdt(Integer.parseInt(sdt));
                    dh.setTenKH(name);
                    dh.setTongSoLuong(soluong);
                    dh.setTongThanhTien(gia * soluong);
                    dao.addToCard(dh);
                }
                response.sendRedirect("ListCard?uid=" + uid);
            }

        } else {
            request.setAttribute("message", "Cần Đăng Nhập Để Mua Hàng");
            request.getRequestDispatcher("ShoppingArea").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
