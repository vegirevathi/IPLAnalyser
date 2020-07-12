import IPLAnalyser.exception.IPLAnalyserException;
import IPLAnalyser.model.MostRunCSV;
import IPLAnalyser.service.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int numOfRecords = iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(100,numOfRecords);
    }

    @Test
    public void givenIPLMostWktsCSVFile_ShouldReturnCorrectRecords() {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int numOfRecords = iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_CSV_FILE_PATH);
        Assert.assertEquals(100,numOfRecords);
    }

    @Test
    public void givenIPLMostRunsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplpLayersRecords = iplAnalyser.getAvgWiseSortedIPLPLayersRecords(IPL_MOST_RUNS_CSV_FILE_PATH);
            MostRunCSV[] mostRunsCSV = new Gson().fromJson(iplpLayersRecords, MostRunCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunsCSV[mostRunsCSV.length - 1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
