package Objects;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String consultations;

    public Doctor() {

    }

    public Doctor(int id, String firstName, String lastName, String department, String consultations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.consultations = consultations;
    }

    public int getDid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getConsultations() {
        return consultations;
    }

    public void setConsultations(String consultations) {
        this.consultations = consultations;
    }
}
