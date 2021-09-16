package model;

import java.util.Objects;

public class MessageFromLipUnit {
    private String binValue;
    private int decValue;
    private String nameOfValue;

    public String getBinValue() {
        return binValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFromLipUnit that = (MessageFromLipUnit) o;
        return decValue == that.decValue && Objects.equals(binValue, that.binValue) && Objects.equals(nameOfValue, that.nameOfValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(binValue, decValue, nameOfValue);
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
        return binValue + ", " + decValue + " : " + nameOfValue + "\n";
    }
}
