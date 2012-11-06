/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dbmapper.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javabean.UserBean;

/**
 *
 * @author Tin Huynh
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
    
    public boolean CreateNewUser(UserBean user)throws Exception
    {
        UserMapper userMapper=new UserMapper();
        boolean isCreated=false;
        try {
            isCreated=userMapper.createNewUser(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            userMapper.con.close();
        }
        return isCreated;
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
