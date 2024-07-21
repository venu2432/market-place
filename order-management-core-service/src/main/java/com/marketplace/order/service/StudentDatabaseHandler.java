package com.marketplace.order.service;

import java.sql.*;
import java.util.*;

class StudentDatabaseHandler {
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static Connection connection;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/order";
        String username = "root";
        String password = "Venu@2432";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        try {
            connection = DriverManager.getConnection(url, username, password);

            for (int i = 0; i < n; i++) {
                int sid = Integer.parseInt(sc.nextLine().trim());
                String sname = sc.nextLine().trim();
                String dname = sc.nextLine().trim();
                String address = sc.nextLine().trim();
                float gpa = Float.parseFloat(sc.nextLine().trim());

                insertStudent(sid, sname, dname, address, gpa);
            }

            System.out.println("Enter Department to search for students:");
            String searchDept = sc.nextLine().trim();
            selectStudentByDept(searchDept);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertStudent(int sid, String sname, String dname, String address, float gpa) throws SQLException {
        String insertQ = "INSERT INTO bill(SID, SNAME, DNAME, ADDRESS, GPA) VALUES (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertQ);
        preparedStatement.setInt(1, sid);
        preparedStatement.setString(2, sname);
        preparedStatement.setString(3, dname);
        preparedStatement.setString(4, address);
        preparedStatement.setFloat(5, gpa);
        int rowsInserted = preparedStatement.executeUpdate();
        System.out.println(rowsInserted + " row(s) inserted.");
    }

    private static void selectStudentByDept(String department) throws SQLException {
        String selectQuery = "SELECT SID, SNAME, DNAME, ADDRESS, GPA FROM bill WHERE DNAME=?";
        preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, department);
        resultSet = preparedStatement.executeQuery();

        boolean found = false;
        while (resultSet.next()) {
            found = true;
            int sid = resultSet.getInt("SID");
            String sname = resultSet.getString("SNAME");
            String dname = resultSet.getString("DNAME");
            String address = resultSet.getString("ADDRESS");
            float gpa = resultSet.getFloat("GPA");
            System.out.format("%d %s %s %s %.1f\n", sid, sname, dname, address, gpa);
        }

        if (!found) {
            System.out.println("No students in " + department + " department");
        }
    }
}
