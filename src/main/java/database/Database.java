package database;

import components.Priority;
import components.Status;
import components.Task;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

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

    public void addRecord (Task task) {
        String SQL = "INSERT INTO task(title,description,priority,status) "
                + "VALUES(?,?,?,?)";
        int id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getPriority().toString());
            pstmt.setString(4, task.getStatus().toString());

            System.out.println("Record added to database successfully.");


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getInt(1);
                        task.setID(id);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delRecord(int id) {
        String SQL = "DELETE FROM task WHERE id=?";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setInt(1,id);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ObservableList<Task> showAllRecords () {
        ObservableList<Task> tasksFromDb = FXCollections.observableArrayList();
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM task");


            while(result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                String priority = result.getString("priority");
                Priority prio;
                if (priority.equals("LOW")) {
                    prio = Priority.LOW;
                } else if (priority.equals("MID")) {
                    prio = Priority.MID;
                } else {
                    prio = Priority.HIGH;
                }
                Status stat;
                String status = result.getString("status");
                if (status.equals("TODO")) {
                    stat = Status.TODO;
                } else if (status.equals("DONE")) {
                    stat = Status.DONE;
                } else if (status.equals("WAITING")) {
                    stat = Status.WAITING;
                } else {
                    stat = Status.INPROGRESS;
                }

                tasksFromDb.add(new Task(id, title, description, prio, stat));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tasksFromDb;
    }
}
