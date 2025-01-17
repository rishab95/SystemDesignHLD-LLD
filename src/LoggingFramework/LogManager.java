package LoggingFramework;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Singleton or factory class for managing logger instances.
public class LogManager {
    private static final ConcurrentHashMap<String, Logger> loggerMap = new ConcurrentHashMap<>();
    public static Logger getLogger(String name){
        return loggerMap.computeIfAbsent(name, k -> new Logger(k, LogLevel.INFO));
    }
}
