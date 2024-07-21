package com.marketplace.order.service;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {
    private static final String DB_URL = "jdbc:mysql://localhost/ri_db";
    private static final String USER = "test";
    private static final String PASSWORD = "test]23";


    private Connection conn;


    public JDBCExample() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }


    public void insertStudent(int sid, String sname, String dname, String address, float gpa) throws SQLException {
        String insertQuery = "INSERT INTO bill (SID, SNAME, DNAME, ADDRESS, GPA) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insertQuery);
        stmt.setInt(1, sid);
        stmt.setString(2, sname);
        stmt.setString(3, dname);
        stmt.setString(4, address);
        stmt.setFloat(5, gpa);
        stmt.executeUpdate();
    }


    public void searchByDepartment(String department) throws SQLException {
        String selectQuery = "SELECT SID, SNAME, DNAME, ADDRESS, GPA FROM bill WHERE DNAME = ?";
        PreparedStatement stmt = conn.prepareStatement(selectQuery);
        stmt.setString(1, department);
        ResultSet rs = stmt.executeQuery();

        boolean found = false;
        while (rs.next()) {
            int sid = rs.getInt("SID");
            String sname = rs.getString("SNAME");
            String dname = rs.getString("DNAME");
            String address = rs.getString("ADDRESS");
            float gpa = rs.getFloat("GPA");

            System.out.printf("%d %s %s %s %.2f\n", sid, sname, dname, address, gpa);
            found = true;
        }

        if (!found) {
            System.out.printf("No students in %s department\n", department);
        }

        rs.close();
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        JDBCExample example = null;
        Scanner scanner = new Scanner(System.in);

        try {
            example = new JDBCExample();

            int numStudents = Integer.parseInt(scanner.nextLine().trim());


            for (int i = 0; i < numStudents; i++) {
                int sid = Integer.parseInt(scanner.nextLine().trim());
                String sname = scanner.nextLine().trim();
                String dname = scanner.nextLine().trim();
                String address = scanner.nextLine().trim();
                float gpa = Float.parseFloat(scanner.nextLine().trim());
                example.insertStudent(sid, sname, dname, address, gpa);
            }

            String department = scanner.nextLine().trim();

            example.searchByDepartment(department);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (example != null) {
                    example.close();
                }
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
