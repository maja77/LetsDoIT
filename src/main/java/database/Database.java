package database;

import java.sql.*;

public class Database {
    private final String url = "jdbc:postgresql://localhost:5433/LetsDoIT";
    private final String user = "postgres";
    private final String password = "postgres";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

//    public long addRecord (Task task) {
//        String SQL = "INSERT INTO task(title,description) "
//                + "VALUES(?,?)";
//        long id = 0;
//
//        try (Connection conn = connect();
//             PreparedStatement pstmt = conn.prepareStatement(SQL,
//                     Statement.RETURN_GENERATED_KEYS)) {
//
//            pstmt.setString(1, task.getTitle());
//            pstmt.setString(2, task.getDescription());
//
//
//            int affectedRows = pstmt.executeUpdate();
//            // check the affected rows
//            if (affectedRows > 0) {
//                // get the ID back
//                try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                    if (rs.next()) {
//                        id = rs.getLong(1);
//                        task.setI(id);
//                    }
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return id;
//
//    }
}
