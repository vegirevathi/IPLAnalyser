package CSVBuilder;

public class CSVBuilderFactory {

    public static OpenCSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder();
    }
}
