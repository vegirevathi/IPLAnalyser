import IPLAnalyser.service.IPLAnalyser;
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
}
