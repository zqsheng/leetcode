package desing_pattern.creational;


/**
 * 责任链模式
 * @author zhangqisheng
 */
public class ChainOfResponsibilty {
    private static abstract class AbstactLogger {
        public static final int INFO = 1;
        public static final int DEBUG = 2;
        public static final int ERROR = 3;

        private int level;
        private AbstactLogger nextLogger;

        public void setNextLogger(AbstactLogger logger) {
            this.nextLogger = logger;
        }
        public void logMessage(int level,String msg) {
            if(this.level <= level) {
                write(msg);
            }
            if(nextLogger != null) {
                nextLogger.logMessage(level,msg);
            }
        }
        protected abstract void write(String msg);
    }

    private static class ConsoleLogger extends AbstactLogger {
        public ConsoleLogger(int level) {
            super.level = level;
        }

        @Override
        protected void write(String msg) {
            System.out.println("Standard Console::" + msg);
        }
    }
    private static class FileLogger extends AbstactLogger {

        public FileLogger(int level) {
            super.level = level;
        }

        @Override
        protected void write(String msg) {
            System.out.println("File Logger::" + msg);
        }
    }

    private static class ErrorLogger extends AbstactLogger {
        public ErrorLogger(int level) {
            super.level = level;
        }

        @Override
        protected void write(String msg) {
            System.out.println("Error Console::" + msg);
        }
    }

    private static AbstactLogger getLoggerChain() {
        ErrorLogger errorLogger = new ErrorLogger(AbstactLogger.ERROR);
        ConsoleLogger consoleLogger = new ConsoleLogger(AbstactLogger.INFO);
        FileLogger fileLogger = new FileLogger(AbstactLogger.DEBUG);

        errorLogger.setNextLogger(consoleLogger);
        consoleLogger.setNextLogger(fileLogger);
        return errorLogger;

    }

    public static void main(String[] args) {
        AbstactLogger chain = getLoggerChain();

        chain.logMessage(AbstactLogger.DEBUG,"this.is logger");


    }

}
