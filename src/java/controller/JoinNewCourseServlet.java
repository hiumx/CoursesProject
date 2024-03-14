/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserCourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import model.User;
import model.UserCourse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "JoinNewCourseServlet", urlPatterns = {"/courses/join"})
public class JoinNewCourseServlet extends HttpServlet {

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
            out.println("<title>Servlet JoinNewCourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JoinNewCourseServlet at " + request.getContextPath() + "</h1>");
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
        String courseIdRaw = request.getParameter("courseId");
        HttpSession session = request.getSession();
        try {
            int courseId = Integer.parseInt(courseIdRaw);
            int userId = ((User)session.getAttribute("user")).getId();

            System.out.println(courseId + "   " + userId);
            UserCourseDAO ucdb = new UserCourseDAO();

            if (!ucdb.isJoinedCourse(userId, courseId)) {
                int rowEff = ucdb.joinNewCourse(new UserCourse(userId, courseId, LocalDate.now().toString()));
                if (rowEff > 0) {
                    response.sendRedirect("/mycourses");    
                } else {
                    request.setAttribute("message", "Something wrong from server!");
                    request.getRequestDispatcher("/courses?id=" + courseId).forward(request, response);
                }
            } else {
                request.setAttribute("message", "Bạn đã tham gia khóa học này rồi!");
                request.getRequestDispatcher("/courses?id=" + courseId).forward(request, response);
            }

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
