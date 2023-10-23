/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Enterprise;
import model.User;

/**
 *
 * @author Anh4Lan
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

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
            out.println("<title>Servlet ChangePasswordServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
        HttpSession session = request.getSession();        
        String emaildont = (String) session.getAttribute("emaildont");
        System.out.println(emaildont);
        String pass = request.getParameter("pass-input").trim();
        String confirm = request.getParameter("confirm-input").trim();        
        String[] inputArray = {pass, confirm};
        System.out.println("lay duouc pass va confirm");
        if (isEmptyInput(inputArray)) {
            request.setAttribute("inputError", "Must fill all input!");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        } else if (!isConfirmedPassword(pass, confirm)) {
            request.setAttribute("inputError", "Confirm incorrect password!");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }
        System.out.println("check xong if 1 2 ");
        int id = -1;
        if ("User".equals(session.getAttribute("role"))) {
            User u = new User(emaildont, pass);            
            id = u.changePass();
        } else if ("Enterprise".equals(session.getAttribute("role"))) {
            Enterprise e = new Enterprise(emaildont, pass);            
            id = e.changePass();
        }
        System.out.println("check xong if 3 4 ");
        response.sendRedirect("LoginServlet");
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

    public static boolean isEmptyInput(String[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isConfirmedPassword(String pass, String confirm) {
        if (confirm.equals(pass)) {
            return true;
        }
        return false;
    }
}
