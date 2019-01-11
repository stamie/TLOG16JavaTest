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

public class TestTimeLogger { //extends TestCase {

    protected String str;
    protected long longer;
    protected long longer2;
    protected int[] actualDay;
    protected LocalTime time;
    protected LocalDate date;

    /**
     * 1.) Create a WorkDay with actual day 2016.04.14! Create a 2016/04
     * WorkMonth! Create a Task with beginning time 7:30, finishing time 10:30!
     * Add the task to the day, add the day to the month! Create a new
     * TimeLogger! Add the month to the timelogger! Call the getMinPerTask on
     * the Task! Call the getSumPerMonth on the first month of the timelogger!
     * -> These should be equal.
     *
     */
    /* First point Begin */
    @Test //(expected = OwnException.class)

    public void timeLogger1_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "10:30");

            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 4;
            date1[2] = 14;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            WorkMonth workMonth = new WorkMonth(2016, 4);
            workMonth.addWorkDay(workDay1);

            TimeLogger timeLogger = new TimeLogger();
            timeLogger.addMonth(workMonth);

            this.longer = workMonth.getSumPerMonth();
            this.longer2 = timeLogger.getMonths().get(0).getSumPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(this.longer, this.longer2);

    }

    /* First point End */
    /**
     * 2.) Create a workMonth1 and a workMonth2 both of them with date 2016/04!
     * Create a TimeLogger, and add the WorkMonths to the TimeLogger! -> You
     * should get a NotNewMonthException! (you should write this exception, it
     * doesn't exist)
     *
     */
    /* Second point Begin */
    @Test

    public void timeLogger2_1() throws OwnException {

        this.longer = 0;

        try {

            WorkMonth workMonth1 = new WorkMonth(2016, 4);
            WorkMonth workMonth2 = new WorkMonth(2016, 4);

            TimeLogger timeLogger = new TimeLogger();
            timeLogger.addMonth(workMonth1);
            timeLogger.addMonth(workMonth2);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NotNewMonthException", this.str);

    }
    /* Second point End */
 /* TIMELOGGER CLASS TEST END */
}
