package Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import Logger.Util;
import timelogger.exceptions.OwnException;


/**
 *
 * @author stampel Task class: taskId :String startTime :LocalTime endTime
 * :LocalTime comment :String
 */
public class Task extends Util {

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
            this.taskId = taskIdI;
            this.comment = commentI;
            if (this.taskId == null || this.taskId.isEmpty()) {
                throw new OwnException("Invalid taskID!");
            } else if (commentI == null || commentI.isEmpty()) {
                this.comment = "";
            } else if (startTimeStringI.isEmpty()) {
                throw new OwnException("The startTime is Empty!");
            } else if (endTimeStringI.isEmpty()) {
                throw new OwnException("The endTime is Empty!");
            } else if (taskIdI.isEmpty() || taskIdI == null) {
                throw new OwnException("Invalid taskID!");
            } else {
                this.startTimeString = startTimeStringI;

                this.endTimeString = endTimeStringI;

                LocalTime l = LocalTime.parse(this.startTimeString);
                LocalTime l2 = LocalTime.parse(this.endTimeString);

                if (l.isAfter(l2)) {
                    throw new OwnException("The startTime is not Before for endTime!");
                } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                    throw new OwnException("Invalid taskID!");

                } else {

                    if (!this.isMultipleQuarterHour()) {
                        this.roundedEndTime();
                    } else {

                        this.startTimeArray = new int[2];
                        this.startTimeArray[0] = l.getHour();
                        this.startTimeArray[1] = l.getMinute();

                        this.endTimeArray = new int[2];
                        this.endTimeArray[0] = l2.getHour();
                        this.endTimeArray[1] = l2.getMinute();
                    }
                }
            }

        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getMessage());

        }

    }

    public Task(String taskIdI,
            String commentI,
            int[] startTimeArrayI,
            int[] endTimeArrayI) throws OwnException {

        try {

            this.taskId = taskIdI;
            this.comment = commentI;
            if (this.taskId == null || this.taskId.isEmpty()) {
                throw new OwnException("Invalid taskID!");
            } else if (startTimeArrayI == null) {
                throw new OwnException("The startTime is Empty!");
            } else if (endTimeArrayI == null) {
                throw new OwnException("The endTime is Empty!");
            } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                throw new OwnException("Invalid taskID!");

            } else if (startTimeArrayI.length != 2 || endTimeArrayI.length != 2) {

                throw new OwnException("Input is wrong! StartTime or EndTime not 2 length!");
            } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                throw new OwnException("Invalid taskID!");

            } else {
                if (commentI == null || commentI.isEmpty()) {
                    this.comment = "";
                }

                this.startTimeString = this.arrayTimeToString(startTimeArrayI);
                this.endTimeString = this.arrayTimeToString(endTimeArrayI);
                LocalTime l = LocalTime.parse(this.startTimeString);
                LocalTime l2 = LocalTime.parse(this.endTimeString);
                if (l.isAfter(l2)) {
                    throw new OwnException("The startTime is not Before for endTime!");
                } else if (!this.isMultipleQuarterHour()) {
                    this.roundedEndTime();
                } else {

                    l = LocalTime.parse(this.startTimeString);
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

    public Task(String taskIdI,
            String commentI,
            int[] startTimeArrayI) throws OwnException {

        try {
            this.taskId = taskIdI;
            this.comment = commentI;
            if (this.taskId == null || this.taskId.isEmpty()) {
                throw new OwnException("Invalid taskID!");
            } else if (startTimeArrayI == null) {
                throw new OwnException("The startTime is Empty!");
            } else if (commentI == null || commentI.isEmpty()) {
                this.comment = "";
            } else if (startTimeArrayI.length != 2) {

                throw new OwnException("Input is wrong! The startTime length is not 2! It's: " + startTimeArrayI.length);

            } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                throw new OwnException("Invalid taskID!");

            } else {
                this.startTimeString = this.arrayTimeToString(startTimeArrayI);

                LocalTime l = LocalTime.parse(this.startTimeString);
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

    public Task(String taskIdI,
            int[] startTimeArrayI,
            int[] endTimeArrayI) throws OwnException {
        try {

            this.taskId = taskIdI;
            if (this.taskId == null || this.taskId.isEmpty()) {
                throw new OwnException("Invalid taskID!");
            } else if (startTimeArrayI == null) {
                throw new OwnException("The startTime is Empty!");
            } else if (endTimeArrayI == null) {
                throw new OwnException("The endTime is Empty!");
            } else if (startTimeArrayI.length != 2 || endTimeArrayI.length != 2) {

                throw new OwnException("Input is wrong! StartTime or EndTime not 2 length!");

            } else {

                if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                    throw new OwnException("Invalid taskID!");

                } else {
                    this.startTimeString = this.arrayTimeToString(startTimeArrayI);
                    this.endTimeString = this.arrayTimeToString(endTimeArrayI);

                    LocalTime l = LocalTime.parse(this.startTimeString);
                    LocalTime l2 = LocalTime.parse(this.endTimeString);
                    if (l.isAfter(l2)) {
                        throw new OwnException("The startTime is not Before for endTime!");
                    } else if (!this.isMultipleQuarterHour()) {
                        this.roundedEndTime();
                    } else {

                        this.comment = this.startTimeString;

                        l = LocalTime.parse(this.startTimeString);
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
            }
        } catch (DateTimeParseException ex) {

            throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());

        }
    }

    public Task(String taskIdI,
            int[] startTimeArrayI)
            throws OwnException {

        this.taskId = taskIdI;
        if (this.taskId == null || this.taskId.isEmpty()) {
            throw new OwnException("Invalid taskID!");
        } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
            throw new OwnException("Invalid taskID!");

        } else if (startTimeArrayI == null) {
            throw new OwnException("The startTime is Empty!");
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
            //LocalTime l = LocalTime.parse(startTimeStringI);

            this.taskId = taskIdI;
            if (this.taskId == null || this.taskId.isEmpty()) {
                throw new OwnException("Invalid taskID!");
            } else if (!this.isValidTaskId() && !this.isValidLTTaskId() && !this.isValidRedmineTaskId()) {
                throw new OwnException("Invalid taskID!");

            } else if (startTimeStringI.isEmpty()) {
                throw new OwnException("The startTime is Empty!");
            } else {
                this.startTimeString = startTimeStringI;
                //  this.endTimeString = endTimeI;
                this.comment = startTimeStringI;
                LocalTime l = LocalTime.parse(startTimeStringI);
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

    public LocalTime getStartTime() {

        try {
            return LocalTime.parse(this.startTimeString);
        } catch (NullPointerException ex) {
            return null;
        }

    }

    public LocalTime getEndTime() {
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

        if (this.endTimeString == null || this.endTimeString.isEmpty()) {
            throw new OwnException("EmptyTimeFieldException");
        } else {
            long i = Duration.between(this.getStartTime(), this.getEndTime()).toMinutes();
            return i;
        }
        //Duration.between(this.getStartTime(), this.getEndTime()).toMinutes();

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

//        if (this.startTimeArray == null || this.endTimeArray == null) {
//            return true;
//        }
//        long minutes = Duration.between(LocalTime.parse(this.startTimeString), LocalTime.parse(this.endTimeString)).toMinutes();
//
//        if (minutes % 15 == 0 && minutes > 15) {
//
//            return true;
//
//        }

        return super.isMultipleQuarterHour(LocalTime.parse(this.startTimeString),LocalTime.parse(this.endTimeString));

    }

    public void endTaskWithString(String endTimeStringI) throws OwnException {

        try {
            LocalTime l = LocalTime.parse(this.startTimeString);
            LocalTime l2 = LocalTime.parse(endTimeStringI);
            if (l.isAfter(l2)) {
                throw new OwnException("The startTime is not Before for endTime!");
            } else {

                this.endTimeString = endTimeStringI;
                this.endTimeArray = new int[2];
                this.endTimeArray[0] = LocalTime.parse(this.endTimeString).getHour();
                this.endTimeArray[1] = LocalTime.parse(this.endTimeString).getMinute();

                if (!this.isMultipleQuarterHour()) {
                    this.roundedEndTime();
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
                String str = this.arrayTimeToString(endTimeArrayI);
                if (LocalTime.parse(str).isBefore(this.getStartTime())) {
                    throw new OwnException("The startTime is not Before for endTime!");

                } else {
                    this.endTimeString = str;
                    this.endTimeArray = endTimeArrayI;
                    if (!this.isMultipleQuarterHour()) {
                        this.roundedEndTime();
                    }
                }
            } catch (DateTimeParseException ex) {
                throw new OwnException(ex.getErrorIndex() + ": " + ex.getParsedString());
            }
        }

    }

    public void setStartTime(int hour, int minute) throws OwnException {

        try {

            int[] timeArray = new int[2];
            timeArray[0] = hour;
            timeArray[1] = minute;
            String timeString = this.arrayTimeToString(timeArray);
            LocalTime startTime = LocalTime.parse(timeString);
            if (startTime.isAfter(this.getEndTime())) {
                throw new OwnException("Wrong new startTime!");
            } else {

                this.startTimeArray[0] = hour;
                this.startTimeArray[1] = minute;
                this.startTimeString = this.arrayTimeToString(this.startTimeArray);
                LocalTime.parse(this.startTimeString);

                if (!this.isMultipleQuarterHour()) {
                    this.roundedEndTime();
                }

            }
        } catch (DateTimeParseException ex) {
            throw new OwnException("Wrong startTime!");
        }

    }

    public void setStartTime(String timeString) throws OwnException {

        try {

            LocalTime startTime = LocalTime.parse(timeString);
            LocalTime time = this.getEndTime();
            if (startTime.isAfter(time)) {
                throw new OwnException("Wrong new startTime!");
            } else {
                this.startTimeString = timeString;
                time = LocalTime.parse(this.startTimeString);
                this.startTimeArray[0] = time.getHour();
                this.startTimeArray[1] = time.getMinute();
                this.setStartTime(this.startTimeArray[0], this.startTimeArray[1]);
            }
        } catch (DateTimeParseException ex) {
            throw new OwnException("Wrong startTime!");
        }

    }

    public void setEndTime(int hour, int minute) throws OwnException {

        try {

            int[] timeArray = new int[2];
            timeArray[0] = hour;
            timeArray[1] = minute;
            String timeString = this.arrayTimeToString(timeArray);
            LocalTime endTime = LocalTime.parse(timeString);
            if (endTime.isBefore(this.getStartTime())) {
                throw new OwnException("Wrong new endTime!");
            } else {
                this.endTimeArray = timeArray;
                this.endTimeString = timeString;

                if (!this.isMultipleQuarterHour()) {
                    this.roundedEndTime();
                }

            }
        } catch (DateTimeParseException ex) {
            throw new OwnException("Wrong endTime!");
        }

    }

    private void roundedEndTime() throws OwnException {

        long mod = Duration.between(this.getStartTime(), this.getEndTime()).toMinutes() % 15;
        LocalTime endTime = this.getEndTime();

        if (mod < 15 - mod && Duration.between(this.getStartTime(), this.getEndTime()).toMinutes() - mod > 15) {
            endTime.minusMinutes(mod);
            this.endTimeArray[0] = endTime.getHour();
            this.endTimeArray[1] = endTime.getMinute();

            this.endTimeString = this.arrayTimeToString(this.endTimeArray);

        } else {
            endTime.plusMinutes(15 - mod);
            this.endTimeArray[0] = endTime.getHour();
            this.endTimeArray[1] = endTime.getMinute();

            this.endTimeString = this.arrayTimeToString(this.endTimeArray);

        }

    }

    public void setEndTime(String timeString) throws OwnException {
        try {
            LocalTime time = LocalTime.parse(timeString);
            LocalTime startTime = this.getStartTime();
            if (startTime.isAfter(time)) {
                throw new OwnException("Wrong new endTime!");
            } else {
                this.setEndTime(time.getHour(), time.getMinute());
            }
        } catch (DateTimeParseException ex) {
            throw new OwnException("Wrong endTime!");
        }

    }

    public void setTaskId(String taskId) throws OwnException {

        if (taskId == null || taskId.isEmpty()) {
            throw new OwnException("Invalid taskID!");

        } else {
            String oldTaskId = this.getTaskId();
            this.taskId = taskId;
            if (!this.isValidLTTaskId() && !this.isValidRedmineTaskId() && !this.isValidTaskId()) {
                this.taskId = oldTaskId;
                throw new OwnException("Wrong taskID!");
            }
        }

    }

    public void setComment(String comment) {

        this.comment = comment;

    }

}
