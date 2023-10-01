/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Job;

/**
 *
 * @author MY PC
 */
@WebServlet(name = "postJob", urlPatterns = {"/postJob"})
public class postJob extends HttpServlet {

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
            out.println("<title>Servlet postJob</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet postJob at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    // Các xử lý khác ở đầu phương thức
    
    // Tạo một đối tượng Job từ thông tin được gửi từ giao diện người dùng
    String title = request.getParameter("title");
    String location = request.getParameter("location");
    String type = request.getParameter("type");
    String description = request.getParameter("description");
    String skills = request.getParameter("skills");

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateOpen = null;
    Date dateClose = null;
    try {
        dateOpen = dateFormat.parse(request.getParameter("dateOpen"));
        dateClose = dateFormat.parse(request.getParameter("dateClose"));
    } catch (java.text.ParseException e) {
        e.printStackTrace();
    }

    Job job = new Job();
    job.setTitle(title);
    job.setLocation(location);
    job.setType(type);
    job.setDescription(description);
    job.setSkills(skills);
    job.setDateOpen(dateOpen);
    job.setDateClose(dateClose);

    // Tạo kết nối cơ sở dữ liệu
    Connection conn = null;
    // Sử dụng lớp DAO và truyền kết nối cơ sở dữ liệu
    JobDAO jobDAO = new JobDAO(conn);
    boolean success = jobDAO.insertJob(job); // Lưu thông tin công việc vào cơ sở dữ liệu
    if (success) {
        // Nếu lưu thành công, chuyển hướng người dùng đến trang danh sách công việc
        response.sendRedirect("joblist.jsp");
    } else {
        // Xử lý lỗi, ví dụ: hiển thị thông báo lỗi cho người dùng
        response.getWriter().write("Đã xảy ra lỗi khi lưu công việc.");
    } 
    } finally static {
        try {
            Object conn = null;
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

