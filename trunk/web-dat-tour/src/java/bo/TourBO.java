/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.TourMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.SearchBean;
import javabean.TourBean;

/**
 *
 * @author AT
 */
public class TourBO {
    
    public String getTouId() throws SQLException
    {
        TourMapper tourMapper=new TourMapper();
        return tourMapper.getTourId();
    }
    
    public TourBean isExist(String tourid) throws Exception
    {
        TourMapper tourMapper=new TourMapper();
        TourBean tour=null;
        tour = tourMapper.isExist(tourid);
        return tour;  
    }
    public boolean createNewTour(TourBean tour) throws Exception
    {
        TourMapper tourMapper=new TourMapper();
        boolean isCreated=tourMapper.createNewTour(tour);
        return isCreated;    
    }
    
    public boolean updateSpecifiedTour(TourBean tour) throws Exception
    {
        TourMapper tourMapper=new TourMapper();
        boolean isUpdated=tourMapper.updateSpecifiedTour(tour);
        return isUpdated;
    }
    
    public boolean deleteSpecifiedTour(String tourid)throws Exception
    {
        TourMapper tourMapper=new TourMapper();
        boolean isDeleted=tourMapper.deleteSpecifiedTour(tourid);
        return isDeleted;
    }
    public ArrayList<TourBean> listAllTour() throws Exception {
        TourMapper tourMapper=new TourMapper();
        ArrayList listOfTours = null;
        try {
            listOfTours = tourMapper.listAllTour();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourMapper.con.close();
        }
        return listOfTours;
    }
    public ArrayList<TourBean> searchTour(SearchBean toursearch) throws Exception {
        TourMapper tourMapper=new TourMapper();
        ArrayList listOfTours = null;
        try {
            listOfTours = tourMapper.searchTour(toursearch);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourMapper.con.close();
        }
        return listOfTours;
    }
    
}
