/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.TourProgramMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import javabean.TourProgramBean;

/**
 *
 * @author AT
 */
public class TourProgramBO {
    public String getTourProgramId() throws SQLException
    {
        TourProgramMapper tourProgramMapper=new TourProgramMapper();
        return tourProgramMapper.getTourProgramId();
    }
    
    public TourProgramBean isExist(String tourprogramid) throws Exception{
        TourProgramMapper tourProgramMapper=new TourProgramMapper();
        TourProgramBean tourprogram=null;
        tourprogram = tourProgramMapper.isExist(tourprogramid);        
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
