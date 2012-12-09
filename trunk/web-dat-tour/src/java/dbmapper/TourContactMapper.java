/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import bo.TourBO;
import bo.TravellerBO;
import bo.UserBO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javabean.TourContactBean;

/**
 *
 * @author AT
 */
public class TourContactMapper extends DBMapper{
    
    
    public String getTourContactId() throws SQLException
    {
        Calendar toDay = Calendar.getInstance();
        int year = toDay.get(Calendar.YEAR);
        String Value=removeCharAt(removeCharAt(String.valueOf(year),0),0);
        String lastID = GetTopDataCell("TourContact","tourcontactid","tourcontactid");
        String nextID = NextID(lastID,"TC"+Value); 
        return nextID;
    }
    
    public TourContactBean isExist(String id) throws Exception {
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [TourContact] WHERE tourcontactid='"+id+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("TourContactId"));
            tourcontact.setAssignDate(rs.getDate("AssignDate"));
            TourBO tour=new TourBO();
            tourcontact.setTour(tour.isExist(rs.getString("TourId")));
            TravellerBO traveller=new TravellerBO();
            System.out.print(rs.getString("TravellerId"));
            tourcontact.setTraveller(traveller.isExist(rs.getString("TravellerId")));
            tourcontact.setPayment(rs.getString("Payment"));
            UserBO userBO=new UserBO();
            tourcontact.setUserName(userBO.isExist("username"));
                    
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
        DateFormat formatter ; 
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String assigndate = formatter.format(tourcontact.getAssignDate());
        sqlStr = "INSERT INTO [TourContact]"
     +"VALUES"
           +"('"+tourcontact.getTourContactId()
           +"','"+assigndate
           +"','"+tourcontact.getTraveller().getTravellerId()
           +"','"+tourcontact.getUserName().getUserName()
           +"','"+tourcontact.getTour().getTourId()+"',N'"+tourcontact.getPayment()+"');";
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
        sqlStr = "DELETE FROM tourcontact WHERE tourcontactid='"+tourcontact.getTourContactId()+"'";
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
        sqlStr = "UPDATE [tourcontact] set assigndate='"+tourcontact.getAssignDate()+"', tourid=N'"
                +tourcontact.getTour().getTourId()+"', travellerid=N'"+tourcontact.getTraveller().getTravellerId()
                +"', username=N'"+tourcontact.getUserName().getUserName()+"'  WHERE tourcontactid='"
                +tourcontact.getTourContactId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TourContactBean> listOfTourContact() throws Exception
    {
        ArrayList listOfTourContact = new ArrayList<TourContactBean>();
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM tourcontact";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            tourcontact.setPayment(rs.getString("payment"));
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
        String sqlStr="SELECT * FROM tourcontact WHERE tourcontactid="+tourcontactid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            tourcontact.setPayment(rs.getString("payment"));
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
    
    public ArrayList<TourContactBean> searchTourid(String tourid) throws Exception
    {
        ArrayList listOfTourContact = new ArrayList<TourContactBean>();
        TourContactBean tourcontact = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM tourcontact WHERE tourid='"+tourid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            tourcontact = new TourContactBean();
            tourcontact.setTourContactId(rs.getString("tourcontactid"));
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   //Date date = new Date();
	   //System.out.println(dateFormat.format(date));
            tourcontact.setAssignDate(rs.getDate("assigndate"));
            tourcontact.setPayment(rs.getString("payment"));
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
