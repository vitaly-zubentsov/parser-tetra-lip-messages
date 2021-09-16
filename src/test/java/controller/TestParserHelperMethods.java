package controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static controller.ParserHelper.calculateLatitudeFromLipBits;
import static controller.ParserHelper.calculateLongitudeFromLipBits;


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


}
