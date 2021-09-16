package model;

import java.util.HashMap;

//Serialization protocol units from book ETSI TS 100 392-18-1 V1.7.2 (2018-01)
public class LipProtocolUnits {

    //Table 6.91: PDU type information element contents
    private final BaseProtocolUnits pduType = new BaseProtocolUnits(2, new HashMap<Integer, String>() {{
        put(0, "Short Location report");
        put(1, "Long location report");
        put(2, "Reserved for further extension, will not be used in phase 1");
        put(3, "Reserved for further extension, will not be used in phase 1");
    }});

    //Table 6.92: PDU type extension information element contents
    private final BaseProtocolUnits pduTypeExtension = new BaseProtocolUnits(4, new HashMap<Integer, String>() {{
        put(0, "Reserved for further extension");
        put(1, "Immediate location report request");
        put(2, "Reserved");
        put(3, "Long location report");
        put(4, "Location report acknowledgement");
        put(5, "Basic location parameters request/response");
        put(6, "Add/modify trigger request/response ");
        put(7, "Remove trigger request/response ");
        put(8, "Report trigger request/response");
        put(9, "Report basic location parameters request/response");
        put(10, "Location reporting enable/disable request/response");
        put(11, "Location reporting temporary control request/response");
        put(12, "Backlog request/response");
        put(13, "Reserved");
        put(14, "Reserved");
        put(15, "Reserved");
    }});

    //Table 6.114: Time type information element contents
    private final BaseProtocolUnits timeType = new BaseProtocolUnits(2, new HashMap<Integer, String>() {{
        put(0, "None");
        put(1, "Time elapsed");
        put(2, "Time of position");
        put(3, "Reserved");
    }});

    //Table 6.111: Time elapsed information element contents
    private final BaseProtocolUnits timeElapsed = new BaseProtocolUnits(2, new HashMap<Integer, String>() {{
        put(0, "less than 5 s");
        put(1, "less than 5 min");
        put(2, "less than 30 min");
        put(3, "Time elapsed not known or not applicable");
    }});

    //part for Day Table 6.112: Time of position information element contents

    private final BaseProtocolUnits dayTimeOfPosition = new BaseProtocolUnits(5, new HashMap<Integer, String>() {{
        put(0, "Reserved");
        put(1, "Day Number 1");
        put(2, "Day Number 2");
        put(3, "Day Number 3");
        put(4, "Day Number 4");
        put(5, "Day Number 5");
        put(6, "Day Number 6");
        put(7, "Day Number 7");
        put(8, "Day Number 8");
        put(9, "Day Number 9");
        put(10, "Day Number 10");
        put(11, "Day Number 11");
        put(12, "Day Number 12");
        put(13, "Day Number 13");
        put(14, "Day Number 14");
        put(15, "Day Number 15");
        put(16, "Day Number 16");
        put(17, "Day Number 17");
        put(18, "Day Number 18");
        put(19, "Day Number 19");
        put(20, "Day Number 20");
        put(21, "Day Number 21");
        put(22, "Day Number 22");
        put(23, "Day Number 23");
        put(24, "Day Number 24");
        put(25, "Day Number 25");
        put(26, "Day Number 26");
        put(27, "Day Number 27");
        put(28, "Day Number 28");
        put(29, "Day Number 29");
        put(30, "Day Number 30");
        put(31, "Day Number 31");
    }});

    //part for Hour Table 6.112: Time of position information element contents

    private final BaseProtocolUnits hourTimeOfPosition = new BaseProtocolUnits(5, new HashMap<Integer, String>() {{
        put(0, "Hour number 0");
        put(1, "Hour number 1");
        put(2, "Hour number 2");
        put(3, "Hour number 3");
        put(4, "Hour number 4");
        put(5, "Hour number 5");
        put(6, "Hour number 6");
        put(7, "Hour number 7");
        put(8, "Hour number 8");
        put(9, "Hour number 9");
        put(10, "Hour number 10");
        put(11, "Hour number 11");
        put(12, "Hour number 12");
        put(13, "Hour number 13");
        put(14, "Hour number 14");
        put(15, "Hour number 15");
        put(16, "Hour number 16");
        put(17, "Hour number 17");
        put(18, "Hour number 18");
        put(19, "Hour number 19");
        put(20, "Hour number 20");
        put(21, "Hour number 21");
        put(22, "Hour number 22");
        put(23, "Hour number 23");
        put(24, "Reserved");
        put(25, "Reserved");
        put(26, "Reserved");
        put(27, "Reserved");
        put(28, "Reserved");
        put(29, "Reserved");
        put(30, "Reserved");
        put(31, "Reserved");
    }});

    //part for Minute Table 6.112: Time of position information element contents
    private final BaseProtocolUnits minuteTimeOfPosition = new BaseProtocolUnits(6, new HashMap<Integer, String>() {{
        put(0, "Minute number 0");
        put(1, "Minute number 1");
        put(2, "Minute number 2");
        put(3, "Minute number 3");
        put(4, "Minute number 4");
        put(5, "Minute number 5");
        put(6, "Minute number 6");
        put(7, "Minute number 7");
        put(8, "Minute number 8");
        put(9, "Minute number 9");
        put(10, "Minute number 10");
        put(11, "Minute number 11");
        put(12, "Minute number 12");
        put(13, "Minute number 13");
        put(14, "Minute number 14");
        put(15, "Minute number 15");
        put(16, "Minute number 16");
        put(17, "Minute number 17");
        put(18, "Minute number 18");
        put(19, "Minute number 19");
        put(20, "Minute number 20");
        put(21, "Minute number 21");
        put(22, "Minute number 22");
        put(23, "Minute number 23");
        put(24, "Minute number 24");
        put(25, "Minute number 25");
        put(26, "Minute number 26");
        put(27, "Minute number 27");
        put(28, "Minute number 28");
        put(29, "Minute number 29");
        put(30, "Minute number 30");
        put(31, "Minute number 31");
        put(32, "Minute number 32");
        put(33, "Minute number 33");
        put(34, "Minute number 34");
        put(35, "Minute number 35");
        put(36, "Minute number 36");
        put(37, "Minute number 37");
        put(38, "Minute number 38");
        put(39, "Minute number 39");
        put(40, "Minute number 40");
        put(41, "Minute number 41");
        put(42, "Minute number 42");
        put(43, "Minute number 43");
        put(44, "Minute number 44");
        put(45, "Minute number 45");
        put(46, "Minute number 46");
        put(47, "Minute number 47");
        put(48, "Minute number 48");
        put(49, "Minute number 49");
        put(50, "Minute number 50");
        put(51, "Minute number 51");
        put(52, "Minute number 52");
        put(53, "Minute number 53");
        put(54, "Minute number 54");
        put(55, "Minute number 55");
        put(56, "Minute number 56");
        put(57, "Minute number 57");
        put(58, "Minute number 58");
        put(59, "Minute number 59");
        put(60, "Reserved ");
        put(61, "Reserved ");
        put(62, "Reserved ");
        put(63, "Reserved ");

    }});

