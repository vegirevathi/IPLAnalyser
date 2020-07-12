package IPLAnalyser.service;

import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;
import IPLAnalyser.exception.IPLAnalyserException;
import IPLAnalyser.model.MostRunCSV;
import IPLAnalyser.model.MostWktsCSV;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class IPLAnalyser {

    List<MostRunCSV> iplCSVList;
    List<MostWktsCSV> iplWktsCsvList;

    public int loadIPLMostRunsData(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplCSVList = csvBuilder.getCSVFileList(reader, MostRunCSV.class);
            return iplCSVList.size();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (CSVBuilderException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int loadIPLMostWktsData(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplWktsCsvList = csvBuilder.getCSVFileList(reader, MostWktsCSV.class);
            return iplCSVList.size();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (CSVBuilderException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getAvgWiseSortedIPLPLayersRecords(String csvFilePath) throws IPLAnalyserException {
        loadIPLMostRunsData(csvFilePath);
        if (iplCSVList == null || iplCSVList.size() == 0) {
            throw new IPLAnalyserException(IPLAnalyserException.ExceptionType.NO_IPL_DATA, "NO_IPL_DATA");
        }

        Comparator<MostRunCSV> iplComparator = Comparator.comparing(iplRecord -> iplRecord.avg);
        iplCSVList.sort(iplComparator);
        String sortedIplData = new Gson().toJson(iplCSVList);
        return sortedIplData;
    }
}
