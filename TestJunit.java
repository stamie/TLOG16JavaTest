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

public class TestJunit { //extends TestCase {

    protected String str;
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
    
 /* TASK CLASS TEST END */
}
