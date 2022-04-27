package controller;

import model.MeetingInfo;
import model.MeetingResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.CommonConstants.*;
import static util.ValidationUtil.*;

public class MeetingController {

    private Map<Integer, List<LocalDateTime[]>> occupiedSlots;
    public MeetingController() {
        occupiedSlots = new HashMap<>();
    }

    public MeetingResponse scheduleMeeting(MeetingInfo meetingInfo) throws Exception {
        validateNonNull(meetingInfo, MEETING_INFO);
        validateNonNull(meetingInfo.getOrganiserId(), ORGANISER_ID);
        validateNonNull(meetingInfo.getJoinerId(), JOINER_ID);
        validateNonNull(meetingInfo.getStartTime(), START_TIME);
        validateNonNull(meetingInfo.getEndTime(), END_TIME);
        validateNonNull(meetingInfo.getTitle(), TITLE);
        validateStartTimeEndTime(meetingInfo.getStartTime(), meetingInfo.getEndTime());
        checkForConflicts(occupiedSlots, meetingInfo.getOrganiserId(), meetingInfo.getStartTime(), meetingInfo.getEndTime(), true);
        checkForConflicts(occupiedSlots, meetingInfo.getJoinerId(), meetingInfo.getStartTime(), meetingInfo.getEndTime(), false);
        occupiedSlots.putIfAbsent(meetingInfo.getOrganiserId(), new ArrayList<>());
        occupiedSlots.putIfAbsent(meetingInfo.getJoinerId(), new ArrayList<>());
        // storing the given meeting times as occupied for the organiser and the joiner to keep track and check future meeting conflicts.
        occupiedSlots.get(meetingInfo.getOrganiserId()).add(new LocalDateTime[]{meetingInfo.getStartTime(), meetingInfo.getEndTime()});
        occupiedSlots.get(meetingInfo.getJoinerId()).add(new LocalDateTime[]{meetingInfo.getStartTime(), meetingInfo.getEndTime()});
        return new MeetingResponse(meetingInfo.getOrganiserId(), meetingInfo.getJoinerId(), meetingInfo.getStartTime(), meetingInfo.getEndTime(), meetingInfo.getTitle(), "Meeting has successfully been scheduled.");
    }
}
