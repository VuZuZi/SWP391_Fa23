package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public interface DatabaseInfoo {
    public static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=JC";
    public static String userDB="theanhntp22";
    public static String passDB="theanhntp22";
    public static Connection getConnect() throws SQLException{
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
            return ds.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseInfoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeResultSet(ResultSet rs) {
        if( rs!=null){
            try{
                rs.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement createCustomerPS) {
        if(createCustomerPS!=null){
            try{
                createCustomerPS.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }	
    }

    public static void closeConnection(Connection conn) {
        if(conn!=null){
            try{
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }		
    }
}
