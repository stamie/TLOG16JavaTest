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

public class TestWorkMonth { //extends TestCase {

    protected String str;
    protected long longer;
    protected long longer2;
    protected int[] actualDay;
    protected LocalTime time;
    protected LocalDate date;

    /**
     * 1.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 420 as requiredMinPerDay! Add the Task to the WorkDay!
     * Create a new Task with start time 8:45 and end time 9:45! Create a
     * WorkDay with 420 as requiredMinPerDay and 2016.09.01. as actualDay!
     * Create a WorkMonth! Add the WorkDays to the WorkMonth! Call the
     * getSumPerMonth! -> The result should be 135.
     *
     * @throws OwnException
     */
    /* First point Begin */
    @Test //(expected = OwnException.class)

    public void taskWorkMonth1_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
            workMonth.addWorkDay(workDay1);
            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getSumPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(135, this.longer);

    }

    /* First point End */
    /**
     * 2.) Create a WorkMonth! Call the getSumPerMonth method! -> The result
     * should be 0.
     */
    /* Second point Begin */
    @Test

    public void taskWorkMonth2_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);

            this.longer = workMonth.getSumPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(0, this.longer);

    }

    /* Second point End */
    /**
     * 3.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 420 as requiredMinPerDay! Add the Task to the WorkDay!
     * Create a new Task with start time 8:45 and end time 9:45! Create a
     * WorkDay with 420 as requiredMinPerDay and 2016.09.01. as actualDay!
     * Create a WorkMonth! Add the WorkDays to the WorkMonth! Call the
     * getExtraMinPerMonth method! -> The result should be -705.
     *
     * @throws OwnException
     */
    /* Thired point Begin */
    @Test

    public void taskWorkMonth3_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
            workMonth.addWorkDay(workDay1);
            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getExtraMinPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(-705, this.longer);

    }

    /* Thired point End */
    /**
     * 4.) Create a WorkMonth! Call the getExtraMinPerMonth method! -> The
     * result should be 0.
     *
     * @throws OwnException
     */
    /* Fourth point Begin */
    @Test

    public void taskWorkMonth4_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
//            workMonth.addWorkDay(workDay1);
//            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getExtraMinPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(0, this.longer);

    }

    /* Fourth point End */
    /**
     * 5.) Create a WorkDay with 420 as requiredMinPerDay and 2016.09.01. as
     * actualDay! Create an other WorkDay with 420 as requiredMinPerDay! Create
     * a WorkMonth and add the WorkDays to it! Call the getRequiredMinPerMonth!
     * -> The result should be 840.
     */
    /* Fiveth point Begin */
    @Test

    public void taskWorkMonth5_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
            workMonth.addWorkDay(workDay1);
            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getRequiredMinPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(840, this.longer);

    }

    /* Fiveth point Begin */
    /**
     * 6.) Create a WorkMonth! Call the getRequiredMinPerMonth! -> The result
     * should be 0.
     *
     * @throws OwnException
     */
    /* Sixth point Begin */
    @Test

    public void taskWorkMonth6_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 7;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
//            workMonth.addWorkDay(workDay1);
//            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getRequiredMinPerMonth();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(0, this.longer);

    }

    /* Sixth point Begin */
    /**
     * 7.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 2016.09.09. as actualDay! Add the Task to the WorkDay!
     * Create a WorkMonth and add the WorkDay to the WorkMonth! Call the
     * getSumPerDay on the WorkDay! Call the getSumPerMonth on the WorkMonth! ->
     * These should be equal.
     *
     */
    /* Seventh point Begin */
    @Test

    public void taskWorkMonth7_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 9;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
            workDay2.addTask(task2);

            WorkMonth workMonth = new WorkMonth(2016, 9);
            workMonth.addWorkDay(workDay1);
