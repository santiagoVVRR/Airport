package model;

import java.util.Comparator;

public class FlightAirlineComparator implements Comparator<Flight>{

	@Override
	public int compare(Flight f1, Flight f2) {
		
		int comp;
		String airline1 = f1.getAirline();
		String airline2 = f2.getAirline();
		
		if(airline1.compareTo(airline2) < 0) {
			comp = -1;
		}else if(airline1.compareTo(airline2) > 0) {
			comp = 1;
		}else {
			comp = 0;
		}
		
		return comp;
	}

}
