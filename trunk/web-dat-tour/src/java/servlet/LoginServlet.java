/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bo.UserBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.UserBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karl
 */
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                String action = request.getParameter("action");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                out.println(action);

                if (action.equals("Đăng nhập")) {                    
                    UserBO userBO = new UserBO();
                    UserBean user = userBO.isExist(username, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("userbean", user);
                    if (user == null) {
                        response.sendRedirect("./jsp/LoginFailed.jsp");
                        }
                    else {
                        response.sendRedirect("./jsp/LoginSuccessed.jsp");
                    }
                } else 
                if(action.equals("Đổi mật khẩu")){
                    response.sendRedirect("./jsp/ChangePassword.jsp");
                }else 
                if(action.equals("Đăng nhập lại")){
                    response.sendRedirect("./jsp/Login.jsp");
                }else 
                if(action.equals("Đăng ký lại")){
                    // Invoke SecondServlet's job here.
                    response.sendRedirect("./jsp/Register.jsp");
                }
                
            
        } catch (SQLException ex) {
            out.println(ex.getMessage());
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
                        processRequest(request, response);
            } catch (Exception ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
