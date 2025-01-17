package LoggingFramework;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Logger {
    private String name;
    private LogLevel level;
    private List<Appender> appenders;
    private static final BlockingDeque<LogMessage> logQueue = new LinkedBlockingDeque<>();

    public Logger(String name, LogLevel level){

    }

    public void log(LogLevel level, String message){
        if (level.ordinal() >= this.level.ordinal()) {
            logQueue.offer(new LogMessage(level, message, LocalDateTime.now()));
        }
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void info(String message){
        log(LogLevel.INFO, message);
    }
    public void error(String message){
        log(LogLevel.ERROR, message);
    }
    public void warn(String message){
        log(LogLevel.WARN, message);
    }

}
