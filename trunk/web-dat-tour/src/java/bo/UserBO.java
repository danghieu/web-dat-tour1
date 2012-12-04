/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.UserMapper;
import java.util.ArrayList;
import javabean.UserBean;

/**
 *
 * @author AT
 */
public class UserBO {
    public UserBean isExist(String username, String password) throws Exception {
        UserMapper userMapper = new UserMapper();
        UserBean user = null;
        try {
            user = userMapper.isExist(username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            userMapper.con.close();
        }
        return user;

    }
    
    public boolean createNewUser(UserBean user)throws Exception
    {
        UserMapper userMapper=new UserMapper();
        boolean isCreated=userMapper.createNewUser(user);
        return isCreated;
    }
    
    public boolean deleteSpecifiedUser(UserBean user)throws Exception
    {
        UserMapper userMapper=new UserMapper();
        boolean isDeleted=userMapper.deleteSpecifiedUser(user);
        return isDeleted;
    }
    
    public boolean updateSpecifiedUser(UserBean user)throws Exception
    {
        UserMapper userMapper=new UserMapper();
        boolean isUpdated=userMapper.updateSpecifiedUser(user);
        return isUpdated;
    }
    
    public boolean changeUserPassword(UserBean user, String newpasswordstr) throws Exception
    {
        UserMapper userMapper=new UserMapper();
        boolean isUpdated=userMapper.changeUserPassword(user, newpasswordstr);
        return isUpdated;
    }
    
    public ArrayList<UserBean> searchUser(UserBean user) throws Exception {
        UserMapper userMapper = new UserMapper();
        ArrayList listOfUsers = null;
        try {
            listOfUsers = userMapper.searchUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            userMapper.con.close();
        }
        return listOfUsers;

    }
    
    public ArrayList<UserBean> listAllUser() throws Exception {
        UserMapper userMapper = new UserMapper();
        ArrayList listOfUsers = null;
        try {
            listOfUsers = userMapper.listAllUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            userMapper.con.close();
        }
        return listOfUsers;

    }
}
