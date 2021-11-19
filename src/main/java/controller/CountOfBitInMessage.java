package controller;

import model.MessageFromLip;
import model.MessageFromLipUnit;

import java.util.List;

public class CountOfBitInMessage {

    private MessageFromLip messageFromLip;

    public CountOfBitInMessage(MessageFromLip messageFromLip) {
        this.messageFromLip = messageFromLip;
    }

    public int countOfBitsInMessage() {
        List<MessageFromLipUnit> messages = messageFromLip.getMessageFromLip();
        Integer countOfBits=0;
        for (int i=6; i<messages.size(); i++) {
           countOfBits += messages.get(i).getBinValue().length();
        }
        return countOfBits;
    }



}
