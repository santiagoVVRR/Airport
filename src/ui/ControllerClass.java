package ui;

import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Date;
import model.Flight;
import model.FlightAirlineComparator;
import model.FlightCityComparator;
import model.FlightDateComparator;
import model.FlightDoorComparator;
import model.Hour;

public class ControllerClass {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Menu order;

    @FXML
    private TextField maxFlights;

    @FXML
    private Button generate;

    @FXML
    private VBox airlineCl;

    @FXML
    private Label airline;

    @FXML
    private VBox numberCl;

    @FXML
    private Label number;

    @FXML
    private VBox cityCl;

    @FXML
    private Label city;

    @FXML
    private VBox dateCl;

    @FXML
    private Label date;

    @FXML
    private VBox hourCl;

    @FXML
    private Label hour;

    @FXML
    private VBox doorCl;

    @FXML
    private Label gate;

    @FXML
    private MenuButton searchType;

    @FXML
    private TextField searchText;

    @FXML
    private Button search;

    @FXML
    private Label page;
    
    private int type;
    
    private Flight[] flights;

    @FXML
    void airlineSearch(ActionEvent event) {

    	searchType.setText("Airline");
    	type = 1;
    	search.setDisable(false);
    	
    }

    @FXML
    void byAirline(ActionEvent event) {

    	clear();
    	Comparator<Flight> flightCo = new FlightAirlineComparator();
		
		Arrays.sort(flights, flightCo);
		fill();
    	
    }

    @FXML
    void byCity(ActionEvent event) {

    	clear();
    	Comparator<Flight> flightC = new FlightCityComparator();
		
		Arrays.sort(flights, flightC);
		fill();
    	
    }

    @FXML
    void byDate(ActionEvent event) {

    	clear();
    	Comparator<Flight> flightCom = new FlightDateComparator();
		
		Arrays.sort(flights, flightCom);
		fill();
    	
    }

    @FXML
    void byDoor(ActionEvent event) {

    	clear();
    	Comparator<Flight> flightComp = new FlightDoorComparator();
    	
    	Arrays.sort(flights, flightComp);
    	fill();
    	
    }

    @FXML
    void byNumber(ActionEvent event) {

    	clear();
    	Arrays.sort(flights);
    	fill();
    	
    }

    @FXML
    void citySearch(ActionEvent event) {

    	searchType.setText("City");
    	type = 2;
    	search.setDisable(false);
    	
    }

    @FXML
    void dateSearch(ActionEvent event) {

    	searchType.setText("Date");
    	type = 3;
    	search.setDisable(false);
    	
    }

    @FXML
    void doorSearch(ActionEvent event) {

    	searchType.setText("Gate");
    	type = 4;
    	search.setDisable(false);
    	
    }

    @FXML
    void generate(ActionEvent event) {

    	clear();
    	
    	flights = new Flight[Integer.parseInt(maxFlights.getText())];
    	for(int i = 0; i < Integer.parseInt(maxFlights.getText()); i++) {
    		Random n = new Random();
    		String number = n.nextInt(9999)+"";
    		
    		Random c = new Random();
    		int city = c.nextInt(5)+1;
    		
    		Flight current = new Flight(createDate(), createHour(), createAirlines(), number, createCity(city), city);
    		flights[i] = current;
    	}
    	
    	Comparator<Flight> flightCompa = new FlightDateComparator();
    	Arrays.sort(flights, flightCompa);
    	fill();
    	order.setDisable(false);
    	
    }

    @FXML
    void hourSearch(ActionEvent event) {

    	searchType.setText("Hour");
    	type = 5;
    	search.setDisable(false);
    	
    }
    
    @FXML
    void numberSearch(ActionEvent event) {

    	searchType.setText("Number");
    	type = 6;
    	search.setDisable(false);
    	
    }

    @FXML
    void next(ActionEvent event) {

    	int newPage = Integer.parseInt(page.getText())+1;
    	if(newPage<(flights.length/17)+2) {
    		page.setText(newPage+"");
    		clear();
    		fill();
    	}
    	
    }

    @FXML
    void previus(ActionEvent event) {

    	int newPage = Integer.parseInt(page.getText())-1;
    	if(newPage>0) {
    		page.setText(newPage+"");
    		clear();
    		fill();
    	}
    	
    }

    @FXML
    void search(ActionEvent event) {

    	String text = searchText.getText();
    	boolean stop = false;
    	Flight current = flights[0];
    	clear();
    	if(type == 1) {
    		for(int i=0; i<flights.length && !stop; i++) {
    			if(flights[i].getAirline().equalsIgnoreCase(text)) {
    				current = flights[i];
    				stop = true;
    			}
    		}
    		flights = new Flight[1];
    		flights[0] = current;
    		fill();
    		
    	}else if(type == 2) {
    		for(int i=0; i<flights.length && !stop; i++) {
    			if(flights[i].getCity().equalsIgnoreCase(text)) {
    				current = flights[i];
    				stop = true;
    			}
    		}
    		flights = new Flight[1];
    		flights[0] = current;
    		fill();
    		
    	}else if(type == 3) {
    		//Date
    		
    		
    	}else if(type == 4) {
    		for(int i=0; i<flights.length && !stop; i++) {
    			if(flights[i].getDoor() == Integer.parseInt(text)) {
    				current = flights[i];
    				stop = true;
    			}
    		}
    		flights = new Flight[1];
    		flights[0] = current;
    		fill();
    		
    	}else if(type == 5) {
    		//Hour
    		
    		
    	}else {
    		for(int i=0; i<flights.length && !stop; i++) {
    			if(flights[i].getNumber().equalsIgnoreCase(text)) {
    				current = flights[i];
    				stop = true;
    			}
    		}
    		flights = new Flight[1];
    		flights[0] = current;
    		fill();
    	}
    	
    }

