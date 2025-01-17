package LoggingFramework;

public class ConsoleAppender extends Appender{
    public ConsoleAppender(Formatter formatter) {
        super(formatter);
    }

    @Override
    public void append(LogLevel level, String message) {
        System.out.println(formatter.format(level, message));
    }
}
