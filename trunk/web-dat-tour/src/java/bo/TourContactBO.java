/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.TourContactMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import javabean.TourContactBean;

/**
 *
 * @author AT
 */
public class TourContactBO {
    
    public long Total(TourContactBean tourcontact )
    {
        long total=0;
        if(tourcontact.getTraveller().getClientType().equals("Người lớn"))
            total+=tourcontact.getTour().getBasiccharge();
        if(tourcontact.getTraveller().getClientType().equals("Trẻ em"))
            total+=tourcontact.getTour().getKidcharge();
        if(tourcontact.getTraveller().getClientType().equals("Trẻ nhỏ"))
            total+=tourcontact.getTour().getInfantcharge();
        if(tourcontact.getTraveller().getSingleRoom())
            total+=tourcontact.getTour().getSingleroomsurcharge();
        total+=tourcontact.getTour().getAirportcharge()+tourcontact.getTour().getSurcharge()+tourcontact.getTour().getVisasurcharge();
        return total;
    }
    
    public String getTourContactId() throws SQLException
    {
        TourContactMapper tourcontactMapper=new TourContactMapper();
        return tourcontactMapper.getTourContactId();
    }
    
    public TourContactBean isExist(String tourcontactid) throws Exception {
        TourContactMapper tourcontactMapper = new TourContactMapper();
        TourContactBean tourcontact = null;
        try {
            tourcontact = tourcontactMapper.isExist(tourcontactid);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourcontactMapper.con.close();
        }
        return tourcontact;
    }
    
    public boolean createNewTourContact(TourContactBean tourcontact) throws Exception
    {
        TourContactMapper tourcontactMapper=new TourContactMapper();
        boolean isCreated=tourcontactMapper.createNewTourContact(tourcontact);
        return isCreated;
    }
    
    public boolean deleteSpecifiedTourContact(TourContactBean tourcontact) throws Exception
    {
        TourContactMapper tourcontactMapper=new TourContactMapper();
        boolean isDeleted=tourcontactMapper.deleteTourContact(tourcontact);
        return isDeleted;
    }
    
    public boolean updateTourContact(TourContactBean tourcontact) throws Exception
    {
        TourContactMapper tourcontactMapper=new TourContactMapper();
        boolean isUpdated=tourcontactMapper.updateTourContact(tourcontact);
        return isUpdated;
    }
    
    public ArrayList<TourContactBean> searchTourContact(String tourcontact) throws Exception
    {
        TourContactMapper tourcontactMapper = new TourContactMapper();
        ArrayList listOfTourcontacts = null;
        try {
            listOfTourcontacts = tourcontactMapper.searchTourContact(tourcontact);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourcontactMapper.con.close();
        }
        return listOfTourcontacts;
    }
    
    public ArrayList<TourContactBean> searchTourid(String tourcontact) throws Exception
    {
        TourContactMapper tourcontactMapper = new TourContactMapper();
        ArrayList listOfTourcontacts = null;
        try {
            listOfTourcontacts = tourcontactMapper.searchTourid(tourcontact);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourcontactMapper.con.close();
        }
        return listOfTourcontacts;
    }
    
    
}
