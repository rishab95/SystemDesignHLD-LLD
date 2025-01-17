package MeetingRoomScheduler;

import java.util.List;

public class Room {
    int roomId;
    int size;
    boolean hasAudio;
    List<TimeRange> schedule;

    public Room(int roomId, int size, boolean hasAudio, List<TimeRange> schedule) {
        this.roomId = roomId;
        this.size = size;
        this.hasAudio = hasAudio;
        this.schedule = schedule;
    }
}
