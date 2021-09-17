package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ParserHelper {

    // To understand how calculate longitude from lipLongitude see clause 6.3.50, ETSI TS 100 392-18-1 V1.7.2 (2018-01)
    protected static String calculateLongitudeFromLipBits(String lipBinLongitude) {
        int lipDecLongitude = Integer.parseInt(lipBinLongitude.substring(1), 2);
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
        int lipDecLatitude = Integer.parseInt(lipBinLatitude.substring(1), 2);
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

    // To understand how calculate altitude from lipLatitude see clause 6.3.31, ETSI TS 100 392-18-1 V1.7.2 (2018-01)
    protected static String calculateAltitudeFromLipBits(String lipBinAltitude) {
        int lipDecAltitude = Integer.parseInt(lipBinAltitude.substring(1), 2);

        //define altitude above  positive or negative number
        if (lipBinAltitude.substring(0, 1).equalsIgnoreCase("1")) {
            return "User define altitude";
        } else if (lipDecAltitude == 0) {
            return "Reserved";
        } else if (lipDecAltitude < 1202) {
            return Integer.toString(-201 + lipDecAltitude) + " m";
        } else if (lipDecAltitude < 1927) {
            return Integer.toString(1000 + (lipDecAltitude - 1201) * 2) + " m";
        } else if (lipDecAltitude < 2047) {
            return Integer.toString(2450 +(lipDecAltitude - 1926) * 75) + " m";
        } else {
            return "11525 m or more";
        }
    }


    protected static Integer convertBinToDec(String substring) {
        return Math.toIntExact(Long.parseLong(substring, 2));
    }
}