    //part for Second Table 6.112: Time of position information element contents
    private final BaseProtocolUnits secondTimeOfPosition = new BaseProtocolUnits(6, new HashMap<Integer, String>() {{
        put(0, "Second number 0");
        put(1, "Second number 1");
        put(2, "Second number 2");
        put(3, "Second number 3");
        put(4, "Second number 4");
        put(5, "Second number 5");
        put(6, "Second number 6");
        put(7, "Second number 7");
        put(8, "Second number 8");
        put(9, "Second number 9");
        put(10, "Second number 10");
        put(11, "Second number 11");
        put(12, "Second number 12");
        put(13, "Second number 13");
        put(14, "Second number 14");
        put(15, "Second number 15");
        put(16, "Second number 16");
        put(17, "Second number 17");
        put(18, "Second number 18");
        put(19, "Second number 19");
        put(20, "Second number 20");
        put(21, "Second number 21");
        put(22, "Second number 22");
        put(23, "Second number 23");
        put(24, "Second number 24");
        put(25, "Second number 25");
        put(26, "Second number 26");
        put(27, "Second number 27");
        put(28, "Second number 28");
        put(29, "Second number 29");
        put(30, "Second number 30");
        put(31, "Second number 31");
        put(32, "Second number 32");
        put(33, "Second number 33");
        put(34, "Second number 34");
        put(35, "Second number 35");
        put(36, "Second number 36");
        put(37, "Second number 37");
        put(38, "Second number 38");
        put(39, "Second number 39");
        put(40, "Second number 40");
        put(41, "Second number 41");
        put(42, "Second number 42");
        put(43, "Second number 43");
        put(44, "Second number 44");
        put(45, "Second number 45");
        put(46, "Second number 46");
        put(47, "Second number 47");
        put(48, "Second number 48");
        put(49, "Second number 49");
        put(50, "Second number 50");
        put(51, "Second number 51");
        put(52, "Second number 52");
        put(53, "Second number 53");
        put(54, "Second number 54");
        put(55, "Second number 55");
        put(56, "Second number 56");
        put(57, "Second number 57");
        put(58, "Second number 58");
        put(59, "Second number 59");
        put(60, "Reserved ");
        put(61, "Reserved ");
        put(62, "Reserved ");
        put(63, "Reserved ");
    }});

    //Table 6.79: Location shape information element contents
    //In this class include unit only for "location circle with altitude"(5),
    //location shape "no shape" consist only latitude and longitude
    private final BaseProtocolUnits locationShape = new BaseProtocolUnits(4, new HashMap<Integer, String>() {{
        put(0, "No shape");
        put(1, "Location point");
        put(2, "Location circle");
        put(3, "Location ellipse");
        put(4, "Location point with altitude");
        put(5, "Location circle with altitude");
        put(6, "Location ellipse with altitude");
        put(7, "Location circle with altitude and altitude uncertainty");
        put(8, "Location ellipse with altitude and altitude uncertainty");
        put(9, "Location arc");
        put(10, "Location point and position error");
        put(12, "Reserved");
        put(13, "Reserved");
        put(14, "Reserved");
        put(11, "Reserved");
        put(15, "Location shape extension, see note 5");
    }});

    //Horizontal position uncertainty
    //The horizontal position uncertainty information elements shall be encoded as defined in table 6.49 for horizontal
    //position accuracy.
    //Table 6.49: Horizontal position accuracy information element contents
    private final BaseProtocolUnits horizontalPositionUncertainty = new BaseProtocolUnits(6, new HashMap<Integer, String>() {{
        put(0, "Less than 1 m");
        put(1, "Less than 2 m");
        put(2, "Less than 3,2 m");
        put(3, "Less than 4,6 m");
        put(4, "Less than 6,3 m");
        put(5, "Less than 8,4 m");
        put(6, "Less than 10,9 m");
        put(7, "Less than 13,8 m");
        put(8, "Less than 17,4 m");
        put(9, "Less than 21,7 m");
        put(10, "Less than 26,8 m");
        put(11, "Less than 33 m");
        put(12, "Less than 40,4 m");
        put(13, "Less than 49,2 m");
        put(14, "Less than 59,9 m");
        put(15, "Less than 72,7 m");
        put(16, "Less than 88 m");
        put(17, "Less than 106,4 m");
        put(18, "Less than 128,5 m");
        put(19, "Less than 155 m");
        put(20, "Less than 186,8 m");
        put(21, "Less than 225 m");
        put(22, "Less than 270,7 m");
        put(23, "Less than 325,7 m");
        put(24, "Less than 391,6 m");
        put(25, "Less than 470,8 m");
        put(26, "Less than 565,7 m");
        put(27, "Less than 679,6 m");
        put(28, "Less than 816,4 m");
        put(29, "Less than 980,4 m");
        put(30, "Less than 1177,3 m");
        put(31, "Less than 1413,6 m");
        put(32, "Less than 1697,1 m");
        put(33, "Less than 2037,3 m");
        put(34, "Less than 2445,6 m");
        put(35, "Less than 2935,5 m");
        put(36, "Less than 3523,5 m");
        put(37, "Less than 4228,9 m");
        put(38, "Less than 5075,5 m");
        put(39, "Less than 6091,4 m");
        put(40, "Less than 7310,5 m");
        put(41, "Less than 8773,4 m");
        put(42, "Less than 10528,9 m");
        put(43, "Less than 12635,5 m");
        put(44, "Less than 15163,4 m");
        put(45, "Less than 18196,9 m");
        put(46, "Less than 21837,1 m");
        put(47, "Less than 26205,3 m");
        put(48, "Less than 31447,1 m");
        put(49, "Less than 37737,3 m");
        put(50, "Less than 45285,6 m");
        put(51, "Less than 54343,5 m");
        put(52, "Less than 65213 m");
        put(53, "Less than 78256,4 m");
        put(54, "Less than 93908,5 m");
        put(55, "Less than 112691 m");
        put(56, "Less than 135230 m");
        put(57, "Less than 162276,8 m");
        put(58, "Less than 194733 m");
        put(59, "Less than 233680,4 m");
        put(60, "Less than 280417,3 m");
        put(61, "Less than 336501,6 m");
        put(62, "Less than 403802,7 m");
        put(63, "Best effort");
    }});

