package controller;

import model.ParsedLipMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParserLipMessages {

    @Test
    public void testParsedShortLipMessage() {
        String parsedMessages = "000000000000000000000000010011110000000000000000000110110111011100000000000000000000000000001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010100000010100000000110101100011000001000101001111010001000001101100000000000000000000000";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        ParsedLipMessage parsedLipMessage =  parserLipMessages.parseLipMessage(parsedMessages);
        ParsedLipMessage rightParsedLipMessage = new ParsedLipMessage();
        rightParsedLipMessage.addParsedPart("00000000000000000000000001001111",79,"number of packet");
        rightParsedLipMessage.addParsedPart("00000000000000000001101101110111",7031,"subscriber number");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000001010",0,"base station number");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000000000",0,"longitude");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000000000",0,"latitude");
        rightParsedLipMessage.addParsedPart("00000000000000000000000001010100",84,"length in bits");
        rightParsedLipMessage.addParsedPart("00001010",10,"PDU header");
        rightParsedLipMessage.addParsedPart("00",0,"Short Location report");
        rightParsedLipMessage.addParsedPart("00", 0, "None");
        rightParsedLipMessage.addParsedPart("0001101011000110000010001",3509265, "37,6503288745");
        rightParsedLipMessage.addParsedPart("010011110100010000011011",5194779,"55,7339322566");
        rightParsedLipMessage.addParsedPart("000",0,"less than 2 m");
        rightParsedLipMessage.addParsedPart("0000000",0,"0 km/h");
        rightParsedLipMessage.addParsedPart("0000",0, "0 North (N)");
        rightParsedLipMessage.addParsedPart("0", 0, "Reason for sending");
        rightParsedLipMessage.addParsedPart("00000000",0,"Subscriber unit is powered ON");
        Assertions.assertEquals(rightParsedLipMessage,parsedLipMessage);


    }

    @Test
    public void testParsedShortLipMessageWithUserDefinedData() {
        String parsedMessages = "0000000000000000000000000100111100000000000000000001101101110111000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010101000000101000000000000000000000000000000000000000000000000000000111111111111111010101010001";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        ParsedLipMessage parsedLipMessage =  parserLipMessages.parseLipMessage(parsedMessages);
        ParsedLipMessage rightParsedLipMessage = new ParsedLipMessage();
        rightParsedLipMessage.addParsedPart("00000000000000000000000001001111",79,"number of packet");
        rightParsedLipMessage.addParsedPart("00000000000000000001101101110111",7031,"subscriber number");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000001010",0,"base station number");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000000000",0,"longitude");
        rightParsedLipMessage.addParsedPart("00000000000000000000000000000000",0,"latitude");
        rightParsedLipMessage.addParsedPart("00000000000000000000000001010100",84,"length in bits");
        rightParsedLipMessage.addParsedPart("00001010",10,"PDU header");
        rightParsedLipMessage.addParsedPart("00",0,"Short Location report");
        rightParsedLipMessage.addParsedPart("00", 0, "None");
        rightParsedLipMessage.addParsedPart("0000000000000000000000000",3509265, "0E-10");
        rightParsedLipMessage.addParsedPart("000000000000000000000000",5194779,"0E-10");
        rightParsedLipMessage.addParsedPart("111",7,"Position error not known");
        rightParsedLipMessage.addParsedPart("1111111",127,"Horizontal speed is not known");
        rightParsedLipMessage.addParsedPart("1111",15,"337,5 or direction of travel is not known NNW");
        rightParsedLipMessage.addParsedPart("1",1, "User defined data");
        rightParsedLipMessage.addParsedPart("010101010001", 0,"user define value");
        Assertions.assertEquals(rightParsedLipMessage,parsedLipMessage);
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
