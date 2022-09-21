package home.des.example.lesson1;

import java.sql.*;

public class DatabaseMethods {

    private static Connection connection;
    private static Statement stm;

    public static void main(String[] args) {
        try {
            connect();
            findAllStudents();
            insertNewStudent(28, "Ann");
            findAllStudents();
            updateStudent(3, 29, "Ann");
            findAllStudents();
            deleteStudent(2);
            findAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost/students", "postgres", "postgres");
        stm = connection.createStatement();
    }

    private static void findAllStudents() throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT * FROM students");
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3));
        }
        System.out.println();
    }

    private static void insertNewStudent(int age, String name) throws SQLException {
        stm.executeUpdate(String.format("INSERT INTO students (age_fld, name_fld) values(%d, '%s');", age, name));
    }

    private static void updateStudent(int id, int updateAge, String name) throws SQLException {
        stm.executeUpdate(String.format("UPDATE students SET age_fld = %d, name_fld = '%s' WHERE student_id = %d", updateAge, name, id));
    }

    private static void deleteStudent(int id) throws SQLException {
        stm.executeUpdate(String.format("DELETE FROM students WHERE student_id = %d;", id));
    }

}
