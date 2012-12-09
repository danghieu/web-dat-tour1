package dbmapper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javabean.UserBean;


/**
 *
 * @author Karl
 */
public class UserMapper extends DBMapper{
    public UserBean isExist(String username, String password) throws Exception {
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [UserProfile] WHERE username='"+username+"' AND password='"
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
    
    public UserBean isExist(String username) throws Exception {
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM [UserProfile] WHERE username='"+username+"'";
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
        UserBean usertemp = isExist(user.getUserName(),user.getPassword());
        if (usertemp !=null) {
            return false;
        }
        DateFormat formatter ; 
        Date date =new Date();  
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String birthday = formatter.format(user.getBirthday());
         String creationdate = formatter.format(date);
 
        sqlStr = "insert into [userprofile](username,password,firstname,lastname"
                + ",birthday,gender,email,phone,address,company,datecreation,roleid)"
                + " values('"+user.getUserName()+"','"+user.getPassword()+"','"
                +user.getFirstName()+"','"+user.getLastName()+"','"+birthday
                +"','"+(user.isGender()?"1":"0")+"','"+user.getEmail()+"','"
                +user.getPhone()+"','"+user.getAddress()+"','"+user.getCompany()
                +"','"+creationdate+"','"+"2"+"')";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedUser(UserBean user)throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        UserBean usertemp = isExist(user.getUserName(),user.getPassword());
        if (usertemp ==null) {
            return false;
        }
        sqlStr = "DELETE FROM [userprofile] WHERE username='"+user.getUserName()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean changeUserPassword(UserBean user,String strnewpassword) throws Exception {
        Statement st = con.createStatement();
        String sqlStr;
        UserBean usertemp = isExist(user.getUserName(),user.getPassword());
        if (usertemp == null) {
            return false;
        }
        sqlStr = "UPDATE [userprofile] set password='"+strnewpassword+"' WHERE username='"+user.getUserName()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean updateSpecifiedUser(UserBean user) throws Exception{
        Statement st = con.createStatement();
        String sqlStr;
        UserBean usertemp = isExist(user.getUserName(),user.getPassword());
        if (usertemp ==null) {
            return false;
        }
        DateFormat formatter ; 
        Date date =new Date();  
         formatter = new SimpleDateFormat("dd-MM-yyyy");  
         String birthday = formatter.format(user.getBirthday());
         String creationdate = formatter.format(date);
        sqlStr = "UPDATE [userprofile] set firstname='"+user.getFirstName()+
                "', lastname='"+user.getLastName() + "', birthday='"+birthday +
                "', gender='"+user.isGender() + "', phone='"+user.getPhone() +
                "', address='"+user.getAddress() + "', company='"+user.getCompany() +
                "' WHERE username='"+user.getUserName()+"'";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public ArrayList<UserBean> searchUser(UserBean user) throws Exception {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        UserBean usertemp = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM UserProfile WHERE username='"+user.getUserName()+"'";//+"' OR firstname='"+user.getFirstName()+"' OR lastname='"
                //+user.getLastName()+"' OR birthday='"+user.getBirthday()+"';";
        ResultSet rs;
        rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            usertemp = new UserBean();
            usertemp.setUserName(rs.getString("username"));
            usertemp.setPassword(rs.getString("password"));
            usertemp.setFirstName(rs.getString("firstname"));
            usertemp.setLastName(rs.getString("lastname"));
            usertemp.setBirthday(rs.getDate("birthday"));
            usertemp.setGender(rs.getBoolean("gender"));
            usertemp.setEmail(rs.getString("email"));
            usertemp.setPhone(rs.getString("phone"));
            usertemp.setAddress(rs.getString("address"));
            usertemp.setCompany(rs.getString("company"));
            usertemp.setDateCreation(rs.getDate("datecreation"));
            usertemp.setRoleId(rs.getString("roleid"));
            listOfUsers.add(user);
        }
        
        return listOfUsers;
    }
    
    
    public ArrayList<UserBean> listAllUser() throws Exception {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM UserProfile";
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
