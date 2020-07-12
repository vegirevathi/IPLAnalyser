package IPLAnalyser.exception;

public class IPLAnalyserException extends Exception {

    public ExceptionType type;

    public enum ExceptionType {NO_IPL_DATA}

    public IPLAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
