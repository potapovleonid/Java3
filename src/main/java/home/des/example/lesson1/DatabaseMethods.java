package home.des.example.lesson1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseMethods {

    private static Connection connection;
    private static Statement stm;

    public static void main(String[] args) {
        try {
            connect();
//            insertNewStudent(25, "Bob1");
//            insertNewStudent(26, "Bob2");
//            insertNewStudent(27, "Bob3");
//            insertNewStudent(28, "Bob4");
//            findAllStudents();
            readAndSetNewStudentScore("students.txt");
            findAllStudents();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws SQLException {

        connection = DriverManager.getConnection("jdbc:postgresql://localhost/students", "postgres", "postgres");
        stm = connection.createStatement();
    }

    private static void readAndSetNewStudentScore(String pathFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(pathFile));
        ArrayList<String[]> studentsAllInfo = new ArrayList<>();
        while (scanner.hasNextLine()) {
            studentsAllInfo.add(scanner.nextLine().split("  "));
        }
        for (String[] student : studentsAllInfo) {
            try {
                updateStudentScore(student[0], student[2]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static void findAllStudents() throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3));
        }
        System.out.println();
    }

    private static void insertNewStudent(int score, String name) throws SQLException {
        stm.executeUpdate(String.format("INSERT INTO students (score_fld, name_fld) values(%d, '%s');", score, name));
    }

    private static void updateStudent(int id, int updateScore, String name) throws SQLException {
        stm.executeUpdate(String.format("UPDATE students SET score_fld = %d, name_fld = '%s' WHERE student_id = %d;", updateScore, name, id));
    }

    private static void updateStudentScore(String id, String score) throws SQLException {
        String req = String.format("UPDATE public.students SET score_fld = %s WHERE student_id = %s;", score, id);
        stm.executeUpdate(req);
    }

    private static void deleteStudent(int id) throws SQLException {
        stm.executeUpdate(String.format("DELETE FROM students WHERE student_id = %d;", id));
    }

}
