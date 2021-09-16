package controller;

import model.MessageFromLip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParserLipMessages {

    @Test
    public void testParsedShortLipMessage() {
        String lipMessageInBits =
                "000000000000000000000000010011110000000000000000000110110111011100000000000000000000000000001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010100000010100000000110101100011000001000101001111010001000001101100000000000000000000000";

        ParserLipMessages parserLipMessages = new ParserLipMessages();
        MessageFromLip messageFromLip =  parserLipMessages.parseLipMessage(lipMessageInBits);

        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111",79,"number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111",7031,"subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010",10,"base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000",0,"longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000",0,"latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001010100",84,"length in bits");
        rightMessageFromLip.addParsedPart("00001010",10,"PDU header");
        rightMessageFromLip.addParsedPart("00",0,"Short Location report");
        rightMessageFromLip.addParsedPart("00", 0, "less than 5 s");
        rightMessageFromLip.addParsedPart("0001101011000110000010001",3509265, "37.6503288746");
        rightMessageFromLip.addParsedPart("010011110100010000011011",5194779,"55.7339322567");
        rightMessageFromLip.addParsedPart("000",0,"less than 2 m");
        rightMessageFromLip.addParsedPart("0000000",0,"0 km/h");
        rightMessageFromLip.addParsedPart("0000",0, "0 North (N)");
        rightMessageFromLip.addParsedPart("0", 0, "Reason for sending");
        rightMessageFromLip.addParsedPart("00000000",0,"Subscriber unit is powered ON");

        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
  }

    @Test
    public void testParsedShortLipMessageWithUserDefinedData() {
        String parsedMessages = "0000000000000000000000000100111100000000000000000001101101110111000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010101000000101000000000000000000000000000000000000000000000000000000111111111111111010101010001";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        MessageFromLip messageFromLip =  parserLipMessages.parseLipMessage(parsedMessages);
        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111",79,"number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111",7031,"subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010",10,"base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000",0,"longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000",0,"latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001010100",84,"length in bits");
        rightMessageFromLip.addParsedPart("00001010",10,"PDU header");
        rightMessageFromLip.addParsedPart("00",0,"Short Location report");
        rightMessageFromLip.addParsedPart("00", 0, "less than 5 s");
        rightMessageFromLip.addParsedPart("0000000000000000000000000",0, "0E-10");
        rightMessageFromLip.addParsedPart("000000000000000000000000",0,"0E-10");
        rightMessageFromLip.addParsedPart("111",7,"Position error not known");
        rightMessageFromLip.addParsedPart("1111111",127,"Horizontal speed is not known");
        rightMessageFromLip.addParsedPart("1111",15,"337,5 or direction of travel is not known NNW");
        rightMessageFromLip.addParsedPart("1",1, "User defined data");
        rightMessageFromLip.addParsedPart("010101010001", 0,"user define value");

        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
    }

    @Test
    public void testParsedLongLipType1Message() {

    }

    @Test
    public void testParsedLongLipType2Message() {

    }

    @Test
    public void testParsedLongLipType3Message() {

    }

}
