/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bo.TourBO;
import bo.TourProgramBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.TourBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AT
 */
public class EditTourServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                TourBean tour=new TourBean();
                out.println(request.getParameter("tourid"));
                tour.setTourId(request.getParameter("tourid"));
                out.println(request.getParameter("tourprogramid"));
                TourProgramBO tourprogramBO=new TourProgramBO();
                tour.setTourProgram(tourprogramBO.isExist(request.getParameter("tourprogramid")));
                out.println(tour.getTourProgram().getTourProgramName());
                tour.setStartplace(request.getParameter("startplace"));
                out.println(request.getParameter("startplace"));
                tour.setStartdate(new Date(request.getParameter("year")+"/"+request.getParameter("month")+"/"+request.getParameter("date")));
                out.println(tour.getStartdate());
                tour.setEndplace(request.getParameter("endplace"));
                out.println(request.getParameter("endplace"));
                tour.setMaxpeople(Integer.parseInt(request.getParameter("maxpeople")));
                out.println(request.getParameter("maxpeople"));
                tour.setBasiccharge(Long.parseLong(request.getParameter("basiccharge")));
                out.println(request.getParameter("basiccharge"));
                tour.setSurcharge(Long.parseLong(request.getParameter("surcharge")));
                out.println(request.getParameter("surcharge"));
                tour.setAirportcharge(Long.parseLong(request.getParameter("airportcharge")));
                out.println(request.getParameter("airportcharge"));
                tour.setInfantcharge(Long.parseLong(request.getParameter("infantcharge")));
                out.println(request.getParameter("infantcharge"));
                tour.setKidcharge(Long.parseLong(request.getParameter("kidcharge")));
                out.println(request.getParameter("kidcharge"));
                tour.setSingleroomsurcharge(Long.parseLong(request.getParameter("singleroomsurcharge")));
                out.println(request.getParameter("singleroomsurcharge"));
                tour.setVisasurcharge(Long.parseLong(request.getParameter("visasurcharge")));
                out.println(request.getParameter("visasurcharge"));
                
                TourBO tourBO=new TourBO();
                boolean isCreated=false;
                isCreated=tourBO.updateSpecifiedTour(tour);
                out.println(isCreated);
                if(isCreated==true) {
                response.sendRedirect("./jsp/ListTour.jsp");
                }
                else {
                response.sendRedirect("./jsp/EditTour.jsp?id="+tour.getTourId());
            }      
                
            
        } catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(EditTourServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditTourServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditTourServlet.class.getName()).log(Level.SEVERE, null, ex);
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
