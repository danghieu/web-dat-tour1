/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bo.TourProgramBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.TourProgramBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AT
 */
public class CreateTourProgramServlet extends HttpServlet {

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
                TourProgramBean tourprogram=new TourProgramBean();
                out.println(request.getParameter("tourprogramid"));
                tourprogram.setTourProgramId(request.getParameter("tourprogramid"));
                tourprogram.setTourProgramName(request.getParameter("tourprogramname"));
                tourprogram.setTransportation(request.getParameter("transportation"));
                tourprogram.setNotice(request.getParameter("notice"));
                tourprogram.setInclude(request.getParameter("include"));
                tourprogram.setExclude(request.getParameter("exclude"));
                tourprogram.setPaymentCondition(request.getParameter("paymentcondition"));
                tourprogram.setImage(request.getParameter("image"));
                tourprogram.setItinerary(request.getParameter("itinerary"));
                
                TourProgramBO tourprogramBO=new TourProgramBO();
                boolean isCreated=false;
                isCreated=tourprogramBO.createNewTourProgram(tourprogram);
                out.println(isCreated);
                if(isCreated==true) {
                response.sendRedirect("./jsp/ListTourProgram.jsp");
                }
                else {
                    HttpSession session = request.getSession();
                    session.setAttribute("tourprogram", tourprogram);
                    session.setAttribute("loi", "Mã chương trình tour đã tồn tại");
                response.sendRedirect("./jsp/CreateTourProgram.jsp");
            }      
                
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(CreateTourProgramServlet.class.getName()).log(Level.SEVERE, null, ex);
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
