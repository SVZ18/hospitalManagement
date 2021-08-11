package Objects;

public class Drugs {

    private String serialNum;
    private String name;

    public Drugs(String serialNum, String name) {
        this.serialNum = serialNum;
        this.name = name;
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
