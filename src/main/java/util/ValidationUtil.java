package util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ValidationUtil {
    public static void validateStartTimeEndTime(LocalDateTime startTime, LocalDateTime endTime) throws Exception {
        if(startTime.compareTo(endTime) > 0)
            throw new Exception("startTime should not be greater than endTime. Please check the payload and hit.");
    }

    public static void validateNonNull(Object value, String param) throws Exception {
        if(Objects.isNull(value))
            throw new Exception(param + " is null or empty. Please check the request payload and try again.");
    }

    public static void checkForConflicts(Map<Integer, List<LocalDateTime[]>> available, int participantId, LocalDateTime start, LocalDateTime end, boolean isOrganiser) throws Exception {
        if(!available.containsKey(participantId))
            return ;
        List<LocalDateTime[]> slots = available.get(participantId);
        for(LocalDateTime each[]: slots) {
            // each[0], each[1]
            // start, end
            // checks whether the occupied slot end time is before meeting start time
            // and meeting  end time is before the occupied slot start time
            if(each[1].compareTo(start) < 0 && end.compareTo(each[0]) < 0)
                continue;
            else
                throw new Exception(getConflictMsg(isOrganiser));
        }
    }

    private static String getConflictMsg(boolean isOrganiser) {
        return isOrganiser ? "Your calender is conflicting with chosen time. please choose some other time and try again"
                : "joinee is not available is the chosen time slot. Please choose another time slot.";
    }
}
