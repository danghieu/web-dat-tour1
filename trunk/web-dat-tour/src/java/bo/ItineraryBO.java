/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.ItineraryMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.ItineraryBean;

/**
 *
 * @author AT
 */
public class ItineraryBO {
    public ItineraryBean isExist(ItineraryBean iti) throws Exception
    {
        ItineraryMapper itiMapper=new ItineraryMapper();
        ItineraryBean iti2=null;
        try {
            iti2 = itiMapper.isExist(iti);
        } catch (SQLException ex) {
            Logger.getLogger(ItineraryBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            itiMapper.con.close();
        }
        return iti2;        
    }
    
    public boolean createNewItinerary(ItineraryBean itinerary) throws Exception
    {
        ItineraryMapper itiMapper=new ItineraryMapper();
        boolean isCreated=itiMapper.createNewItinerary(itinerary);
        return isCreated;
    }
    
    public boolean updateSpecifiedItinerary(ItineraryBean iti) throws Exception
    {
        ItineraryMapper itiMapper=new ItineraryMapper();
        boolean isUpdated=itiMapper.updateSpecifiedItinerary(iti);
        return isUpdated;
    }
    
    public boolean deleteSpecifiedItinerary(String tourprogramid) throws Exception
    {
        ItineraryMapper itiMapper=new ItineraryMapper();
        boolean isDeleted=itiMapper.deleteSpecifiedItinerary(tourprogramid);
        return isDeleted;
    }
    
    public ArrayList<ItineraryBean> listAllItineraries() throws Exception
    {
        ItineraryMapper itiMapper = new ItineraryMapper();
        ArrayList listOfItineraries = null;
        try {
            listOfItineraries = itiMapper.listAllItineraries();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            itiMapper.con.close();
        }
        return listOfItineraries;
    }
    
    public ArrayList<ItineraryBean> listSpecifiedtinerary(String tourprogramid) throws Exception
    {
        ItineraryMapper itiMapper = new ItineraryMapper();
        ArrayList listOfItineraries = null;
        try {
            listOfItineraries = itiMapper.listSpecifiedtinerary(tourprogramid);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            itiMapper.con.close();
        }
        return listOfItineraries;
    }
}
