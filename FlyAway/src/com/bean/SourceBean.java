package com.bean;

public class SourceBean {
	private int Sr_no;
	private String AirportName;
	private String City;
	private String State;
	private String IATAcode;
	
	public SourceBean(){
		
	}
	public SourceBean(int Sr_no,String AirportName,String City,String State,String IATAcode){
		this.Sr_no = Sr_no;
		this.AirportName = AirportName;
		this.City = City;
		this.State = State;
		this.IATAcode = IATAcode;
	}
	public SourceBean(int Sr_no,String City){
		this.Sr_no = Sr_no;
		this.City = City;
	}

	public int getSr_no() {
		return Sr_no;
	}

	public void setSr_no(int sr_no) {
		Sr_no = sr_no;
	}

	public String getAirportName() {
		return AirportName;
	}

	public void setAirportName(String airportName) {
		AirportName = airportName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getIATAcode() {
		return IATAcode;
	}

	public void setIATAcode(String iATAcode) {
		IATAcode = iATAcode;
	}

}
