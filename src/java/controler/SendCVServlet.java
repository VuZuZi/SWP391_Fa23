/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.CV;
import model.Job;
import model.User;

/**
 *
 * @author thean
 */
@WebServlet(name = "SendCVServlet", urlPatterns = {"/SendCVServlet"})
@MultipartConfig(
    location = "/fileUpload", // Đường dẫn đến thư mục lưu CV
    maxFileSize = 1024 * 1024 * 10, // Kích thước tối đa cho một tệp (ở đây là 10 MB)
    maxRequestSize = 1024 * 1024 * 30, // Kích thước tối đa cho một yêu cầu (ở đây là 30 MB)
    fileSizeThreshold = 1024 * 1024 * 5 // Kích thước ngưỡng để lưu trữ tạm thời trên đĩa (ở đây là 5 MB)
)
public class SendCVServlet extends HttpServlet {

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
            out.println("<title>Servlet SendCVServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendCVServlet at " + request.getContextPath() + "</h1>");
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
        String JobID = request.getParameter("id");
        System.out.println("doGet");
        System.out.println(JobID);
        Job j = new Job();

        Job JobSendingCV = j.getJobbyId(JobID);
        System.out.println(JobSendingCV.getJobId());

        request.getSession().setAttribute("JobSendingCV", JobSendingCV);
        request.getRequestDispatcher("SendCV.jsp").forward(request, response);
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
        String applititle = request.getParameter("applititle");   
        System.out.println(applititle);
        String jobpossion = request.getParameter("jobpossion");  
        System.out.println(jobpossion);
        String description = request.getParameter("description");        
        System.out.println(description);
        Collection<Part> parts = request.getParts();

        HttpSession session = request.getSession();        
        User u = (User) session.getAttribute("User");
        String userID = u.getUserID();
        Job job = (Job) session.getAttribute("JobSendingCV");
        String jobId = job.getJobId();
        System.out.println(userID);
        System.out.println(jobId);

        String fileName ="";
        for (Part part : parts) {
            if (part.getName().equals("cvFile") && part.getSize() > 0) {
                fileName = getFileName(part);
                part.write(fileName);                
            }
        }     
                                
        int id = -1;
        CV j = new CV(jobId,userID, applititle, jobpossion, description, fileName);
        id = j.addNewCV();
        request.getSession().setAttribute("userinfo", u);
        request.getRequestDispatcher("mainUser.jsp").forward(request, response);
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }
    
    public static boolean isEmptyInput(String[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i].isEmpty()) {
                return true;
            }
        }
        return false;
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
