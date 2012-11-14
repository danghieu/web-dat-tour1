package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.ContactPersonBean;


/**
 *
 * @author Karl
 */
public class ContactPersonMapper extends DBMapper{
    public ContactPersonBean isExist(String username, String password) throws Exception {
        ContactPersonBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `user` WHERE username='"+username+"' AND password='"
                +password+ "'";
        ResultSet rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            
        }
        
        return user;
    }
    
    public boolean createNewUser(ContactPersonBean user) throws SQLException {
       
        return true;
    }
    
    public boolean deleteSpecifiedUser(String username) {
        
        return true;
    }
    
    public String updateSpecifiedUser(ContactPersonBean user) {
        String username = "";
        
        return username;
    }
    
    public ArrayList<ContactPersonBean> searchUser(ContactPersonBean user) {
        ArrayList listOfUsers = new ArrayList<ContactPersonBean>();
        
        
        return listOfUsers;
    }
    
    
    public ArrayList<ContactPersonBean> listAllUser() throws Exception {
        ArrayList listOfUsers = new ArrayList<ContactPersonBean>();
        
        return listOfUsers;
    }
}
