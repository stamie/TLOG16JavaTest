/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stampel
 */
//import junit.framework.TestCase;
//import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import Logger.Util;
import Logger.Task;
import Logger.WorkDay;
import Logger.WorkMonth;
import Logger.TimeLogger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import timelogger.exceptions.OwnException;

public class TestUtil { //extends TestCase {

    protected String str;
    protected long longer;
    protected long longer2;
    protected int[] actualDay;
    protected LocalTime time;
    protected LocalDate date;
    protected boolean bool;

    /**
     * 1.) Create a LocalTime type variable which gets its value by calling
     * roundToMultipleQuarterHour(startTime, endTime), where startTime: 7:30,
     * endTime=7:50. -> The result should be 7:45.
     *
     */
    /* First point Begin */
    @Test //(expected = OwnException.class)

    public void util1_1() throws OwnException {

        this.longer = 0;

        Util util = new Util();

        LocalTime endTime = util.roundToMultipleQuarterHour(LocalTime.of(7, 30), LocalTime.of(7, 50));
        this.str = endTime.toString();

        assertEquals("07:45", this.str);

    }

    /* First point End */
    /**
     * 2.) Create a boolean type variable which gets its value by calling
     * isMultipleQuarterHour(startTime, endTime), where startTime: 7:30,
     * endTime: 7:50. -> The result should be false.
     */
    /* Second point Begin */
    @Test

    public void util2_1() throws OwnException {

        this.bool = true;

        Util util = new Util();

        this.bool = util.isMultipleQuarterHour(LocalTime.parse("07:30"), LocalTime.parse("07:50"));

        assertEquals(false, this.bool);

    }

    /* Second point End */
    /**
     * 3.) Create a boolean type variable which gets its value by calling
     * isMultipleQuarterHour(startTime, endTime), where startTime: 7:30,
     * endTime: 7:45. -> The result should be true.
     */
    @Test

    public void util3_1() throws OwnException {

        this.bool = false;

        Util util = new Util();

        this.bool = util.isMultipleQuarterHour(LocalTime.parse("07:30"), LocalTime.parse("07:45"));

        assertEquals(true, this.bool);

    }

    /**
     * 4.) Call isMultipleQuarterHour(startTime, endTime), where startTime:
     * null, endTime: 7:45. -> You should get an EmptyTimeFieldException
     *
     */
    @Test

    public void util4_1() throws OwnException {

        this.str = ":(";
        try {
            Util util = new Util();
            LocalTime startTime = null;

            this.bool = util.isMultipleQuarterHour(startTime, LocalTime.parse("07:45"));
        } catch (OwnException ex) {
            this.str = ex.getMessage();
        }

        assertEquals("EmptyTimeFieldException", this.str);

    }

    /**
     * 5.) Call isMultipleQuarterHour(startTime, endTime), where startTime:
     * 8:30, endTime: 7:45. -> You should get a NotExpectedTimeOrderException
     *
     */
    @Test

    public void util5_1() throws OwnException {

        this.str = ":(";
        try {
            Util util = new Util();
            LocalTime startTime = null;

            this.bool = util.isMultipleQuarterHour(LocalTime.parse("08:30"), LocalTime.parse("07:45"));
        } catch (OwnException ex) {
            this.str = ex.getMessage();
        }

        assertEquals("NotExpectedTimeOrderException", this.str);

    }

    /**
     * 6.) Test the isSeparatedTime method with the following cases: Test cases
     */
    /* in the task list new task    result */
 /* 6:30-6:45    5:30-6:30   true +*/
 /* 6:30-6:45    6:45-7:00   true +*/
 /* 6:30-6:30    5:30-6:30   true +*/
 /* 6:30-7:30    7:30-7:30   true +*/
 /* 6:30-7:00    6:00-6:45   false +*/
 /* 6:30-7:00    6:30-6:45   false +*/
 /* 6:30-7:00    6:45-7:15   false +*/
 /* 6:30-7:00    6:45-7:00   false +*/
 /* 6:30-6:30    6:30-7:00   false <- true*/
 /* 6:30-7:30    6:30-6:30   false <- true*/
    @Test

    public void util6_1() throws OwnException {

        this.bool = false;

        Util util = new Util();
        LocalTime startTime = null;

        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("06:45"),
                LocalTime.parse("05:30"), LocalTime.parse("06:30"));
        assertEquals(true, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("06:45"),
                LocalTime.parse("06:45"), LocalTime.parse("07:00"));
        assertEquals(true, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("06:30"),
                LocalTime.parse("05:30"), LocalTime.parse("06:30"));
        assertEquals(true, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("06:45"),
                LocalTime.parse("05:30"), LocalTime.parse("06:30"));
        assertEquals(true, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("07:00"),
                LocalTime.parse("06:00"), LocalTime.parse("06:45"));
        assertEquals(false, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("07:00"),
                LocalTime.parse("06:00"), LocalTime.parse("06:45"));
        assertEquals(false, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("07:00"),
                LocalTime.parse("06:30"), LocalTime.parse("06:45"));
        assertEquals(false, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("07:00"),
                LocalTime.parse("06:45"), LocalTime.parse("07:15"));
        assertEquals(false, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("06:30"),
                LocalTime.parse("06:30"), LocalTime.parse("07:00"));
        assertEquals(true, this.bool);
        this.bool = util.isSeparatedTime(LocalTime.parse("06:30"), LocalTime.parse("07:30"),
                LocalTime.parse("06:30"), LocalTime.parse("06:30"));
        assertEquals(true, this.bool);

    }
    /* UTIL CLASS TEST END */
}
