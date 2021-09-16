package controller;

import model.BaseProtocolUnits;
import model.LipProtocolUnits;
import model.MessageFromLip;

import static controller.ParserHelper.*;

public class ParserLipMessages {

    MessageFromLip messageFromLip = new MessageFromLip();
    LipProtocolUnits lipProtocolUnits = new LipProtocolUnits();

    public MessageFromLip getMessageFromLip() {
        return messageFromLip;
    }

    public MessageFromLip parseLipMessage(String lipMessage) {

        StringBuilder messageForParsing = new StringBuilder(lipMessage);
        parseTetraServerHead(messageForParsing.substring(0, 200));
        messageForParsing.delete(0, 200);

        BaseProtocolUnits pduType = lipProtocolUnits.getPduType();
        String pduTypeInBits = messageForParsing.substring(0, pduType.getCountOfBits());
        int pduTypeInDec = convertBinToDec(pduTypeInBits);
        messageForParsing.delete(0, pduType.getCountOfBits());
        if (pduTypeInBits.equalsIgnoreCase("00")) {
            messageFromLip.addParsedPart(pduTypeInBits, pduTypeInDec, pduType.getData().get(pduTypeInDec));
            parseShortLip(messageForParsing);
        } else if (pduTypeInBits.equalsIgnoreCase("01")) {
            messageFromLip.addParsedPart(pduTypeInBits, pduTypeInDec, pduType.getData().get(pduTypeInDec));
            //parseLongLip(messageForParsing);
        } else {
            messageFromLip.addParsedPart(pduTypeInBits, pduTypeInDec, pduType.getData().get(pduTypeInDec));
        }
        return this.messageFromLip;
    }

    private void parseShortLip(StringBuilder messageForParsing) {
        BaseProtocolUnits timeElapsed = lipProtocolUnits.getTimeElapsed();
        String timeElapsedInBits = messageForParsing.substring(0, timeElapsed.getCountOfBits());
        int timeElapsedInDec = convertBinToDec(timeElapsedInBits);
        messageForParsing.delete(0, timeElapsed.getCountOfBits());
        messageFromLip.addParsedPart(timeElapsedInBits, timeElapsedInDec, timeElapsed.getData().get(timeElapsedInDec));

        String lipLongitudeInBits = messageForParsing.substring(0, 25);
        messageForParsing.delete(0, 25);
        messageFromLip.addParsedPart(lipLongitudeInBits,
                convertBinToDec(lipLongitudeInBits), calculateLongitudeFromLipBits(lipLongitudeInBits));

        String lipLatitudeInBits = messageForParsing.substring(0, 24);
        messageForParsing.delete(0, 24);
        messageFromLip.addParsedPart(lipLatitudeInBits,
                convertBinToDec(lipLatitudeInBits), calculateLatitudeFromLipBits(lipLatitudeInBits));

        BaseProtocolUnits positionError = lipProtocolUnits.getPositionError();
        String positionErrorInBits = messageForParsing.substring(0, positionError.getCountOfBits());
        int positionErrorInDec = convertBinToDec(positionErrorInBits);
        messageForParsing.delete(0, positionError.getCountOfBits());
        messageFromLip.addParsedPart(positionErrorInBits, positionErrorInDec, positionError.getData().get(positionErrorInDec));

        BaseProtocolUnits horizontalVelocity = lipProtocolUnits.getHorizontalVelocity();
        String horizontalVelocityInBits = messageForParsing.substring(0, horizontalVelocity.getCountOfBits());
        int horizontalVelocityInDec = convertBinToDec(horizontalVelocityInBits);
        messageForParsing.delete(0, horizontalVelocity.getCountOfBits());
        messageFromLip.addParsedPart(horizontalVelocityInBits, horizontalVelocityInDec, horizontalVelocity.getData().get(horizontalVelocityInDec));

        BaseProtocolUnits directionOfTravel = lipProtocolUnits.getDirectionalOfTravel();
        String directionOfTravelInBits = messageForParsing.substring(0, directionOfTravel.getCountOfBits());
        int directionOfTravelInDec = convertBinToDec(directionOfTravelInBits);
        messageForParsing.delete(0, directionOfTravel.getCountOfBits());
        messageFromLip.addParsedPart(directionOfTravelInBits, directionOfTravelInDec, directionOfTravel.getData().get(directionOfTravelInDec));

        BaseProtocolUnits typeOfAdditional = lipProtocolUnits.getTypeOfAdditionalData();
        String typeOfAdditionalInBits = messageForParsing.substring(0, typeOfAdditional.getCountOfBits());
        int typeOfAdditionalInDec = convertBinToDec(typeOfAdditionalInBits);
        messageForParsing.delete(0, typeOfAdditional.getCountOfBits());
        messageFromLip.addParsedPart(typeOfAdditionalInBits, typeOfAdditionalInDec, typeOfAdditional.getData().get(typeOfAdditionalInDec));
        if (typeOfAdditionalInBits.equalsIgnoreCase("0")) {
            //parse Reason for sending
            BaseProtocolUnits reasonForSending = lipProtocolUnits.getReasonForSending();
            String reasonForSendingInBits = messageForParsing.substring(0, reasonForSending.getCountOfBits());
            int reasonForSendingInDec = convertBinToDec(reasonForSendingInBits);
            messageForParsing.delete(0, reasonForSending.getCountOfBits());
            messageFromLip.addParsedPart(reasonForSendingInBits, reasonForSendingInDec, reasonForSending.getData().get(reasonForSendingInDec));

        } else {
            //insert user define value
            messageFromLip.addParsedPart(messageForParsing.toString(), 0, "user define value");
        }
    }

    private void parseTetraServerHead(String tetraHead) {

        String packetNumber = tetraHead.substring(0, 32);
        messageFromLip.addParsedPart(packetNumber, convertBinToDec(packetNumber), "number of packet");

        String ssiNumber = tetraHead.substring(32, 64);
        messageFromLip.addParsedPart(ssiNumber, convertBinToDec(ssiNumber), "subscriber number");

        String baseStationNumber = tetraHead.substring(64, 96);
        messageFromLip.addParsedPart(baseStationNumber, convertBinToDec(baseStationNumber), "base station number");

        String longitude = tetraHead.substring(96, 128);
        messageFromLip.addParsedPart(longitude, convertBinToDec(longitude), "longitude");

        String latitude = tetraHead.substring(128, 160);
        messageFromLip.addParsedPart(latitude, convertBinToDec(latitude), "latitude");

        String lengthInBits = tetraHead.substring(160, 192);
        messageFromLip.addParsedPart(lengthInBits, convertBinToDec(lengthInBits), "length in bits");

        String pduHeader = tetraHead.substring(192, 200);
        messageFromLip.addParsedPart(pduHeader, convertBinToDec(pduHeader), "PDU header");
    }

}
