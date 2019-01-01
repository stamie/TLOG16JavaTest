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

public class TestTask { //extends TestCase {

    protected String str;
    protected String startTime;
    protected String endTime;
    protected String comment;
    protected String taskId;
    protected long integer;

    /* TASK CLASS TEST BEGIN */
 /* First point Begin */
    @Test //(expected = OwnException.class)

    public void taskTest1_1() throws OwnException {

        this.str = ":(";

        try {
            Task task = new Task("LT-1234", "van ez így", "08:45", "07:30");
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("The startTime is not Before for endTime!", this.str);

    }

    @Test

    public void taskTest1_2() throws OwnException {
        this.str = ":(";
        try {
            int[] startTimeArray = new int[2];
            int[] endTimeArray = new int[2];
            startTimeArray[0] = 8;
            startTimeArray[1] = 45;
            endTimeArray[0] = 7;
            endTimeArray[1] = 30;

            Task task = new Task("LT-1234", "van ez így", startTimeArray, endTimeArray);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is not Before for endTime!", this.str);

    }

    @Test

    public void taskTest1_3() throws OwnException {
        this.str = ":(";

        try {
            int[] startTimeArray = new int[2];
            int[] endTimeArray = new int[2];
            startTimeArray[0] = 8;
            startTimeArray[1] = 45;
            endTimeArray[0] = 7;
            endTimeArray[1] = 30;

            Task task = new Task("LT-1234", startTimeArray, endTimeArray);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is not Before for endTime!", this.str);

    }

    @Test

    public void taskTest1_4() throws OwnException {
        this.str = ":(";

        try {
            String startTimeString = "08:45";
            String endTimeString = "07:30";

            Task task = new Task("LT-1234", startTimeString);
            task.endTaskWithString(endTimeString);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is not Before for endTime!", this.str);

    }

    @Test

    public void taskTest1_5() throws OwnException {
        this.str = ":(";

        try {
            int[] startTimeArray = new int[2];
            int[] endTimeArray = new int[2];
            startTimeArray[0] = 8;
            startTimeArray[1] = 45;
            endTimeArray[0] = 7;
            endTimeArray[1] = 30;

            Task task = new Task("LT-1234", startTimeArray);
            task.endTaskWithArray(endTimeArray);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is not Before for endTime!", this.str);

    }

    /* First point End */
 /* Second point Start */
    public void taskTest2_1() throws OwnException {

        this.str = ":(";

        try {
            String startTimeString = null;
            String endTimeString = null;
            Task task = new Task("LT-1234", "van ez így", startTimeString, endTimeString);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("The startTime is Empty!", this.str);

    }

    @Test

    public void taskTest2_2() throws OwnException {
        this.str = ":(";
        try {
            int[] startTimeArray = null;
            int[] endTimeArray = null;

            Task task = new Task("LT-1234", "van ez így", startTimeArray, endTimeArray);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is Empty!", this.str);

    }

    public void taskTest2_3() throws OwnException {

        this.str = ":(";

        try {
            String startTimeString = null;
            String endTimeString = null;
            Task task = new Task("LT-1234", "van ez így", startTimeString, endTimeString);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("The startTime is Empty!", this.str);

    }

    @Test

    public void taskTest2_4() throws OwnException {
        this.str = ":(";
        try {
            int[] startTimeArray = null;
            int[] endTimeArray = null;

            Task task = new Task("LT-1234", "van ez így", startTimeArray);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is Empty!", this.str);

    }

    public void taskTest2_5() throws OwnException {

        this.str = ":(";

        try {
            String startTimeString = null;
            String endTimeString = null;
            Task task = new Task("LT-1234", startTimeString);
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("The startTime is Empty!", this.str);

    }

    @Test

    public void taskTest2_6() throws OwnException {
        this.str = ":(";
        try {
            int[] startTimeArray = null;
            int[] endTimeArray = null;

            Task task = new Task("LT-1234", startTimeArray);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
        assertEquals("The startTime is Empty!", this.str);

    }

    /* Second point End */
 /* Thired point Start */
    @Test

    public void taskTest3_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task1 = new Task("LT-1111", "07:30");
            task1.endTaskWithString("08:45");
            this.integer = task1.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    @Test

    public void taskTest3_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task2 = new Task("LT-1111", startTimeArrayI);
            task2.endTaskWithArray(endTimeArrayI);
            this.integer = task2.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    @Test

    public void taskTest3_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task3 = new Task("LT-1111", "ez van", startTimeArrayI);
            task3.endTaskWithArray(endTimeArrayI);
            this.integer = task3.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    @Test

    public void taskTest3_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task4 = new Task("LT-1111", startTimeArrayI, endTimeArrayI);
            this.integer = task4.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    @Test

    public void taskTest3_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task5 = new Task("LT-1111", "ez van", "07:30", "08:45");
            this.integer = task5.getMinPerTask();
            this.str = "itt vok";

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    @Test

    public void taskTest3_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task6 = new Task("LT-1111", "ez van", startTimeArrayI, endTimeArrayI);
            this.integer = task6.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals(75, this.integer);

    }

    /* Thired point End */
 /* Fourth point Start */
    @Test

    public void taskTest4_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task1 = new Task("154858", "07:30");
            task1.endTaskWithString("08:45");
            this.integer = task1.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest4_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task2 = new Task("154858", startTimeArrayI);
            task2.endTaskWithArray(endTimeArrayI);
            this.integer = task2.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest4_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task3 = new Task("154858", "ez van", startTimeArrayI);
            task3.endTaskWithArray(endTimeArrayI);
            this.integer = task3.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest4_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task4 = new Task("154858", startTimeArrayI, endTimeArrayI);
            this.integer = task4.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest4_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task5 = new Task("154858", "ez van", "07:30", "08:45");
            this.integer = task5.getMinPerTask();
            this.str = "itt vok";

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest4_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task6 = new Task("154858", "ez van", startTimeArrayI, endTimeArrayI);
            this.integer = task6.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    /* Fourth point End */
 /* Fiveth point Start */
    @Test

    public void taskTest5_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task1 = new Task("LT-154858", "07:30");
            task1.endTaskWithString("08:45");
            this.integer = task1.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest5_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task2 = new Task("LT-154858", startTimeArrayI);
            task2.endTaskWithArray(endTimeArrayI);
            this.integer = task2.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest5_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task3 = new Task("LT-154858", "ez van", startTimeArrayI);
            task3.endTaskWithArray(endTimeArrayI);
            this.integer = task3.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest5_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            Task task4 = new Task("LT-154858", startTimeArrayI, endTimeArrayI);
            this.integer = task4.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest5_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            Task task5 = new Task("LT-154858", "ez van", "07:30", "08:45");
            this.integer = task5.getMinPerTask();
            this.str = "itt vok";

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest5_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;

            Task task6 = new Task("LT-154858", "ez van", startTimeArrayI, endTimeArrayI);
            this.integer = task6.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    /* Fiveth point End */
 /* Sixth point Start */
    @Test

    public void taskTest6_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            this.str = "baj van";
            String taskId = "";
            Task task1 = new Task(taskId, "07:30");
            //task1.endTaskWithString("08:45");
            //this.integer = task1.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest6_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "";
            Task task2 = new Task(taskId, startTimeArrayI);
            task2.endTaskWithArray(endTimeArrayI);
            this.integer = task2.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest6_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "";
            Task task3 = new Task(taskId, "ez van", startTimeArrayI);
            task3.endTaskWithArray(endTimeArrayI);
            this.integer = task3.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest6_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "";
            Task task4 = new Task(taskId, startTimeArrayI, endTimeArrayI);
            this.integer = task4.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest6_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            String taskId = "";
            Task task5 = new Task(taskId, "ez van", "07:30", "08:45");
            this.integer = task5.getMinPerTask();
            this.str = "itt vok";

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest6_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "";
            Task task6 = new Task(taskId, "ez van", startTimeArrayI, endTimeArrayI);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    /* Sixth point End */
 /* Seventh point End */
    public void taskTest7_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            Task task1 = new Task(taskId, "", startTimeArrayI, endTimeArrayI);
            this.str = task1.getComment();
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    public void taskTest7_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            Task task2 = new Logger.Task(taskId, "", startTimeArrayI);
            this.str = task2.getComment();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    public void taskTest7_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            Task task3 = new Logger.Task(taskId, "", "07:00", "08:00");
            this.str = task3.getComment();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    public void taskTest7_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            String commentI = null;
            Task task1 = new Task(taskId, commentI, startTimeArrayI, endTimeArrayI);
            this.str = task1.getComment();
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    public void taskTest7_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            String commentI = null;
            Task task2 = new Logger.Task(taskId, commentI, startTimeArrayI);
            this.str = task2.getComment();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    public void taskTest7_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = "LT-1111";
            String commentI = null;
            Task task3 = new Logger.Task(taskId, commentI, "07:00", "08:00");
            this.str = task3.getComment();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("", this.str);

    }

    /* Seventh point End */
    /**
     * 8.) Create a task, which starts at 7:30 and ends at 7:50! -> The task's
     * endTime should be rounded to 7:45
     */
    /* Eighth point Begin */
    public void taskTest8_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";

        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 50;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            //task.setEndTime(8, 0);
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    public void taskTest8_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", "07:30", "07:50");
            //task.setEndTime(8, 0);
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    /* Eighth point End */
    /**
     * 9.) Create a task! Set the start time so the duration will not be
     * multiple of quarter hours (try all the 3 types of setStartTime)! -> the
     * end time should be rounded
     */
    /* Nineth point Begin */
    public void taskTest9_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";

        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task.setStartTime(7, 40);

            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:40", this.startTime);
        assertEquals("07:55", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    public void taskTest9_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", "07:40", "07:45");
            //task.setEndTime(8, 0);
            task.setStartTime("7:40");
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:40", this.startTime);
        assertEquals("07:55", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    /* Nineth point End */
    /**
     * 10.) Create a task! Set the end time so the duration will not be multiple
     * of quarter hours (try all the 3 types of setEndTime)! -> the end time
     * should be rounded
     *
     */
    /* Tenth point Begin */
public void taskTest10_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";

        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task.setEndTime(7, 40);

            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    public void taskTest10_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", "07:30", "07:45");
            task.setEndTime(7, 40);
    //        task.setStartTime("7:40");
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }
 /* Tenth point End */
 /* Eleventh point Start */
    @Test

    public void taskTest11_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            this.str = "baj van";
            String taskId = null;
            Task task1 = new Task(taskId, "07:30");
            //task1.endTaskWithString("08:45");
            //this.integer = task1.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest11_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task2 = new Task(taskId, startTimeArrayI);
            task2.endTaskWithArray(endTimeArrayI);
            this.integer = task2.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest11_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task3 = new Task(taskId, "ez van", startTimeArrayI);
            task3.endTaskWithArray(endTimeArrayI);
            this.integer = task3.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest11_4() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task4 = new Task(taskId, startTimeArrayI, endTimeArrayI);
            this.integer = task4.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest11_5() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            String taskId = null;
            Task task5 = new Task(taskId, "ez van", "07:30", "08:45");
            this.integer = task5.getMinPerTask();
            this.str = "itt vok";

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest11_6() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task(taskId, "ez van", startTimeArrayI, endTimeArrayI);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    /* Eleventh point End */
    /**
     * ***********************************************
     *
     * 12.) Create a task! Set the task id to be invalid! ->
     *
     * ->You should get an InvalidTaskIdException
     *
     *
     ************************************************
     */
    /* Twelfth point Begin */
    @Test

    public void taskTest12_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setTaskId("jbbwefh379675");

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Wrong taskID!", this.str);

    }

    @Test

    public void taskTest12_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setTaskId("");

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    @Test

    public void taskTest12_3() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setTaskId(taskId);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Invalid taskID!", this.str);

    }

    /* Twelfth point End */
    /**
     * *
     * 13.) Create a task! Set the start time to be later than the end time! ->
     * You should get a NotExpectedTimeOrderException
     */
    /* Thirteenth point Begin */
    @Test

    public void taskTest13_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setStartTime(9, 0);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Wrong new startTime!", this.str);

    }

    @Test

    public void taskTest13_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setStartTime("09:00");

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Wrong new startTime!", this.str);

    }

    /* Thirteenth point End */
    /**
     * 14.) Create a task! Set the end time to be earlier than the start time!
     * -> You should get a NotExpectedTimeOrderException
     */
    /* Fourteenth point Begin */
    @Test

    public void taskTest14_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setEndTime(7, 0);

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Wrong new endTime!", this.str);

    }

    @Test

    public void taskTest14_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            task6.setEndTime("07:00");

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("Wrong new endTime!", this.str);

    }

    /* Fourteenth point End */
    /**
     * 15.) Create a task only with task id parameter! Call the getMinPerTask
     * method! -> You should get an EmptyTimeFieldException
     */
    /* Fiveteenth point Begin */
    public void taskTest15_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = null;
            int[] endTimeArrayI = null;
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 8;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task6 = new Task("LT-1234", startTimeArrayI);
            this.integer = task6.getMinPerTask();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("EmptyTimeFieldException", this.str);

    }

    /* Fiveteenth point End */
    /**
     * 16.) Create a task, which starts at 7:30 and ends at 7:45! Set the start
     * time to 7:00. -> The start time should be 7:00
     *
     */
    /* Sixteenth point Begin */
    public void taskTest16_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = null;
            int[] endTimeArrayI = null;
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", startTimeArrayI, endTimeArrayI);
            task.setStartTime("07:00");
            this.str = task.getStartTimeToString();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:00", this.str);

    }

    public void taskTest16_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = null;
            int[] endTimeArrayI = null;
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", startTimeArrayI, endTimeArrayI);
            task.setStartTime(7, 0);
            this.str = task.getStartTimeToString();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:00", this.str);

    }

    /* Sixteenth point End */
    /**
     * 17.) Create a task, which starts at 7:30 and ends at 7:45! Set the end
     * time to 8:00. -> The end time should be 8:00
     */
    /* Seventeenth point Begin */
    public void taskTest17_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = null;
            int[] endTimeArrayI = null;
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", startTimeArrayI, endTimeArrayI);
            task.setEndTime("08:00");
            this.str = task.getStartTimeToString();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("08:00", this.str);

    }

