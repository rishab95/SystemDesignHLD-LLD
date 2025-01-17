package LoggingFramework;

import java.time.LocalDateTime;
import java.util.List;

public class LogMessage {
    private final LogLevel level;
    private final String message;
    private LocalDateTime timeStamp;
    public LogMessage(LogLevel level, String message, LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
        this.message = message;
        this.level = level;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
