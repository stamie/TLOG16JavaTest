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

public class TestWorkDay { //extends TestCase {

    protected String str;
    protected long longer;
    protected int[] actualDay;
    protected LocalTime time;
    protected LocalDate date;

    /**
     * 1.) Create a Task which starts at 7:30 and ends at 8:45! Create a
     * WorkDay, which has default value as requiredMinPerDay! Add Task to the
     * WorkDay! Call getExtraMinutesPerDay! -> The result should be -375.
     *
     * @throws OwnException
     */
    /* First point Begin */
    @Test //(expected = OwnException.class)

    public void taskWorkDay1_1() throws OwnException {

        this.longer = 0;

        try {
            Task task = new Task("LT-1234", "van ez így", "07:30", "08:45");
            WorkDay workDay = new WorkDay();
            workDay.addTask(task);
            this.longer = workDay.getExtraMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(-375, this.longer);

    }

    /* First point End */
    /**
     * 2.) Create a WorkDay which has no Task added! Call getExtraMinutesPerDay!
     * -> The result should be -requiredMinPerDay
     */
    /* Second point Begin */
    @Test

    public void taskWorkDay2_1() throws OwnException {
        this.longer = 0;

        try {
            WorkDay workDay = new WorkDay(24);
            this.longer = workDay.getExtraMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(-24, this.longer);

    }

    /* Second point End */
    /**
     * 3.) Create a WorkDay! Try to set a negative value as requiredMinPerDay
     * with calling the setRequiredMinPerDay method! -> You should get a
     * NegativeMinutesOfWorkException (you should write this exception, it
     * doesn't exist)
     *
     * @throws OwnException
     */
    /* Thired point Begin */
    @Test

    public void taskWorkDay3_1() throws OwnException {
        this.longer = 0;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(24);
            workDay.setRequiredMinPerDay(-24);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NegativeMinutesOfWorkException", this.str);

    }

    @Test

    public void taskWorkDay3_2() throws OwnException {
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(this.actualDay, 24);
            workDay.setRequiredMinPerDay(-24);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NegativeMinutesOfWorkException", this.str);

    }

    /* Thired point End */
    /**
     * 4.) Create a WorkDay with a negative value of requiredMinPerDay! -> You
     * should get a NegativeMinutesOfWorkException
     *
     * @throws OwnException
     */
    /* Fourth point Begin */
    @Test

    public void taskWorkDay4_1() throws OwnException {
        this.longer = 0;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(-24);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NegativeMinutesOfWorkException", this.str);

    }

    @Test

    public void taskWorkDay4_2() throws OwnException {
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(this.actualDay, -24);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NegativeMinutesOfWorkException", this.str);

    }

    /* Fourth point End */
    /**
     * 5.) Create a WorkDay! Try to set a future date as actualDay with calling
     * the setActualDay method! -> You should get a FutureWorkException (you
     * should write this exception, it doesn't exist)
     *
     */
    /* Fiveth point Begin */
    @Test

    public void taskWorkDay5_1() throws OwnException {
        this.longer = 0;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2020;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;

        try {
            WorkDay workDay = new WorkDay();
            workDay.setActualDay(this.actualDay);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("FutureWorkException", this.str);

    }

    @Test

    public void taskWorkDay5_2() throws OwnException {
        this.actualDay = new int[3];
        this.actualDay[0] = 2020;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(24);
            workDay.setActualDay(this.actualDay);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("FutureWorkException", this.str);

    }

    /* Fiveth point Begin */
    /**
     * 6.) Create a WorkDay with a future date as actualDay! -> You should get a
     * FutureWorkException
     *
     * @throws OwnException
     */
    /* Sixth point Begin */
    @Test

    public void taskWorkDay6_1() throws OwnException {
        this.longer = 0;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2020;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;

        try {
            WorkDay workDay = new WorkDay(this.actualDay);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("FutureWorkException", this.str);

    }

    @Test

    public void taskWorkDay6_2() throws OwnException {
        this.actualDay = new int[3];
        this.actualDay[0] = 2020;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.str = ":(";

        try {
            WorkDay workDay = new WorkDay(this.actualDay, 24);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("FutureWorkException", this.str);

    }

    /* Sixth point Begin */
    /**
     * 7.) Create a Task which starts at 7:30 and ends at 8:45! Create an other
     * one which starts at 8:45 and ends at 9:45! Create a WorkDay, and add the
     * Tasks to it! Call the getSumPerDay! -> The result should be 135.
     *
     */
    /* Seventh point Begin */
    @Test

    public void taskWorkDay7_1() throws OwnException {
        this.longer = 0;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "08:45", "09:45");
            WorkDay workDay = new WorkDay(this.actualDay);
            workDay.addTask(task1);
            workDay.addTask(task2);
            this.longer = workDay.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(135, this.longer);

    }

    @Test

    public void taskWorkDay7_2() throws OwnException {
        this.actualDay = new int[3];
        this.str = ":(";

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "08:45", "09:45");
            WorkDay workDay = new WorkDay();
            workDay.addTask(task1);
            workDay.addTask(task2);
            this.longer = workDay.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(135, this.longer);

    }

    /* Seventh point End */
    /**
     * 8.) Create a WorkDay! Call the getSumPerDay! -> The result should be 0.
     *
     */
    /* Eighth point Begin */
    @Test

    public void taskWorkDay8_1() throws OwnException {
        this.longer = 2;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "08:45", "09:45");
            WorkDay workDay = new WorkDay(this.actualDay);
//            workDay.addTask(task1);
//            workDay.addTask(task2);
            this.longer = workDay.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(0, this.longer);

    }

    @Test

    public void taskWorkDay8_2() throws OwnException {
        this.actualDay = new int[3];
        this.str = ":(";
        this.longer = 2;

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "08:45", "09:45");
            WorkDay workDay = new WorkDay();
//            workDay.addTask(task1);
//            workDay.addTask(task2);
            this.longer = workDay.getSumPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(0, this.longer);

    }

    /* Eighth point End */
    /**
     * 9.) Create a Task with beginning time 7:30, finishing time 8:45. Create
     * an other one with beginning time 9:30, finishing time 11:45. Create a
     * WorkDay and add these tasks to it. Call the endTimeOfTheLastTask() on the
     * WorkDay -> The result should be LocalTime.of(11:45)
     *
     * @throws OwnException
     */
    /* Nineth point Begin */
    @Test

    public void taskWorkDay9_1() throws OwnException {
        this.longer = 2;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.time = LocalTime.of(1, 0);

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "09:30", "11:45");
            WorkDay workDay = new WorkDay(this.actualDay);
            workDay.addTask(task1);
            workDay.addTask(task2);
            this.time = workDay.endTimeOfTheLastTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(LocalTime.of(11, 45), this.time);

    }

