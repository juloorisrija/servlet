package com.assignment7.jsf.bean;

public class BillConstruct {
	
	 private int meterid;
	 private int currbillreading;
	 private int prevbillreading;
	 private String zone;
	 private long result;
	 
	 public BillConstruct() {
		 super();
	 }
	public BillConstruct(int meterid, int currbillreading, int prevbillreading, String zone, long result) {
		super();
		this.meterid = meterid;
		this.currbillreading = currbillreading;
		this.prevbillreading = prevbillreading;
		this.zone = zone;
		this.result=result;
	}
	
	public int getMeterid() {
		return meterid;
	}
	public void setMeterid(int meterid) {
		this.meterid = meterid;
	}
	public int getCurrbillreading() {
		return currbillreading;
	}
	public void setCurrbillreading(int currbillreading) {
		this.currbillreading = currbillreading;
	}
	public int getPrevbillreading() {
		return prevbillreading;
	}
	public void setPrevbillreading(int prevbillreading) {
		this.prevbillreading = prevbillreading;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}
	

}
