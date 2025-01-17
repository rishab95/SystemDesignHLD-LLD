package MeetingRoomScheduler;

import java.util.Deque;
import java.util.PriorityQueue;

public class MeetingScheduler {

    private final Deque<TimeRange> auditLog;
    private final PriorityQueue<Room> rooms;
    private final int auditLogLimit;

    public MeetingScheduler(Deque<TimeRange> auditLog, PriorityQueue<Room> rooms, int auditLogLimit) {
        this.auditLog = auditLog;
        this.auditLogLimit = auditLogLimit;
        this.rooms = rooms;
    }
}
