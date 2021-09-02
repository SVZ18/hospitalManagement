package controllers;

import Objects.Doctor;
import Objects.Drugs;
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

        System.out.print("Enter the name of the drugs: ");
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

    public static Drugs getDrugsById() {

        System.out.print("Enter the id of the drugs: ");
        int drugid = scanner.nextInt();


        try {
            ps = DbConnector.getConnection().prepareStatement("SELECT * FROM drugs" +
                    " WHERE drugid = " + drugid);
            rs = ps.executeQuery();

            int drugId;
            String serialNum, name;

            Drugs drugs = new Drugs();
            while (rs.next()) {
                drugId = rs.getInt("drugid");
                serialNum = rs.getString("serialnum");
                name = rs.getString("name");

                drugs.setDrugId(drugId);
                drugs.setSerialNum(serialNum);
                drugs.setName(name);

                System.out.println(drugId + "\t " + serialNum + "\t " + name + "\t "
                );

            }

            return drugs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
    public static void deleteDrugs() {

        System.out.print("Enter the id of drugs you want to delete: ");
        int drugid = scanner.nextInt();

        try {
            ps = DbConnector.getConnection().prepareStatement("DELETE FROM drugs WHERE drugid=" + drugid);
            ps.execute();
            System.out.println("Drugs deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editDrugs() {
        System.out.println("Enter the id of drugs: ");
        int drugid = scanner.nextInt();

        System.out.print("serialnumber, name");
        System.out.println();
        System.out.print("Enter the field you would like to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnector.getConnection().prepareStatement("UPDATE drugs SET" + field + " = " + update +
                    " WHERE drugid = " + drugid);
            ps.executeUpdate();
            System.out.println("Patient's data updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
