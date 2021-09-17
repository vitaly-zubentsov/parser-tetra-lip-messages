package controller;

import model.MessageFromLip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestParserLipMessages {

    @Test
    public void testParsedShortLipMessage() {
        String lipMessageInBits =
                "0000000000000000000000000100111100000000000000000001101101110111000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010101000000101000000001101011000110000010001010011110100010000011011000000000000000000000000";

        ParserLipMessages parserLipMessages = new ParserLipMessages();
        MessageFromLip messageFromLip = parserLipMessages.parseLipMessage(lipMessageInBits);

        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111", 79, "number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111", 7031, "subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010", 10, "base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001010100", 84, "length in bits");
        rightMessageFromLip.addParsedPart("00001010", 10, "PDU header");
        rightMessageFromLip.addParsedPart("00", 0, "Short Location report");
        rightMessageFromLip.addParsedPart("00", 0, "less than 5 s");
        rightMessageFromLip.addParsedPart("0001101011000110000010001", 3509265, "37.6503288746");
        rightMessageFromLip.addParsedPart("010011110100010000011011", 5194779, "55.7339322567");
        rightMessageFromLip.addParsedPart("000", 0, "less than 2 m");
        rightMessageFromLip.addParsedPart("0000000", 0, "0 km/h");
        rightMessageFromLip.addParsedPart("0000", 0, "0 North (N)");
        rightMessageFromLip.addParsedPart("0", 0, "Reason for sending");
        rightMessageFromLip.addParsedPart("00000000", 0, "Subscriber unit is powered ON");
        rightMessageFromLip.addParsedPart("0", 0, "padding");
        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
    }

    @Test
    public void testParsedShortLipMessageWithUserDefinedData() {
        String parsedMessages = "0000000000000000000000000100111100000000000000000001101101110111000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010101000000101000000000000000000000000000000000000000000000000000000111111111111111010101010001";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        MessageFromLip messageFromLip = parserLipMessages.parseLipMessage(parsedMessages);
        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111", 79, "number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111", 7031, "subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010", 10, "base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001010100", 84, "length in bits");
        rightMessageFromLip.addParsedPart("00001010", 10, "PDU header");
        rightMessageFromLip.addParsedPart("00", 0, "Short Location report");
        rightMessageFromLip.addParsedPart("00", 0, "less than 5 s");
        rightMessageFromLip.addParsedPart("0000000000000000000000000", 0, "0E-10");
        rightMessageFromLip.addParsedPart("000000000000000000000000", 0, "0E-10");
        rightMessageFromLip.addParsedPart("111", 7, "Position error not known");
        rightMessageFromLip.addParsedPart("1111111", 127, "Horizontal speed is not known");
        rightMessageFromLip.addParsedPart("1111", 15, "337,5 or direction of travel is not known NNW");
        rightMessageFromLip.addParsedPart("1", 1, "User defined data");
        rightMessageFromLip.addParsedPart("010101010001", 0, "user define value");

        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
    }

    @Test
    public void testParsedLongLipType1Message() {
        String parsedMessages =
                "00000000000000000000000001001111000000000000000000011011011101110000000000000000000000000000101000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111001100001010010011000101000110101100011000001000101001111010001000001101100000001111111111110100000000000000000000000000";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        MessageFromLip messageFromLip = parserLipMessages.parseLipMessage(parsedMessages);
        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111", 79, "number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111", 7031, "subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010", 10, "base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001110011", 115, "length in bits");
        rightMessageFromLip.addParsedPart("00001010", 10, "PDU header");
        rightMessageFromLip.addParsedPart("01", 1, "Location protocol PDU with extension");
        rightMessageFromLip.addParsedPart("0011", 3, "Long location report");
        rightMessageFromLip.addParsedPart("00", 0, "None");
        rightMessageFromLip.addParsedPart("0101", 5, "Location circle with altitude");
        rightMessageFromLip.addParsedPart("0001101011000110000010001", 3509265, "37.6503288746");
        rightMessageFromLip.addParsedPart("010011110100010000011011", 5194779, "55.7339322567");
        rightMessageFromLip.addParsedPart("000000", 0, "Less than 1 m");
        rightMessageFromLip.addParsedPart("011111111111", 2047, "11525 m or more");
        rightMessageFromLip.addParsedPart("101", 5, "Horizontal velocity with direction of travel extended");
        rightMessageFromLip.addParsedPart("0000000", 0, "0 km/h");
        rightMessageFromLip.addParsedPart("00000000", 0, "Direction in degrees 0 (clockwise from north)");
        rightMessageFromLip.addParsedPart("0", 0, "No acknowledgement requested");
        rightMessageFromLip.addParsedPart("0", 0, "Reason for sending");
        rightMessageFromLip.addParsedPart("00000000", 0, "Subscriber unit is powered ON");
        rightMessageFromLip.addParsedPart("0", 0, "padding");
        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
    }

    @Test
    public void testParsedLongLipType2Message() {
        String parsedMessages = "0000000000000000000000000100111100000000000000000001101101110111000000000000000000000000000010100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010000101001001101000101000110101100011000001000101001111010001000001101111111101111111111110111111111111111110000000000";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        MessageFromLip messageFromLip = parserLipMessages.parseLipMessage(parsedMessages);
        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111", 79, "number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111", 7031, "subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010", 10, "base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000001110101", 117, "length in bits");
        rightMessageFromLip.addParsedPart("00001010", 10, "PDU header");
        rightMessageFromLip.addParsedPart("01", 1, "Location protocol PDU with extension");
        rightMessageFromLip.addParsedPart("0011", 3, "Long location report");
        rightMessageFromLip.addParsedPart("01", 1, "Time elapsed");
        rightMessageFromLip.addParsedPart("00", 0, "less than 5 s");
        rightMessageFromLip.addParsedPart("0101", 5, "Location circle with altitude");
        rightMessageFromLip.addParsedPart("0001101011000110000010001", 3509265, "37.6503288746");
        rightMessageFromLip.addParsedPart("010011110100010000011011", 5194779, "55.7339322567");
        rightMessageFromLip.addParsedPart("111111", 63, "Best effort");
        rightMessageFromLip.addParsedPart("011111111111", 2047, "11525 m or more");
        rightMessageFromLip.addParsedPart("101", 5, "Horizontal velocity with direction of travel extended");
        rightMessageFromLip.addParsedPart("1111111", 127, "Horizontal speed is not known");
        rightMessageFromLip.addParsedPart("11111111", 255, "Direction in degrees 358,6 (clockwise from north)");
        rightMessageFromLip.addParsedPart("1", 1, "Acknowledgement requested");
        rightMessageFromLip.addParsedPart("0", 0, "Reason for sending");
        rightMessageFromLip.addParsedPart("00000000", 0, "Subscriber unit is powered ON");
        rightMessageFromLip.addParsedPart("0", 0, "padding");
        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());

    }

    @Test
    public void testParsedLongLipType3Message() {
        String parsedMessages = "000000000000000000000000010011110000000000000000000110110111011100000000000000000000000000001010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001001000010100100111000001000000000000000000101000110101100011000001000101001111010001000001101100000001111111111110100000000000000000000000000";
        ParserLipMessages parserLipMessages = new ParserLipMessages();

        MessageFromLip messageFromLip = parserLipMessages.parseLipMessage(parsedMessages);
        MessageFromLip rightMessageFromLip = new MessageFromLip();
        rightMessageFromLip.addParsedPart("00000000000000000000000001001111", 79, "number of packet");
        rightMessageFromLip.addParsedPart("00000000000000000001101101110111", 7031, "subscriber number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000001010", 10, "base station number");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "longitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000000000000", 0, "latitude");
        rightMessageFromLip.addParsedPart("00000000000000000000000010001001", 137, "length in bits");
        rightMessageFromLip.addParsedPart("00001010", 10, "PDU header");
        rightMessageFromLip.addParsedPart("01", 1, "Location protocol PDU with extension");
        rightMessageFromLip.addParsedPart("0011", 3, "Long location report");
        rightMessageFromLip.addParsedPart("10", 2, "Time of position");
        rightMessageFromLip.addParsedPart("00001", 1, "Day Number 1");
        rightMessageFromLip.addParsedPart("00000", 0, "Hour number 0");
        rightMessageFromLip.addParsedPart("000000", 0, "Minute number 0");
        rightMessageFromLip.addParsedPart("000000", 0, "Second number 0");
        rightMessageFromLip.addParsedPart("0101", 5, "Location circle with altitude");
        rightMessageFromLip.addParsedPart("0001101011000110000010001", 3509265, "37.6503288746");
        rightMessageFromLip.addParsedPart("010011110100010000011011", 5194779, "55.7339322567");
        rightMessageFromLip.addParsedPart("000000", 0, "Less than 1 m");
        rightMessageFromLip.addParsedPart("011111111111", 2047, "11525 m or more");
        rightMessageFromLip.addParsedPart("101", 5, "Horizontal velocity with direction of travel extended");
        rightMessageFromLip.addParsedPart("0000000", 0, "0 km/h");
        rightMessageFromLip.addParsedPart("00000000", 0, "Direction in degrees 0 (clockwise from north)");
        rightMessageFromLip.addParsedPart("0", 0, "No acknowledgement requested");
        rightMessageFromLip.addParsedPart("0", 0, "Reason for sending");
        rightMessageFromLip.addParsedPart("00000000", 0, "Subscriber unit is powered ON");
        rightMessageFromLip.addParsedPart("0", 0, "padding");
        Assertions.assertArrayEquals(rightMessageFromLip.getMessageFromLip().toArray(), messageFromLip.getMessageFromLip().toArray());
    }

}
