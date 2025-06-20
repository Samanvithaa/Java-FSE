public class Singleton{

    static class Logger {
        private static Logger instance = new Logger();

        private Logger() {
            System.out.println("Logger initialized.");
        }

        // Public method to access the instance
        public static Logger getInstance() {
            return instance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message.");
        logger2.log("Second message.");

        if (logger1 == logger2) {
            System.out.println("Singleton confirmed: Both references point to the same instance.");
        } else {
            System.out.println("Singleton failed: Different instances exist.");
        }
    }
}
