/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextBasedUI;

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

/**
 *
 * @author stampel
 */
/*
0. Exit
1. List months: shows a counter, the year & the month line by line (example: 1. 2016-09, 2. 2016-10, ...)
2. List days:
lists the months, select one by ask for row number
list all workdays of this month
3. List tasks for a specific day (ask for month & day)
4. Add new month: specify year & month with integers
5. Add day to a specific month:
list the workmonths (2. menu item)
ask the index of workmonth
ask the day
ask the required working hours, default value=7.5
6. Start a task for a day
ask for month, day, task id, what you do (comment)
ask for start time in format 10:30 
if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
don't ask for the end time!
7. Finish a specific task: 
ask for month & day, 
display only unfinished tasks
ask for end time (format: 12:45, with validation)
8. Delete a task: ask for month, day, select task - ask for confirmation!
9. Modify task: ask for month, day, task, let change every fields (shows previous value in braces, if the input is empty, don't change the value!)
10. Statistics: ask for month, then print the statistics of the month, and the statistics of the days of this month
 */
public class TimeLoggerUI {

    private LocalDate thisDate;

    public boolean TimeLoggerUICreat(int input, TimeLogger timeLogger) {
        switch (input) {
            
            case 0: // Exit
                return false;
            case 1: // List months: shows a counter, the year & the month line by line (example: 1. 2016-09, 2. 2016-10, ...)
                listMonths(timeLogger);
                break;
            case 2:
                /* List days:
                lists the months, select one by ask for row number
                list all workdays of this month */
                listDays(timeLogger);
                break;
                
            case 3: // List tasks for a specific day (ask for month & day)
                listTasks(timeLogger);
                break;
            case 4: // Add new month: specify year & month with integers
                addNewMonth(timeLogger);
                break;
            case 5:
                /* Add day to a specific month:
                list the workmonths (2. menu item)
                ask the index of workmonth
                ask the day
                ask the required working hours, default value=7.5 */
                addDay(timeLogger);
                break;
            case 6:
                /* Start a task for a day
                ask for month, day, task id, what you do (comment)
                ask for start time in format 10:30
                if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
                don't ask for the end time! */
                startTask(timeLogger);
                break;
            case 7:
                /* Finish a specific task:
                ask for month & day,
                display only unfinished tasks
                ask for end time (format: 12:45, with validation)*/
                finishASpecificTask(timeLogger);
                break;
            case 8: // Delete a task: ask for month, day, select task - ask for confirmation!
                deleteTask(timeLogger);
                break;
            case 9: // Modify task: ask for month, day, task, let change every fields (shows previous value in braces, if the input is empty, don't change the value!)
                modifyTask(timeLogger);
                break;
            case 10: // Statistics: ask for month, then print the statistics of the month, and the statistics of the days of this month
                statistics(timeLogger);
                break;
            default:
                System.out.println("Wrong function key!");
                break;
        }
        return true;
        
        
    }

    public void listMonths(TimeLogger timeLogger) {

        System.out.println("List of month:");
        if (!timeLogger.listMonths()) {
            System.out.println("No items");
        }
        System.out.println();
        return;

    }

    public int listDays(TimeLogger timeLogger) {
        this.listMonths(timeLogger);

        if (timeLogger.getMonths().isEmpty()) {
            return -1;
        }

        Scanner in = new Scanner(System.in);
        int monthNum;
        while (1 == 1) {
            System.out.print("Months number is: ");
            monthNum = in.nextInt();

            if (monthNum > timeLogger.getMonths().size() || monthNum < 1) {
                System.out.println("Wrong number");
            } else {
                break;
            }
        }

        monthNum--;

        WorkMonth month = timeLogger.getMonths().get(monthNum);

        if (!month.listDays()) {
            System.out.println("It haven't work days.");
            return -1;

        }
        System.out.println();
        return monthNum;
    }

