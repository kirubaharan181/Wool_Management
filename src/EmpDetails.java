import Project.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kirubaharan
 */
public class EmpDetails {
     public static void main(String[] args) {
        // Get employee ID from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();

        // Call method to display employee details
        displayEmployeeDetails(employeeId);

        // Close scanner
        scanner.close();
    }

    public static void displayEmployeeDetails(int employeeId) {
        try {
            // Get database connection
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs;

            // SQL query to retrieve employee details
            String query = "SELECT first_name, last_name, designation FROM employees WHERE employee_id = " + employeeId;
            rs = st.executeQuery(query);

            // Check if employee details are found
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String designation = rs.getString("designation");

                // Display employee details
                System.out.println("Employee ID: " + employeeId);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Designation: " + designation);
            } else {
                // Employee not found
                System.out.println("Employee with ID " + employeeId + " not found.");
            }

            // Close resources
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            // Handle exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }
}