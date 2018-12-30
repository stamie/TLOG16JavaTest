package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import timelogger.exceptions.OwnException;

/**
 *
 * @author stampel Task class: taskId :String startTime :LocalTime endTime
 * :LocalTime comment :String
 */
public class Task implements Util {

    private String taskId;
    private String comment;
    private String startTimeString;
    private String endTimeString;
    private int[] startTimeArray;
    private int[] endTimeArray;

    public Task(String taskIdI,
            String commentI,
            String startTimeStringI,
            String endTimeStringI) throws OwnException {
        try {
            if (startTimeStringI.isEmpty()) {
                throw new OwnException("The startTime is Empty!");
            } else if (endTimeStringI.isEmpty()) {
                throw new OwnException("The endTime is Empty!");
            } else {

                LocalTime l = LocalTime.parse(this.startTimeString);
                LocalTime l2 = LocalTime.parse(this.endTimeString);
                if (l.isAfter(l2)) {
                    throw new OwnException("The startTime is not Before for endTime!");
                } else {
                    this.taskId = taskIdI;
                    if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
                        throw new OwnException("Invalid taskID!");

                    } else {
                        this.startTimeString = startTimeStringI;
                        this.endTimeString = endTimeStringI;
                        if (!this.isMultipleQuarterHour()) {
                            throw new OwnException("The duration is not multi quater hour!");
                        } else {

                            this.comment = commentI;

                            this.startTimeArray = new int[2];
                            this.startTimeArray[0] = l.getHour();
                            this.startTimeArray[1] = l.getMinute();

                            this.endTimeArray = new int[2];
                            this.endTimeArray[0] = l2.getHour();
                            this.endTimeArray[1] = l2.getMinute();
                        }
                    }
                }
            }
        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public Task(String taskIdI,
            String commentI,
            int[] startTimeArrayI,
            int[] endTimeArrayI) throws OwnException {

        this.taskId = taskIdI;

        if (startTimeArrayI.length != 2 && endTimeArrayI.length != 2) {

            throw new OwnException("Input is wrong! StartTime or EndTime not 2 length!");

        } else if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
            throw new OwnException("Invalid taskID!");

        } else {
            this.startTimeString = this.arrayTimeToString(startTimeArrayI);
            this.endTimeString = this.arrayTimeToString(endTimeArrayI);
            if (!this.isMultipleQuarterHour()) {
                throw new OwnException("The duration is not multi quater hour!");
            } else {

                this.comment = commentI;

                try {

                    LocalTime l = LocalTime.parse(this.startTimeString);
                    int hour = l.getHour();
                    int minute = l.getMinute();

                    this.startTimeArray = new int[2];
                    this.startTimeArray[0] = hour;
                    this.startTimeArray[1] = minute;

                    l = LocalTime.parse(this.endTimeString);
                    hour = l.getHour();
                    minute = l.getMinute();

                    this.endTimeArray = new int[2];
                    this.endTimeArray[0] = hour;
                    this.endTimeArray[1] = minute;

                } catch (DateTimeParseException ex) {

                    throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

                }
            }
        }
    }