    @Test

    public void taskWorkDay9_2() throws OwnException {
        this.actualDay = new int[3];
        this.str = ":(";
        this.longer = 2;

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "09:30", "11:45");
            WorkDay workDay = new WorkDay();
            workDay.addTask(task1);
            workDay.addTask(task2);
            this.time = workDay.endTimeOfTheLastTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(LocalTime.of(11, 45), this.time);

    }

    /* Nineth point End */
    /**
     * 10.) Create a WorkDay and call the endTimeOfTheLastTask method on it. ->
     * The result should be null.
     *
     */
    /* Tenth point Begin */
    public void taskWorkDay10_1() throws OwnException {
        this.longer = 2;
        this.str = ":(";
        this.actualDay = new int[3];
        this.actualDay[0] = 2019;
        this.actualDay[1] = 1;
        this.actualDay[2] = 3;
        this.time = LocalTime.of(1, 0);

        try {
//            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
//            Task task2 = new Task("LT-5234", "ez van", "09:30", "11:45");
            WorkDay workDay = new WorkDay(this.actualDay);
//            workDay.addTask(task1);
//            workDay.addTask(task2);
            this.time = workDay.endTimeOfTheLastTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(null, this.time);

    }

    @Test

    public void taskWorkDay10_2() throws OwnException {
        this.actualDay = new int[3];
        this.str = ":(";
        this.longer = 2;

        try {
//            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
//            Task task2 = new Task("LT-5234", "ez van", "09:30", "11:45");
            WorkDay workDay = new WorkDay();
//            workDay.addTask(task1);
//            workDay.addTask(task2);
            this.time = workDay.endTimeOfTheLastTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(null, this.time);

    }

    /* Tenth point End */
    /**
     * 11.) Create a Task with the start time 7:30 and the end time 8:45! Create
     * an other one with the start time 8:30 and the end time 9:45! Create an
     * arbitrary WorkDay! Add the Tasks to the WorkDay! -> You should get a
     * NotSeparatedTimesException (you should write this exception, it doesn't
     * exist)
     *
     */
    /* Eleventh point Begin */
    @Test

    public void taskWorkDay11_1() throws OwnException {
        this.actualDay = new int[3];
        this.str = ":(";
        this.longer = 2;

        try {
            Task task1 = new Task("LT-1234", "ez van", "07:30", "08:45");
            Task task2 = new Task("LT-5234", "ez van", "08:30", "09:45");
            WorkDay workDay = new WorkDay();
            workDay.addTask(task1);
            workDay.addTask(task2);
            this.time = workDay.endTimeOfTheLastTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("NotSeparatedTimesException", this.str);

    }

    /* Eleventh point End */
    /**
     * 12.) Create a workday with given date and required minutes per day! Check
     * if it is created properly!
     *
     */
    /* Twelveth point Begin */
    @Test

    public void taskWorkDay12_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

        try {
            int[] actualDayI = new int[3];
            actualDayI[0] = 2018;
            actualDayI[1] = 12;
            actualDayI[2] = 11;
            WorkDay workDay = new WorkDay(actualDayI, 300);
            this.str = workDay.getActualDayToString();
            this.longer = workDay.getRequiredMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("2018-12-11", this.str);
        assertEquals(300, this.longer);

    }

    /* Twelveth point End */
    /**
     * 13.) Create a workday with given date, the required minutes per day
     * should be the default! Check if it is created properly!
     *
     * @throws OwnException
     */
    /* Thirteenth point Begin˙*/
    @Test

    public void taskWorkDay13_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

        try {
            int[] actualDayI = new int[3];
            actualDayI[0] = 2018;
            actualDayI[1] = 12;
            actualDayI[2] = 11;
            WorkDay workDay = new WorkDay(actualDayI);
            this.str = workDay.getActualDayToString();
            this.longer = workDay.getRequiredMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("2018-12-11", this.str);
        assertEquals(450, this.longer);

    }

    /* Thirteenth point End˙*/
    /**
     * 14.) Create a workday with default date, and the required minutes per day
     * should be the 300! Check if it is created properly!
     *
     * @throws OwnException
     */
    /* Fourteenth point Begin */
    @Test

    public void taskWorkDay14_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

        try {
            int[] actualDayI = new int[3];
            actualDayI[0] = 2018;
            actualDayI[1] = 12;
            actualDayI[2] = 11;
            WorkDay workDay = new WorkDay(300);
            this.date = workDay.getActualDay();
            this.longer = workDay.getRequiredMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(LocalDate.now(), this.date);
        assertEquals(300, this.longer);

    }

    /* Fourteenth point End */
    /**
     * 15.) Create a workday with the default values and check if it it created
     * properly!
     *
     * @throws OwnException
     */
    /* Fiveteenth point Begin */
    @Test

    public void taskWorkDay15_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

//        try {
        int[] actualDayI = new int[3];
        actualDayI[0] = 2018;
        actualDayI[1] = 12;
        actualDayI[2] = 11;
        WorkDay workDay = new WorkDay();
        this.date = workDay.getActualDay();
        this.longer = workDay.getRequiredMinPerDay();

//        } catch (OwnException ex) {
//
//            this.str = ex.getMessage();
//        }
        assertEquals(LocalDate.now(), this.date);
        assertEquals(450, this.longer);

    }

    /* Fiveteenth point End */
    /**
     * 16.) Create an arbitrary workday! Set the actual day to be 2016/09/01!
     * Check if the date is 2016/09/01 now!
     *
     */
    @Test

    public void taskWorkDay16_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

        try {
            int[] actualDayI = new int[3];
            actualDayI[0] = 2016;
            actualDayI[1] = 9;
            actualDayI[2] = 1;
            WorkDay workDay = new WorkDay();
            workDay.setActualDay(actualDayI);
            this.date = workDay.getActualDay();
//        this.longer = workDay.getRequiredMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals(LocalDate.of(2016, 9, 1), this.date);
//        assertEquals(450, this.longer);

    }

    /**
     * 17.) Create an arbitrary workday! Set the required minutes per day to be
     * 300! Check if it is 300 now!
     */
    @Test

    public void taskWorkDay17_1() throws OwnException {
        this.str = ":(";
        this.longer = 0;

        try {
            int[] actualDayI = new int[3];
            actualDayI[0] = 2016;
            actualDayI[1] = 9;
            actualDayI[2] = 1;
            WorkDay workDay = new WorkDay();
            workDay.setRequiredMinPerDay(300);
//            this.date = workDay.getActualDay();
            this.longer = workDay.getRequiredMinPerDay();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
//        assertEquals(LocalDate.of(2016, 9, 1), this.date);
        assertEquals(300, this.longer);

    }
    /**
     * 18.) Create a Task with only task id as parameter! Create an arbitrary
     * workday! Add the task to the workday! Call the getSumPerDay method! ->
     * You should get an EmptyTimeFieldException
     *
     */
    /* WORKDAY CLASS TEST END */
}
