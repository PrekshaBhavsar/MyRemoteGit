package com.bean;

public class RegistrationBean {
	
	private String Firstname;
	private String Lastname;
	private int dd;
	private int mm;
	private int yy;
	private String Email;
	private String Gender;
	private String SourceCity;
	private String DestinationCity;
	private String FlightNo;
	private int Travellers;
	private String TravellDate;

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getYy() {
		return yy;
	}

	public void setYy(int yy) {
		this.yy = yy;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSourceCity() {
		return SourceCity;
	}

	public void setSourceCity(String sourceCity) {
		SourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return DestinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		DestinationCity = destinationCity;
	}

	public String getFlightNo() {
		return FlightNo;
	}

	public void setFlightNo(String flightno) {
		FlightNo = flightno;
	}

	public int getTravellers() {
		return Travellers;
	}

	public void setTravellers(int travellers) {
		Travellers = travellers;
	}

	public String getTravellDate() {
		return TravellDate;
	}

	public void setTravellDate(String TravellDate) {
		this.TravellDate = TravellDate;
	}



}
