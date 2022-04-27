import controller.MeetingController;
import model.MeetingInfo;
import model.MeetingResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

public class MeetingControllerTest {

    private MeetingController meetingController;

    @Test
    public void testMeetingSuccess() throws Exception {
        meetingController = new MeetingController();
        MeetingInfo meetingInfo = getTestMeetInfo();
        MeetingResponse meetingResponse = meetingController.scheduleMeeting(meetingInfo);
        Assertions.assertNotNull(meetingInfo);
        Assertions.assertEquals("Meeting has successfully been scheduled.", meetingResponse.getMessage());
    }

    private MeetingInfo getTestMeetInfo() {
        MeetingInfo meetingInfo = new MeetingInfo(1, 2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), "QuickCatchup");
        return meetingInfo;
    }
}
