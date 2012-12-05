/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bo.UserBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.UserBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karl
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                UserBean user=new UserBean();
                user.setUserName(request.getParameter("username"));
                user.setPassword(request.getParameter("password"));
                user.setFirstName(request.getParameter("firstname"));
                user.setLastName(request.getParameter("lastname"));
                user.setBirthday(new Date(request.getParameter("year")+"/"+request.getParameter("month")+"/"+request.getParameter("date")));
                user.setGender(request.getParameter("gender").equals("Nam")?true:false);
                user.setPhone(request.getParameter("phone"));
                user.setEmail(request.getParameter("email"));
                user.setAddress(request.getParameter("address"));
                user.setCompany(request.getParameter("email"));
                user.setAddress(request.getParameter("address"));
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   //get current date time with Date()
                Date date = new Date();
	   //System.out.println(dateFormat.format(date));
                user.setDateCreation(date);
                user.setRoleId("2");
                UserBO userBO = new UserBO();
                boolean isCreated=false;
                isCreated=userBO.createNewUser(user);
                out.println(isCreated);
                if(isCreated==true) {
                response.sendRedirect("./jsp/RegisterSuccessed.jsp");
                }
                else {
                response.sendRedirect("./jsp/RegisterFailed.jsp");
            }      
                
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