    public String createAirlines() {
    	
    	String airline= "";
    	Random air = new Random();
    	int op = air.nextInt(5)+1;
    	
    	if(op == 0) {
    		airline = "LATAM";
    	}else if(op == 1) {
    		airline = "AVIANCA";
    	}else if(op == 2) {
    		airline = "WINGO";
    	}else if(op == 3) {
    		airline = "COPA AIRLINES";
    	}else if(op == 4) {
    		airline = "Viva Colombia";
    	}else if(op == 5) {
    		airline = "SANTIAGO AIRLINES";
    	}
    	
    	return airline;
    }
    
    public String createCity(int op) {
    	
    	String city = "";
    	
    	if(op == 0) {
    		city = "Miami";
    	}else if(op == 1) {
    		city = "Buenos Aires";
    	}else if(op == 2) {
    		city = "Barcelona";
    	}else if(op == 3) {
    		city = "Madrid";
    	}else if(op == 4) {
    		city = "Los Angeles";
    	}else if(op == 5) {
    		city = "Lima";
    	}
    	
    	return city;
    }
    
    public Hour createHour() {
    	
    	Random h = new Random();
    	int hh = h.nextInt(11)+1;
    	Random m = new Random();
    	int mm = m.nextInt(59)+1;
    	Random s = new Random();
    	int op = s.nextInt(2);
    	
    	String moment = "";
    	
    	if(op == 0) {
    		moment = "AM";
    	}else {
    		moment = "PM";
    	}
    	
    	Hour hour = new Hour(hh, mm, moment);
    	return hour;
    	
    }
    
    public Date createDate() {
    	
    	Random d = new Random();
    	int day = d.nextInt(30)+1;
    	Random m = new Random();
    	int month = m.nextInt(11)+1;
    	Random y = new Random();
    	int year = y.nextInt(7)+2012;
    	
    	Date date = new Date(day, month, year);
    	return date;
    	
    }
    
    public void clear() {
    	
    	airlineCl.getChildren().clear();
    	airlineCl.getChildren().add(airline);
    	
    	numberCl.getChildren().clear();
    	numberCl.getChildren().add(number);
    	
    	cityCl.getChildren().clear();
    	cityCl.getChildren().add(city);
    	
    	dateCl.getChildren().clear();
    	dateCl.getChildren().add(date);
    	
    	hourCl.getChildren().clear();
		hourCl.getChildren().add(hour);
		
		doorCl.getChildren().clear();
		doorCl.getChildren().add(gate);
    	
    }
    
    public void fill() {
    	
    	int pages = (flights.length/17);
    	
    	for(int j = 0; j <= pages; j++) {
    		if(j+1 == Integer.parseInt(page.getText())) {
    			for(int i = (17*j); i < 17+(17*j) && i < flights.length; i++) {
    				
    				Label airline = new Label(flights[i].getAirline());
    				Label number = new Label (flights[i].getNumber()+"");
    				Label city = new Label (flights[i].getCity());
    				Label date = new Label (flights[i].getDate()+"");
    				Label hour = new Label (flights[i].getHour()+"");
    				Label door = new Label (flights[i].getDoor()+"");
    				
    				airlineCl.getChildren().add(airline);
    				numberCl.getChildren().add(number);
    				cityCl.getChildren().add(city);
    				dateCl.getChildren().add(date);
    				hourCl.getChildren().add(hour);
    				doorCl.getChildren().add(door);
    			}
    		}
    	}
    }
    
    @FXML
    void initialize() {
        assert order != null : "fx:id=\"order\" was not injected: check your FXML file 'screen.fxml'.";
        assert maxFlights != null : "fx:id=\"maxFlights\" was not injected: check your FXML file 'screen.fxml'.";
        assert generate != null : "fx:id=\"generate\" was not injected: check your FXML file 'screen.fxml'.";
        assert airlineCl != null : "fx:id=\"airlineCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert airline != null : "fx:id=\"airline\" was not injected: check your FXML file 'screen.fxml'.";
        assert numberCl != null : "fx:id=\"numberCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert number != null : "fx:id=\"number\" was not injected: check your FXML file 'screen.fxml'.";
        assert cityCl != null : "fx:id=\"cityCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'screen.fxml'.";
        assert dateCl != null : "fx:id=\"dateCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'screen.fxml'.";
        assert hourCl != null : "fx:id=\"hourCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert hour != null : "fx:id=\"hour\" was not injected: check your FXML file 'screen.fxml'.";
        assert doorCl != null : "fx:id=\"doorCl\" was not injected: check your FXML file 'screen.fxml'.";
        assert gate != null : "fx:id=\"gate\" was not injected: check your FXML file 'screen.fxml'.";
        assert searchType != null : "fx:id=\"searchType\" was not injected: check your FXML file 'screen.fxml'.";
        assert searchText != null : "fx:id=\"searchText\" was not injected: check your FXML file 'screen.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'screen.fxml'.";
        assert page != null : "fx:id=\"page\" was not injected: check your FXML file 'screen.fxml'.";

    }
}