    //Table 6.63: Location altitude accuracy information element contents
    private final BaseProtocolUnits locationAltitudeAccuracy = new BaseProtocolUnits(3, new HashMap<Integer, String>() {{
        put(0, "Less than 1 m");
        put(1, "Less than 2 m");
        put(2, "Less than 5 m");
        put(3, "Less than 15 m");
        put(4, "Less than 50 m");
        put(5, "Less than 150 m");
        put(6, "Less than 300 m");
        put(7, "Best effort or not supported");
    }});

    //Table 6.123: Velocity type information element contents
    //In this class include unit only for "Horizontal velocity with direction of travel extended"(5),
    private final BaseProtocolUnits velocityType = new BaseProtocolUnits(3, new HashMap<Integer, String>() {{
        put(0, "No velocity information");
        put(1, "Horizontal velocity");
        put(2, "Horizontal velocity with uncertainty");
        put(3, "Horizontal velocity and vertical velocity");
        put(4, "Horizontal velocity and vertical velocity with uncertainty");
        put(5, "Horizontal velocity with direction of travel extended");
        put(6, "Horizontal velocity with direction of travel extended and uncertainty");
        put(7, "Horizontal velocity and vertical velocity with direction of travel extended and uncertainty");
    }});

    //Horizontal velocity 6.3.17
    //Table 6.51: Examples of horizontal velocity information element contents
    private final BaseProtocolUnits horizontalVelocity = new BaseProtocolUnits(7, new HashMap<Integer, String>() {{
        put(0, "0 km/h");
        put(1, "1 km/h");
        put(2, "2 km/h");
        put(3, "3 km/h");
        put(4, "4 km/h");
        put(5, "5 km/h");
        put(6, "6 km/h");
        put(7, "7 km/h");
        put(8, "8 km/h");
        put(9, "9 km/h");
        put(10, "10 km/h");
        put(11, "11 km/h");
        put(12, "12 km/h");
        put(13, "13 km/h");
        put(14, "14 km/h");
        put(15, "15 km/h");
        put(16, "16 km/h");
        put(17, "17 km/h");
        put(18, "18 km/h");
        put(19, "19 km/h");
        put(20, "20 km/h");
        put(21, "21 km/h");
        put(22, "22 km/h");
        put(23, "23 km/h");
        put(24, "24 km/h");
        put(25, "25 km/h");
        put(26, "26 km/h");
        put(27, "27 km/h");
        put(28, "28 km/h");
        put(29, "29 km/h");
        put(30, "30 km/h");
        put(31, "31 km/h");
        put(32, "32 km/h");
        put(33, "34 km/h");
        put(34, "35 km/h");
        put(35, "36 km/h");
        put(36, "38 km/h");
        put(37, "39 km/h");
        put(38, "41 km/h");
        put(39, "42 km/h");
        put(40, "44 km/h");
        put(41, "45 km/h");
        put(42, "47 km/h");
        put(43, "49 km/h");
        put(44, "51 km/h");
        put(45, "53 km/h");
        put(46, "55 km/h");
        put(47, "57 km/h");
        put(48, "59 km/h");
        put(49, "61 km/h");
        put(50, "64 km/h");
        put(51, "66 km/h");
        put(52, "69 km/h");
        put(53, "71 km/h");
        put(54, "74 km/h");
        put(55, "77 km/h");
        put(56, "80 km/h");
        put(57, "83 km/h");
        put(58, "86 km/h");
        put(59, "89 km/h");
        put(60, "92 km/h");
        put(61, "96 km/h");
        put(62, "99 km/h");
        put(63, "103 km/h");
        put(64, "107 km/h");
        put(65, "111 km/h");
        put(66, "115 km/h");
        put(67, "120 km/h");
        put(68, "124 km/h");
        put(69, "129 km/h");
        put(70, "134 km/h");
        put(71, "139 km/h");
        put(72, "144 km/h");
        put(73, "150 km/h");
        put(74, "156 km/h");
        put(75, "162 km/h");
        put(76, "168 km/h");
        put(77, "174 km/h");
        put(78, "181 km/h");
        put(79, "188 km/h");
        put(80, "195 km/h");
        put(81, "202 km/h");
        put(82, "210 km/h");
        put(83, "218 km/h");
        put(84, "226 km/h");
        put(85, "235 km/h");
        put(86, "244 km/h");
        put(87, "253 km/h");
        put(88, "262 km/h");
        put(89, "272 km/h");
        put(90, "283 km/h");
        put(91, "293 km/h");
        put(92, "305 km/h");
        put(93, "316 km/h");
        put(94, "328 km/h");
        put(95, "341 km/h");
        put(96, "354 km/h");
        put(97, "367 km/h");
        put(98, "381 km/h");
        put(99, "395 km/h");
        put(100, "410 km/h");
        put(101, "426 km/h");
        put(102, "442 km/h");
        put(103, "459 km/h");
        put(104, "477 km/h");
        put(105, "495 km/h");
        put(106, "513 km/h");
        put(107, "533 km/h");
        put(108, "553 km/h");
        put(109, "574 km/h");
        put(110, "596 km/h");
        put(111, "619 km/h");
        put(112, "642 km/h");
        put(113, "667 km/h");
        put(114, "692 km/h");
        put(115, "718 km/h");
        put(116, "745 km/h");
        put(117, "774 km/h");
        put(118, "803 km/h");
        put(119, "834 km/h");
        put(120, "865 km/h");
        put(121, "898 km/h");
        put(122, "932 km/h");
        put(123, "968 km/h");
        put(124, "1005 km/h");
        put(125, "1043 km/h");
        put(126, "More than 1 043 km/h ");
        put(127, "Horizontal speed is not known");
    }});

