package org.yakirl.alcolil.account;

//import org.gitprof.alcolil.common.*;

public enum ExecutionType {

	BUY_MKT, 
	BUY_STP, 
	BUY_LMT, 
	SELL_MKT, 
	SELL_STP, 
	SELL_LMT;

	public boolean isLong() {
		return (0 == this.compareTo(ExecutionType.BUY_STP)) ||
			   (0 == this.compareTo(ExecutionType.BUY_LMT)) || 
			   (0 == this.compareTo(ExecutionType.BUY_MKT)); 
	
	}
	
	public boolean isShort() {
		return !isLong();
	}
}
