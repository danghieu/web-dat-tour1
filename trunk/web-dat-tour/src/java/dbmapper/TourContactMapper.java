/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.TourContactBean;

/**
 *
 * @author AT
 */
public class TourContactMapper extends DBMapper{
    public TourContactBean isExist(String tourcontactid) throws Exception {
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `tourcontact` WHERE `tourcontactid`='"+tourcontactid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            TourMapper tourMapper=new TourMapper();
            tourcontact.setTour(tourMapper.isExist(rs.getString("tourid")));
            TravellerMapper travellerMapper=new TravellerMapper();
            tourcontact.setTraveller(travellerMapper.isExist(rs.getString("travellerid")));
            UserMapper userMapper=new UserMapper();
            tourcontact.setUserName(userMapper.isExist(rs.getString("username")));
        }
        return tourcontact;
    }
    
    public boolean createNewTourContact(TourContactBean tourcontact) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourContactBean tourcontacttemp = isExist(tourcontact.getTourContactId());
        if (tourcontacttemp !=null) {
            return false;
        }
        sqlStr = "insert into [tourcontact](tourcontactid,assigndate,tourid,travellerid"
                + ",username)"+ " values('"+tourcontact.getTourContactId()+"','"+tourcontact.getAssignDate()+"','"
                +tourcontact.getTour().getTourId()+"','"+tourcontact.getTraveller().getTravellerId()
                +"','"+tourcontact.getUserName().getUserName()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteTourContact(TourContactBean tourcontact) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourContactBean tourcontacttemp = isExist(tourcontact.getTourContactId());
        if (tourcontacttemp !=null) {
            return false;
        }
        sqlStr = "DELETE FROM `tourcontact` WHERE `tourcontactid`='"+tourcontact.getTourContactId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateTourContact(TourContactBean tourcontact) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourContactBean tourcontacttemp = isExist(tourcontact.getTourContactId());
        if (tourcontacttemp !=null) {
            return false;
        }
        sqlStr = "UPDATE [tourcontact] set `assigndate`='"+tourcontact.getAssignDate()+"', `tourid`='"
                +tourcontact.getTour().getTourId()+"', `travellerid`='"+tourcontact.getTraveller().getTravellerId()
                +"', `username`='"+tourcontact.getUserName().getUserName()+"'  WHERE `tourcontactid`='"
                +tourcontact.getTourContactId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TourContactBean> listOfTourContact() throws Exception
    {
        ArrayList listOfTourContact = new ArrayList<TourContactBean>();
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `tourcontact`";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            TourMapper tourMapper=new TourMapper();
            tourcontact.setTour(tourMapper.isExist(rs.getString("tourid")));
            TravellerMapper travellerMapper=new TravellerMapper();
            tourcontact.setTraveller(travellerMapper.isExist(rs.getString("travellerid")));
            UserMapper userMapper=new UserMapper();
            tourcontact.setUserName(userMapper.isExist(rs.getString("username")));
            listOfTourContact.add(tourcontact);
        }
        return listOfTourContact;
    }
    
    public ArrayList<TourContactBean> searchTourContact(String tourcontactid) throws Exception
    {
        ArrayList listOfTourContact = new ArrayList<TourContactBean>();
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `tourcontact` WHERE `tourcontactid`="+tourcontactid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            TourMapper tourMapper=new TourMapper();
            tourcontact.setTour(tourMapper.isExist(rs.getString("tourid")));
            TravellerMapper travellerMapper=new TravellerMapper();
            tourcontact.setTraveller(travellerMapper.isExist(rs.getString("travellerid")));
            UserMapper userMapper=new UserMapper();
            tourcontact.setUserName(userMapper.isExist(rs.getString("username")));
            listOfTourContact.add(tourcontact);
        }
        return listOfTourContact;
    }
}
