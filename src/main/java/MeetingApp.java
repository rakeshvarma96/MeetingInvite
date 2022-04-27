import controller.MeetingController;
import model.MeetingInfo;
import model.MeetingResponse;

import java.time.LocalDateTime;

public class MeetingApp {

    public MeetingController meetingController;
    public MeetingApp() {
        meetingController = new MeetingController();
    }

    public static void main(String[] args) {
        MeetingInfo meetingInfo = new MeetingInfo(1, 2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), "QuickCatchup");
        MeetingApp meetingApp = new MeetingApp();
        System.out.println("MeetingApp is up and running");
        try {
            MeetingResponse meetingResponse = meetingApp.meetingController.scheduleMeeting(meetingInfo);
            System.out.println(meetingResponse);
        } catch (Exception e) {
            System.out.println("Error while scheduling the given meeting:");
            e.printStackTrace();
        }
    }
}
