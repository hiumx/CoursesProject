/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BlogDAO;
import dal.CourseDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Blog;
import model.Course;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ManagementServlet", urlPatterns = {"/management"})
public class ManagementServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String type = "user";
        String typeRaw = request.getParameter("type");
        if (typeRaw != null) {
            type = typeRaw;
        }

        switch (type) {
            case "user":
                UserDAO udb = new UserDAO();
                List<User> listUsers = udb.getAll();
                request.setAttribute("listUsers", listUsers);
                request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
                break;
            case "course":
                CourseDAO cdb = new CourseDAO();
                List<Course> listCourses = cdb.getAll();
                request.setAttribute("listCourses", listCourses);
                request.setAttribute("type", type);
                request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
                break;
            case "blog":
                BlogDAO bdb = new BlogDAO();
                String status = request.getParameter("status");
                List<Blog> listBlogs = new ArrayList<>();
                if(status == null ) {
                    listBlogs = bdb.getAll();
                    request.setAttribute("status", "all");
                } else if (status.equals("confirmed")) {
                    listBlogs = bdb.getBlogsByStatus("Confirmed");
                } else if (status.equals("pending")) {
                    listBlogs = bdb.getBlogsByStatus("Pendding");
                    request.setAttribute("status", "pending");
                };
                request.setAttribute("listBlogs", listBlogs);
                request.setAttribute("type", type);
                request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }

        request.setAttribute("type", type);
        request.getRequestDispatcher("page/management/management.jsp").forward(request, response);
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
