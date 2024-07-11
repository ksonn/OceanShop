
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.ProductDTO;
import Dal.DAO.CategoryDAO;
import Dal.DAO.ProductDAO;
import Model.Admin;
import Model.PhanLoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class ManageProduct extends HttpServlet {

    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO productDAO = new ProductDAO();

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
        Admin a = (Admin) hs.getAttribute("emp");
        if (a != null) {
            String searchValue = request.getParameter("searchValue");
            String category = request.getParameter("category");

            searchValue = (searchValue == null || searchValue.length() == 0) ? " " : searchValue;
            category = (category == null || category.length() == 0) ? null : category;

            ArrayList<ProductDTO> list = productDAO.getAllProductInSys();
            if (searchValue != null || category != null) {
                searchValue = searchValue.trim();
                Set<ProductDTO> filter = new HashSet<>();
                for (ProductDTO productDTO : list) {
                    if (searchValue.length() > 0 && (productDTO.getTenSanPham().contains(searchValue)
                            || productDTO.getThuongHieu().equalsIgnoreCase(searchValue)
                            || productDTO.getMauSac().equalsIgnoreCase(searchValue))) {
                        filter.add(productDTO);
                    }
                    if (productDTO.getIdPhanLoai().equals(category)) {
                        filter.add(productDTO);
                    }
                }
                if (filter.isEmpty()) {
                    request.setAttribute("list", list);
                } else {
                    request.setAttribute("list", filter);
                }
            }

            ArrayList<PhanLoai> categories = categoryDAO.getAllCategory();
            request.setAttribute("categories", categories);
            request.setAttribute("category", category);
            request.getRequestDispatcher("jsp/manageProduct.jsp").forward(request, response);
        } else {
            response.getWriter().println("Access Denied");
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
