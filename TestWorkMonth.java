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
     * 2.) Create a WorkMonth! Call the getSumPerMonth method! -> The result
     * should be 0.
     */
    /* Second point Begin */
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
 /* Thired point End */
    /**
     * 4.) Create a WorkMonth! Call the getExtraMinPerMonth method! -> The
     * result should be 0.
     *
     * @throws OwnException
     */
    /* Fourth point Begin */
 /* Fourth point End */
    /**
     * 5.) Create a WorkDay with 420 as requiredMinPerDay and 2016.09.01. as
     * actualDay! Create an other WorkDay with 420 as requiredMinPerDay! Create
     * a WorkMonth and add the WorkDays to it! Call the getRequiredMinPerMonth!
     * -> The result should be 840.
     */
    /* Fiveth point Begin */
 /* Fiveth point Begin */
    /**
     * 6.) Create a WorkMonth! Call the getRequiredMinPerMonth! -> The result
     * should be 0.
     *
     * @throws OwnException
     */
    /* Sixth point Begin */
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
 /* Seventh point End */
    /**
     * 8.) Create a Task with start time 7:30 and end time 8:45! Create a
     * WorkDay with 2016.08.28. as actualDay! Add the Task to the WorkDay!
     * Create a WorkMonth and add the WorkDay to the WorkMonth with a true value
     * of isWeekendEnabled! Call the getSumPerDay on the WorkDay! Call the
     * getSumPerMonth on the WorkMonth! -> These should be equal.
     */
    /* Eighth point Begin */
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
