package org.yakirl.alcolil.filter;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.yakirl.alcolil.common.*;
import org.yakirl.alcolil.database.FileSystemDBManager;
import org.yakirl.alcolil.strategy.AlphaGraphAnalyzer;
import org.apache.commons.configuration2.XMLConfiguration;

public class StockFilter {
	
	BigDecimal minAvgVol;
	int lastXDaysForAvg;
	BigDecimal minMarketCap;
	BigDecimal minLastPrice;
	
	public StockFilter(String filename) {
		//getConfFromFile(filename);
	}
	
	public void getConfFromFile(String confFileName) {
		Configurations configs = new Configurations();
		XMLConfiguration config = null;
		try {
			config = configs.xml(confFileName);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		setConf(config.getBigDecimal("StockFilter.minAvgVol"),
				config.getInt("StockFilter.lastXDaysForAvg"),				
				config.getBigDecimal("StockFilter.minMarketCap"),
				new BigDecimal(config.getDouble("StockFilter.minLastPRice")));
	}
	
	public void setConf(BigDecimal minAvgVol,
						int lastXDaysForAvg,
						BigDecimal marketCap,
						BigDecimal lastPrice) {
		this.minAvgVol = minAvgVol;
		this.lastXDaysForAvg = lastXDaysForAvg;
		this.minMarketCap = marketCap;
		this.minLastPrice = lastPrice;
	}
	
	private BigDecimal avgVolofLastXDays(Stock stock) throws IOException {
		//ATimeSeries timeSeries = DBManager.getInstance().readFromQuoteDB(stock.getSymbol());
		//BigDecimal avgVol = new AlphaGraphAnalyzer(timeSeries.getBarSeries(AInterval.DAILY)).avgVolofXDays(lastXDaysForAvg, null);
		//return avgVol;
	    return null;
	}
	
	private boolean isMatch(Stock stock) throws IOException{
		boolean ret = true;
		if ((avgVolofLastXDays(stock).compareTo(minAvgVol)) == 1 ||
		    (stock.getMarketCap().compareTo(minMarketCap) == 1) ||
			(stock.getLastPrice().doubleValue() < minLastPrice.doubleValue()))
			ret = false;
		return ret;
	}
	
	public StockCollection filter(StockCollection stockCollection) throws IOException {
		StockCollection filteredCollection = new StockCollection();
		for (Stock stock : stockCollection) {
			if(isMatch(stock)) {
				filteredCollection.add(stock);
			}
		}
		return filteredCollection;
	}
}
