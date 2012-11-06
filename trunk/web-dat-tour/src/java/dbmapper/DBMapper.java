package dbmapper;

import dbconnection.DBConnectionService;
import java.sql.Connection;
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
    
}
