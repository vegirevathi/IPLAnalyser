package IPLAnalyser.service;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import IPLAnalyser.model.MostRunCSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IPLAnalyser {
    public int loadIPLMostRunsData(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<MostRunCSV> battingDataIterator = csvBuilder.getCSVFileIterator(reader, MostRunCSV.class);
            Iterable<MostRunCSV> battingDataIterable = () -> battingDataIterator;
            return (int) StreamSupport.stream(battingDataIterable.spliterator(), false).count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (CSVBuilderException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
