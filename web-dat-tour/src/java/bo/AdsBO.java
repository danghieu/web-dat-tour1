/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.AdsMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import javabean.AdsBean;

/**
 *
 * @author AT
 */
public class AdsBO {
    
    public AdsBean isExist(String tourprogramid) throws Exception{
        AdsMapper tourProgramMapper=new AdsMapper();
        AdsBean tourprogram=null;
        tourprogram = tourProgramMapper.isExist(tourprogramid);        
        return tourprogram;  
    }
    
    public boolean createNewAds(AdsBean tourprogram)throws Exception
    {
        AdsMapper tourprogramMapper=new AdsMapper();
        boolean isCreated=tourprogramMapper.createNewAds(tourprogram);
        return isCreated;    
    }
    
    public boolean updateSpecifiedAds(AdsBean tourprogram)throws Exception
    {
        AdsMapper tourprogramMapper=new AdsMapper();
        boolean isUpdated=tourprogramMapper.updateSpecifiedAds(tourprogram);
        return isUpdated;
    }
    
    public boolean deleteSpecifiedAds(String tourprogramid)throws Exception
    {
        AdsMapper tourprogramMapper=new AdsMapper();
        boolean isDeleted=tourprogramMapper.deleteSpecifiedAds(tourprogramid);
        return isDeleted;
    }
    
    public ArrayList<AdsBean> listAllAds() throws Exception {
        AdsMapper tourprogramMapper=new AdsMapper();
        ArrayList listOfAdss = null;
        try {
            listOfAdss = tourprogramMapper.listAllAds();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            tourprogramMapper.con.close();
        }
        return listOfAdss;
    }
    
}
