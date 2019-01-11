/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * @author stampel
 */
public class Util {

    public boolean isMultipleQuarterHour(LocalTime startTime, LocalTime endTime) {

        long minutes = Duration.between(startTime, endTime).toMinutes();

        if (minutes % 15 == 0 && minutes > 15) {

            return true;

        }

        return false;

    }

    public boolean isSeparatedTime(LocalTime startTime1, LocalTime endTime1, LocalTime startTime2, LocalTime endTime2) {
        if (startTime1 == startTime2 || endTime2 == endTime1) {
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

}
