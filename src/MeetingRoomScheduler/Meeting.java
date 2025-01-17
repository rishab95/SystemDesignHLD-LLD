package MeetingRoomScheduler;


public class Meeting {
    int roomId;
    TimeRange timeRange;

    public Meeting(int roomId, TimeRange timeRange) {
        this.roomId = roomId;
        this.timeRange = timeRange;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "roomId=" + roomId +
                ", timeRange=" + timeRange +
                '}';
    }

}