//            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getSumPerMonth();
            this.longer2 = workDay1.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(this.longer2, this.longer);

    }

    /* Seventh point End */
    /**
     * 8.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 2016.08.28. as actualDay! Add the Task to the WorkDay!
     * Create a WorkMonth and add the WorkDay to the WorkMonth with a true value
     * of isWeekendEnabled! Call the getSumPerDay on the WorkDay! Call the
     * getSumPerMonth on the WorkMonth! -> These should be equal.
     */
    /* Eighth point Begin */
    @Test

    public void taskWorkMonth8_1() throws OwnException {

        this.longer = 0;

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 8;
            date1[2] = 28;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

//            int[] date2 = new int[3];
//            date2[0] = 2016;
//            date2[1] = 9;
//            date2[2] = 1;
//            WorkDay workDay2 = new WorkDay(date2, 420);
//            workDay2.addTask(task2);
            WorkMonth workMonth = new WorkMonth(2016, 8);
            workMonth.addWorkDay(workDay1, true);
//            workMonth.addWorkDay(workDay2);

            this.longer = workMonth.getSumPerMonth();
            this.longer2 = workDay1.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(this.longer2, this.longer);

    }

    /* Eighth point End */
    /**
     * 9.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 2016.08.28. as actualDay! Add the Task to the WorkDay!
     * Create a WorkMonth and add the WorkDay to the WorkMonth with a false
     * value of isWeekendEnabled! -> You should get a WeekendNotEnabledException
     * (you should write this exception, it doesn't exist)
     *
     * @throws OwnException
     */
    /* Nineth point Begin */
    @Test

    public void taskWorkMonth9_1() throws OwnException {

        this.longer = 0;
        this.str = ":(";

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 8;
            date1[2] = 28;
            WorkDay workDay1 = new WorkDay(date1, 420);
            workDay1.addTask(task1);

//            int[] date2 = new int[3];
//            date2[0] = 2016;
//            date2[1] = 9;
//            date2[2] = 1;
//            WorkDay workDay2 = new WorkDay(date2, 420);
//            workDay2.addTask(task2);
            WorkMonth workMonth = new WorkMonth(2016, 8);
            workMonth.addWorkDay(workDay1, false);
//            workMonth.addWorkDay(workDay2);

//            this.longer = workMonth.getSumPerMonth();
//            this.longer2 = workDay1.getSumPerDay();
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("WeekendNotEnabledException", this.str);

    }

    /* Nineth point End */
    /**
     * 10.) Create a WorkDay with 2016.09.01. as actualDay! Create a WorkDay
     * with 2016.09.01. as actualDay! Create a WorkMonth and add the WorkDays to
     * it! -> You should get a NotNewDateException (you should write this
     * exception, it doesn't exist)
     *
     *
     */
    /* Tenth point Begin */
    @Test

    public void taskWorkMonth10_1() throws OwnException {

        this.longer = 0;
        this.str = ":(";

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 1;
            WorkDay workDay1 = new WorkDay(date1, 420);
//            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 9;
            date2[2] = 1;
            WorkDay workDay2 = new WorkDay(date2, 420);
//            workDay2.addTask(task2);
            WorkMonth workMonth = new WorkMonth(2016, 9);

            workMonth.addWorkDay(workDay1, false);
            workMonth.addWorkDay(workDay2);

//            this.longer = workMonth.getSumPerMonth();
//            this.longer2 = workDay1.getSumPerDay();
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NotNewDateException", this.str);

    }

    /* Tenth point End */
    /**
     * 11.) Create a WorkDay with 2016.09.01. as actualDay! Create a WorkDay
     * with 2016.08.30. as actualDay! Create a WorkMonth and add the WorkDays to
     * it! -> You should get a NotTheSameMonthException (you should write this
     * exception, it doesn't exist)
     *
     *
     */
    /* Eleventh point Begin */
    @Test

    public void taskWorkMonth11_1() throws OwnException {

        this.longer = 0;
        this.str = ":(";

        try {
            Task task1 = new Task("LT-1234", "van ez így", "07:30", "08:45");
            Task task2 = new Task("LT-1234", "van ez így", "08:45", "09:45");
            int[] date1 = new int[3];
            date1[0] = 2016;
            date1[1] = 9;
            date1[2] = 1;
            WorkDay workDay1 = new WorkDay(date1, 420);
//            workDay1.addTask(task1);

            int[] date2 = new int[3];
            date2[0] = 2016;
            date2[1] = 8;
            date2[2] = 30;
            WorkDay workDay2 = new WorkDay(date2, 420);
//            workDay2.addTask(task2);
            WorkMonth workMonth = new WorkMonth(2016, 9);

            workMonth.addWorkDay(workDay1, false);
            workMonth.addWorkDay(workDay2);

//            this.longer = workMonth.getSumPerMonth();
//            this.longer2 = workDay1.getSumPerDay();
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NotTheSameMonthException", this.str);

    }

    /* Eleventh point End */
    /**
     * 12.) Create a task with only task id! Create an arbitrary day and a
     * month! Add the task to the day and the day to the month! Call
     * getSumPerMonth on this month! -> You should get an
     * EmptyTimeFieldException
     *
     *
     */
    /* Twelveth point Begin */

 /* Twelveth point End */
    /**
     * 13.) Create a task with only task id! Create an arbitrary day and a
     * month! Add the task to the day and the day to the month! Call
     * getExtraMinPerMonth on this month! -> You should get an
     * EmptyTimeFieldException
     *
     * @throws OwnException
     */
    /* Thirteenth point Begin˙*/

 /* Thirteenth point End˙*/
 /* WORKMONTH CLASS TEST END */
}
