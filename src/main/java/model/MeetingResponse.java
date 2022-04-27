package model;

import java.time.LocalDateTime;

public class MeetingResponse extends MeetingInfo{
    private String message;

    public MeetingResponse(int organiserId, int joinerId, LocalDateTime startTime, LocalDateTime endTime, String title, String message) {
        super(organiserId, joinerId, startTime, endTime, title);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MeetingResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
