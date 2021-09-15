package model;

public class ParsedLipUnit {
    private String binValue;
    private int decValue;
    private String nameOfValue;

    public String getBinValue() {
        return binValue;
    }

    public void setBinValue(String binValue) {
        this.binValue = binValue;
    }

    public int getDecValue() {
        return decValue;
    }

    public void setDecValue(int decValue) {
        this.decValue = decValue;
    }

    public String getNameOfValue() {
        return nameOfValue;
    }

    public void setNameOfValue(String nameOfValue) {
        this.nameOfValue = nameOfValue;
        Object o = new Object();

    }

    @Override
    public String toString() {
        return binValue + ", " + decValue + " - " + nameOfValue;
    }
}
