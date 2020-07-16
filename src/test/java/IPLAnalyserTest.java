import IPLAnalyser.exception.IPLAnalyserException;
import IPLAnalyser.model.MostRunCSV;
import IPLAnalyser.service.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class IPLAnalyserTest {
    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_MOST_RUNS_WRONGCSV_FILE_PATH = "./src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_RUNS_WRONGCSV_FILE_TYPE = "./src/test/resources/IPL2019FactsheetMostRuns.pdf";
    private static final String IPL_MOST_WKTS_WRONGCSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private static final String IPL_MOST_WKTS_WRONGCSV_FILE_TYPE = "./src/test/resources/IPL2019FactsheetMostWkts.jpg";
    private IPLAnalyser iplAnalyser;

    @Before
    public void setUp() throws Exception {
       iplAnalyser = new IPLAnalyser();
    }

    @Test
    public void givenIPLMostRunsCSVFile_ShouldReturnCorrectRecords() {
        try {
            int numOfRecords = iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100,numOfRecords);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLMostWktsCSVFile_ShouldReturnCorrectRecords() {
        try {
            int numOfRecords = iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_CSV_FILE_PATH);
            Assert.assertEquals(100,numOfRecords);
        } catch (IPLAnalyserException e) {
        }
    }

    @Test
    public void givenIPLMostWktsCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_WRONGCSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostWktsCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_WRONGCSV_FILE_TYPE);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostWktsCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.DELIMITER_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostWktsCSVFile_WithWrongDelimiter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostWktsData(IPL_MOST_WKTS_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.DELIMITER_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_WithWrongFilePath_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_WRONGCSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_WithWrongFileType_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_WRONGCSV_FILE_TYPE);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.DELIMITER_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_WithWrongDelimiter_ShouldThrowException() {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(IPLAnalyserException.class);
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.DELIMITER_HEADER_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIPLMostRunsCSVFile_WhenSortedOnAvg_ShouldReturnCorrectDesiredSortedData() {
        try {
            iplAnalyser.loadIPLMostRunsData(IPL_MOST_RUNS_CSV_FILE_PATH);
            String iplPLayersRecords = iplAnalyser.getAvgWiseSortedIPLPLayersRecords(IPL_MOST_RUNS_CSV_FILE_PATH);
            MostRunCSV[] mostRunsCSV = new Gson().fromJson(iplPLayersRecords, MostRunCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunsCSV[mostRunsCSV.length - 1].player);
        } catch (IPLAnalyserException e) {
            e.printStackTrace();
        }
    }
}
