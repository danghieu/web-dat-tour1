/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.TravellerMapper;
import dbmapper.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import javabean.TravellerBean;

/**
 *
 * @author AT
 */
public class TravellerBO {
    public String getTravllerId() throws SQLException
    {
        TravellerMapper travellerMapper = new TravellerMapper();
        return travellerMapper.getTravellerId();
    }
    
    public TravellerBean isExist(String travellerid) throws Exception {
        TravellerMapper travellerMapper = new TravellerMapper();
        TravellerBean traveller = null;
        try {
            traveller = travellerMapper.isExist(travellerid);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            travellerMapper.con.close();
        }
        return traveller;
    }
    
    public boolean createNewTraveller(TravellerBean traveller) throws Exception {
        TravellerMapper travellerMapper=new TravellerMapper();
        boolean isCreated=travellerMapper.createNewTraveller(traveller);
        return isCreated;
    }
    
    public boolean deleteSpecifiedTraveller(TravellerBean traveller) throws Exception {
        TravellerMapper travellerMapper=new TravellerMapper();
        boolean isDeleted=travellerMapper.deleteSpecifiedTraveller(traveller);
        return isDeleted;
    }
    
    public boolean updateSpecifiedTraveller(TravellerBean traveller) throws Exception {
        TravellerMapper travellerMapper=new TravellerMapper();
        boolean isDeleted=travellerMapper.deleteSpecifiedTraveller(traveller);
        return isDeleted;
    }
    
    public ArrayList<TravellerBean> listOfTraveller()throws Exception
    {
        TravellerMapper travellerMapper = new TravellerMapper();
        ArrayList listOfTravellers = null;
        try {
            listOfTravellers = travellerMapper.listOfTraveller();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            travellerMapper.con.close();
        }
        return listOfTravellers;
    }
    
    public ArrayList<TravellerBean> searchTraveller(String Name)throws Exception
    {
        TravellerMapper travellerMapper = new TravellerMapper();
        ArrayList listOfTravellers = null;
        try {
            listOfTravellers = travellerMapper.searchTraveller(Name);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            travellerMapper.con.close();
        }
        return listOfTravellers;
    }
    
}
