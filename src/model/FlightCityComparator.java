package model;

import java.util.Comparator;

public class FlightCityComparator implements Comparator<Flight>{

	@Override
	public int compare(Flight f1, Flight f2) {
		
		int comp;
		String city1 = f1.getCity();
		String city2 = f2.getCity();
		
		if(city1.compareTo(city2) < 0) {
			comp = -1;
		}else if(city1.compareTo(city2) > 0) {
			comp = 1;
		}else {
			comp = 0;
		}
		
		return comp;
	}

	
	
}
