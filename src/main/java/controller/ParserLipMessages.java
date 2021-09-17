package controller;

import model.BaseProtocolUnits;
import model.LipProtocolUnits;
import model.MessageFromLip;

import static controller.ParserHelper.*;
import static controller.ParserHelper.convertBinToDec;

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
            parseLongLip(messageForParsing);
        } else {
            messageFromLip.addParsedPart(pduTypeInBits, pduTypeInDec, pduType.getData().get(pduTypeInDec));
        }
        return this.messageFromLip;
    }

    private void parseLongLip(StringBuilder messageForParsing) {
        BaseProtocolUnits pduTypeExtension = lipProtocolUnits.getPduTypeExtension();
        String pduTypeExtensionInBits = messageForParsing.substring(0, pduTypeExtension.getCountOfBits());
        int pduTypeExtensionInDec = convertBinToDec(pduTypeExtensionInBits);
        messageForParsing.delete(0, pduTypeExtension.getCountOfBits());
        messageFromLip.addParsedPart(pduTypeExtensionInBits, pduTypeExtensionInDec, pduTypeExtension.getData().get(pduTypeExtensionInDec));

        BaseProtocolUnits timeType = lipProtocolUnits.getTimeType();
        String timeTypeInBits = messageForParsing.substring(0, timeType.getCountOfBits());
        int timeTypeInDec = convertBinToDec(timeTypeInBits);
        messageForParsing.delete(0, timeType.getCountOfBits());
        messageFromLip.addParsedPart(timeTypeInBits, timeTypeInDec, timeType.getData().get(timeTypeInDec));

        if (timeTypeInDec == 1) {
            //Parse Time Elapsed
            BaseProtocolUnits timeElapsed = lipProtocolUnits.getTimeElapsed();
            String timeElapsedInBits = messageForParsing.substring(0, timeElapsed.getCountOfBits());
            int timeElapsedInDec = convertBinToDec(timeElapsedInBits);
            messageForParsing.delete(0, timeElapsed.getCountOfBits());
            messageFromLip.addParsedPart(timeElapsedInBits, timeElapsedInDec, timeElapsed.getData().get(timeElapsedInDec));
        } else if (timeTypeInDec == 2) {
            //Parse TimeOfPosition
            BaseProtocolUnits dayTimeOfPosition = lipProtocolUnits.getDayTimeOfPosition();
            String dayTimeOfPositionInBits = messageForParsing.substring(0, dayTimeOfPosition.getCountOfBits());
            int dayTimeOfPositionInDec = convertBinToDec(dayTimeOfPositionInBits);
            messageForParsing.delete(0, dayTimeOfPosition.getCountOfBits());
            messageFromLip.addParsedPart(dayTimeOfPositionInBits, dayTimeOfPositionInDec, dayTimeOfPosition.getData().get(dayTimeOfPositionInDec));

            BaseProtocolUnits hourTimeOfPosition = lipProtocolUnits.getHourTimeOfPosition();
            String hourTimeOfPositionInBits = messageForParsing.substring(0, hourTimeOfPosition.getCountOfBits());
            int hourTimeOfPositionInDec = convertBinToDec(hourTimeOfPositionInBits);
            messageForParsing.delete(0, hourTimeOfPosition.getCountOfBits());
            messageFromLip.addParsedPart(hourTimeOfPositionInBits, hourTimeOfPositionInDec, hourTimeOfPosition.getData().get(hourTimeOfPositionInDec));

            BaseProtocolUnits minuteTimeOfPosition = lipProtocolUnits.getMinuteTimeOfPosition();
            String minuteTimeOfPositionInBits = messageForParsing.substring(0, minuteTimeOfPosition.getCountOfBits());
            int minuteTimeOfPositionInDec = convertBinToDec(minuteTimeOfPositionInBits);
            messageForParsing.delete(0, minuteTimeOfPosition.getCountOfBits());
            messageFromLip.addParsedPart(minuteTimeOfPositionInBits, minuteTimeOfPositionInDec, minuteTimeOfPosition.getData().get(minuteTimeOfPositionInDec));

            BaseProtocolUnits secondTimeOfPosition = lipProtocolUnits.getSecondTimeOfPosition();
            String secondTimeOfPositionInBits = messageForParsing.substring(0, secondTimeOfPosition.getCountOfBits());
            int secondTimeOfPositionInDec = convertBinToDec(secondTimeOfPositionInBits);
            messageForParsing.delete(0, secondTimeOfPosition.getCountOfBits());
            messageFromLip.addParsedPart(secondTimeOfPositionInBits, secondTimeOfPositionInDec, secondTimeOfPosition.getData().get(secondTimeOfPositionInDec));
        }

        BaseProtocolUnits locationShape = lipProtocolUnits.getLocationShape();
        String locationShapeInBits = messageForParsing.substring(0, locationShape.getCountOfBits());
        int locationShapeInDec = convertBinToDec(locationShapeInBits);
        messageForParsing.delete(0, locationShape.getCountOfBits());
        messageFromLip.addParsedPart(locationShapeInBits, locationShapeInDec, locationShape.getData().get(locationShapeInDec));

        String lipLongitudeInBits = messageForParsing.substring(0, 25);
        messageForParsing.delete(0, 25);
        messageFromLip.addParsedPart(lipLongitudeInBits,
                convertBinToDec(lipLongitudeInBits), calculateLongitudeFromLipBits(lipLongitudeInBits));

        String lipLatitudeInBits = messageForParsing.substring(0, 24);
        messageForParsing.delete(0, 24);
        messageFromLip.addParsedPart(lipLatitudeInBits,
                convertBinToDec(lipLatitudeInBits), calculateLatitudeFromLipBits(lipLatitudeInBits));

        BaseProtocolUnits positionUncertainty = lipProtocolUnits.getHorizontalPositionUncertainty();
        String positionUncertaintyInBits = messageForParsing.substring(0, positionUncertainty.getCountOfBits());
        int positionUncertaintyInDec = convertBinToDec(positionUncertaintyInBits);
        messageForParsing.delete(0, positionUncertainty.getCountOfBits());
        messageFromLip.addParsedPart(positionUncertaintyInBits, positionUncertaintyInDec, positionUncertainty.getData().get(positionUncertaintyInDec));

        String lipAltitudeInBits = messageForParsing.substring(0, 12);
        messageForParsing.delete(0, 12);
        messageFromLip.addParsedPart(lipAltitudeInBits,
                convertBinToDec(lipAltitudeInBits), calculateAltitudeFromLipBits(lipAltitudeInBits));

        BaseProtocolUnits velocityType = lipProtocolUnits.getVelocityType();
        String velocityTypeInBits = messageForParsing.substring(0, velocityType.getCountOfBits());
        int velocityTypeInDec = convertBinToDec(velocityTypeInBits);
        messageForParsing.delete(0, velocityType.getCountOfBits());
        messageFromLip.addParsedPart(velocityTypeInBits, velocityTypeInDec, velocityType.getData().get(velocityTypeInDec));

        BaseProtocolUnits horizontalVelocity = lipProtocolUnits.getHorizontalVelocity();
        String horizontalVelocityInBits = messageForParsing.substring(0, horizontalVelocity.getCountOfBits());
        int horizontalVelocityInDec = convertBinToDec(horizontalVelocityInBits);
        messageForParsing.delete(0, horizontalVelocity.getCountOfBits());
        messageFromLip.addParsedPart(horizontalVelocityInBits, horizontalVelocityInDec, horizontalVelocity.getData().get(horizontalVelocityInDec));

        BaseProtocolUnits directionOfTravelExtended = lipProtocolUnits.getDirectionOfTravelExtended();
        String directionOfTravelExtendedInBits = messageForParsing.substring(0, directionOfTravelExtended.getCountOfBits());
        int directionOfTravelExtendedInDec = convertBinToDec(directionOfTravelExtendedInBits);
        messageForParsing.delete(0, directionOfTravelExtended.getCountOfBits());
        messageFromLip.addParsedPart(directionOfTravelExtendedInBits, directionOfTravelExtendedInDec, directionOfTravelExtended.getData().get(directionOfTravelExtendedInDec));

        BaseProtocolUnits acknowledgementRequest = lipProtocolUnits.getAcknowledgementRequest();
        String acknowledgementRequestInBits = messageForParsing.substring(0, acknowledgementRequest.getCountOfBits());
        int acknowledgementRequestInDec = convertBinToDec(acknowledgementRequestInBits);
        messageForParsing.delete(0, acknowledgementRequest.getCountOfBits());
        messageFromLip.addParsedPart(acknowledgementRequestInBits, acknowledgementRequestInDec, acknowledgementRequest.getData().get(acknowledgementRequestInDec));

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
            messageFromLip.addParsedPart(messageForParsing.toString(), 0, "padding");
        } else {
            //insert user define value
            messageFromLip.addParsedPart(messageForParsing.toString(), 0, "user define value");
        }




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
            messageFromLip.addParsedPart(messageForParsing.toString(), 0, "padding");
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
