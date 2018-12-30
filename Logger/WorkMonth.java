package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.util.List;
import Logger.WorkDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author stampel
 *
 * days:List<WorkDay>
 * date sumPerMonth requiredMinPerMonth
 */
public class WorkMonth {

    private List<WorkDay> days;
    private LocalDate date;
    private long sumPerMonth;
    private long requiredMinPerMonth;

    /*
     * WorkMonth class's methods: 
     * constructor which has a year, and a month paramater, 
     * but in the constructor from this informations you should create the date field
     */
    public WorkMonth(int year, int month) {

        this.date = LocalDate.parse(year + "-" + month + "-1", DateTimeFormatter.ofPattern("yyyy-M-d"));
        this.days = new ArrayList();
        this.requiredMinPerMonth = 0;
        this.sumPerMonth = 0;

    }

    /* getters for all the fields */
    public List<WorkDay> getDays() {
        return this.days;
    }

    public LocalDate getDate() {

        return this.date;

    }

    public long getSumPerMonth() {

        return this.sumPerMonth;

    }

    public long getRequiredMinPerMonth() {

        return this.requiredMinPerMonth;

    }

    /*
  *  long getExtraMinPerMonth():
  *  long method should calculate, how many extra minutes did the employee work in the actual month
     */
    public long getExtraMinPerMonth() {

        return this.sumPerMonth - this.requiredMinPerMonth;

    }

    /*
 * boolean isNewDate(WorkDay):
 * boolean method decides if this day is already existing or not
     */
    public boolean isNewDate(WorkDay workDayI) {

        for (WorkDay day : this.days) {
            if (day.getActualDay() == workDayI.getActualDay()) {

                return false;

            }

        }

        return true;
    }

    /*
 * boolean isSameMonth(WorkDay): 
 * boolean method decides, if this day should be in this month or it fits into an other month by date
     */
    public boolean isSameMonth(WorkDay workDayI) {
        if (workDayI.getActualDay().getMonth() == this.date.getMonth() && workDayI.getActualDay().getYear() == this.date.getYear()) {
            return true;
        }

        return false;

    }

    /*   
 * void addWorkDay(WorkDay wd, boolean isWeekendEnabled):
 * void add a day to the list of days, if isWeekendEnabled=true.
 * Do not add the day to the list of days, if actualDay is on the weekend and isWeekendEnabled=false. 
 * The isWeekendEnabled boolean parameter has default value=false 
 * (it means there will be an overloaded method). You should also check if the WorkDay is in this month, 
 * and if it is existing already or not .
     */
    public void addWorkDay(WorkDay wd, boolean isWeekendEnabled) {

        if (!wd.isWeekday() && !isWeekendEnabled) {

            return;

        }

        if (this.isNewDate(wd) && this.isSameMonth(wd)) {
            int i = 0;
            if (this.days.isEmpty()) {

                this.days.add(wd);
                this.requiredMinPerMonth += wd.getRequiredMinPerDay();
                this.sumPerMonth += wd.getSumPerDay();
                return;

            }
            for (WorkDay workDay : this.days) {
                if (workDay.getActualDay().getDayOfYear() > wd.getActualDay().getDayOfYear()) {

                    this.days.add(i, wd);
                    this.requiredMinPerMonth += wd.getRequiredMinPerDay();
                    this.sumPerMonth += wd.getSumPerDay();
                    return;
                }
            }

        }

        return;
    }

    public void addWorkDay(WorkDay wd) {

        this.addWorkDay(wd, false);

    }

    public boolean listDays() {
        int i = 1;

        for (WorkDay day : this.days) {

            System.out.print(i + ". " + day.getActualDayToString() + "; ");
            i++;
        }

        if (i > 1) {
            return true;
        }
        return false;

    }

    public void updateWorkDay(WorkDay workDayI) {

        if (!this.isNewDate(workDayI)) {

            int i = -1;

            for (WorkDay workDay : this.days) {
                i++;
                if (workDay.getActualDayToString() == workDayI.getActualDayToString()) {
                    this.days.remove(i);
                    this.requiredMinPerMonth -= this.days.get(i).getRequiredMinPerDay();
                    this.sumPerMonth -= this.days.get(i).getSumPerDay();

                    this.days.add(i, workDayI);
                    this.requiredMinPerMonth += workDay.getRequiredMinPerDay();
                    this.sumPerMonth += workDay.getSumPerDay();
                    return;
                }
            }
        }
    }

    public void refreshStatistics() {

        this.requiredMinPerMonth = 0;
        this.sumPerMonth = 0;

        for (WorkDay day : this.days) {

            this.requiredMinPerMonth += day.getRequiredMinPerDay();
            this.sumPerMonth += day.getSumPerDay();

        }

    }

}
