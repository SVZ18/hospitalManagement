package controllers;

import Objects.Doctor;
import Objects.Patient;
import dbHelper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDoctor() {

        System.out.print("Enter the first name of the doctor: ");
        String firstName = scanner.next();

        System.out.print("Enter the last name of the doctor: ");
        String lastName = scanner.next();

        System.out.print("Enter the age of the doctor: ");
        int age = scanner.nextInt();

        System.out.print("Enter the department: ");
        String department = scanner.next();


        try {

            ps = DbConnector.getConnection().prepareStatement("INSERT INTO doctors(firstname, lastname, age, " +
                    "department)" + " VALUES('" + firstName + "', '" + lastName + "', " + age + " , '" + department + "')");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Doctor getDoctorById() {

        System.out.print("Enter the id of the doctor: ");
        int id = scanner.nextInt();


        try {
            ps = DbConnector.getConnection().prepareStatement("SELECT * FROM doctors" +
                    " WHERE id = " + id);
            rs = ps.executeQuery();

            int doctorId, age;
            String firstName, lastName, department;

            Doctor doctor = new Doctor();
            while (rs.next()) {
                doctorId = rs.getInt("id");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                age = rs.getInt("age");
                department = rs.getString("department");
                doctor.setId(doctorId);
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setAge(age);
                doctor.setDepartment(department);
                System.out.println(doctorId + "\t " + firstName + "\t " + lastName + "\t " + age + "\t " + department + "\t "
                );

            }

            return doctor;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void deleteDoctor() {

        System.out.print("Enter the id of the doctor you want to delete: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM doctors WHERE id=" + id);
            ps.execute();
            System.out.println("Doctor data deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editDoctor() {
        System.out.println("Enter the doctor's id: ");
        int id = scanner.nextInt();

        System.out.print("first name, last name, age, department");
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE doctors SET" + field + " = " + update +
                    " WHERE id = " + id);
            ps.executeUpdate();
            System.out.println("Doctor's data updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
