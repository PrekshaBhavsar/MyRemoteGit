package com.bean;

public class FlightsBean {
	private int Sr_no;
	private String Airline;
	private String Flightid;
	private String SourceAirport;
	private String SourceCity;
	private String SourceState;
	private String SourceIATAcode;
	private int SourceAirportid;
	private String DestinationAirport;
	private String DestinationCity;
	private String DestinationState;
	private String DestinationIATAcode;
	private int DestinationAirportid;
	private int Price;
	private String DepartureDate;
	private String ReturningDate;
	private String Time;

	public FlightsBean() {
		
		
	}
	public FlightsBean(String airline, String flightid,String sourceCity,
			String destinationCity,String departureDate,String time) {
		super();
		Airline = airline;
		Flightid = flightid;
		SourceCity = sourceCity;
		DestinationCity = destinationCity;
		DepartureDate = departureDate;
		Time = time;
	}
	public FlightsBean(String airline,String sourceCity,
			String destinationCity,String departureDate,String time) {
		super();
		Airline = airline;
		SourceCity = sourceCity;
		DestinationCity = destinationCity;
		DepartureDate = departureDate;
		Time = time;
	}
	public FlightsBean(String airline, String flightid,String sourceCity,
			String destinationCity,int price,String departureDate,String time) {
		super();
		Airline = airline;
		Flightid = flightid;
		SourceCity = sourceCity;
		DestinationCity = destinationCity;
		Price = price;
		DepartureDate = departureDate;
		Time = time;
	}
	public FlightsBean(int sr_no,String airline, String flightid,String sourceCity,
			String destinationCity,int price,String departureDate,String time) {
		super();
		Sr_no = sr_no;
		Airline = airline;
		Flightid = flightid;
		SourceCity = sourceCity;
		DestinationCity = destinationCity;
		Price = price;
		DepartureDate = departureDate;
		Time = time;
	}
	public FlightsBean(String airline, String flightid, String sourceAirport, String sourceCity,
			String sourceState, String sourceIATAcode, String destinationAirport, String destinationCity,
			String destinationState, String destinationIATAcode, int price, String departureDate,String time) {
		super();
		Airline = airline;
		Flightid = flightid;
		SourceAirport = sourceAirport;
		SourceCity = sourceCity;
		SourceState = sourceState;
		SourceIATAcode = sourceIATAcode;
		DestinationAirport = destinationAirport;
		DestinationCity = destinationCity;
		DestinationState = destinationState;
		DestinationIATAcode = destinationIATAcode;
		Price = price;
		DepartureDate = departureDate;
		Time = time;
	}


	public int getSr_no() {
		return Sr_no;
	}

	public void setSr_no(int sr_no) {
		Sr_no = sr_no;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public String getFlightid() {
		return Flightid;
	}

	public void setFlightid(String flightid) {
		Flightid = flightid;
	}

	public String getSourceAirport() {
		return SourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		SourceAirport = sourceAirport;
	}

	public String getSourceCity() {
		return SourceCity;
	}

	public void setSourceCity(String sourceCity) {
		SourceCity = sourceCity;
	}

	public String getSourceState() {
		return SourceState;
	}

	public void setSourceState(String sourceState) {
		SourceState = sourceState;
	}

	public String getSourceIATAcode() {
		return SourceIATAcode;
	}

	public void setSourceIATAcode(String sourceIATAcode) {
		SourceIATAcode = sourceIATAcode;
	}

	public int getSourceAirportid() {
		return SourceAirportid;
	}

	public void setSourceAirportid(int sourceAirportid) {
		SourceAirportid = sourceAirportid;
	}


	public String getDestinationAirport() {
		return DestinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		DestinationAirport = destinationAirport;
	}
	public String getDestinationCity() {
		return DestinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		DestinationCity = destinationCity;
	}

	public String getDestinationState() {
		return DestinationState;
	}

	public void setDestinationState(String destinationState) {
		DestinationState = destinationState;
	}

	public String getDestinationIATAcode() {
		return DestinationIATAcode;
	}

	public void setDestinationIATAcode(String destinationIATAcode) {
		DestinationIATAcode = destinationIATAcode;
	}

	public int getDestinationAirportid() {
		return DestinationAirportid;
	}

	public void setDestinationAirportid(int destinationAirportid) {
		DestinationAirportid = destinationAirportid;
	}


	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getDepartureDate() {
		DepartureDate.replaceAll("-", "/");
		return DepartureDate;
	}


	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
		DepartureDate.replaceAll("-", "/");
	}


	public String getReturningDate() {
		return ReturningDate;
	}

	public void setReturningDate(String returningDate) {
		ReturningDate = returningDate;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}
	@Override
	public String toString() {
		return "Airline-" + Airline + "-SourceCity-" + SourceCity + "-DestinationCity-" + DestinationCity
				+ "-DepartureDate-" + DepartureDate + "-Time-" + Time ;
	}

	

}
