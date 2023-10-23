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

public class DatabaseInfoImpl implements DatabaseInfo {

//    @Override
    public Connection getConnect() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");

            // Kết nối đến cơ sở dữ liệu
            Connection connection = ds.getConnection();
            logConnectedToDatabase(connection);
            return connection;
        } catch (Exception ex) {
            logError("Error connecting to database", ex);
        }
        return null;
    }

    private void logConnectedToDatabase(Connection connection) throws SQLException{
        System.out.println("Connected to database: " + connection.getCatalog());
        // Bạn có thể thực hiện các thao tác khác tại đây nếu cần thiết
    }

    private void logError(String message, Exception ex) {
        Logger.getLogger(DatabaseInfoImpl.class.getName()).log(Level.SEVERE, message, ex);
        // Bạn có thể xử lý lỗi tại đây hoặc chuyển nó ra bên ngoài
    }

//    @Override
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logError("Error closing ResultSet", e);
            }
        }
    }

//    @Override
    public void closeStatement(PreparedStatement createCustomerPS) {
        if (createCustomerPS != null) {
            try {
                createCustomerPS.close();
            } catch (SQLException e) {
                logError("Error closing PreparedStatement", e);
            }
        }
    }

//    @Override
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logError("Error closing Connection", e);
            }
        }
    }
}
