import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import model.Job;

public class JobDAO {
    private Connection conn;

    public JobDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insertJob(Job job) {
        try {
            String sql = "INSERT INTO Job (JobID, Title, DateClose, DateOpen, Location, Type, Description, Skills, EnterpriseID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, generateJobID()); // Tạo một ID công việc duy nhất
            preparedStatement.setString(2, job.getTitle());
            preparedStatement.setDate(3, new java.sql.Date(job.getDateClose().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(job.getDateOpen().getTime()));
            preparedStatement.setString(5, job.getLocation());
            preparedStatement.setString(6, job.getType());
            preparedStatement.setString(7, job.getDescription());
            preparedStatement.setString(8, job.getSkills());
            preparedStatement.setString(9, job.getEnterpriseID());
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateJobID() {
        // Tạo mã công việc duy nhất (có thể sử dụng UUID, timestamp, hoặc cách khác)
        // ...
        return "job12345";
    }
}
