/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlog16java;

import Logger.*;
import TextBasedUI.TimeLoggerUI;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import timelogger.exceptions.OwnException;

/**
 *
 * @author stampel
 */
public class TLOG16Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, OwnException {
        // TODO code application logic here

        List<WorkMonth> months = new ArrayList();
        TimeLogger TL = new TimeLogger(months);
        Scanner in = new Scanner(System.in);
        while (1 == 1) {

            int i = in.nextInt();

            TimeLoggerUI tlui = new TimeLoggerUI();
            if (!tlui.TimeLoggerUICreat(i, TL)) {
                
                return;
            }
        }

    }

}