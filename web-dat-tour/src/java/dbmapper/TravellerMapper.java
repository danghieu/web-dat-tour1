/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javabean.TravellerBean;

/**
 *
 * @author AT
 */
public class TravellerMapper extends DBMapper{
    
    
    
    public String getTravellerId() throws SQLException
    {
        Calendar toDay = Calendar.getInstance();
        int year = toDay.get(Calendar.YEAR);
        String Value=removeCharAt(removeCharAt(String.valueOf(year),0),0);
        String lastID = GetTopDataCell("Traveller","Travellerid","Travellerid");
        String nextID = NextID(lastID,"HK"+Value); 
        return nextID;
    }
    
    public TravellerBean isExist(String travellerid) throws Exception {
        TravellerBean traveller = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [Traveller] WHERE TravellerId like'%"+travellerid+"%'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            traveller = new TravellerBean();
            traveller.setTravellerId(rs.getString("TravellerId"));
            traveller.setName(rs.getString("name"));
            traveller.setBirthday(rs.getDate("birthday"));
            traveller.setGender(rs.getBoolean("gender"));
            traveller.setAddress(rs.getString("address"));
            traveller.setSingleRoom(rs.getBoolean("singleroom"));
            traveller.setClientType(rs.getString("clienttype"));
        }
        return traveller;
    }
    
    public boolean createNewTraveller(TravellerBean traveller) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        TravellerBean travellertemp = isExist(traveller.getTravellerId());
        if (travellertemp !=null) {
            return false;
        }
        DateFormat formatter ;  
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String birthday = formatter.format(traveller.getBirthday());
        sqlStr = "INSERT INTO [web-dat-tour].[dbo].[Traveller]"
        +"VALUES"
           +"('"+traveller.getTravellerId()
           +"',N'"+traveller.getName()
           +"','"+birthday
           +"',"+(traveller.getGender()?"1":"0")
           +",N'"+traveller.getAddress()
           +"',"+(traveller.getSingleRoom()?"1":"0")
           +",N'"+traveller.getClientType()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTraveller(TravellerBean traveller) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        TravellerBean travellertemp = isExist(traveller.getTravellerId());
        if (travellertemp == null) {
            return false;
        }
        sqlStr = "UPDATE [traveller] set name=N'"+traveller.getName()+
                "', birthday='"+traveller.getBirthday() + "', gender='"+traveller.getGender() +
                 "', address=N'"+traveller.getAddress() +"', singlroom='"+traveller.getSingleRoom() +
                 "', clienttype=N'"+traveller.getClientType() +" WHERE travellerid='"+
                traveller.getTravellerId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedTraveller(TravellerBean traveller) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        TravellerBean travellertemp = isExist(traveller.getTravellerId());
        if (travellertemp ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [traveller] WHERE travellerid='"+
                traveller.getTravellerId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TravellerBean> listOfTraveller() throws Exception
    {
        ArrayList listOfTravellers = new ArrayList<TravellerBean>();
        TravellerBean traveller = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Traveller";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            traveller = new TravellerBean();
            traveller.setTravellerId(rs.getString("travellerid"));
            traveller.setName(rs.getString("name"));
            traveller.setGender(rs.getBoolean("gender"));
            traveller.setBirthday(rs.getDate("birthday"));
            traveller.setAddress(rs.getString("address"));
            traveller.setSingleRoom(rs.getBoolean("SingleRoom"));
            traveller.setClientType(rs.getString("clientype"));
            listOfTravellers.add(traveller);
        }
        
        return listOfTravellers;
    }
    
    public ArrayList<TravellerBean> searchTraveller(String Name) throws Exception
    {
        ArrayList listOfTravellers = new ArrayList<TravellerBean>();
        TravellerBean traveller = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Traveller WHERE name=N'"+Name+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            traveller = new TravellerBean();
            traveller.setTravellerId(rs.getString("travellerid"));
            traveller.setName(rs.getString("name"));
            traveller.setGender(rs.getBoolean("gender"));
            traveller.setBirthday(rs.getDate("birthday"));
            traveller.setAddress(rs.getString("address"));
            traveller.setSingleRoom(rs.getBoolean("SingleRoom"));
            traveller.setClientType(rs.getString("clientype"));
            listOfTravellers.add(traveller);
        }
        
        return listOfTravellers;
    }
    
    
}
