package controllers;

import dbHelper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DrugController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDrugs() {

        System.out.print("Enter the serial number of drugs: ");
        String serialNum = scanner.next();

        System.out.print("Enter the last name of the drugs: ");
        String name = scanner.next();


        try {

            ps = DbConnector.getConnection().prepareStatement("INSERT INTO drugs(serialnum, name)" + " VALUES('" +
                    serialNum + "', '" + name + "')");

            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void deleteDrugs() {

        System.out.print("Enter the name of drugs you want to delete: ");
        String name = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM drugs WHERE name=" + name);
            ps.execute();
            System.out.println("Drugs successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editDrugs() {
        System.out.println("Enter the name of drugs: ");
        String name = scanner.next();

        System.out.print("serialnum, name");
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE drugs SET" + field + " = " + update +
                    " WHERE name = " + name);
            ps.executeUpdate();
            System.out.println("Patient's data updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
