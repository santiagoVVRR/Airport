package model;

public class Flight implements Comparable<Flight>{
	
	private String airline;
	private String number;
	private String city;
	private int door;
	
	private Date date;
	private Hour hour;
	
	public Flight(Date date, Hour hour, String airline, String number, String city, int door) {
		
		this.airline = airline;
		this.number = number;
		this.city = city;
		this.door = door;
		this.date = date;
		this.hour = hour;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Hour getHour() {
		return hour;
	}

	public void setHour(Hour hour) {
		this.hour = hour;
	}
	
	@Override
	public int compareTo(Flight other) {
		
		int comp;
		if(number.compareTo(other.number) < 0) {
			comp = -1;
		}else if(number.compareTo(other.number) > 0) {
			comp = 1;
		}else {
			comp = 0;
		}
		return comp;
	}

}
