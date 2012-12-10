/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmapper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.AdsBean;

/**
 *
 * @author AT
 */
public class AdsMapper extends DBMapper{
    public AdsBean isExist(String adsid) throws Exception {
        AdsBean ads = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [Ads] WHERE AdsId='"+adsid+"'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            ads = new AdsBean();
            ads.setAdsID(rs.getString("AdsId"));
            ads.setLink(rs.getString("Link"));
            ads.setImage(rs.getString("Image"));
            ads.setCaption(rs.getString("Caption"));
        }
        
        return ads;
    }
    
    public boolean createNewAds(AdsBean ads)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        AdsBean temp = isExist(ads.getAdsID());
        if (temp !=null) {
            return false;
        }
        sqlStr = "INSERT INTO [Ads]"
           +"([Link]"
           +",[Image]"
           +",[Caption])"
     +"VALUES"
           +"('"+ads.getLink()
           +"','"+ads.getImage()
           +"',N'"+ads.getCaption()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedAds(AdsBean ads)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        AdsBean temp = isExist(ads.getAdsID());
        if (temp == null) {
            return false;
        }
         sqlStr = "UPDATE ads set Link='"+ads.getLink()+"',Image='"+ads.getImage()+ "',Caption=N'"+
                 ads.getCaption() +"'  where AdsId='"+ads.getAdsID()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    public boolean deleteSpecifiedAds(String adsid)throws Exception
    {
        Statement st = con.createStatement();
        String sqlStr;
        AdsBean temp = isExist(adsid);
        if (temp ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [ads] WHERE adsid='"+adsid+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<AdsBean> listAllAds() throws Exception {
        ArrayList listOfAdss = new ArrayList<AdsBean>();
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM Ads";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            AdsBean ads = new AdsBean();
            ads.setAdsID(rs.getString("AdsId"));
            ads.setLink(rs.getString("Link"));
            ads.setImage(rs.getString("Image"));
            ads.setCaption(rs.getString("Caption"));            
            listOfAdss.add(ads);
        }
        
        return listOfAdss;
    }
}
