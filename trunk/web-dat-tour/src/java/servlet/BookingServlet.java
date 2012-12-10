/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bo.TourBO;
import bo.TourContactBO;
import bo.TravellerBO;
import bo.UserBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.TourContactBean;
import javabean.TravellerBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AT
 */
public class BookingServlet extends HttpServlet {

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
            TourContactBean tourcontact=new TourContactBean();
            TourBO tourBO=new TourBO();
            tourcontact.setTour(tourBO.isExist(request.getParameter("tourid")));
            out.println(request.getParameter("tourid"));
            UserBO userBO=new UserBO();
            tourcontact.setUserName(userBO.isExist(request.getParameter("username").trim()));
            out.println(tourcontact.getUserName().getUserName());
            TravellerBean traveller=new TravellerBean();
            TravellerBO travellerBO=new TravellerBO();
            traveller.setTravellerId(request.getParameter("travellerid"));
            out.println(request.getParameter("travellerid"));
            traveller.setName(request.getParameter("name"));
            out.println(request.getParameter("name"));
            traveller.setBirthday(new Date(request.getParameter("year")+"/"+request.getParameter("month")+"/"+request.getParameter("date")));
            out.println(request.getParameter("year"));
            out.println(request.getParameter("month"));
            out.println(request.getParameter("date"));
            traveller.setGender(request.getParameter("gender").equals("Nam"));
            out.println(request.getParameter("gender"));
            out.println(request.getParameter("singleroom").equals("Có"));
            traveller.setSingleRoom(request.getParameter("singleroom").equals("Có"));
            traveller.setAddress(request.getParameter("address"));
            traveller.setClientType(request.getParameter("clienttype"));
            out.println(request.getParameter("clienttype"));            
            String tourcontactid=request.getParameter("tourcontact");
            out.println(request.getParameter("tourcontact"));
            boolean CreateTraveller=travellerBO.createNewTraveller(traveller);
            out.println(CreateTraveller);
            if(CreateTraveller)
            {
                TourContactBO tourcontactBO=new TourContactBO();
                tourcontact.setTourContactId(tourcontactid);
                tourcontact.setTraveller(traveller);
                tourcontact.setPayment(request.getParameter("payment"));
                tourcontact.setAssignDate(new Date());
                boolean CreateTourContact=tourcontactBO.createNewTourContact(tourcontact);
                if(CreateTourContact)
                {
                    response.sendRedirect("./jsp/BookingSuccessed.jsp?id="+tourcontactid);
                }
                else
                {
                    out.print("That bái");
                }
            }
            else
            {
                out.print("Khong  them traveller dc");
            }
        }catch (Exception ex) {
            out.println(ex.getMessage());
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
