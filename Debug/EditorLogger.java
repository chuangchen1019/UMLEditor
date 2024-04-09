package Debug;
import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class EditorLogger extends Logger {
    private static EditorLogger logger;
    private ConsoleHandler consoleHandler;

    public EditorLogger() {
        super("UMLLogger", null);
        consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);

    }

    public static synchronized EditorLogger getInstance() {
        if (logger == null) {
            logger = new EditorLogger();
        }
        return logger;
    }

    public void setLogLevel(Level level) {
        this.setLevel(level);
    }

    public void logInfo(String message) {
        this.info(message);
    }

    public void logWarning(String message) {
        this.warning(message);
    }

    public void logError(String message) {
        this.severe(message);
    }

    private static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return "[" + record.getLevel() + "] " + record.getMessage() + "\n";
        }
    }
}
