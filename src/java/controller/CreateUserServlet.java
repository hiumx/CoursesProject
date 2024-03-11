/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/management/users/add-user"})
public class CreateUserServlet extends HttpServlet {

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
            out.println("<title>Servlet AddUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUserServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("type", "addUser");
        request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        String pattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        String phoneRegex = "^\\d{10}$";
        UserDAO udb = new UserDAO();

        boolean isUsernameExist = udb.isUserNameExist(username);

        if (isUsernameExist) {
            request.setAttribute("error", "User name already existed! Please try anothers.");
            request.setAttribute("type", "addUser");
            request.setAttribute("username", username);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
        } else if (!phone.matches(phoneRegex)) {
            request.setAttribute("error", "Phone already existed!. Please enter another.");
            request.setAttribute("type", "addUser");
            request.setAttribute("username", username);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
        } else if (!password.matches(pattern)) {
            request.setAttribute("error", "Password must be at least 8 characters, one lower char,"
                    + " one upper char and one special char");
            request.setAttribute("type", "addUser");
            request.setAttribute("username", username);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/page/management/management.jsp").forward(request, response);
        } else {
            int rowEffected = udb.createUser(username, password, phone);
            if (rowEffected > 0) {
                response.sendRedirect("/management");
            }
        }

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
