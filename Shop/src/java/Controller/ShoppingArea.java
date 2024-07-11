/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DTO.ProductDTO;
import Dal.DAO.CategoryDAO;
import Dal.DAO.ProductDAO;
import Model.PhanLoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class ShoppingArea extends HttpServlet {

    CategoryDAO categoryDAO = new CategoryDAO();
    ProductDAO dao = new ProductDAO();

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
        String category = request.getParameter("category");
        
        ArrayList<ProductDTO> listAll = dao.getAllProductInSys();
        ArrayList<ProductDTO> list = new ArrayList<>();
        if (category != null) {
            for (ProductDTO product : listAll) {
                if (product.getIdPhanLoai().trim().equals(category)) {
                    list.add(product);
                }
            }
        }
        if (list.isEmpty()) {
            request.setAttribute("list", listAll);
        } else {
            request.setAttribute("list", list);
        }
        
        if (category == null) {
            request.setAttribute("list", null);
        }
        ArrayList<PhanLoai> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("jsp/gianhang.jsp").forward(request, response);
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
