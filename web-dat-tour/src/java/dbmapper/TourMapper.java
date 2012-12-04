/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.SearchBean;
import javabean.TourBean;
import javabean.TourProgramBean;

/**
 *
 * @author AT
 */
public class TourMapper extends DBMapper{
    public TourBean isExist(String tourid) throws Exception
    {
        TourBean tour= null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Tour`,`TourProgram` WHERE TourId='"+tourid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("TourId"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid"), "0"));
            tour.setStartdate(rs.getDate("StartDate"));
            tour.setStartplace(rs.getString("StartPlace"));
            tour.setEndplace(rs.getString("EndPlace"));
            tour.setMaxpeople(rs.getInt("Maxpeople"));
            tour.setBasiccharge(rs.getLong("BasicCharge"));
            tour.setSurcharge(rs.getLong("SurCharge"));
            tour.setAirportcharge(rs.getLong("AirportCharge"));
            tour.setSingleroomsurcharge(rs.getLong("SingleRoomSurCharge"));
            tour.setVisasurcharge(rs.getLong("VisaSurCharge"));
            tour.setKidcharge(rs.getLong("KidCharge"));
            tour.setInfantcharge(rs.getLong("InfantCharge"));
        }
        
        return tour;
    }
    
    public boolean createNewTour(TourBean tour) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourBean tourBean = isExist(tour.getTourId());
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        TourProgramBean tourprogramBean= tourprogramMapper.isExist(tour.getTourProgram().getTourProgramId(), "");
        if (tourBean !=null || tourprogramBean!=null) {
            return false;
        }
        sqlStr = "insert into [tour](tourid,tourprogramid,startdate, startplace, endplace, maxpeople, basiccharge, surcharge,"
                + " airportcharge, singleroomsurcharge, visasurcharge, kidcharge, infantcharge)"
                + " values('"+tour.getTourId()+"','"+tour.getTourProgram().getTourProgramId()+"','"
                +tour.getStartdate()+"','"+tour.getStartplace()+"','"+tour.getEndplace()+"','"+tour.getMaxpeople()
                +tour.getBasiccharge()+"','"+tour.getSurcharge()+"','"+tour.getAirportcharge()+"','"+tour.getSingleroomsurcharge()
                +"','"+tour.getVisasurcharge()+"','"+tour.getKidcharge()+"','"+tour.getInfantcharge()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTour(TourBean tour) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourBean tourBean = isExist(tour.getTourId());
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        TourProgramBean tourprogramBean= tourprogramMapper.isExist(tour.getTourProgram().getTourProgramId(), "");
        if (tourBean !=null || tourprogramBean!=null) {
            return false;
        }
        sqlStr = "UPDATE [tour] set `startdate`='"+tour.getStartdate()+
                "', `startplace`='"+tour.getStartplace() + "', `endplace`='"+tour.getEndplace() +
                 "', `maxpeople`='"+tour.getMaxpeople() +"', `basiccharge`='"+tour.getBasiccharge() +
                "', `surcharge`='"+tour.getSurcharge() + "', `airportcharge`='"+tour.getAirportcharge() +
                 "', `singleroomsurcharge`='"+tour.getSingleroomsurcharge() +"', `visasurcharge`='"+tour.getVisasurcharge() +
                 "', `kidcharge`='"+tour.getKidcharge() +"', `infantcharge`='"+tour.getInfantcharge() +" WHERE `tourid`='"+
                tour.getTourId()+"' and `tourprogramid`='"+tour.getTourProgram().getTourProgramId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedTour(String tourid)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourBean temp = isExist(tourid);
        if (temp !=null) {
            return false;
        }
        sqlStr = "DELETE FROM [tour] WHERE `tourpid`='"+tourid+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TourBean> listAllTour() throws Exception {
        ArrayList listOfTours = new ArrayList<TourBean>();
        TourBean tour = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Tour`";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("tourid"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid"), ""));
            tour.setStartdate(rs.getDate("startdate"));
            tour.setStartplace(rs.getString("startplace"));
            tour.setEndplace(rs.getString("endplace"));
            tour.setMaxpeople(rs.getInt("maxpeople"));
            tour.setBasiccharge(rs.getLong("basiccharge"));
            tour.setSurcharge(rs.getLong("SurCharge"));
            tour.setAirportcharge(rs.getLong("AirportCharge"));
            tour.setSingleroomsurcharge(rs.getLong("SingleRoomSurCharge"));
            tour.setVisasurcharge(rs.getLong("VisaSurCharge"));
            tour.setKidcharge(rs.getLong("KidCharge"));
            tour.setInfantcharge(rs.getLong("InfantCharge"));
            listOfTours.add(tour);
        }
        return listOfTours;
    }
    
    public ArrayList<TourBean> searchTour(SearchBean toursearch) throws Exception {
        ArrayList listOfTours = new ArrayList<TourBean>();
        TourBean tour = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `Tour`, `TourProgram` WHERE `tour`.`tourprogramid`=`tourprogram`.`tourprogramid`"
                + " and `tourprogramname`='%"+toursearch.getTourName()+"%' and `startdate`="+toursearch.getStartDate()+"' and `startplace`='"
                + toursearch.getStartPlace()+"' and `basiccharge`>="+toursearch.getChargeFrom()+" and `basiccharge`<="+toursearch.getChargeTo();
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("tourid"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid"), ""));
            tour.setStartdate(rs.getDate("startdate"));
            tour.setStartplace(rs.getString("startplace"));
            tour.setEndplace(rs.getString("endplace"));
            tour.setMaxpeople(rs.getInt("maxpeople"));
            tour.setBasiccharge(rs.getLong("basiccharge"));
            tour.setSurcharge(rs.getLong("SurCharge"));
            tour.setAirportcharge(rs.getLong("AirportCharge"));
            tour.setSingleroomsurcharge(rs.getLong("SingleRoomSurCharge"));
            tour.setVisasurcharge(rs.getLong("VisaSurCharge"));
            tour.setKidcharge(rs.getLong("KidCharge"));
            tour.setInfantcharge(rs.getLong("InfantCharge"));
            listOfTours.add(tour);
        }
        return listOfTours;
    }
}
