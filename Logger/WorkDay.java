package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.util.List;
import Logger.Task;
import Logger.Util;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import timelogger.exceptions.OwnException;

/**
 *
 * @author stampel
 *
 * tasks :List<Task>
 * requiredMinPerDay :(defulte 7,5 houers)long actualDay :LocalDate sumPerDay
 * :long
 */
public class WorkDay extends Util {

    private List<Task> tasks;
    private long requiredMinPerDay;
    private int[] actualDay;
    private long sumPerDay; //calculations

    public WorkDay(int[] actualDayI,
            long requiredMinPerDayI
    ) throws OwnException {

        if (requiredMinPerDayI <= 0) {
            throw new OwnException("NegativeMinutesOfWorkException");

        } else if (actualDayI.length != 3) {
            throw new OwnException("Is array problem");
        } else {
            LocalDate date = LocalDate.of(actualDayI[0], actualDayI[1], actualDayI[2]);
            if (date.isAfter(LocalDate.now())) {
                throw new OwnException("FutureWorkException");

            } else {
                this.requiredMinPerDay = requiredMinPerDayI;
                this.sumPerDay = 0;

                this.actualDay = new int[3];
                this.actualDay = actualDayI;
                this.tasks = new ArrayList();
            }
        }
    }

    public WorkDay(long requiredMinPerDayI
    ) throws OwnException {
        if (requiredMinPerDayI <= 0) {
            throw new OwnException("NegativeMinutesOfWorkException");

        } else {
            this.requiredMinPerDay = requiredMinPerDayI;
            this.sumPerDay = 0;
            LocalDate now = LocalDate.now();
            this.actualDay = new int[3];
            this.actualDay[0] = now.getYear();
            this.actualDay[1] = now.getMonthValue();
            this.actualDay[2] = now.getDayOfMonth();
            this.tasks = new ArrayList();
        }
    }

    public WorkDay(int[] actualDayI
    ) throws OwnException {

        if (actualDayI.length != 3) {
            throw new OwnException("Is array problem");
        } else {
            LocalDate date = LocalDate.of(actualDayI[0], actualDayI[1], actualDayI[2]);
            if (date.isAfter(LocalDate.now())) {
                throw new OwnException("FutureWorkException");

            } else {

                this.requiredMinPerDay = 450;
                this.sumPerDay = 0;

                this.actualDay = new int[3];
                this.actualDay = actualDayI;
                this.tasks = new ArrayList();

            }
        }
    }

    public WorkDay() {
        this.requiredMinPerDay = 450;
        this.sumPerDay = 0;
        LocalDate now = LocalDate.now();
        this.actualDay = new int[3];
        this.actualDay[0] = now.getYear();
        this.actualDay[1] = now.getMonthValue();
        this.actualDay[2] = now.getDayOfMonth();
        this.tasks = new ArrayList();
    }

    /* 
  * getters for requiredMinPerDay, sumPerDay and actualDay 
     */
    public long getRequiredMinPerDay() {

        return this.requiredMinPerDay;

    }

    public List<Task> getTasks() {

        return this.tasks;

    }

    public LocalTime endTimeOfTheLastTask() throws OwnException {

        LocalTime result = null;
        for (Task task : this.tasks) {
            if (result == null && task.getEndTime() != null) {
                result = task.getEndTime();
            } else if (task.getEndTime() != null && result.isBefore(task.getEndTime())) {
                result = task.getEndTime();
            }
        }

        return result;

    }

    public LocalTime startTimeOfTheFirstTask() {

        LocalTime result = null;
        for (Task task : this.tasks) {
            if (result == null && task.getStartTime() != null) {
                result = task.getStartTime();
            } else if (task.getStartTime() != null && result.isAfter(task.getStartTime())) {
                result = task.getStartTime();
            }
        }

        return result;

    }

    public long getSumPerDay() {

        this.refreshStatistics();
        return this.sumPerDay;

    }

    public LocalDate getActualDay() {

        return LocalDate.of(this.actualDay[0], this.actualDay[1], this.actualDay[2]);

    }

    public String getActualDayToString() {

        return this.actualDay[0] + "-" + this.actualDay[1] + "-" + this.actualDay[2];

    }

    /*
 * long getExtraMinPerDay():
 *        long method, which calculates the difference between requiredMinPerDay and sumPerDay
     */
    public long getExtraMinPerDay() {

        this.refreshStatistics();
        return this.sumPerDay - this.requiredMinPerDay;

    }

    /*
 * boolean isSeparatedTime(Task t):
 *         boolean method should be able to decide if the t Task has a common time interval with any 
 *         existing Task's time interval in the tasks list
     */
    public boolean isSeparatedTime(Task t) throws OwnException {

        for (Task t1 : this.tasks) {
            if (!super.isSeparatedTime(t1.getStartTime(), t1.getEndTime(), t.getStartTime(), t.getEndTime())) {
                return false;
            }

        }

        return true;
    }

