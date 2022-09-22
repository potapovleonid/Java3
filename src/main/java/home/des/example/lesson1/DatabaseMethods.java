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
//            findAllStudents();
//            insertNewStudent(28, "Ann");
//            findAllStudents();
//            updateStudent(3, 29, "Ann");
//            findAllStudents();
//            deleteStudent(2);
//            findAllStudents();
        readAndSetNewStudentScore("students.txt");
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
        while (scanner.hasNextLine()){
            studentsAllInfo.add(scanner.nextLine().split(", "));
        }
        for (String[] student: studentsAllInfo) {
            try {
                updateStudentScore(Integer.parseInt(student[0]), Integer.parseInt(student[2]));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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

    private static void updateStudentScore(int id, int score) throws SQLException {
        stm.executeUpdate(String.format("UPDATE students SET score_fld = %d WHERE student_id = %d", score, id));
    }

    private static void deleteStudent(int id) throws SQLException {
        stm.executeUpdate(String.format("DELETE FROM students WHERE student_id = %d;", id));
    }

}
