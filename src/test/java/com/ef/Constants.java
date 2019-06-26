package com.ef;

public class Constants {
    public static final int FILE_TOTAL_ACCESS = 116484;
    public static final String PATH_TO_FILE = "src/test/resources/access.log";
    public static final String PATH_FILE_NOT_EXISTS = "/path/file/not/exists";

    public static final String IP = "192.168.234.82";
    public static final String DATE = "2017-01-01 00:00:11.763";
    public static final String REQUEST = "GET / HTTP/1.1";
    public static final String STATUS = "200";
    public static final String USER_AGENT = "swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0";

    public static final String START_DATE_2017_01_01_13H = "2017-01-01.13:00:00";
    public static final String START_DATE_2017_01_01_00H = "2017-01-01.00:00:00";
    public static final String HOURLY_VALUE = "hourly";
    public static final String THRESHOLD_200 = "200";
    public static final int EXPECTED_HOURLY_BLOCKED = 2;

    public static final String DAILY_VALUE = "daily";
    public static final String THRESHOLD_500 = "500";
    public static final int EXPECTED_DAILY_BLOCKED = 15;
}
