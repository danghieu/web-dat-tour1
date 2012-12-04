/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.TravellerBean;

/**
 *
 * @author AT
 */
public class TravellerMapper extends DBMapper{
    public TravellerBean isExist(String travellerid) throws Exception {
        TravellerBean traveller = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Traveller` WHERE TravellerId='"+travellerid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            traveller = new TravellerBean();
            traveller.setTravellerId(rs.getString("travellerid"));
            traveller.setName(rs.getString("name"));
            traveller.setGender(rs.getBoolean("gender"));
            traveller.setBirthday(rs.getDate("birthday"));
            traveller.setAddress(rs.getString("address"));
            traveller.setSingleRoom(rs.getBoolean("SingleRoom"));
            traveller.setClientType(rs.getString("clientype"));
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
        sqlStr = "insert into [traveller](travellerid,name,birthday,gender"
                + ",address,singleroom,clientype)"
                + " values('"+traveller.getTravellerId()+"','"+traveller.getName()+"','"
                +traveller.getBirthday()+"','"+traveller.getGender()+"','"+traveller.getAddress()
                +"','"+(traveller.getSingleRoom()?"1":"0")+"','"+traveller.getClientType()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTraveller(TravellerBean traveller) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        TravellerBean travellertemp = isExist(traveller.getTravellerId());
        if (travellertemp !=null) {
            return false;
        }
        sqlStr = "UPDATE [traveller] set `name`='"+traveller.getName()+
                "', `birthday`='"+traveller.getBirthday() + "', `gender`='"+traveller.getGender() +
                 "', `address`='"+traveller.getAddress() +"', `singlroom`='"+traveller.getSingleRoom() +
                 "', `clienttype`='"+traveller.getClientType() +" WHERE `travellerid`='"+
                traveller.getTravellerId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedTraveller(TravellerBean traveller) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        TravellerBean travellertemp = isExist(traveller.getTravellerId());
        if (travellertemp !=null) {
            return false;
        }
        sqlStr = "DELETE FROM [traveller] WHERE `travellerid`='"+
                traveller.getTravellerId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TravellerBean> listOfTraveller() throws Exception
    {
        ArrayList listOfTravellers = new ArrayList<TravellerBean>();
        TravellerBean traveller = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Traveller`";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
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
        String sqlStr="SELECT * FROM `Traveller` WHERE `name`='"+Name+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
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
