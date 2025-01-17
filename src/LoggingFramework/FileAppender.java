package LoggingFramework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class FileAppender extends Appender{

    private final File logFile;
    private final ReentrantLock fileLock = new ReentrantLock();
    public FileAppender(Formatter formatter, File logFile) {
        super(formatter);
        this.logFile = logFile;
    }

    @Override
    public void append(LogLevel level, String message) {
        fileLock.lock();
        try (FileWriter writer = new FileWriter(logFile, true)){
            writer.write(formatter.format(level, message));
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            fileLock.unlock();
        }
    }
}