    //6.3.6 Direction of travel extended
    //The direction of travel extended information element shall be encoded as defined for the Angle information element in
    //table 6.33.
    //Table 6.33: Angle information element contents
    private final BaseProtocolUnits directionOfTravelExtended = new BaseProtocolUnits(8, new HashMap<Integer, String>() {{
        put(0, "Direction in degrees 0 (clockwise from north)");
        put(1, "Direction in degrees 1,4 (clockwise from north)");
        put(2, "Direction in degrees 2,8 (clockwise from north)");
        put(3, "Direction in degrees 4,2 (clockwise from north)");
        put(4, "Direction in degrees 5,6 (clockwise from north)");
        put(5, "Direction in degrees 7 (clockwise from north)");
        put(6, "Direction in degrees 8,4 (clockwise from north)");
        put(7, "Direction in degrees 9,8 (clockwise from north)");
        put(8, "Direction in degrees 11,3 (clockwise from north)");
        put(9, "Direction in degrees 12,7 (clockwise from north)");
        put(10, "Direction in degrees 14,1 (clockwise from north)");
        put(11, "Direction in degrees 15,5 (clockwise from north)");
        put(12, "Direction in degrees 16,9 (clockwise from north)");
        put(13, "Direction in degrees 18,3 (clockwise from north)");
        put(14, "Direction in degrees 19,7 (clockwise from north)");
        put(15, "Direction in degrees 21,1 (clockwise from north)");
        put(16, "Direction in degrees 22,5 (clockwise from north)");
        put(17, "Direction in degrees 23,9 (clockwise from north)");
        put(18, "Direction in degrees 25,3 (clockwise from north)");
        put(19, "Direction in degrees 26,7 (clockwise from north)");
        put(20, "Direction in degrees 28,1 (clockwise from north)");
        put(21, "Direction in degrees 29,5 (clockwise from north)");
        put(22, "Direction in degrees 30,9 (clockwise from north)");
        put(23, "Direction in degrees 32,3 (clockwise from north)");
        put(24, "Direction in degrees 33,8 (clockwise from north)");
        put(25, "Direction in degrees 35,2 (clockwise from north)");
        put(26, "Direction in degrees 36,6 (clockwise from north)");
        put(27, "Direction in degrees 38 (clockwise from north)");
        put(28, "Direction in degrees 39,4 (clockwise from north)");
        put(29, "Direction in degrees 40,8 (clockwise from north)");
        put(30, "Direction in degrees 42,2 (clockwise from north)");
        put(31, "Direction in degrees 43,6 (clockwise from north)");
        put(32, "Direction in degrees 45 (clockwise from north)");
        put(33, "Direction in degrees 46,4 (clockwise from north)");
        put(34, "Direction in degrees 47,8 (clockwise from north)");
        put(35, "Direction in degrees 49,2 (clockwise from north)");
        put(36, "Direction in degrees 50,6 (clockwise from north)");
        put(37, "Direction in degrees 52 (clockwise from north)");
        put(38, "Direction in degrees 53,4 (clockwise from north)");
        put(39, "Direction in degrees 54,8 (clockwise from north)");
        put(40, "Direction in degrees 56,3 (clockwise from north)");
        put(41, "Direction in degrees 57,7 (clockwise from north)");
        put(42, "Direction in degrees 59,1 (clockwise from north)");
        put(43, "Direction in degrees 60,5 (clockwise from north)");
        put(44, "Direction in degrees 61,9 (clockwise from north)");
        put(45, "Direction in degrees 63,3 (clockwise from north)");
        put(46, "Direction in degrees 64,7 (clockwise from north)");
        put(47, "Direction in degrees 66,1 (clockwise from north)");
        put(48, "Direction in degrees 67,5 (clockwise from north)");
        put(49, "Direction in degrees 68,9 (clockwise from north)");
        put(50, "Direction in degrees 70,3 (clockwise from north)");
        put(51, "Direction in degrees 71,7 (clockwise from north)");
        put(52, "Direction in degrees 73,1 (clockwise from north)");
        put(53, "Direction in degrees 74,5 (clockwise from north)");
        put(54, "Direction in degrees 75,9 (clockwise from north)");
        put(55, "Direction in degrees 77,3 (clockwise from north)");
        put(56, "Direction in degrees 78,8 (clockwise from north)");
        put(57, "Direction in degrees 80,2 (clockwise from north)");
        put(58, "Direction in degrees 81,6 (clockwise from north)");
        put(59, "Direction in degrees 83 (clockwise from north)");
        put(60, "Direction in degrees 84,4 (clockwise from north)");
        put(61, "Direction in degrees 85,8 (clockwise from north)");
        put(62, "Direction in degrees 87,2 (clockwise from north)");
        put(63, "Direction in degrees 88,6 (clockwise from north)");
        put(64, "Direction in degrees 90 (clockwise from north)");
        put(65, "Direction in degrees 91,4 (clockwise from north)");
        put(66, "Direction in degrees 92,8 (clockwise from north)");
        put(67, "Direction in degrees 94,2 (clockwise from north)");
        put(68, "Direction in degrees 95,6 (clockwise from north)");
        put(69, "Direction in degrees 97 (clockwise from north)");
        put(70, "Direction in degrees 98,4 (clockwise from north)");
        put(71, "Direction in degrees 99,8 (clockwise from north)");
        put(72, "Direction in degrees 101,3 (clockwise from north)");
        put(73, "Direction in degrees 102,7 (clockwise from north)");
        put(74, "Direction in degrees 104,1 (clockwise from north)");
        put(75, "Direction in degrees 105,5 (clockwise from north)");
        put(76, "Direction in degrees 106,9 (clockwise from north)");
        put(77, "Direction in degrees 108,3 (clockwise from north)");
        put(78, "Direction in degrees 109,7 (clockwise from north)");
        put(79, "Direction in degrees 111,1 (clockwise from north)");
        put(80, "Direction in degrees 112,5 (clockwise from north)");
        put(81, "Direction in degrees 113,9 (clockwise from north)");
        put(82, "Direction in degrees 115,3 (clockwise from north)");
        put(83, "Direction in degrees 116,7 (clockwise from north)");
        put(84, "Direction in degrees 118,1 (clockwise from north)");
        put(85, "Direction in degrees 119,5 (clockwise from north)");
        put(86, "Direction in degrees 120,9 (clockwise from north)");
        put(87, "Direction in degrees 122,3 (clockwise from north)");
        put(88, "Direction in degrees 123,8 (clockwise from north)");
        put(89, "Direction in degrees 125,2 (clockwise from north)");
        put(90, "Direction in degrees 126,6 (clockwise from north)");
        put(91, "Direction in degrees 128 (clockwise from north)");
        put(92, "Direction in degrees 129,4 (clockwise from north)");
        put(93, "Direction in degrees 130,8 (clockwise from north)");
        put(94, "Direction in degrees 132,2 (clockwise from north)");
        put(95, "Direction in degrees 133,6 (clockwise from north)");
        put(96, "Direction in degrees 135 (clockwise from north)");
        put(97, "Direction in degrees 136,4 (clockwise from north)");
        put(98, "Direction in degrees 137,8 (clockwise from north)");
        put(99, "Direction in degrees 139,2 (clockwise from north)");
        put(100, "Direction in degrees 140,6 (clockwise from north)");
        put(101, "Direction in degrees 142 (clockwise from north)");
        put(102, "Direction in degrees 143,4 (clockwise from north)");
        put(103, "Direction in degrees 144,8 (clockwise from north)");
        put(104, "Direction in degrees 146,3 (clockwise from north)");
        put(105, "Direction in degrees 147,7 (clockwise from north)");
        put(106, "Direction in degrees 149,1 (clockwise from north)");
        put(107, "Direction in degrees 150,5 (clockwise from north)");
        put(108, "Direction in degrees 151,9 (clockwise from north)");
        put(109, "Direction in degrees 153,3 (clockwise from north)");
        put(110, "Direction in degrees 154,7 (clockwise from north)");
        put(111, "Direction in degrees 156,1 (clockwise from north)");
        put(112, "Direction in degrees 157,5 (clockwise from north)");
        put(113, "Direction in degrees 158,9 (clockwise from north)");
        put(114, "Direction in degrees 160,3 (clockwise from north)");
        put(115, "Direction in degrees 161,7 (clockwise from north)");
        put(116, "Direction in degrees 163,1 (clockwise from north)");
        put(117, "Direction in degrees 164,5 (clockwise from north)");
        put(118, "Direction in degrees 165,9 (clockwise from north)");
        put(119, "Direction in degrees 167,3 (clockwise from north)");
        put(120, "Direction in degrees 168,8 (clockwise from north)");
        put(121, "Direction in degrees 170,2 (clockwise from north)");
        put(122, "Direction in degrees 171,6 (clockwise from north)");
        put(123, "Direction in degrees 173 (clockwise from north)");
        put(124, "Direction in degrees 174,4 (clockwise from north)");
        put(125, "Direction in degrees 175,8 (clockwise from north)");
        put(126, "Direction in degrees 177,2 (clockwise from north)");
        put(127, "Direction in degrees 178,6 (clockwise from north)");
        put(128, "Direction in degrees 180 (clockwise from north)");
        put(129, "Direction in degrees 181,4 (clockwise from north)");
        put(130, "Direction in degrees 182,8 (clockwise from north)");
        put(131, "Direction in degrees 184,2 (clockwise from north)");
        put(132, "Direction in degrees 185,6 (clockwise from north)");
        put(133, "Direction in degrees 187 (clockwise from north)");
        put(134, "Direction in degrees 188,4 (clockwise from north)");
        put(135, "Direction in degrees 189,8 (clockwise from north)");
        put(136, "Direction in degrees 191,3 (clockwise from north)");
        put(137, "Direction in degrees 192,7 (clockwise from north)");
        put(138, "Direction in degrees 194,1 (clockwise from north)");
        put(139, "Direction in degrees 195,5 (clockwise from north)");
        put(140, "Direction in degrees 196,9 (clockwise from north)");
        put(141, "Direction in degrees 198,3 (clockwise from north)");
        put(142, "Direction in degrees 199,7 (clockwise from north)");
        put(143, "Direction in degrees 201,1 (clockwise from north)");
        put(144, "Direction in degrees 202,5 (clockwise from north)");
        put(145, "Direction in degrees 203,9 (clockwise from north)");
        put(146, "Direction in degrees 205,3 (clockwise from north)");
        put(147, "Direction in degrees 206,7 (clockwise from north)");
        put(148, "Direction in degrees 208,1 (clockwise from north)");
        put(149, "Direction in degrees 209,5 (clockwise from north)");
        put(150, "Direction in degrees 210,9 (clockwise from north)");
        put(151, "Direction in degrees 212,3 (clockwise from north)");
        put(152, "Direction in degrees 213,8 (clockwise from north)");
        put(153, "Direction in degrees 215,2 (clockwise from north)");
        put(154, "Direction in degrees 216,6 (clockwise from north)");
        put(155, "Direction in degrees 218 (clockwise from north)");
        put(156, "Direction in degrees 219,4 (clockwise from north)");
        put(157, "Direction in degrees 220,8 (clockwise from north)");
        put(158, "Direction in degrees 222,2 (clockwise from north)");
        put(159, "Direction in degrees 223,6 (clockwise from north)");
        put(160, "Direction in degrees 225 (clockwise from north)");
        put(161, "Direction in degrees 226,4 (clockwise from north)");
        put(162, "Direction in degrees 227,8 (clockwise from north)");
        put(163, "Direction in degrees 229,2 (clockwise from north)");
        put(164, "Direction in degrees 230,6 (clockwise from north)");
        put(165, "Direction in degrees 232 (clockwise from north)");
        put(166, "Direction in degrees 233,4 (clockwise from north)");
        put(167, "Direction in degrees 234,8 (clockwise from north)");
        put(168, "Direction in degrees 236,3 (clockwise from north)");
        put(169, "Direction in degrees 237,7 (clockwise from north)");
        put(170, "Direction in degrees 239,1 (clockwise from north)");
        put(171, "Direction in degrees 240,5 (clockwise from north)");
        put(172, "Direction in degrees 241,9 (clockwise from north)");
        put(173, "Direction in degrees 243,3 (clockwise from north)");
        put(174, "Direction in degrees 244,7 (clockwise from north)");
        put(175, "Direction in degrees 246,1 (clockwise from north)");
        put(176, "Direction in degrees 247,5 (clockwise from north)");
        put(177, "Direction in degrees 248,9 (clockwise from north)");
        put(178, "Direction in degrees 250,3 (clockwise from north)");
        put(179, "Direction in degrees 251,7 (clockwise from north)");
        put(180, "Direction in degrees 253,1 (clockwise from north)");
        put(181, "Direction in degrees 254,5 (clockwise from north)");
        put(182, "Direction in degrees 255,9 (clockwise from north)");
        put(183, "Direction in degrees 257,3 (clockwise from north)");
        put(184, "Direction in degrees 258,8 (clockwise from north)");
        put(185, "Direction in degrees 260,2 (clockwise from north)");
        put(186, "Direction in degrees 261,6 (clockwise from north)");
        put(187, "Direction in degrees 263 (clockwise from north)");
        put(188, "Direction in degrees 264,4 (clockwise from north)");
        put(189, "Direction in degrees 265,8 (clockwise from north)");
        put(190, "Direction in degrees 267,2 (clockwise from north)");
        put(191, "Direction in degrees 268,6 (clockwise from north)");
        put(192, "Direction in degrees 270 (clockwise from north)");
        put(193, "Direction in degrees 271,4 (clockwise from north)");
        put(194, "Direction in degrees 272,8 (clockwise from north)");
        put(195, "Direction in degrees 274,2 (clockwise from north)");
        put(196, "Direction in degrees 275,6 (clockwise from north)");
        put(197, "Direction in degrees 277 (clockwise from north)");
        put(198, "Direction in degrees 278,4 (clockwise from north)");
        put(199, "Direction in degrees 279,8 (clockwise from north)");
        put(200, "Direction in degrees 281,3 (clockwise from north)");
        put(201, "Direction in degrees 282,7 (clockwise from north)");
        put(202, "Direction in degrees 284,1 (clockwise from north)");
        put(203, "Direction in degrees 285,5 (clockwise from north)");
        put(204, "Direction in degrees 286,9 (clockwise from north)");
        put(205, "Direction in degrees 288,3 (clockwise from north)");
        put(206, "Direction in degrees 289,7 (clockwise from north)");
        put(207, "Direction in degrees 291,1 (clockwise from north)");
        put(208, "Direction in degrees 292,5 (clockwise from north)");
        put(209, "Direction in degrees 293,9 (clockwise from north)");
        put(210, "Direction in degrees 295,3 (clockwise from north)");
        put(211, "Direction in degrees 296,7 (clockwise from north)");
        put(212, "Direction in degrees 298,1 (clockwise from north)");
        put(213, "Direction in degrees 299,5 (clockwise from north)");
        put(214, "Direction in degrees 300,9 (clockwise from north)");
        put(215, "Direction in degrees 302,3 (clockwise from north)");
        put(216, "Direction in degrees 303,8 (clockwise from north)");
        put(217, "Direction in degrees 305,2 (clockwise from north)");
        put(218, "Direction in degrees 306,6 (clockwise from north)");
        put(219, "Direction in degrees 308 (clockwise from north)");
        put(220, "Direction in degrees 309,4 (clockwise from north)");
        put(221, "Direction in degrees 310,8 (clockwise from north)");
        put(222, "Direction in degrees 312,2 (clockwise from north)");
        put(223, "Direction in degrees 313,6 (clockwise from north)");
        put(224, "Direction in degrees 315 (clockwise from north)");
        put(225, "Direction in degrees 316,4 (clockwise from north)");
        put(226, "Direction in degrees 317,8 (clockwise from north)");
        put(227, "Direction in degrees 319,2 (clockwise from north)");
        put(228, "Direction in degrees 320,6 (clockwise from north)");
        put(229, "Direction in degrees 322 (clockwise from north)");
        put(230, "Direction in degrees 323,4 (clockwise from north)");
        put(231, "Direction in degrees 324,8 (clockwise from north)");
        put(232, "Direction in degrees 326,3 (clockwise from north)");
        put(233, "Direction in degrees 327,7 (clockwise from north)");
        put(234, "Direction in degrees 329,1 (clockwise from north)");
        put(235, "Direction in degrees 330,5 (clockwise from north)");
        put(236, "Direction in degrees 331,9 (clockwise from north)");
        put(237, "Direction in degrees 333,3 (clockwise from north)");
        put(238, "Direction in degrees 334,7 (clockwise from north)");
        put(239, "Direction in degrees 336,1 (clockwise from north)");
        put(240, "Direction in degrees 337,5 (clockwise from north)");
        put(241, "Direction in degrees 338,9 (clockwise from north)");
        put(242, "Direction in degrees 340,3 (clockwise from north)");
        put(243, "Direction in degrees 341,7 (clockwise from north)");
        put(244, "Direction in degrees 343,1 (clockwise from north)");
        put(245, "Direction in degrees 344,5 (clockwise from north)");
        put(246, "Direction in degrees 345,9 (clockwise from north)");
        put(247, "Direction in degrees 347,3 (clockwise from north)");
        put(248, "Direction in degrees 348,8 (clockwise from north)");
        put(249, "Direction in degrees 350,2 (clockwise from north)");
        put(250, "Direction in degrees 351,6 (clockwise from north)");
        put(251, "Direction in degrees 353 (clockwise from north)");
        put(252, "Direction in degrees 354,4 (clockwise from north)");
        put(253, "Direction in degrees 355,8 (clockwise from north)");
        put(254, "Direction in degrees 357,2 (clockwise from north)");
        put(255, "Direction in degrees 358,6 (clockwise from north)");
    }});

