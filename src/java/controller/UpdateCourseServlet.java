/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateCourseServlet", urlPatterns = {"/management/courses/update"})
public class UpdateCourseServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateCourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCourseServlet at " + request.getContextPath() + "</h1>");
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
        String courseIdRaw = request.getParameter("id");
        try {
            int courseId = Integer.parseInt(courseIdRaw);
            CourseDAO cdb = new CourseDAO();
            Course course = cdb.getCourseDetail(courseId);
            request.setAttribute("course", course);
            request.setAttribute("type", "updateCourse");
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
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
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String levelRaw = request.getParameter("level");
        String content = request.getParameter("content");
        String target = request.getParameter("target");
        String idRaw = request.getParameter("id");


        if (!title.equalsIgnoreCase("") && !description.equalsIgnoreCase("")
                && !content.equalsIgnoreCase("")&& title != null && description != null
                && content != null ) {
            try {
                int level = Integer.parseInt(levelRaw);
                int id = Integer.parseInt(idRaw);
                CourseDAO cdb = new CourseDAO();
                int rowEffected = cdb.UpdateCourseById(id, title, description, content, target, level);
                if (rowEffected > 0) {
                    response.sendRedirect("/management");
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } else {
            request.setAttribute("error", "Please fill all fields!");
            request.setAttribute("type", "addCourse");
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.setAttribute("content", content);
            request.setAttribute("target", target);
            System.out.println("LEVEL:" + levelRaw);
            request.setAttribute("level", levelRaw);
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
            
        }
        request.setAttribute("type", "course");
        request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
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
