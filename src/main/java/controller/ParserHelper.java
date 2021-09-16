package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ParserHelper {

    // To understand how calculate longitude from lipLongitude see clause 6.3.50, ETSI TS 100 392-18-1 V1.7.2 (2018-01)
    protected static String calculateLongitudeFromLipBits(String lipBinLongitude) {
        double lipDecLongitude = Long.parseLong(lipBinLongitude.substring(1), 2);
        double stepOfCalculating = 360.0 / 33554432;// 360 /(2 ^ 25);
        double longitude = lipDecLongitude * stepOfCalculating;
        BigDecimal roundLongitude = new BigDecimal(longitude).setScale(10, RoundingMode.HALF_UP);
        //define a positive or negative number
        if (lipBinLongitude.substring(0, 1).equalsIgnoreCase("0")) {
            return roundLongitude.toString();
        } else {
            return "-" + roundLongitude;
        }
    }

    // To understand how calculate latitude from lipLatitude see clause 6.3.30, ETSI TS 100 392-18-1 V1.7.2 (2018-01)
    protected static String calculateLatitudeFromLipBits(String lipBinLatitude) {
        double lipDecLatitude = Long.parseLong(lipBinLatitude.substring(1), 2);
        double stepOfCalculating = 180.0 / 16777216; //180/(2^24)
        double latitude = lipDecLatitude * stepOfCalculating;
        BigDecimal roundLatitude = new BigDecimal(latitude).setScale(10, RoundingMode.HALF_UP);
        //define a positive or negative number
        if (lipBinLatitude.substring(0, 1).equalsIgnoreCase("0")) {
            return roundLatitude.toString();
        } else {
            return "-" + roundLatitude;
        }
    }



    protected static Integer convertBinToDec(String substring) {
        return Math.toIntExact(Long.parseLong(substring, 2));
    }
}
