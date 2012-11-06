package dbmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javabean.UserBean;

public class UserMapper extends DBMapper{
    public UserBean isExist(String username, String password) throws Exception {
        UserBean user = null;
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `user` WHERE username='"+username+"' AND password='"
                +password+ "'";
        ResultSet rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next()) {
            user = new UserBean();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullname(rs.getString("fullname"));
            user.setBirthday(rs.getString("birthday"));
            user.setSex(rs.getString("sex"));
            user.setPhonenumber(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
        }
        
        return user;
    }
    
    public boolean createNewUser(UserBean user) throws SQLException {
        Statement st = con.createStatement();
        String sqlStr="SELECT * FROM `user` WHERE username='"+user.getUsername()+"'";
        ResultSet rs = st.executeQuery(sqlStr.toString());
        if (rs != null && rs.next())
            return false;
        sqlStr="INSERT INTO user (username, password, fullname, birthday, sex, phone, email, address) VALUES('"+user.getUsername()
                +"', '"+user.getPassword()+"', '"+user.getFullname()+"', '"+user.getBirthday()+"', '"+user.getSex()+
                "', '"+user.getPhonenumber()+"', '"+user.getEmail()+"', '"+user.getAddress()+"' )";
        st.executeUpdate(sqlStr.toString());
        return true;
    }
    
    public boolean deleteSpecifiedUser(String username) {
        
        return true;
    }
    
    public String updateSpecifiedUser(UserBean user) {
        String username = "";
        
        return username;
    }
    
    public ArrayList<UserBean> searchUser(UserBean user) {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        
        
        return listOfUsers;
    }
    
    
    public ArrayList<UserBean> listAllUser() throws Exception {
        ArrayList listOfUsers = new ArrayList<UserBean>();
        Statement st = con.createStatement();
        StringBuffer sqlStr = new StringBuffer();
        sqlStr.append(" SELECT * FROM user");
        ResultSet rs = st.executeQuery(sqlStr.toString());
        while (rs != null && rs.next()) {
            UserBean user = new UserBean();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullname(rs.getString("fullname"));
            user.setBirthday(rs.getString("birthday"));
            user.setSex(rs.getString("sex"));
            user.setPhonenumber(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            listOfUsers.add(user);
        }
        
        return listOfUsers;
    }
    
}
