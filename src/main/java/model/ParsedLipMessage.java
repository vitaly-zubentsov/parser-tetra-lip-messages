package model;

import java.util.ArrayList;
import java.util.List;

public class ParsedLipMessage {
    private List<ParsedLipUnit> parsedMessage = new ArrayList<ParsedLipUnit>();

    public void addParsedPart(String binValue, int decValue, String nameOfValue) {
        ParsedLipUnit parsedLipUnit = new ParsedLipUnit();
        parsedLipUnit.setBinValue(binValue);
        parsedLipUnit.setDecValue(decValue);
        parsedLipUnit.setNameOfValue(nameOfValue);
        parsedMessage.add(parsedLipUnit);
    }

    @Override
    public String toString() {
        StringBuilder outputText = new StringBuilder();
        for(int i=0; parsedMessage.size()<i; i++){
            outputText.append(parsedMessage.get(i).toString()).append("\n");
        }
        return outputText.toString();
    }

    public List<ParsedLipUnit> getParsedMessage() {
        return parsedMessage;
    }
}
