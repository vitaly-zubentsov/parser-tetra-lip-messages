package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageFromLip {
    private List<MessageFromLipUnit> messageFromLip = new ArrayList<MessageFromLipUnit>();

    public void addParsedPart(String binValue, int decValue, String nameOfValue) {
        MessageFromLipUnit messageFromLipUnit = new MessageFromLipUnit();
        messageFromLipUnit.setBinValue(binValue);
        messageFromLipUnit.setDecValue(decValue);
        messageFromLipUnit.setNameOfValue(nameOfValue);
        messageFromLip.add(messageFromLipUnit);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFromLip that = (MessageFromLip) o;
        return Objects.equals(messageFromLip, that.messageFromLip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageFromLip);
    }

    public List<MessageFromLipUnit> getMessageFromLip() {
        return messageFromLip;
    }
}
