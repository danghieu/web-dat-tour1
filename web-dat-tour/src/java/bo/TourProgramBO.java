/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.ItineraryMapper;
import dbmapper.TourProgramMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.TourProgramBean;

/**
 *
 * @author AT
 */
public class TourProgramBO {
    public TourProgramBean isExist(String tourprogramid, String tourprogramname) throws Exception{
        TourProgramMapper tourProgramMapper=new TourProgramMapper();
        TourProgramBean tourprogram=null;
        try {
            tourprogram = tourProgramMapper.isExist(tourprogramid,tourprogramname);
        } catch (SQLException ex) {
            Logger.getLogger(ItineraryBO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            tourProgramMapper.con.close();
        }
        return tourprogram;  
    }
    
    public boolean createNewTourProgram(TourProgramBean tourprogram)throws Exception
    {
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        boolean isCreated=tourprogramMapper.createNewTourProgram(tourprogram);
        return isCreated;    
    }
    
    public boolean updateSpecifiedTourProgram(TourProgramBean tourprogram)throws Exception
    {
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        boolean isUpdated=tourprogramMapper.updateSpecifiedTourProgram(tourprogram);
        return isUpdated;
    }
    
    public boolean deleteSpecifiedTourProgram(String tourprogramid)throws Exception
    {
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        boolean isDeleted=tourprogramMapper.deleteSpecifiedTourProgram(tourprogramid);
        return isDeleted;
    }
    
    public ArrayList<TourProgramBean> listAllTourProgram() throws Exception {
        TourProgramMapper tourprogramMapper=new TourProgramMapper();
        ArrayList listOfTourPrograms = null;
        try {
            listOfTourPrograms = tourprogramMapper.listAllTourProgram();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourprogramMapper.con.close();
        }
        return listOfTourPrograms;
    }
}