    public Task(String taskIdI,
            String commentI,
            int[] startTimeArrayI) throws OwnException {

        this.taskId = taskIdI;

        if (startTimeArrayI.length != 2) {

            throw new OwnException("Input is wrong! The startTime length is not 2! It's: " + startTimeArrayI.length);

        } else if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
            throw new OwnException("Invalid taskID!");

        } else {
            try {
                this.startTimeString = this.arrayTimeToString(startTimeArrayI);
                this.comment = commentI;

                LocalTime l = LocalTime.parse(this.startTimeString);
                int hour = l.getHour();
                int minute = l.getMinute();

                this.startTimeArray = new int[2];
                this.startTimeArray[0] = hour;
                this.startTimeArray[1] = minute;

            } catch (DateTimeParseException ex) {

                throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

            }
        }
    }

    public Task(String taskIdI,
            int[] startTimeArrayI,
            int[] endTimeArrayI) throws OwnException {

        if (startTimeArrayI.length != 2 && endTimeArrayI.length != 2) {

            throw new OwnException("Input is wrong! StartTime or EndTime not 2 length!");

        } else {
            try {
                this.taskId = taskIdI;
                if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
                    throw new OwnException("Invalid taskID!");

                } else {
                    this.startTimeString = this.arrayTimeToString(startTimeArrayI);
                    this.endTimeString = this.arrayTimeToString(endTimeArrayI);
                    if (!this.isMultipleQuarterHour()) {
                        throw new OwnException("The duration is not multi quater hour!");
                    } else {

                        this.comment = this.startTimeString;

                        LocalTime l = LocalTime.parse(this.startTimeString);
                        int hour = l.getHour();
                        int minute = l.getMinute();

                        this.startTimeArray = new int[2];
                        this.startTimeArray[0] = hour;
                        this.startTimeArray[1] = minute;

                        l = LocalTime.parse(this.endTimeString);
                        hour = l.getHour();
                        minute = l.getMinute();

                        this.endTimeArray = new int[2];
                        this.endTimeArray[0] = hour;
                        this.endTimeArray[1] = minute;
                    }
                }
            } catch (DateTimeParseException ex) {

                throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

            }

        }
    }

    public Task(String taskIdI,
            int[] startTimeArrayI)
            throws OwnException {

        this.taskId = taskIdI;
        if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
            throw new OwnException("Invalid taskID!");

        } else {
            if (startTimeArrayI.length != 2) {

                throw new OwnException("Input is wrong! The startTime length is not 2! It's: " + startTimeArrayI.length);

            } else {
                try {
                    this.startTimeString = this.arrayTimeToString(startTimeArrayI);
                    this.comment = this.startTimeString;

                    LocalTime l = LocalTime.parse(this.startTimeString);
                    int hour = l.getHour();
                    int minute = l.getMinute();

                    this.startTimeArray = new int[2];
                    this.startTimeArray[0] = hour;
                    this.startTimeArray[1] = minute;

                } catch (DateTimeParseException ex) {

                    throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

                }
            }
        }
    }

    public Task(String taskIdI,
            String startTimeStringI) throws OwnException {

        try {
            LocalTime l = LocalTime.parse(startTimeStringI);

            this.taskId = taskIdI;
            if (!this.isValidTaskId() || !this.isValidLTTaskId() || !this.isValidRedmineTaskId()) {
                throw new OwnException("Invalid taskID!");

            } else {
                this.startTimeString = startTimeStringI;
                //  this.endTimeString = endTimeI;
                this.comment = startTimeStringI;

                int hour = l.getHour();
                int minute = l.getMinute();

                this.startTimeArray = new int[2];
                this.startTimeArray[0] = hour;
                this.startTimeArray[1] = minute;
            }
        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    private String arrayTimeToString(int[] timeI) {

        String timeString;
        if (timeI[0] > 9) {
            timeString = timeI[0] + ":";
        } else {
            timeString = "0" + timeI[0] + ":";
        }

        if (timeI[1] > 9) {
            timeString += timeI[1];
        } else {
            timeString += "0" + timeI[1];
        }

        return timeString;
    }

    private void TaskNotEndTimeString(String taskIdI,
            String commentI,
            String startTimeI) throws OwnException {
        try {
            this.taskId = taskIdI;
            this.startTimeString = startTimeI;
            this.comment = commentI;

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString() + " " + ex.getMessage());

        }

    }

    private void TaskWithEndTimeStringNotComment(String taskIdI,
            String startTimeI,
            String endTimeI) throws OwnException {

        this.taskId = taskIdI;
        this.startTimeString = startTimeI;
        this.endTimeString = endTimeI;
        this.comment = startTimeI;

        try {

            LocalTime l = LocalTime.parse(this.startTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.startTimeArray = new int[2];
            this.startTimeArray[0] = hour;
            this.startTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

        try {

            LocalTime l = LocalTime.parse(this.endTimeString);
            int hour = l.getHour();
            int minute = l.getMinute();

            this.endTimeArray = new int[2];
            this.endTimeArray[0] = hour;
            this.endTimeArray[1] = minute;

        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

        }

    }

    public String getTaskId() throws OwnException {

        return this.taskId;

    }

    public LocalTime getStartTime() throws OwnException {

        return LocalTime.parse(this.startTimeString);

    }

    public LocalTime getEndTime() throws OwnException {
        try {
            return LocalTime.parse(this.endTimeString);
        } catch (NullPointerException ex) {
            return null;
        }

    }

    public String getStartTimeToString() {

        return this.startTimeString;

    }

    public String getEndTimeToString() {
        // try {

        return this.endTimeString;
        /* } catch (NullPointerException ex) {
            return null;
        }*/

    }

    public long getMinPerTask() throws OwnException {

        return Duration.between(this.getStartTime(), this.getEndTime()).toMinutes();

    }

    public String getComment() {

        return this.comment;

    }

    /*
 * boolean isValidTaskId():
 *   boolean (Valid Ids: 4 digits or LT-{4 digits} for example: LT-4863)
     */
    public boolean isValidTaskId() {

        String regExp = "(L)(T)(-)\\d\\d\\d\\d";
        return this.taskId.matches(regExp);
    }

    public boolean isValidLTTaskId() {

        String regExp = "(L)(T)(-)\\d";
        return this.taskId.matches(regExp);
    }

    public boolean isValidRedmineTaskId() {

        String regExp = "\\d\\d\\d\\d";
        return this.taskId.matches(regExp);
    }

    /*
 * boolean isMultipleQuarterHour():
 *   boolean (check if the time interval's length is multiple of the quarter hour)
     */
    public boolean isMultipleQuarterHour() {

        if (this.startTimeArray == null || this.endTimeArray == null) {
            return true;
        }
        long minutes = Duration.between(LocalTime.parse(this.startTimeString), LocalTime.parse(this.endTimeString)).toMinutes();

        if (minutes % 15 == 0 && minutes > 15) {

            return true;

        }

        return false;

    }

    public void endTaskWithString(String endTimeStringI) throws OwnException {

        try {
            if (LocalTime.parse(endTimeStringI).isBefore(this.getStartTime())) {
                throw new OwnException("The endTime is before the startDate!");

            } else {

                this.endTimeString = endTimeStringI;
                if (!this.isMultipleQuarterHour()) {
                    throw new OwnException("The duration is not multi quater hour!");
                } else {

                    this.endTimeArray = new int[2];
                    this.endTimeArray[0] = LocalTime.parse(this.endTimeString).getHour();
                    this.endTimeArray[1] = LocalTime.parse(this.endTimeString).getMinute();
                }
            }
        } catch (DateTimeParseException ex) {
            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());
        }

    }

    public void endTaskWithArray(int[] endTimeArrayI) throws OwnException {

        if (endTimeArrayI.length != 2) {
            throw new OwnException("Wrong Input! The endTime length is not 2! It's: " + endTimeArrayI.length);

        } else {

            try {

                if (LocalTime.parse(endTimeArrayI[0] + ":" + endTimeArrayI[1]).isBefore(this.getStartTime())) {
                    throw new OwnException("The endTime is before the startDate!");

                } else {
                    this.endTimeString = endTimeArrayI[0] + ":" + endTimeArrayI[1];
                    if (!this.isMultipleQuarterHour()) {
                        throw new OwnException("The duration is not multi quater hour!");
                    } else {

                        this.endTimeArray = new int[2];
                        this.endTimeArray = endTimeArrayI;
                    }
                }
            } catch (DateTimeParseException ex) {
                throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());
            }
        }

    }

}
