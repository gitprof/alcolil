package org.yakirl.alcolil.marketdata;

import java.io.IOException;
import java.util.ArrayList;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import org.yakirl.alcolil.common.Interval;
import org.yakirl.alcolil.common.StockSeries;
import org.yakirl.alcolil.database.DBManagerAPI;
import org.yakirl.alcolil.database.IntegratedDBManager;
import org.yakirl.alcolil.scanner.BackTestPipe;
import org.yakirl.alcolil.unittests.SuperTestCase;

public class HistoricalDataUpdaterTest extends SuperTestCase {

    public HistoricalDataUpdaterTest() {
        super();
    }
   /*
    @Test
    public void testUpdateQuoteDB() throws IOException {
        YahooFetcher fetcher = new YahooFetcher();
        DBManagerAPI dbManager = new IntegratedDBManager();
        BackTestPipe pipe = new BackTestPipe
        ArrayList<String> symbols = new ArrayList<String>();
        symbols.add("GOOG_EXAMPLE");      
        
        HistoricalDataUpdater updater = new HistoricalDataUpdater(dbManager, fetcher);       
        updater.updateQuoteDB(symbols, Interval.ONE_MIN);
        // read from quote DB and verify writing

        updater = new HistoricalDataUpdater(fetcher);
        updater.updateQuoteDB(symbols, AInterval.ONE_MIN);
        // read from quote DB and verify merging
    }
    
    @Test
    public void testWithMocks() {
        Mockery context = new Mockery();
        BackTestPipe mockedPipe = context.mock(org.gitprof.alcolil.scanner.BackTestPipe.class);
        context.checking(new Expectations() {{
            atLeast(1).of(mockedPipe).getRemoteHistoricalData();
            will(returnValue(AStockSeries.class));
        }});
        context.assertIsSatisfied();
        
    }*/
}
