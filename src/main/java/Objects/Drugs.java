package Objects;

public class Drugs {

    private int drugId;
    private String serialNum;
    private String name;


    public Drugs() {

    }

    public Drugs(int drugiId, String serialNum, String name) {
        this.drugId = drugId;
        this.serialNum = serialNum;
        this.name = name;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
