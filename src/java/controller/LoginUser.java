/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Job;
import model.Users;
import model.UserDB;

/**
 *
 * @author ASUS
 */
public class LoginUser extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginUser at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String uName = request.getParameter("account-login").trim();
        String pass = request.getParameter("password-login").trim();
        // remember me?
        String remember  = request.getParameter("remember");
        if(remember.equals("on")){
            response.addCookie(new Cookie("account",uName));
            response.addCookie(new Cookie("password", pass));
        }
        UserDB db = new UserDB();
       
        //end remember mel
        Users u = db.getUser(uName);
//        HttpSession session = request.getSession();
//        session.setAttribute("idU", u.getUserID());
        System.out.println(u);
        if(u.getUserPassword().equals(pass)==false){
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
             UserDB dao = new UserDB();
             List<Job> list = dao.getJob();
             System.out.println(list);
             System.out.println(u);
                request.setAttribute("list", list);
//        request.setAttribute("notic", "Login fail. Username or password is wrong!");
//        request.setAttribute("link", "login.jsp");
//        request.setAttribute("subLink", "Relogin");
        request.getRequestDispatcher("main.jsp").forward(request, response);
        }
   }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
U     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