    //Table 6.93: Position error information element contents
    private final BaseProtocolUnits positionError = new BaseProtocolUnits(3, new HashMap<Integer, String>() {{
        put(0, "less than 2 m");
        put(1, "less than 20 m");
        put(2, "less than 200 m");
        put(3, "less than 2 km");
        put(4, "less than 20 km");
        put(5, "less than or equal to 200 km");
        put(6, "more than 200 km");
        put(7, "Position error not known");

    }});


    //Table 6.45: Direction of travel information element contents
    private final BaseProtocolUnits directionalOfTravel = new BaseProtocolUnits(4, new HashMap<Integer, String>() {{
        put(0,  "0 North (N)");
        put(1,  "22,5 NNE");
        put(2,  "45 NE");
        put(3,  "67,5 ENE");
        put(4,  "90 East (E)");
        put(5,  "112,5 ESE");
        put(6,  "135 SE");
        put(7,  "157,5 SSE");
        put(8,  "180 South (S)");
        put(9,  "202,5 SSW");
        put(10, "225 SW");
        put(11, "247,5 WSW");
        put(12, "270 West (W)");
        put(13, "292,5 WNW");
        put(14, "315 NW");
        put(15, "337,5 or direction of travel is not known NNW");
    }});

    //Table 6.120: Type of additional data information element contents
    private final BaseProtocolUnits typeOfAdditionalData = new BaseProtocolUnits(1, new HashMap<Integer, String>() {
        {
            put(0, "Reason for sending");
            put(1, "User defined data");
        }});

