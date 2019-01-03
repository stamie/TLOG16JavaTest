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
 /* WORKDAY CLASS TEST END */
}
