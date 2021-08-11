package controllers;
import Objects.Patient;
import dbHelper.DbConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewPatient() {

        System.out.print("Enter the first name of the patient: ");
        String firstName = scanner.next();

        System.out.print("Enter the last name of the patient: ");
        String lastName = scanner.next();

        System.out.print("Enter the age of the patient: ");
        int age = scanner.nextInt();

        System.out.print("Enter the sex of the patient: ");
        String sex = scanner.next();

        System.out.println("dd.mm.yyyy");
        System.out.print("Enter the date of sign-in: ");
        String signIn = scanner.next();

        System.out.println("dd.mm.yyyy");
        System.out.print("Enter the date of sign-out: ");
        String signOut = scanner.next();

        System.out.print("Enter the drugs prescribed to the patient: ");
        String drugs = scanner.next();

        try {

            ps = DbConnector.getConnection().prepareStatement("INSERT INTO patients(firstname, lastname, age, " +
                    "sex, signin, signout, drugs)" + " VALUES('" + firstName + "', '" + lastName + "', " + age + " , '" + sex + "', '" +
                    signIn + "', '" + signOut + "', '" + drugs + "')");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static Patient getPatientById() {

        System.out.print("Enter the id of the patient: ");
        int id = scanner.nextInt();


        try {
            ps = DbConnector.getConnection().prepareStatement("SELECT * FROM patients" +
                    " WHERE id = " + id);
            rs = ps.executeQuery();

            int patientId, age;
            String firstName, lastName, sex, signIn, signOut, drugs;

            Patient patient = new Patient();
            while (rs.next()) {
                patientId = rs.getInt("id");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                age = rs.getInt("age");
                sex = rs.getString("sex");
                signIn = rs.getString("signin");
                signOut = rs.getString("signout");
                drugs = rs.getString("drugs");
                patient.setId(patientId);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setAge(age);
                patient.setSex(sex);
                patient.setSignIn(signIn);
                patient.setSignOut(signOut);
                patient.setDrugs(drugs);
                System.out.println(patientId + "\t " + firstName + "\t " + lastName + "\t " + age + "\t " + sex + "\t " + signIn + "\t " + signOut + "\t " + drugs + "\t "
                );

            }

            return patient;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deletePatient() {

        System.out.print("Enter the id of the patient you want to delete: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM patients WHERE id=" + id);
            ps.execute();
            System.out.println("Patient data deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editPatient() {
        System.out.println("Enter the patient's id: ");
        int id = scanner.nextInt();

        System.out.print("first name, last name, age, sex, sign-in date, sign-out date, drugs");
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE patients SET" + field + " = " + update +
                    " WHERE id = " + id);
            ps.executeUpdate();
            System.out.println("Patient's data updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

//    public static void addPatientDrugs() {
//        System.out.println("Enter the patient's id: ");
//        int id = scanner.nextInt();
//
//        System.out.println("Enter the drugs prescribed: ");
//        String drugs = scanner.next();
//
//        try {
//            ps = DbConnector.getConnection().prepareStatement();
//
//            ps.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();

