package model;

import java.util.Map;

public class BaseProtocolUnits {

    private int countOfBits;
    private Map<Integer , String> data;

    public BaseProtocolUnits (int countOfBits, Map<Integer , String> data) {
        this.countOfBits = countOfBits;
        this.data = data;
    }

    public int getCountOfBits() {
        return countOfBits;
    }

    public void setCountOfBits(int countOfBits) {
        this.countOfBits = countOfBits;
    }

    public Map<Integer, String> getData() {
        return data;
    }

    public void setData(Map<Integer, String> data) {
        this.data = data;
    }
}
