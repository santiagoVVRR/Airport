package model;

import java.util.Comparator;

public class FlightDoorComparator implements Comparator<Flight>{

	@Override
	public int compare(Flight f1, Flight f2) {
		
		int comp;
		String door1 = f1.getDoor()+"";
		String door2 = f2.getDoor()+"";
		
		if(door1.compareTo(door2) < 0) {
			comp = -1;
		}else if(door1.compareTo(door2) > 0) {
			comp = 1;
		}else {
			comp = 0;
		}
		
		return comp;
	}

}