    //Table 6.94: Reason for sending information element contents
    private final BaseProtocolUnits reasonForSending = new BaseProtocolUnits(8, new HashMap<Integer, String>() {{
        put(0,   "Subscriber unit is powered ON");
        put(1,   "Subscriber unit is powered OFF, see note 1");
        put(2,   "Emergency condition is detected");
        put(3,   "Push-to-talk condition is detected");
        put(4,   "Status, see note 2");
        put(5,   "Transmit inhibit mode ON, see note 3");
        put(6,   "Transmit inhibit mode OFF");
        put(7,   "System access (TMO ON)");
        put(8,   "DMO ON");
        put(9,   "Enter service (after being out of service)");
        put(10,  "Service loss");
        put(11,  "Cell reselection or change of serving cell");
        put(12,  "Low battery");
        put(13,  "Subscriber unit is connected to a car kit");
        put(14,  "Subscriber unit is disconnected from a car kit");
        put(15,  "Subscriber unit asks for transfer initialization configuration");
        put(16,  "Arrival at destination ");
        put(17,  "Arrival at a defined location");
        put(18,  "Approaching a defined location");
        put(19,  "SDS type-1 entered");
        put(20,  "User application initiated");
        put(21,  "Lost ability to determine location See clause 5.3.22");
        put(22,  "Regained ability to determine location See clause 5.3.22");
        put(23,  "Leaving point");
        put(24,  "Ambience Listening call is detected");
        put(25,  "Start of temporary reporting");
        put(26,  "Return to normal reporting");
        put(27,  "Call setup type 1 detected");
        put(28,  "Call setup type 2 detected");
        put(29,  "Positioning device in MS ON");
        put(30,  "Positioning device in MS OFF");
        put(31,  "Reserved");
        put(32,  "Reserved");
        put(33,  "Reserved");
        put(34,  "Reserved");
        put(35,  "Reserved");
        put(36,  "Reserved");
        put(37,  "Reserved");
        put(38,  "Reserved");
        put(39,  "Reserved");
        put(40,  "Reserved");
        put(41,  "Reserved");
        put(42,  "Reserved");
        put(43,  "Reserved");
        put(44,  "Reserved");
        put(45,  "Reserved");
        put(46,  "Reserved");
        put(47,  "Reserved");
        put(48,  "Reserved");
        put(49,  "Reserved");
        put(50,  "Reserved");
        put(51,  "Reserved");
        put(52,  "Reserved");
        put(53,  "Reserved");
        put(54,  "Reserved");
        put(55,  "Reserved");
        put(56,  "Reserved");
        put(57,  "Reserved");
        put(58,  "Reserved");
        put(59,  "Reserved");
        put(60,  "Reserved");
        put(61,  "Reserved");
        put(62,  "Reserved");
        put(63,  "Reserved");
        put(64,  "Reserved");
        put(65,  "Reserved");
        put(66,  "Reserved");
        put(67,  "Reserved");
        put(68,  "Reserved");
        put(69,  "Reserved");
        put(70,  "Reserved");
        put(71,  "Reserved");
        put(72,  "Reserved");
        put(73,  "Reserved");
        put(74,  "Reserved");
        put(75,  "Reserved");
        put(76,  "Reserved");
        put(77,  "Reserved");
        put(78,  "Reserved");
        put(79,  "Reserved");
        put(80,  "Reserved");
        put(81,  "Reserved");
        put(82,  "Reserved");
        put(83,  "Reserved");
        put(84,  "Reserved");
        put(85,  "Reserved");
        put(86,  "Reserved");
        put(87,  "Reserved");
        put(88,  "Reserved");
        put(89,  "Reserved");
        put(90,  "Reserved");
        put(91,  "Reserved");
        put(92,  "Reserved");
        put(93,  "Reserved");
        put(94,  "Reserved");
        put(95,  "Reserved");
        put(96,  "Reserved");
        put(97,  "Reserved");
        put(98,  "Reserved");
        put(99,  "Reserved");
        put(100, "Reserved");
        put(101, "Reserved");
        put(102, "Reserved");
        put(103, "Reserved");
        put(104, "Reserved");
        put(105, "Reserved");
        put(106, "Reserved");
        put(107, "Reserved");
        put(108, "Reserved");
        put(109, "Reserved");
        put(110, "Reserved");
        put(111, "Reserved");
        put(112, "Reserved");
        put(113, "Reserved");
        put(114, "Reserved");
        put(115, "Reserved");
        put(116, "Reserved");
        put(117, "Reserved");
        put(118, "Reserved");
        put(119, "Reserved");
        put(120, "Reserved");
        put(121, "Reserved");
        put(122, "Reserved");
        put(123, "Reserved");
        put(124, "Reserved");
        put(125, "Reserved");
        put(126, "Reserved");
        put(127, "Reserved");
        put(128, "Reserved");
        put(129, "Maximum reporting interval exceeded since the last location information report");
        put(130, "Maximum reporting distance limit travelled since last location information report");
        put(131, "Reserved");
        put(132, "Reserved");
        put(133, "Reserved");
        put(134, "Reserved");
        put(135, "Reserved");
        put(136, "Reserved");
        put(137, "Reserved");
        put(138, "Reserved");
        put(139, "Reserved");
        put(140, "Reserved");
        put(141, "Reserved");
        put(142, "Reserved");
        put(143, "Reserved");
        put(144, "Reserved");
        put(145, "Reserved");
        put(146, "Reserved");
        put(147, "Reserved");
        put(148, "Reserved");
        put(149, "Reserved");
        put(150, "Reserved");
        put(151, "Reserved");
        put(152, "Reserved");
        put(153, "Reserved");
        put(154, "Reserved");
        put(155, "Reserved");
        put(156, "Reserved");
        put(157, "Reserved");
        put(158, "Reserved");
        put(159, "Reserved");
        put(160, "Reserved");
        put(161, "Reserved");
        put(162, "Reserved");
        put(163, "Reserved");
        put(164, "Reserved");
        put(165, "Reserved");
        put(166, "Reserved");
        put(167, "Reserved");
        put(168, "Reserved");
        put(169, "Reserved");
        put(170, "Reserved");
        put(171, "Reserved");
        put(172, "Reserved");
        put(173, "Reserved");
        put(174, "Reserved");
        put(175, "Reserved");
        put(176, "Reserved");
        put(177, "Reserved");
        put(178, "Reserved");
        put(179, "Reserved");
        put(180, "Reserved");
        put(181, "Reserved");
        put(182, "Reserved");
        put(183, "Reserved");
        put(184, "Reserved");
        put(185, "Reserved");
        put(186, "Reserved");
        put(187, "Reserved");
        put(188, "Reserved");
        put(189, "Reserved");
        put(190, "Reserved");
        put(191, "Reserved");
        put(192, "Reserved");
        put(193, "Reserved");
        put(194, "Reserved");
        put(195, "Reserved");
        put(196, "Reserved");
        put(197, "Reserved");
        put(198, "Reserved");
        put(199, "Reserved");
        put(200, "Reserved");
        put(201, "Reserved");
        put(202, "Reserved");
        put(203, "Reserved");
        put(204, "Reserved");
        put(205, "Reserved");
        put(206, "Reserved");
        put(207, "Reserved");
        put(208, "Reserved");
        put(209, "Reserved");
        put(210, "Reserved");
        put(211, "Reserved");
        put(212, "Reserved");
        put(213, "Reserved");
        put(214, "Reserved");
        put(215, "Reserved");
        put(216, "Reserved");
        put(217, "Reserved");
        put(218, "Reserved");
        put(219, "Reserved");
        put(220, "Reserved");
        put(221, "Reserved");
        put(222, "Reserved");
        put(223, "Reserved");
        put(224, "Reserved");
        put(225, "Reserved");
        put(226, "Reserved");
        put(227, "Reserved");
        put(228, "Reserved");
        put(229, "Reserved");
        put(230, "Reserved");
        put(231, "Reserved");
        put(232, "Reserved");
        put(233, "Reserved");
        put(234, "Reserved");
        put(235, "Reserved");
        put(236, "Reserved");
        put(237, "Reserved");
        put(238, "Reserved");
        put(239, "Reserved");
        put(240, "Reserved");
        put(241, "Reserved");
        put(242, "Reserved");
        put(243, "Reserved");
        put(244, "Reserved");
        put(245, "Reserved");
        put(246, "Reserved");
        put(247, "Reserved");
        put(248, "Reserved");
        put(249, "Reserved");
        put(250, "Reserved");
        put(251, "Reserved");
        put(252, "Reserved");
        put(253, "Reserved");
        put(254, "Reserved");
        put(255, "Reserved");
    }});

