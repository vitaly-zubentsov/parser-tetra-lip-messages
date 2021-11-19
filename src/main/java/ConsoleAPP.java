import controller.ParserLipMessages;

public class ConsoleAPP {

    public static void main(String[] args) {

        String lipMessage =
                "00000000000000000100000000000010"+
                        "00000000000000000001111101000100"+
        "00000000000000000000000000001010" +
                        "00000000000000000000000000000000" +
                        "00000000000000000000000000000000" +
                        "00000000000000000000000010100110" +                        "0000101001001100010100011010101101011001110000100111100111100110111010000000000000000001010000000000000000010000001000010111000000010011111010001100110010111111";

        ParserLipMessages parsedLipMessage = new ParserLipMessages();
        System.out.println(parsedLipMessage.parseLipMessage(lipMessage).getMessageFromLip().toString());

    }

}
