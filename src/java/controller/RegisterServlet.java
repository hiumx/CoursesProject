package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServelet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServelet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        String phoneRegex = "^\\d{10}$";
        String passwordPattern = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";

        UserDAO udb = new UserDAO();
        String error = "";
        if (udb.isUserNameExist(username)) {
            error = "Username already existed. Please enter another.";
        } else if (!phone.matches(phoneRegex)) {
            error = "Phone number invalid!";
        } else if (udb.isPhoneExist(phone)) {
            error = "Phone already existed. Please enter another.";
        } else if (!password.matches(passwordPattern)) {
            error = "Password must be at least 8 characters, one lower char,"
                    + " one upper char and one special char";
        } else if (!password.equals(confirmPassword)) {
            error = "Confirm password not matched!";
        }

        if (error.equalsIgnoreCase("")) {
            int rowEff = udb.createUser(username, password, phone);
            if (rowEff > 0) {
                response.sendRedirect("/login.jsp");
            } else {
                request.setAttribute("error", "Register failed!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", error);
            request.setAttribute("username", username);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.setAttribute("confirmPassword", confirmPassword);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
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
