package controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static controller.ParserHelper.*;


public class TestParserHelperMethods {

    @Test
    public void testCalculateLatitudeFromLipBits() {
        Assertions.assertEquals("-89.9999892712", calculateLatitudeFromLipBits("111111111111111111111111"));
        Assertions.assertEquals("-0.0000107288", calculateLatitudeFromLipBits("100000000000000000000001"));

        Assertions.assertEquals("-0E-10", calculateLatitudeFromLipBits("100000000000000000000000"));
        Assertions.assertEquals("0E-10", calculateLatitudeFromLipBits("000000000000000000000000"));

        Assertions.assertEquals("0.0000107288", calculateLatitudeFromLipBits("000000000000000000000001"));
        Assertions.assertEquals("89.9999892712", calculateLatitudeFromLipBits("011111111111111111111111"));

    }

    @Test
    public void testCalculateLongitudeFromLipBits() {
        Assertions.assertEquals("-179.9999892712", calculateLongitudeFromLipBits("1111111111111111111111111"));
        Assertions.assertEquals("-0.0000107288", calculateLongitudeFromLipBits("1000000000000000000000001"));

        Assertions.assertEquals("-0E-10", calculateLongitudeFromLipBits("1000000000000000000000000"));
        Assertions.assertEquals("0E-10", calculateLongitudeFromLipBits("0000000000000000000000000"));

        Assertions.assertEquals("0.0000107288", calculateLongitudeFromLipBits("0000000000000000000000001"));
        Assertions.assertEquals("179.9999892712", calculateLongitudeFromLipBits(
                "0111111111111111111111111"));
    }

    @Test
    public void testCalculateAltitudeFromLipBits() {

        Assertions.assertEquals("User define altitude", calculateAltitudeFromLipBits("111111111111"));
        Assertions.assertEquals("User define altitude", calculateAltitudeFromLipBits("100000000000"));

        Assertions.assertEquals("Reserved", calculateAltitudeFromLipBits("000000000000"));

        Assertions.assertEquals("-200 m", calculateAltitudeFromLipBits("000000000001"));
        Assertions.assertEquals("1000 m", calculateAltitudeFromLipBits("010010110001"));

        Assertions.assertEquals("1002 m", calculateAltitudeFromLipBits("010010110010"));
        Assertions.assertEquals("2450 m", calculateAltitudeFromLipBits("011110000110"));

        Assertions.assertEquals("2525 m", calculateAltitudeFromLipBits("011110000111"));
        Assertions.assertEquals("11450 m", calculateAltitudeFromLipBits("011111111110"));

        Assertions.assertEquals("11525 m or more", calculateAltitudeFromLipBits("011111111111"));
    }



}
