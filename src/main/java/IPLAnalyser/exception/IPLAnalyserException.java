package IPLAnalyser.exception;

public class IPLAnalyserException extends Exception {

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, String name) {
    }

    public enum ExceptionType {NO_IPL_DATA, DELIMITER_HEADER_PROBLEM, CENSUS_FILE_PROBLEM}
    public ExceptionType type;

}