    //Table 6.31: Acknowledgement request information element contents
    private final BaseProtocolUnits acknowledgementRequest = new BaseProtocolUnits(4, new HashMap<Integer, String>() {
        {
            put(0, "No acknowledgement requested ");
            put(1, "Acknowledgement requested");
        }});

    public BaseProtocolUnits getPduType() {
        return pduType;
    }

    public BaseProtocolUnits getPduTypeExtension() {
        return pduTypeExtension;
    }

    public BaseProtocolUnits getTimeType() {
        return timeType;
    }

    public BaseProtocolUnits getTimeElapsed() {
        return timeElapsed;
    }

    public BaseProtocolUnits getDayTimeOfPosition() {
        return dayTimeOfPosition;
    }

    public BaseProtocolUnits getHourTimeOfPosition() {
        return hourTimeOfPosition;
    }

    public BaseProtocolUnits getMinuteTimeOfPosition() {
        return minuteTimeOfPosition;
    }

    public BaseProtocolUnits getSecondTimeOfPosition() {
        return secondTimeOfPosition;
    }

    public BaseProtocolUnits getLocationShape() {
        return locationShape;
    }

    public BaseProtocolUnits getHorizontalPositionUncertainty() {
        return horizontalPositionUncertainty;
    }

    public BaseProtocolUnits getLocationAltitudeAccuracy() {
        return locationAltitudeAccuracy;
    }

    public BaseProtocolUnits getVelocityType() {
        return velocityType;
    }

    public BaseProtocolUnits getHorizontalVelocity() {
        return horizontalVelocity;
    }

    public BaseProtocolUnits getDirectionOfTravelExtended() {
        return directionOfTravelExtended;
    }

    public BaseProtocolUnits getPositionError() {
        return positionError;
    }

    public BaseProtocolUnits getDirectionalOfTravel() {
        return directionalOfTravel;
    }

    public BaseProtocolUnits getTypeOfAdditionalData() {
        return typeOfAdditionalData;
    }

    public BaseProtocolUnits getReasonForSending() {
        return reasonForSending;
    }

    public BaseProtocolUnits getAcknowledgementRequest() {
        return acknowledgementRequest;
    }
}
