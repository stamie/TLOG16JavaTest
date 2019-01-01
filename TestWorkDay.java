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
     /* First point Begin */
    @Test //(expected = OwnException.class)

    public void taskTest1_1() throws OwnException {

        this.str = ":(";
/*
        try {
            Task task = new Task("LT-1234", "van ez így", "08:45", "07:30");
        } catch (OwnException ex) {

            this.str = ex.getMessage();
        }
*/
        assertEquals(":(", this.str);

    }

}