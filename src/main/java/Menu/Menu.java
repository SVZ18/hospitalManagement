package Menu;
import controllers.DoctorController;
import controllers.DrugController;
import controllers.PatientController;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Patients, 2. Doctors, 3. Drugs");
        System.out.println("Choose a section: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Please select an option");
                System.out.println("1. Get patient by ID");
                System.out.println("2. Add new patient");
                System.out.println("3. Edit patient's details");
                System.out.println("4. Delete patient");

                getPatient();
                break;

            case 2:
                System.out.println("1. Get doctor by ID");
                System.out.println("2. Add new doctor");
                System.out.println("3. Edit doctor's details");
                System.out.println("4. Delete doctor");

                getDoctor();
                break;

            case 3:
                System.out.println("1. Get drugs by ID");
                System.out.println("2. Add new drugs");
                System.out.println("3. Edit details of drugs");
                System.out.println("4. Delete drugs");

                getDrugs();
                break;

        }

    }
    public static void getPatient() {
        Scanner scanner = new Scanner(System.in);
                        int selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        PatientController.getPatientById();
                        break;
                    case 2:
                        PatientController.addNewPatient();
                        break;
                    case 3:
                        PatientController.editPatient();
                        break;
                    case 4:
                        PatientController.deletePatient();
                        break;

                }
    }

    public static void getDoctor() {
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                DoctorController.getDoctorById();
                break;
            case 2:
                DoctorController.addNewDoctor();
                break;
            case 3:
                DoctorController.editDoctor();
                break;
            case 4:
                DoctorController.deleteDoctor();
                break;
        }

    }
    public static void getDrugs() {
        Scanner scanner = new Scanner(System.in);

        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                DrugController.getDrugsById();
                break;
            case 2:
                DrugController.addNewDrugs();
                break;
            case 3:
                DrugController.editDrugs();
                break;
            case 4:
                DrugController.deleteDrugs();
                break;
        }

    }

}
