package com.bean;

public class SuccessBooking {
	String From;
	String To;
	String DepartureDate;
	String DepartureTime;
	String Airline;
	String TravelClass;
	String Adult;
	String Children;
	String infant;
	String fullname;
	String phonenumber;
	String email;
	String TicketNo;
	
	public SuccessBooking(){
		
		
	}

	public SuccessBooking(String from, String to, String departureDate, String departureTime, String airline,
			String travelClass, String adult, String children, String infant, String fullname, String phonenumber,
			String email, String ticketNo) {
		super();
		From = from;
		To = to;
		DepartureDate = departureDate;
		DepartureTime = departureTime;
		Airline = airline;
		TravelClass = travelClass;
		Adult = adult;
		Children = children;
		this.infant = infant;
		this.fullname = fullname;
		this.phonenumber = phonenumber;
		this.email = email;
		TicketNo = ticketNo;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getDepartureDate() {
		return DepartureDate;
	}

	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getAirline() {
		return Airline;
	}

	public void setAirline(String airline) {
		Airline = airline;
	}

	public String getTravelClass() {
		return TravelClass;
	}

	public void setTravelClass(String travelClass) {
		TravelClass = travelClass;
	}

	public String getAdult() {
		return Adult;
	}

	public void setAdult(String adult) {
		Adult = adult;
	}

	public String getChildren() {
		return Children;
	}

	public void setChildren(String children) {
		Children = children;
	}

	public String getInfant() {
		return infant;
	}

	public void setInfant(String infant) {
		this.infant = infant;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTicketNo() {
		return TicketNo;
	}

	public void setTicketNo(String ticketNo) {
		TicketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "From-" + From + "-To-" + To + "-DepartureDate-" + DepartureDate + "-DepartureTime-"
				+ DepartureTime + "-Airline-" + Airline + "-TravelClass-" + TravelClass + "-Adult-" + Adult
				+ "-Children-" + Children + "-infant-" + infant + "-fullname-" + fullname + "-phonenumber-"
				+ phonenumber + "-email-" + email + "-TicketNo-" + TicketNo ;
	}
	

}