    // List tasks for a specific day (ask for month & day)
    public int[] listTasks(TimeLogger timeLogger) {
        try {

            int workMonthIndex = this.listDays(timeLogger);
            if (workMonthIndex != -1) {
                int dayNum = 0;

                while ((dayNum > timeLogger.getMonths().get(workMonthIndex).getDays().size() || dayNum == 0) && timeLogger.getMonths().get(workMonthIndex).getDays().size() > 0) {
                    System.out.print("Day Number: ");
                    Scanner in = new Scanner(System.in);
                    dayNum = in.nextInt();
                }

                //TODO: testing the tasks list printer
                if (dayNum > 0) {
                    WorkDay wd = timeLogger.getMonths().get(workMonthIndex).getDays().get(--dayNum);

                    wd.listTask(true);
                    int[] ret = new int[2];
                    ret[0] = workMonthIndex;
                    ret[1] = dayNum;
                    return ret;

                }

            }
        } catch (OwnException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<Task> listTasksNotTheEnd(TimeLogger timeLogger) {
        try {
            int workMonthIndex = this.listDays(timeLogger);
            if (workMonthIndex != -1) {
                int dayNum = 0;

                while ((dayNum > timeLogger.getMonths().get(workMonthIndex).getDays().size() || dayNum == 0) && timeLogger.getMonths().get(workMonthIndex).getDays().size() > 0) {
                    System.out.print("Day number is: ");
                    Scanner in = new Scanner(System.in);
                    dayNum = in.nextInt();
                }

                //TODO: testing the tasks list printer
                if (dayNum > 0) {
                    WorkDay wd = timeLogger.getMonths().get(workMonthIndex).getDays().get(--dayNum);
                    this.thisDate = timeLogger.getMonths().get(workMonthIndex).getDays().get(dayNum).getActualDay();

                    List<Task> ret = wd.listTask(false);
                    return ret;

                }

            }

        } catch (OwnException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void addNewMonth(TimeLogger timeLogger) {

        Scanner in = new Scanner(System.in);
        System.out.print("Year: ");
        int year = in.nextInt();
        System.out.print("Month: ");
        int month = in.nextInt();
        WorkMonth wm = new WorkMonth(year, month);
        timeLogger.addMonth(wm);

    }

    /*
    Add day to a specific month:
        -list the workmonths (2. menu item)
        -ask the index of workmonth
        -ask the day
        -ask the required working hours, default value=7.5
     */
    public void addDay(TimeLogger timeLogger) {

        this.listMonths(timeLogger); //list the workmonths (2. menu item)

        if (timeLogger.getMonths().isEmpty()) {
            return;
        }
        //ask the index of workmonth:
        Scanner in = new Scanner(System.in);
        int month;
        while (1 == 1) {
            System.out.print("Months number is: ");
            month = in.nextInt();

            if (month > timeLogger.getMonths().size() || month < 1) {
                System.out.println("Wrong number!");
            } else {
                break;
            }
        }

        month--;

        //ask the day
        int day;
        while (1 == 1) {
            System.out.print("Add day: ");

            day = in.nextInt();
            if (day > 0 && day < 32) {
                break;
            }
            System.out.println("Wrong day numbers!");
        }

        int[] actualDay = new int[3];
        actualDay[0] = timeLogger.getMonths().get(month).getDate().getYear();
        actualDay[1] = timeLogger.getMonths().get(month).getDate().getMonthValue();
        actualDay[2] = day;

        //ask the required working hours, default value=7.5
        System.out.print("Required working hours: ");

        float hours;
        try {
            Scanner in2 = new Scanner(System.in);
            String hoursString;
            hoursString = "";

            hoursString += in2.nextLine();
            System.out.println("hoursString: " + hoursString);
            hours = Float.parseFloat(hoursString);

            hours = Float.parseFloat(hoursString);
        } catch (NoSuchElementException ex) {
            hours = (float) 7.5;
            System.out.println("It hasen't input! Then hours = 7.5! " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Is wrong input! Then hours = 7.5!");
            hours = (float) 7.5;
        } catch (NumberFormatException ex) {
            System.out.println("Is wrong input! Then hours = 7.5! " + ex.getMessage());
            hours = (float) 7.5;
        } catch (IllegalStateException ex) {
            System.out.println("Is wrong input! Then hours = 7.5! " + ex.getMessage());
            hours = (float) 7.5;
        }

        float minuteFloat = hours * 60;

        int minute = (int) minuteFloat;

        WorkDay wd = new WorkDay(actualDay, minute);
        WorkMonth wm = timeLogger.getMonths().get(month);
        wm.addWorkDay(wd);
        if (timeLogger.isNewMonth(wm)) {
            timeLogger.addMonth(wm);
        } else {
            timeLogger.updateMonth(wm);
        }

    }

    /* Start a task for a day:
    -ask for month, day, task id, what you do (comment)
    -ask for start time in format 10:30 
        -if there is a task in the day, get the end time of the last task and show it in braces! If the user enters an empty value, save that time in the task!
    -don't ask for the end time! */
    public void startTask(TimeLogger timeLogger) {
        try {
            int monthNumber = this.listDays(timeLogger);

            if (monthNumber == -1 || timeLogger.getMonths().get(monthNumber).getDays().isEmpty()) {
                return;
            }

            int dayNumber;

            while (1 == 1) {
                Scanner in = new Scanner(System.in);
                System.out.print("Select day: ");

                dayNumber = in.nextInt();
                if (dayNumber > 0 && dayNumber <= timeLogger.getMonths().get(monthNumber).getDays().size()) {
                    break;
                }
                System.out.println("Wrong day numbers!");
            }

            dayNumber--;

            WorkDay day = timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber);

            Scanner in = new Scanner(System.in);

            System.out.print("TaskId: ");
            String taskId = in.nextLine();
            System.out.print("Comment: ");
            String comment = in.nextLine();
            System.out.print("StartTime: ");
            String startTime = in.nextLine();
            int[] startTimeArray = new int[2];
            if (!startTime.isEmpty()) {
                startTimeArray[0] = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                startTimeArray[1] = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            } else {
                startTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
                startTimeArray[0] = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                startTimeArray[1] = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            }

            Task taskI;
            if (comment.isEmpty()) {
                taskI = new Task(taskId, startTimeArray);
            } else {
                taskI = new Task(taskId, comment, startTimeArray);
            }

            timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).addTask(taskI);
        } catch (OwnException ex) {
            ex.getMessage();
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString() + " " + ex.getMessage());
            return;
        }

    }

    public void finishASpecificTask(TimeLogger timeLogger) {

        try {

            List<Task> notTheEndTasks = this.listTasksNotTheEnd(timeLogger);
            if (notTheEndTasks.isEmpty()) {
                System.out.println("Not unfinished tasks!");
                return;
            }
            Scanner in = new Scanner(System.in);
            int taskNumber;
            while (1 == 1) {
                System.out.print("Task Number: ");
                taskNumber = in.nextInt();
                if (taskNumber > 0 && taskNumber <= notTheEndTasks.size()) {
                    break;

                }
            }

            Task taskI = notTheEndTasks.get(--taskNumber);

            List<WorkMonth> months = timeLogger.getMonths();

            int monthNumber = 0;
            for (WorkMonth month : months) {

                if (month.getDate().getYear() == this.thisDate.getYear() && month.getDate().getMonthValue() == this.thisDate.getMonthValue()) {
                    break;
                }
                monthNumber++;

            }
            int dayNumber = 0;
            for (WorkDay wd : months.get(monthNumber).getDays()) {
                if (wd.getActualDay().getDayOfYear() == this.thisDate.getDayOfYear()) {
                    break;
                }
                dayNumber++;

            }
            int taskN = 0;
            for (Task t : months.get(monthNumber).getDays().get(dayNumber).getTasks()) {
                if (t.equals(taskI)) {
                    break;

                }
                taskN++;
            }

            Scanner in2 = new Scanner(System.in);
            System.out.print("End Time: ");
            String time = in2.nextLine();

            if (time.isEmpty()) {
                time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            }

            timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).getTasks().get(taskN).endTaskWithString(time);
            timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).refreshStatistics();
            timeLogger.getMonths().get(monthNumber).refreshStatistics();

        } catch (OwnException ex) {
            System.out.println(ex.getMessage());
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getErrorIndex() + ": " + ex.getParsedString() + " " + ex.getMessage());
            return;

        }
    }

    /*
     Delete a task: ask for month, day, select task - ask for confirmation!
     */
    public void deleteTask(TimeLogger timeLogger) {
        try {
            int[] monthAndDayIndex = this.listTasks(timeLogger);

            if (monthAndDayIndex == null) {
                System.out.println("Haven't got a task!");
                return;
            }
            Scanner in = new Scanner(System.in);
            int taskNumber;
            while (1 == 1) {
                System.out.print("Task Number: ");
                taskNumber = in.nextInt();
                if (taskNumber > 0 && taskNumber <= timeLogger.getMonths().get(monthAndDayIndex[0]).getDays().get(monthAndDayIndex[1]).getTasks().size()) {
                    break;
                }

            }
            taskNumber--;

            timeLogger.deleteTask(monthAndDayIndex[0], monthAndDayIndex[1], taskNumber);
            
        } catch (OwnException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
    Modify task: ask for month, day, task, let change every fields 
    (shows previous value in braces, if the input is empty, don't change the value!)
     */
    public void modifyTask(TimeLogger timeLogger)  {

        try {
            int[] mdIndex = this.listTasks(timeLogger);
            if (mdIndex == null) {
                System.out.println("Don't have a task!");
                return;
            }

            int taskNumber = 0;
            //The task number input,
            while (1 == 1) {
                System.out.print("Task number: ");
                Scanner in = new Scanner(System.in);
                taskNumber = in.nextInt();
                if (taskNumber > 0 && taskNumber <= timeLogger.getMonths().get(mdIndex[0]).getDays().size()) {
                    break;
                }

            }

            Task task = timeLogger.getMonths().get(mdIndex[0]).getDays().get(mdIndex[1]).getTasks().get(--taskNumber);

            Scanner in = new Scanner(System.in);
            System.out.print("Task Id: (" + task.getTaskId() + ") ");
            String taskIdI = in.nextLine();
            if (taskIdI.isEmpty()) {
                taskIdI = task.getTaskId();
            }
            System.out.print("Comment: (" + task.getComment() + ") ");
            String taskCommentI = in.nextLine();
            if (taskCommentI.isEmpty()) {
                taskCommentI = task.getTaskId();
            }

            System.out.print("Start time: (" + task.getStartTime() + ") ");
            String startTimeI = in.nextLine();
            int[] startTimeArrayI = new int[2];
            if (!startTimeI.isEmpty()) {
                startTimeArrayI[0] = LocalTime.parse(startTimeI, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                startTimeArrayI[1] = LocalTime.parse(startTimeI, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            } else {
                startTimeI = task.getStartTimeToString();
                startTimeArrayI[0] = LocalTime.parse(startTimeI, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                startTimeArrayI[1] = LocalTime.parse(startTimeI, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            }
            System.out.print("End time: (" + task.getEndTime() + ") ");
            String endTimeI = in.nextLine();
            int[] endTimeArrayI = new int[2];
            if (!endTimeI.isEmpty()) {
                endTimeArrayI[0] = LocalTime.parse(endTimeI, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                endTimeArrayI[1] = LocalTime.parse(endTimeI, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            } else if (task.getEndTimeToString() != null) {
                endTimeI = task.getEndTimeToString();
                endTimeArrayI[0] = LocalTime.parse(endTimeI, DateTimeFormatter.ofPattern("HH:mm")).getHour();
                endTimeArrayI[1] = LocalTime.parse(endTimeI, DateTimeFormatter.ofPattern("HH:mm")).getMinute();
            }

            Task inputTask;
            if (!endTimeI.isEmpty()) {
                inputTask = new Task(taskIdI, taskCommentI, startTimeArrayI, endTimeArrayI);
            } else {
                inputTask = new Task(taskIdI, taskCommentI, startTimeArrayI);
            }

            timeLogger.getMonths().get(mdIndex[0]).getDays().get(mdIndex[1]).deleteTask(taskNumber);
            timeLogger.getMonths().get(mdIndex[0]).getDays().get(mdIndex[1]).addTask(inputTask);
            timeLogger.getMonths().get(mdIndex[0]).getDays().get(mdIndex[1]).refreshStatistics();
            timeLogger.getMonths().get(mdIndex[0]).refreshStatistics();
        } catch (OwnException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /*
    Statistics: ask for month, then print the statistics of the month, 
    and the statistics of the days of this month
     */
    public void statistics(TimeLogger timeLogger) {

        this.listMonths(timeLogger);

        if (timeLogger.getMonths().isEmpty()) {
            return;
        }

        int monthNumber;

        while (1 == 1) {
            System.out.print("Month Number: ");
            Scanner in = new Scanner(System.in);
            monthNumber = in.nextInt();

            if (monthNumber > 0 && monthNumber <= timeLogger.getMonths().size()) {
                break;
            }

            System.out.println("Wrong Month Number!");

        }
        monthNumber--;

        System.out.println("Required Mintum / Month: " + timeLogger.getMonths().get(monthNumber).getRequiredMinPerMonth());
        System.out.println("Summa worked Mintum this Month: " + timeLogger.getMonths().get(monthNumber).getSumPerMonth());
        System.out.println("Extra Mintum this Month: " + timeLogger.getMonths().get(monthNumber).getExtraMinPerMonth());

        if (timeLogger.getMonths().get(monthNumber).listDays()) {

            int dayNumber;

            while (1 == 1) {
                System.out.print("Day Number: ");
                Scanner in = new Scanner(System.in);
                dayNumber = in.nextInt();

                if (dayNumber > 0 && dayNumber <= timeLogger.getMonths().get(monthNumber).getDays().size()) {
                    break;
                }

                System.out.println("Wrong Day Number!");

            }
            dayNumber--;

            System.out.println("Required Mintum / Day" + timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).getRequiredMinPerDay());
            System.out.println("Summa Mintum / Day" + timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).getSumPerDay());
            System.out.println("Extra Mintum / Day" + timeLogger.getMonths().get(monthNumber).getDays().get(dayNumber).getExtraMinPerDay());

        }

    }

}
