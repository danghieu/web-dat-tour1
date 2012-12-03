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
            tourprogram.setItineraries(null);
                    
        }
        
        return tourprogram;
    }
    
}
