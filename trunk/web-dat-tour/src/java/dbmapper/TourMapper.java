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
import javabean.SearchBean;
import javabean.TourBean;
import javabean.TourProgramBean;

/**
 *
 * @author AT
 */
public class TourMapper extends DBMapper{
    
    public String getTourId() throws SQLException
    {
        Calendar toDay = Calendar.getInstance();
        int year = toDay.get(Calendar.YEAR);
        String Value=removeCharAt(removeCharAt(String.valueOf(year),0),0);
        String lastID = GetTopDataCell("[Tour]","tourid","tourid");
        String nextID = NextID(lastID,"TO"+Value); 
        return nextID;
    }
    
    public TourBean isExist(String tourid) throws Exception
    {
        TourBean tour= null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Tour WHERE TourId='"+tourid+"';";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("tourid"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid")));
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
        TourProgramBean tourprogramBean= tourprogramMapper.isExist(tour.getTourProgram().getTourProgramId());
        if (tourBean !=null || tourprogramBean==null) {
            return false;
        }
        DateFormat formatter ; 
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String start = formatter.format(tour.getStartdate());
        sqlStr = "INSERT INTO [Tour]"
           +"([TourId]"
           +",[TourProgramId]"
           +",[StartDate]"
           +",[StartPlace]"
           +",[EndPlace]"
           +",[Maxpeople]"
           +",[BasicCharge]"
           +",[SurCharge]"
           +",[AirportCharge]"
           +",[SingleRoomSurCharge]"
           +",[VisaSurCharge]"
           +",[KidCharge]"
           +",[InfantCharge])"
     +"VALUES"
           +"('"+tour.getTourId()
           +"','"+tour.getTourProgram().getTourProgramId()
           +"','"+start
           +"',N'"+tour.getStartplace()
           +"',N'"+tour.getEndplace()
           +"',"+tour.getMaxpeople()
           +","+tour.getBasiccharge()
           +","+tour.getSurcharge()
           +","+tour.getAirportcharge()
           +","+tour.getSingleroomsurcharge()
           +","+tour.getVisasurcharge()
           +","+tour.getKidcharge()
           +","+tour.getInfantcharge()+")";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedTour(TourBean tour) throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourBean tourBean = isExist(tour.getTourId());
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        TourProgramBean tourprogramBean= tourprogramMapper.isExist(tour.getTourProgram().getTourProgramId());
        if (tourBean == null || tourprogramBean ==null) {
            return false;
        }
        DateFormat formatter ; 
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String start = formatter.format(tour.getStartdate());
        sqlStr = "UPDATE [tour] set tourprogramid='"+tour.getTourProgram().getTourProgramId()+"', startdate='"+start+
                "', startplace=N'"+tour.getStartplace() + "', endplace=N'"+tour.getEndplace() +
                 "', maxpeople='"+tour.getMaxpeople() +"', basiccharge="+tour.getBasiccharge() +
                ", surcharge="+tour.getSurcharge() + ", airportcharge="+tour.getAirportcharge() +
                 ", singleroomsurcharge="+tour.getSingleroomsurcharge() +", visasurcharge="+tour.getVisasurcharge() +
                 ", kidcharge="+tour.getKidcharge() +", infantcharge="+tour.getInfantcharge() +" WHERE tourid='"+
                tour.getTourId()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedTour(String tourid)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        TourBean temp = isExist(tourid);
        if (temp ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [tour] WHERE tourid='"+tourid+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<TourBean> listAllTour() throws Exception {
        ArrayList listOfTours = new ArrayList<TourBean>();
        TourBean tour = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Tour";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("tourid"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid")));
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
        DateFormat formatter ; 
         formatter = new SimpleDateFormat("dd/MM/yyyy");  
         String start = formatter.format(toursearch.getStartDate());
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Tour WHERE "
                +"startdate='"+start+"' and startplace like N'"
                + toursearch.getStartPlace()+"' and endplace like N'"+ toursearch.getEndPlace()+"' and basiccharge>="+toursearch.getChargeFrom()+" and basiccharge<"+toursearch.getChargeTo();
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            tour = new TourBean();
            tour.setTourId(rs.getString("tourid"));
            TourProgramMapper tourprogramMapper=new TourProgramMapper();
            tour.setTourProgram(tourprogramMapper.isExist(rs.getString("tourprogramid")));
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
    
    public ArrayList list(String column) throws Exception {
        ArrayList listOfTourPrograms = new ArrayList();
        Statement st = con.createStatement();
        String sqlStr="SELECT DISTINCT "+column+" FROM Tour";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            String a= rs.getString(column);
            listOfTourPrograms.add(a);
        }
        
        return listOfTourPrograms;
    }
    
    public int freeseats(String tour)throws Exception 
    {
        Statement st = con.createStatement();
        String sqlStr="SELECT count(tourid) FROM TourContact Where tourid='"+tour+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        int freeseats=0;
        TourBean tourBean=isExist(tour);
        if (rs != null && rs.next()) {
            freeseats= tourBean.getMaxpeople()- Integer.parseInt(rs.getString(1));
        }
        return freeseats;
    }
}
