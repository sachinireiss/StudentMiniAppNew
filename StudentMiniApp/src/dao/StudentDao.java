package dao;

import Model.Student;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao implements StudentDaoInterface {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "INSERT INTO student_details(name, year, GPA) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setString(2, s.getYear());
            pst.setDouble(3, s.getGPA());
            pst.executeUpdate();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int index) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "DELETE FROM student_details WHERE `index` = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, index);
            int rows = pst.executeUpdate();
            if (rows > 0) flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int index, String update, int ch, Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "";
            switch (ch) {
                case 1: // Update name
                    query = "UPDATE student_details SET name = ? WHERE `index` = ?";
                    break;
                case 2: // Update year
                    query = "UPDATE student_details SET year = ? WHERE `index` = ?";
                    break;
                case 3: // Update GPA
                    query = "UPDATE student_details SET GPA = ? WHERE `index` = ?";
                    break;
                default:
                    System.out.println("Invalid choice");
                    return false;
            }
            PreparedStatement pst = con.prepareStatement(query);
            if (ch == 3) {
                pst.setDouble(1, Double.parseDouble(update));
            } else {
                pst.setString(1, update);
            }
            pst.setInt(2, index);
            int rows = pst.executeUpdate();
            if (rows > 0) flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllStudent() {
        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM student_details";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Index: " + rs.getInt("index") + "\n" +
                        "Name: " + rs.getString("name") + "\n" +
                        "Year: " + rs.getString("year") + "\n" +
                        "GPA: " + rs.getDouble("GPA") + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean showStudentById(int index) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();
            String query = "SELECT * FROM student_details WHERE `index` = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, index);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Index: " + rs.getInt("index") + "\n" +
                        "Name: " + rs.getString("name") + "\n" +
                        "Year: " + rs.getString("year") + "\n" +
                        "GPA: " + rs.getDouble("GPA") + "\n");
                flag = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