    public void taskTest17_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        try {
            int[] startTimeArrayI = null;
            int[] endTimeArrayI = null;
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", startTimeArrayI, endTimeArrayI);
            task.setEndTime(8, 0);
            this.str = task.getStartTimeToString();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("08:00", this.str);

    }

    /* Seventeenth point End */
    /**
     * 18.) Create a simple task and check if all the value is set properly!
     */
    /* Eighteenth point Begin */
    public void taskTest18_1() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";

        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", startTimeArrayI, endTimeArrayI);
            //task.setEndTime(8, 0);
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    public void taskTest18_2() throws OwnException {

        this.str = ":(";
        this.integer = -1;
        this.startTime = "";
        this.endTime = "";
        this.comment = "";
        this.taskId = "";
        try {
            int[] startTimeArrayI = new int[2];
            int[] endTimeArrayI = new int[2];
            startTimeArrayI[0] = 7;
            startTimeArrayI[1] = 30;
            endTimeArrayI[0] = 7;
            endTimeArrayI[1] = 45;
            String taskId = null;
            Task task = new Task("LT-1234", "ez van", "07:30", "07:45");
            //task.setEndTime(8, 0);
            this.startTime = task.getStartTimeToString();
            this.endTime = task.getEndTimeToString();
            this.comment = task.getComment();
            this.taskId = task.getTaskId();

        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }

        assertEquals("07:30", this.startTime);
        assertEquals("07:45", this.endTime);
        assertEquals("LT-1234", this.taskId);
        assertEquals("ez van", this.comment);

    }

    /* Eighteenth point End */
 /* TASK CLASS TEST END */
}
