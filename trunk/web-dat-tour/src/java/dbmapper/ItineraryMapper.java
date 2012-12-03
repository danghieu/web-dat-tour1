/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.ItineraryBean;

/**
 *
 * @author AT
 */
public class ItineraryMapper extends DBMapper{
    public ItineraryBean isExist(String tourprogramid, int day) throws SQLException
    {
        ItineraryBean itinerary=null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Itinerary` WHERE tourprogramid='"+tourprogramid+"' AND day='"
                +day+ "'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            itinerary = new ItineraryBean();
            itinerary.setTourProgramId(rs.getString("tourprogramid"));
            itinerary.setDay(rs.getInt("day"));
            itinerary.setDetail(rs.getString("detail"));
            itinerary.setImage(rs.getString("image"));
        }        
        return itinerary;
    }
    
    public boolean createNewItinerary(ItineraryBean itinerary) throws SQLException
    {
        Statement st = con.createStatement();
        String sqlStr;
        ItineraryBean iti = isExist(itinerary.getTourProgramId(),itinerary.getDay());
        if (iti !=null) {
            return false;
        }
        sqlStr = "insert into [itinerary](tourprogramid,day,detail,image)"
                + " values('"+itinerary.getTourProgramId()+"','"+itinerary.getDay()+"','"
                +itinerary.getDetail()+"','"+itinerary.getImage()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedItinerary(ItineraryBean iti) throws SQLException
    {
        Statement st = con.createStatement();
        String sqlStr;
        ItineraryBean iti2 = isExist(iti.getTourProgramId(),iti.getDay());
        if (iti2 ==null) {
            return false;
        }
        sqlStr = "UPDATE [itinerary] set `detail`='"+iti.getDetail()+
                "', `image`='"+iti.getImage() + " WHERE `tourprogramid`='"+
                iti.getTourProgramId()+"' AND `day`='"+iti.getDay()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedItinerary(String tourprogramid) throws SQLException
    {
        Statement st = con.createStatement();
        String sqlStr;
        ItineraryBean iti2 = isExist(tourprogramid,1);
        if (iti2 ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [itinerary] WHERE `tourprogramid`='"+tourprogramid+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<ItineraryBean> listAllItineraries() throws SQLException
    {
        ArrayList listOfItineraries = new ArrayList<ItineraryBean>();
        ItineraryBean iti=null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `itinerary`";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            iti = new ItineraryBean();
            iti.setTourProgramId(rs.getString("tourprogram"));
            iti.setDay(rs.getInt("day"));
            iti.setDetail(rs.getString("detail"));
            iti.setImage(rs.getString("image"));
        }
        return listOfItineraries;
    }
    
    public ArrayList<ItineraryBean> listSpecifiedtinerary(String tourprogramid) throws SQLException
    {
        ArrayList listOfItineraries = new ArrayList<ItineraryBean>();
        ItineraryBean iti=null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `itinerary` WHERE `tourprogramid`='"+tourprogramid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            iti = new ItineraryBean();
            iti.setTourProgramId(rs.getString("tourprogramid"));
            iti.setDay(rs.getInt("day"));
            iti.setDetail(rs.getString("detail"));
            iti.setImage(rs.getString("image"));
        }
        return listOfItineraries;
    }
    
    }