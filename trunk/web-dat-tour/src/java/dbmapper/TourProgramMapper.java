/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javabean.TourProgramBean;
/**
 *
 * @author AT
 */
public class TourProgramMapper extends DBMapper{
    
    public String getTourProgramId() throws SQLException
    {
        Calendar toDay = Calendar.getInstance();
        int year = toDay.get(Calendar.YEAR);
        String Value=removeCharAt(removeCharAt(String.valueOf(year),0),0);
        String lastID = GetTopDataCell("[TourProgram]","tourprogramid","tourprogramid");
        String nextID = NextID(lastID,"TP"+Value); 
        return nextID;
    }
    
    public TourProgramBean isExist(String tourprogramid) throws Exception {
        TourProgramBean tourprogram = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [TourProgram] WHERE TourProgramId='"+tourprogramid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourprogram = new TourProgramBean();
            tourprogram.setTourProgramId(rs.getString("TourProgramId"));
            tourprogram.setTourProgramName(rs.getString("TourProgramName"));
            tourprogram.setTransportation(rs.getString("Transportation"));
            tourprogram.setNotice(rs.getString("Notice"));
            tourprogram.setInclude(rs.getString("Include"));
            tourprogram.setExclude(rs.getString("Exclude"));
            tourprogram.setPaymentCondition(rs.getString("PaymentCondition"));
            tourprogram.setImage(rs.getString("Image"));
            tourprogram.setItinerary(rs.getString("Itinerary"));
        }
        
        return tourprogram;
    }
    
    public boolean createNewTourProgram(TourProgramBean tourprogram)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourProgramBean temp = isExist(tourprogram.getTourProgramId());
        if (temp !=null) {
            return false;
        }
        sqlStr = "INSERT INTO [TourProgram]"
           +"([TourProgramId]"
           +",[TourProgramName]"
           +",[Image]"
           +",[Itinerary]"
           +",[Notice]"
           +",[Transportation]"
           +",[Include]"
           +",[Exclude]"
           +",[PaymentCondition])"
     +"VALUES"
           +"(N'"+tourprogram.getTourProgramId()
           +"',N'"+tourprogram.getTourProgramName()
           +"',N'"+tourprogram.getImage()
           +"',N'"+tourprogram.getItinerary()
           +"',N'"+tourprogram.getNotice()
           +"',N'"+tourprogram.getTransportation()
           +"',N'"+tourprogram.getInclude()
           +"',N'"+tourprogram.getExclude()
           +"',N'"+tourprogram.getPaymentCondition()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTourProgram(TourProgramBean tourprogram)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourProgramBean temp = isExist(tourprogram.getTourProgramId());
        if (temp == null) {
            return false;
        }
         sqlStr = "UPDATE tourprogram set TourProgramName=N'"+tourprogram.getTourProgramName()+"',Image='"+tourprogram.getImage()+ "',Itinerary=N'"+
                 tourprogram.getItinerary() +"', Notice=N'"+tourprogram.getNotice()+
                 "', Transportation=N'"+tourprogram.getTransportation()+"', Include=N'" +
                 tourprogram.getInclude() +"', Exclude=N'"+tourprogram.getExclude()+
                 "', PaymentCondition=N'"+tourprogram.getPaymentCondition()+                 
                 "'  where TourProgramId='"+tourprogram.getTourProgramId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    public boolean deleteSpecifiedTourProgram(String tourprogramid)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourProgramBean temp = isExist(tourprogramid);
        if (temp ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [tourprogram] WHERE tourprogramid='"+tourprogramid+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TourProgramBean> listAllTourProgram() throws Exception {
        ArrayList listOfTourPrograms = new ArrayList<TourProgramBean>();
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM TourProgram";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            TourProgramBean tourprogram = new TourProgramBean();
            tourprogram.setTourProgramId(rs.getString("tourprogramid"));
            tourprogram.setTourProgramName(rs.getString("tourprogramname"));
            tourprogram.setNotice(rs.getString("notice"));
            tourprogram.setInclude(rs.getString("include"));
            tourprogram.setExclude(rs.getString("exclude"));
            tourprogram.setPaymentCondition(rs.getString("PaymentCondition"));             
            tourprogram.setImage(rs.getString("Image"));
            tourprogram.setItinerary(rs.getString("Itinerary"));            
            listOfTourPrograms.add(tourprogram);
        }
        
        return listOfTourPrograms;
    }
    
}
