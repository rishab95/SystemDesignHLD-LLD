package LoggingFramework;

public abstract class Appender {
    protected Formatter formatter;

    public Appender(Formatter formatter){
        this.formatter = formatter;
    }

    public abstract void append(LogLevel level, String message);
}
