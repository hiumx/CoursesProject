/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BlogDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name="CreateBlogServlet", urlPatterns={"/management/blogs/add-blog"})
public class CreateBlogServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateBlogServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateBlogServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("type", "addBlog");
        UserDAO udb = new UserDAO();
        List<User> listUsers = udb.getAll();
        request.setAttribute("listUsers", listUsers);
        request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String title = request.getParameter("title");
        String userIdRaw = request.getParameter("user-select");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        
        image = "./images/blogs/" + image;
        
        if (!title.equalsIgnoreCase("") && !content.equalsIgnoreCase("") 
                && !image.equalsIgnoreCase("") && title != null 
                && content != null && image != null) {
            try {
                int userId = Integer.parseInt(userIdRaw);
                BlogDAO bdb = new BlogDAO();
                int rowEffected = bdb.createBlog(title, image, content, userId);
                System.out.println("ROW EFFECT: " + rowEffected);
                if (rowEffected > 0) {
                    response.sendRedirect("/management");
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
             
        } else {
            request.setAttribute("error", "Please fill all fields!");
            request.setAttribute("type", "addBlog");
            request.setAttribute("title", title);
            request.setAttribute("content", content);
            request.setAttribute("image", image);
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
            
        } 
       
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
