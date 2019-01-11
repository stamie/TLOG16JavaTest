/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import java.util.List;
import Logger.WorkMonth;
import java.util.ArrayList;
import timelogger.exceptions.OwnException;

/**
 *
 * @author stampel
 */
public class TimeLogger {

    private List<WorkMonth> months;

    public TimeLogger(List<WorkMonth> monthsI) {

        this.months = new ArrayList();
        this.months = monthsI;

    }

    public TimeLogger() {

        this.months = new ArrayList();
        //this.months = monthsI;

    }

    /*
 * getter for months
     */
    public List<WorkMonth> getMonths() {

        return this.months;

    }

    /*
 * List for months
     */
    public boolean listMonths() {

        int i = 1;

        for (WorkMonth month : this.months) {

            System.out.print(i + ". " + month.getDate().getYear() + "-" + month.getDate().getMonthValue() + ", ");
            i++;

        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    /*
 * boolean isNewMonth(WorkMonth):
 * boolean decides, if this month already exists or not
     */
    public boolean isNewMonth(WorkMonth wm) {

        for (WorkMonth wm2 : this.months) {
            if (wm2.getDate().toString().equals(wm.getDate().toString())) {
                return false;
            }
        }
        return true;

    }

    /**
     * void addMonth(WorkMonth): void adds a new month to the months list if it
     * is new
     */
    public void addMonth(WorkMonth wm) throws OwnException {

        if (!this.isNewMonth(wm)) {
            throw new OwnException("NotNewMonthException");
        } else {

            if (this.months.isEmpty()) {
                this.months.add(wm);
                return;
            }
            int i = -1;

            for (WorkMonth month : this.months) {
                i++;
                if ((month.getDate().getMonthValue() > wm.getDate().getMonthValue() && month.getDate().getYear() == wm.getDate().getYear())
                        || (month.getDate().getYear() > wm.getDate().getYear())) {
                    this.months.add(i, wm);
                    return;
                }

            }
            this.months.add(wm);

        }

    }

    public void updateMonth(WorkMonth wm) {

        if (!this.isNewMonth(wm)) {

            int i = -1;

            for (WorkMonth month : this.months) {
                i++;
                if (month.getDate().getMonthValue() == wm.getDate().getMonthValue() && month.getDate().getYear() == wm.getDate().getYear()) {
                    this.months.remove(i);
                    this.months.add(i, wm);
                    return;
                }
            }
        }
    }

    public void deleteTask(int monthIndex, int dayIndex, int taskIndex) throws OwnException {

        this.months.get(monthIndex).getDays().get(dayIndex).deleteTask(taskIndex);
        this.months.get(monthIndex).getDays().get(dayIndex).refreshStatistics();
        this.months.get(monthIndex).refreshStatistics();

    }

}
