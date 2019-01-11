/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import java.time.Duration;
import java.time.LocalTime;
import timelogger.exceptions.OwnException;

/**
 *
 * @author stampel
 */
public class Util {

    public boolean isMultipleQuarterHour(LocalTime startTime, LocalTime endTime) throws OwnException {
        if (startTime == null || endTime == null) {
            throw new OwnException("EmptyTimeFieldException");

        } else if (startTime.isAfter(endTime)) {
            throw new OwnException("NotExpectedTimeOrderException");
        } else {
            long minutes = Duration.between(startTime, endTime).toMinutes();

            if (minutes % 15 == 0 && minutes >= 15) {

                return true;

            }

            return false;
        }

    }

    public boolean isSeparatedTime(LocalTime startTime1, LocalTime endTime1, LocalTime startTime2, LocalTime endTime2) {

        if ((startTime1.equals(startTime2) || endTime2.equals(endTime1))
                && (!startTime1.equals(endTime1) && !startTime2.equals(endTime2))) {

            return false;
        }

        if (Duration.between(startTime1, startTime2).toMinutes() > 0 && Duration.between(startTime2, endTime1).toMinutes() > 0) {
            return false;
        }

        if (Duration.between(endTime2, endTime1).toMinutes() > 0 && Duration.between(startTime1, endTime2).toMinutes() > 0) {
            return false;
        }

        return true;
    }

    public LocalTime roundToMultipleQuarterHour(LocalTime startTime, LocalTime endTime) {

        long mod = Duration.between(startTime, endTime).toMinutes() % 15;
        LocalTime endTime2 = LocalTime.of(endTime.getHour(), endTime.getMinute());

        if (mod < 15 - mod && Duration.between(startTime, endTime).toMinutes() - mod >= 15) {
            endTime2 = endTime2.minusMinutes(mod);

        } else {
            endTime2 = endTime2.plusMinutes(15 - mod);

        }
        return endTime2;
    }

}
