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

        System.out.print("Enter the department: ");
        String department = scanner.next();

        System.out.println("Enter the consultation times: ");
        String consultations = scanner.next();


        try {

            ps = DbConnector.getConnection().prepareStatement("INSERT INTO doctors(firstname, lastname, " +
                    "department, consultations)" + " VALUES('" + firstName + "', '" + lastName + "', '" + department + "', '" + consultations +"')");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Doctor getDoctorById() {

        System.out.print("Enter the id of the doctor: ");
        int did = scanner.nextInt();


        try {
            ps = DbConnector.getConnection().prepareStatement("SELECT * FROM doctors" +
                    " WHERE did = " + did);
            rs = ps.executeQuery();

            int doctorId;
            String firstName, lastName, department, consultations;

            Doctor doctor = new Doctor();
            while (rs.next()) {
                doctorId = rs.getInt("did");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                department = rs.getString("department");
                consultations = rs.getString("consultations");
                doctor.setId(doctorId);
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setDepartment(department);
                doctor.setConsultations(consultations);
                System.out.println(doctorId + "\t " + firstName + "\t " + lastName + "\t " + department + "\t " + consultations + "\t "
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
        int did = scanner.nextInt();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM doctors WHERE did=" + did);
            ps.execute();
            System.out.println("Doctor data deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editDoctor() {
        System.out.println("Enter the doctor's id: ");
        int doctorId= scanner.nextInt();

        System.out.print("firstname, lastname, department, consultation times");
        System.out.println();
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated data: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE doctors SET " + field + " = '" + update + "' WHERE did = " + doctorId);
            ps.executeUpdate();
            System.out.println("Doctor's data updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
