import java.util.*;

public class FlightSchedule {

    private int currentTime;
    private ArrayList< Airline> airlines;
    private ArrayList< Flight> flightMap;

    // constructors
    public FlightSchedule() {
        airlines = new ArrayList< Airline>();
        flightMap = new ArrayList<Flight>();
    }
    // operations
    public void addFlight(Flight flight ) {
        flightMap.add(flight);
    }
    public boolean doesAirlineCodeExits(String code) {
        for (Airline airline : airlines) {
            if (code.equals(airline.getCode())) {
                return true;
            }
        }
        return false;
    }

    public void addAirline(String airlineCode) {
        Airline air = new Airline(airlineCode);
        airlines.add(air);
    }

    public int getCurrentTime()
    {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {

        this.currentTime = currentTime;
    }
    public void display()
    {
        for(int i=0;i<flightMap.size();i++)

            System.out.println(flightMap.get(i));

    }
    public Flight[] toArray() {

        Flight[] it = new Flight[flightMap.size()];

        for(int i = 0; i < flightMap.size(); i++) {
            it[i] = flightMap.get(i);
        }
        return it;
    }

    public ArrayList<Flight> getList() {
        return flightMap;
    }

}