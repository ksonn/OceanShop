/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.DAO.CategoryDAO;
import Dal.DAO.ProductDAO;
import Model.Admin;
import Model.PhanLoai;
import Model.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import utils.UploadFile;

/**
 *
 * @author Administrator
 */
@MultipartConfig
public class ViewProduct extends HttpServlet {

    ProductDAO dao = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();

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
        SanPham s = dao.getProductById(id);
        ArrayList<PhanLoai> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.setAttribute("category", s.getIdPhanLoai());
        request.setAttribute("product", s);
        request.getRequestDispatcher("jsp/viewProduct.jsp").forward(request, response);
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
        HttpSession hs = request.getSession();
        Admin a = (Admin) hs.getAttribute("emp");
        if (a != null) {
            String id = request.getParameter("productId");
            String name = request.getParameter("productName");
            Part part = request.getPart("productImage");
            String des = request.getParameter("productDescription");
            String cate = request.getParameter("category");
            String priceBuy = request.getParameter("productPriceBuy");
            String priceEarn = request.getParameter("productPriceSell");
            String unitInStock = request.getParameter("unitInStock");
            String brand = request.getParameter("brand");
            String color = request.getParameter("color");

            name = (name == null || name.length() == 0) ? null : name.trim();
            cate = (cate == null || cate.length() == 0) ? null : cate.trim();
            priceBuy = (priceBuy == null || priceBuy.length() == 0) ? null : priceBuy.trim();
            priceEarn = (priceEarn == null || priceEarn.length() == 0) ? null : priceEarn.trim();
            unitInStock = (unitInStock == null || unitInStock.length() == 0) ? null : unitInStock.trim();
            String photo = uploadPhoto(part);

            if (id == null
                    || name == null
                    || cate == null
                    || priceBuy == null
                    || priceEarn == null
                    || unitInStock == null) {
                request.setAttribute("error", "Invalid Information");
            } else {
                SanPham sp = new SanPham(
                        id,
                        name,
                        Integer.parseInt(unitInStock),
                        Integer.parseInt(priceBuy),
                        Integer.parseInt(priceEarn),
                        photo,
                        photo,
                        des,
                        brand,
                        color,
                        cate
                );
                dao.updateProduct(sp);
                response.sendRedirect("ViewProduct?id="+id);
            }
        } else {
            response.getWriter().print("Access Denied");
        }
    }

    private String uploadPhoto(Part part) {

        String fileName, pathWithBuild, pathNoBuild;
        InputStream is1, is2;
        UploadFile uploadFile;

        fileName = part.getSubmittedFileName();

        pathWithBuild = getServletContext().getRealPath("lib/img");
        pathNoBuild = pathWithBuild.substring(0, pathWithBuild.indexOf("build")) + "web" + File.separator + "lib/img";

        pathWithBuild += File.separator + fileName;
        pathNoBuild += File.separator + fileName;
        try {
            is1 = part.getInputStream();
            is2 = part.getInputStream();
            uploadFile = new UploadFile();
            uploadFile.uploadFile(is1, pathWithBuild);
            uploadFile.uploadFile(is2, pathNoBuild);
            return "lib/img" + "/" + fileName;
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return "";
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
