package dbmapper;

import dbconnection.DBConnectionService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMapper {
    public Connection con;

    public DBMapper() {
        try {
            con = DBConnectionService.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String GetTopDataCell(String nameTable, String nameSelectColumn, String orderByColumn) throws SQLException
    {
        Statement st = con.createStatement();
        String sqlStr="SELECT TOP 1 "+nameSelectColumn+" FROM [web-dat-tour].[dbo]."+nameTable+"  ORDER BY "+orderByColumn+" DESC";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        String a=null;
        if (rs != null && rs.next()) {
            a=rs.getString(nameSelectColumn);
            return a;
        }
      // System.out.println(a);
       return null;
    }
    
      public static String removeCharAt(String s, int pos) {
    return s.substring(0,pos)+s.substring(pos+1);
    }
      
    private static String removeChar(String s, char c) {
    String r = "";
    for (int i = 0; i < s.length(); i ++) {
       if (s.charAt(i) != c) r += s.charAt(i);
       }
    return r;
    }
    
    public String NextID(String lastID, String prefixID)
        {
            String year,temp=lastID;
            year=temp.substring(0,4);
            System.out.println(year);
            System.out.println(prefixID);
                       
            if("".equals(lastID) || !(year.equals(prefixID)))
           {
               return prefixID+"0001";
           }
           
           //if(prefixID==year)
           
            lastID=removeCharAt(lastID, 0);
            lastID=removeCharAt(lastID, 0);
            lastID=removeCharAt(lastID, 0);
            lastID=removeCharAt(lastID, 0);
            int nextID = Integer.parseInt(lastID);
            nextID++;
           // System.out.println(Integer.toString(nextID));
            int lengthNumerID = temp.length() - 2  - prefixID.length();
            String zeroNumber="";
            for (int i =0; i <= lengthNumerID; i++)
            {
                if (nextID < Math.pow(10, i))
                {
                    for (int j = 0; j <= lengthNumerID- i +1; i++)
                    {
                        zeroNumber+= "0";
                    }
                    return prefixID + zeroNumber + Integer.toString(nextID);
                }
            }
            return prefixID + nextID;

        }
    
}
