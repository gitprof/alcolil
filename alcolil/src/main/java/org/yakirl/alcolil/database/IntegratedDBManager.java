package org.yakirl.alcolil.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yakirl.alcolil.common.BarSeries;
import org.yakirl.alcolil.common.Interval;
import org.yakirl.alcolil.common.Quote;
import org.yakirl.alcolil.common.StockCollection;
import org.yakirl.alcolil.common.StockSeries;
import org.yakirl.alcolil.common.Time;
import org.yakirl.alcolil.common.TimeSeries;

public class IntegratedDBManager implements DBManagerAPI {
	// protected static final Logger LOG = LogManager.getLogger(MarketStoreDBManager.class);
	DBManagerAPI fs, ms;	
	
	public IntegratedDBManager() throws Exception {
		fs = FileSystemDBManager.getInstance();
		ms = MarketStoreDBManager.getInstance();
	}
	
	public static synchronized DBManagerAPI getInstance() throws Exception {
		DBManagerAPI dbManager = new IntegratedDBManager();
		return dbManager;	
	}
	
	public void validateDBStructure() throws Exception {
		fs.validateDBStructure();
		ms.validateDBStructure();
	}
	
	public void close() throws Exception {
		ms.close();
		fs.close();
	}
	
	public StockCollection getStockCollection() throws IOException {
		StockCollection stocks = new StockCollection();
		return stocks;
	}
	
	public void setStockCollection(StockCollection stocks) throws IOException {
		
	}

	public StockSeries readFromQuoteDB(List<String> symbols, Interval interval) throws Exception {
		return ms.readFromQuoteDB(symbols, interval);
	}

	public StockSeries readFromQuoteDB(List<String> symbols, Interval interval, Time from, Time to) throws Exception {
		return ms.readFromQuoteDB(symbols, interval, from, to);
	}
	
	public void rewriteToQuoteDB(StockSeries stockSeries) throws Exception {
		ms.rewriteToQuoteDB(stockSeries);
	}

	public void appendToQuoteDB(StockSeries stockSeries) throws Exception {
		ms.appendToQuoteDB(stockSeries);
	}

	public TimeSeries readFromQuoteDB(String symbol) throws Exception {
		return ms.readFromQuoteDB(symbol);
	}
    
	public void rewriteToQuoteDB(TimeSeries timeSeries) throws Exception {
		ms.rewriteToQuoteDB(timeSeries);
	}
	
	public void appendToQuoteDB(TimeSeries timeSeries) throws Exception {
		ms.appendToQuoteDB(timeSeries);
	}	
	
	public BarSeries readFromQuoteDB(String symbol, Interval interval) throws Exception {
		return ms.readFromQuoteDB(symbol, interval);
	}
	
	public void rewriteToQuoteDB(BarSeries barSeries) throws Exception {    	
        ms.rewriteToQuoteDB(barSeries);
	}
	
	public void appendToQuoteDB(BarSeries barSeries) throws Exception {    	
        ms.appendToQuoteDB(barSeries);
	}
}