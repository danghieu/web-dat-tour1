package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.UserBean;


/**
 *
 * @author Karl
 */
public class UserMapper extends DBMapper{
    public UserBean isExist(String username, String password) throws Exception {
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `UserProfile` WHERE username='"+username+"' AND password='"
                +password+ "'";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            user = new UserBean();
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getBoolean("gender"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setCompany(rs.getString("company"));
            user.setDateCreation(rs.getDate("datecreation"));
            user.setRoleId(rs.getString("roleid"));
        }
        
        return user;
    }
    
    public boolean createNewUser(UserBean user) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        UserBean user2 = isExist(user.getUserName(),user.getPassword());
        if (user2 !=null) {
            return false;
        }
        sqlStr = "insert into [userprofile](username,password,firstname,lastname"
                + ",birthday,gender,email,phone,address,company,datecreation,roleid)"
                + " values('"+user.getUserName()+"','"+user.getPassword()+"','"
                +user.getFirstName()+"','"+user.getLastName()+"','"+user.getBirthday()
                +"','"+(user.isGender()?"1":"0")+"','"+user.getEmail()+"','"
                +user.getPhone()+"','"+user.getAddress()+"','"+user.getCompany()
                +"','"+user.getDateCreation()+"','"+user.getRoleId()+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedUser(String username) {
        
        return true;
    }
    
    public boolean changeUserPassword(UserBean user,String strnewpassword) throws SQLException, Exception {
        Statement st = con.createStatement();
        String sqlStr;
        UserBean user2 = isExist(user.getUserName(),user.getPassword());
        if (user2 ==null) {
            return false;
        }
        sqlStr = "UPDATE [userprofile] set `password`='"+strnewpassword+"' WHERE `username`='"+user.getUserName()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedUser(UserBean user) throws SQLException, Exception{
        
        return true;
    }
    
    public ArrayList<UserBean> searchUser(UserBean user) throws SQLException {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        UserBean user2 = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `UserProfile` WHERE username='"+user.getUserName()+"'";//+"' OR firstname='"+user.getFirstName()+"' OR lastname='"
                //+user.getLastName()+"' OR birthday='"+user.getBirthday()+"';";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            user2 = new UserBean();
            user2.setUserName(rs.getString("username"));
            user2.setPassword(rs.getString("password"));
            user2.setFirstName(rs.getString("firstname"));
            user2.setLastName(rs.getString("lastname"));
            user2.setBirthday(rs.getDate("birthday"));
            user2.setGender(rs.getBoolean("gender"));
            user2.setEmail(rs.getString("email"));
            user2.setPhone(rs.getString("phone"));
            user2.setAddress(rs.getString("address"));
            user2.setCompany(rs.getString("company"));
            user2.setDateCreation(rs.getDate("datecreation"));
            user2.setRoleId(rs.getString("roleid"));
            listOfUsers.add(user);
        }
        
        return listOfUsers;
    }
    
    
    public ArrayList<UserBean> listAllUser() throws Exception {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `UserProfile`";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            user = new UserBean();
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getBoolean("gender"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setCompany(rs.getString("company"));
            user.setDateCreation(rs.getDate("datecreation"));
            user.setRoleId(rs.getString("roleid"));
            listOfUsers.add(user);
        }
        
        return listOfUsers;
    }
}
