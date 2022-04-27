package model;

import java.time.LocalDateTime;

public class MeetingInfo {
    private int organiserId;
    private int joinerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;

    public MeetingInfo(int organiserId, int joinerId, LocalDateTime startTime, LocalDateTime endTime, String title) {
        this.organiserId = organiserId;
        this.joinerId = joinerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }

    public MeetingInfo() {
    }

    public int getOrganiserId() {
        return organiserId;
    }

    public int getJoinerId() {
        return joinerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "organiserId=" + organiserId +
                ", joinerId=" + joinerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", title='" + title + '\'' +
                '}';
    }
}
