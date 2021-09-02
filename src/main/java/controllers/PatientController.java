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

        System.out.println("dd.mm.yyyy");
        System.out.print("Enter the date of sign-in: ");
        String signIn = scanner.next();

        System.out.println("dd.mm.yyyy");
        System.out.print("Enter the date of sign-out: ");
        String signOut = scanner.next();

        System.out.print("Enter the id of drugs prescribed: ");
        int drugs = scanner.nextInt();

        try {

            ps = DbConnector.getConnection().prepareStatement("INSERT INTO patients(firstname, lastname, age, " +
                    "signin, signout, drugs)" + " VALUES('" + firstName + "', '" + lastName + "', " + age + ", '" +
                    signIn + "', '" + signOut + "', " + drugs + ")");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static Patient getPatientById() {

        System.out.print("Enter the id of the patient: ");
        int pid = scanner.nextInt();


        try {
            ps = DbConnector.getConnection().prepareStatement("SELECT * FROM patients" +
                    " WHERE pid = " + pid);
            rs = ps.executeQuery();

            int patientId, age,drugs;
            String firstName, lastName, signIn, signOut;

            Patient patient = new Patient();
            while (rs.next()) {
                patientId = rs.getInt("pid");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                age = rs.getInt("age");
                signIn = rs.getString("signin");
                signOut = rs.getString("signout");
                drugs = rs.getInt("drugs");
                patient.setId(patientId);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setAge(age);
                patient.setSignIn(signIn);
                patient.setSignOut(signOut);
                patient.setDrugs(drugs);
                System.out.println(patientId + "\t " + firstName + "\t " + lastName + "\t " + age +  "\t " + signIn + "\t " + signOut + "\t " + drugs + "\t "
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
        int pid = scanner.nextInt();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM patients WHERE pid=" + pid);
            ps.execute();
            System.out.println("Patient data deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editPatient() {
        System.out.println("Enter the patient's id: ");
        int patientId = scanner.nextInt();

        System.out.print("firstname, lastname, age, sign-in date, sign-out date, drugs");
        System.out.println();
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE patients SET " + field + " = '" + update + "' WHERE pid = " + patientId);
            ps.execute();
            System.out.println("Successfully updated patent.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

