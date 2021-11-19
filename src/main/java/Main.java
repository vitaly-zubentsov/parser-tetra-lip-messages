import controller.CountOfBitInMessage;
import controller.ParserLipMessages;
import fr.bmartel.pcapdecoder.PcapDecoder;
import fr.bmartel.pcapdecoder.structure.types.IPcapngType;
import fr.bmartel.pcapdecoder.structure.types.inter.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //String pathToPcapngFile = "src/main/resources/shortlip/short_without_sputniks_hytera_pt580.pcapng";
        //String pathToPcapngFile = "src/main/resources/shortlip/short_without_sputniks_motorola_mtp850.pcapng";
        //String pathToPcapngFile = "src/main/resources/shortlip/short_without_sputniks_sepura_SRH3800.pcapng";
        //String pathToPcapngFile = "src/main/resources/type1/long_1_without_sputniks_hytera_pt580.pcapng";
        //String pathToPcapngFile = "src/main/resources/type2/long_2_without_sputniks_hytera_pt580.pcapng";
        //String pathToPcapngFile = "src/main/resources/type3/long_3_without_sputniks_hytera_pt580.pcapng";
        String pathToPcapngFile = "src/main/resources/4.pcapng";

        System.out.println("Path to pcapng file : " + pathToPcapngFile);
        PcapDecoder decoder = new PcapDecoder(pathToPcapngFile);

        decoder.decode();
        ArrayList<IPcapngType> sectionList = decoder.getSectionList();
        IEnhancedPacketBLock section = (IEnhancedPacketBLock) sectionList.get(2);

        //Get only body of message
        byte[] byteOfMessage = Arrays.copyOfRange(section.getPacketData(), 42, section.getPacketData().length);

        String lipFromPcapng = convertByteArrayToString(byteOfMessage);
        System.out.println(lipFromPcapng);

        ParserLipMessages parsedLipMessage = new ParserLipMessages();
        System.out.println(parsedLipMessage.parseLipMessage(lipFromPcapng).getMessageFromLip().toString());

        CountOfBitInMessage countOfBitInMessage = new CountOfBitInMessage(parsedLipMessage.getMessageFromLip());
        System.out.println("Количество бит подсчитанных вручную = " + countOfBitInMessage.countOfBitsInMessage());
    }

    private static String convertByteArrayToString(byte[] byteOfMessage) {
        StringBuilder binString = new StringBuilder();
        for (int i = 0; i < byteOfMessage.length; i++) {
            int unsignedByte = byteOfMessage[i] & 0xff;
            binString.append(String.format("%8s", (Integer.toBinaryString(unsignedByte))).replace(" ", "0"));
        }
        return binString.toString();
    }


}
