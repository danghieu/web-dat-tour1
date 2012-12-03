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
import javabean.TourProgramBean;
/**
 *
 * @author AT
 */
public class TourProgramMapper extends DBMapper{
    
    public TourProgramBean isExist(String tourprogramid, String tourprogramname) throws Exception {
        TourProgramBean tourprogram = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `TourProgram` WHERE TourProgramId='"+tourprogramid+"' OR TourProgramName='"
                +tourprogramname+ "'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tourprogram = new TourProgramBean();
            tourprogram.setTourProgramId(rs.getString("TourProgramId"));
            tourprogram.setTourProgramName(rs.getString("TourProgramName"));
            tourprogram.setTransportation(rs.getString("Transportation"));
            tourprogram.setNotice(rs.getString("Notice"));
            tourprogram.setInclude(rs.getString("Include"));
            ItineraryMapper itiMapper=new ItineraryMapper();
            tourprogram.setItineraries(itiMapper.listSpecifiedtinerary(tourprogramid));
        }
        
        return tourprogram;
    }
    
    public boolean createNewTourProgram(TourProgramBean tourprogram)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourProgramBean temp = isExist(tourprogram.getTourProgramId(),tourprogram.getTourProgramName());
        if (temp !=null) {
            return false;
        }
        sqlStr = "insert into [tourprogram](tourprogramid,tourprogramname, notice, transportation, include, exclude, paymentconditions)"
                + " values('"+tourprogram.getTourProgramId()+"','"+tourprogram.getTourProgramName()+"','"
                +tourprogram.getNotice()+"','"+tourprogram.getTransportation()
                +"','"+tourprogram.getInclude()+"','"+tourprogram.getExclude()+"','"+tourprogram.getPaymentCondition()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTourProgram(TourProgramBean tourprogram)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourProgramBean temp = isExist(tourprogram.getTourProgramId(),tourprogram.getTourProgramName());
        if (temp !=null) {
            return false;
        }
         sqlStr = "UPDATE [tourprogram] set `tourprogramname`='"+tourprogram.getTourProgramName()+
                "', `notice`='"+tourprogram.getNotice() + "', `transportation`='"+tourprogram.getTransportation() +
                 "', `include`='"+tourprogram.getInclude() +"', `exclude`='"+tourprogram.getExclude() +
                 "', `paymentconditions`='"+tourprogram.getPaymentCondition() +" WHERE `tourprogramid`='"+
                tourprogram.getTourProgramId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
}