    /*
 * void addTask(Task t):
 *         void add a task to the list of tasks, if length is multiple of the quarter hour and the task
 *         time intervals have no common parts, the else part will be implemented later
     */
    public void addTask(Task t) throws OwnException {

        if (!this.isSeparatedTime(t)) {
            throw new OwnException("NotSeparatedTimesException");
        } else {
            this.insertTask(t);

        }
    }

    private void insertTask(Task taskI) throws OwnException {

        if (this.tasks.isEmpty()) {
            this.tasks = new ArrayList();
            this.tasks.add(taskI);

            if (taskI.getStartTime() != null && taskI.getEndTime() != null) {
                this.sumPerDay = Duration.between(taskI.getStartTime(), taskI.getEndTime()).toMinutes();
            }

            return;

        }

        boolean first = true;
        int index = -1;
        for (Task task : this.tasks) {
            index++;
            if (first && Duration.between(taskI.getStartTime(), task.getStartTime()).toMinutes() >= 0) {

                this.tasks.add(0, taskI);
                if (taskI.getStartTime() != null && taskI.getEndTime() != null) {
                    this.sumPerDay += Duration.between(taskI.getStartTime(), taskI.getEndTime()).toMinutes();
                }
                return;

            }

            first = false;
            if (Duration.between(taskI.getStartTime(), task.getStartTime()).toMinutes() >= 0) {
                int i = index;
                this.tasks.add(i, taskI);
                if (taskI.getStartTime() != null && taskI.getEndTime() != null) {
                    this.sumPerDay += Duration.between(taskI.getStartTime(), taskI.getEndTime()).toMinutes();
                }
                return;

            }

        }

        this.tasks.add(taskI);
        if (taskI.getStartTime() != null && taskI.getEndTime() != null) {
            this.sumPerDay += Duration.between(taskI.getStartTime(), taskI.getEndTime()).toMinutes();
        }
        return;

    }

    /*
 * isWeekday():boolean decide if actual day is a weekday 
     */
    public boolean isWeekday() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("a");

        LocalDate aDay = this.getActualDay();

        String str = aDay.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ROOT).toUpperCase().trim();

        if (str.equalsIgnoreCase("SUN") || str.equalsIgnoreCase("SAT")) {

            return false;

        }

        return true;

    }

    public List<Task> listTask(boolean bool) throws OwnException {

        int i = 1;
        List<Task> returnTasks = new ArrayList();

        for (Task task : this.tasks) {

            if (task.getEndTime() != null && bool) {
                System.out.println(i + "." + task.getStartTime() + " - " + task.getEndTime() + " TaskId: " + task.getTaskId() + " Comment: " + task.getComment());
                i++;
            } else if (task.getEndTime() == null) {
                System.out.println(i + "." + task.getStartTime() + " - null  TaskId: " + task.getTaskId() + " Comment: " + task.getComment());
                returnTasks.add(task);
                i++;

            }

        }

        if (i == 1) {
            System.out.println("Haven't got Tasks");
        }

        return returnTasks;

    }

    public boolean isNewTask(Task TaskI) {

        return true;
    }

    public void updateTask(Task TaskI) throws OwnException {

        if (!this.isNewTask(TaskI)) {

            int i = -1;

            for (Task task : this.tasks) {
                i++;
                if (task.getStartTime() == TaskI.getStartTime()) {

                    this.sumPerDay -= Duration.between(task.getStartTime(), task.getEndTime()).toMinutes();
                    this.tasks.remove(i);
                    this.addTask(TaskI);
                    return;
                }
            }
        }
    }

    public void deleteTask(int index) throws OwnException {

        if (this.tasks.isEmpty()) {
            return;
        }

        if (index < 0 || index >= this.tasks.size()) {
            return;
        }
        Task task = this.tasks.get(index);
        if (task.getStartTime() != null && task.getEndTime() != null) {
            this.sumPerDay -= Duration.between(task.getStartTime(), task.getEndTime()).toMinutes();
        }
        this.tasks.remove(index);

    }

    public void refreshStatistics() { //throws OwnException {

        this.sumPerDay = 0;

        for (Task task : this.tasks) {
            if (!task.getEndTimeToString().isEmpty()) {
                this.sumPerDay += Duration.between(task.getStartTime(), task.getEndTime()).toMinutes();
            }

        }
    }

    public void setRequiredMinPerDay(long requiredMinPerDayI) throws OwnException {
        if (requiredMinPerDayI <= 0) {

            throw new OwnException("NegativeMinutesOfWorkException");

        } else {
            this.requiredMinPerDay = requiredMinPerDayI;
            this.refreshStatistics();
        }

    }

    public void setActualDay(int[] actualDayI) throws OwnException {
        if (actualDayI.length != 3) {
            throw new OwnException("Is array problem");
        } else {
            LocalDate date = LocalDate.of(actualDayI[0], actualDayI[1], actualDayI[2]);
            if (date.isAfter(LocalDate.now())) {
                throw new OwnException("FutureWorkException");

            } else {
                this.actualDay = new int[3];
                this.actualDay = actualDayI;
            }
        }
    }
}
