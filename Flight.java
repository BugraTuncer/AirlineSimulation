
public class Flight {

    Time time;
    private Airline airline;
    private int status; // 1=cancelled 2=scheduled, 3=on the air, 4=waiting for landing, 5=landed
    private String departureairport;
    private int departurehour;
    private int departuremin;
    private String arrivalairport;
    private int arrivalhour;
    private int arrivalmin;

    static public final int SORT_BY_DEPARTURE_TIME = 1;
    static public final int SORT_BY_ARRIVAL_TIME = 2;
    static private int sortBy = SORT_BY_DEPARTURE_TIME;

    public Flight() {
    }


    public Flight(Airline airline, int status, String departureairport, int departurehour, int departuremin, String arrivalairport, int arrivalhour, int arrivalmin) {
        this.airline = airline;
        this.status = status;
        this.departureairport = departureairport;
        this.departurehour = departurehour;
        this.departuremin = departuremin;
        this.arrivalairport = arrivalairport;
        this.arrivalhour = arrivalhour;
        this.arrivalmin = arrivalmin;
    }

    // operations
    public Airline getAirline() {
        return airline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int i) {
        status = i;
    }

    public String getDepartureairport() {
        return departureairport;
    }

    public int getDeparturehour() {
        return departurehour;
    }

    public int getDeparturemin() {
        return departuremin;
    }

    public String getArrivalairport() {
        return arrivalairport;
    }

    public int getArrivalhour() {
        return arrivalhour;
    }

    public int getArrivalmin() {
        return arrivalmin;
    }

    public void setDepartureairport(String departureairport) {
        this.departureairport = departureairport;
    }

    public void setDeparturehour(int departurehour) {
        this.departurehour = departurehour;
    }

    public void setDeparturemin(int departuremin) {
        this.departuremin = departuremin;
    }

    public void setArrivalairport(String arrivalairport) {
        this.arrivalairport = arrivalairport;
    }

    public void setArrivalhour(int arrivalhour) {
        this.arrivalhour = arrivalhour;
    }

    public void setArrivalmin(int arrivalmin) {
        this.arrivalmin = arrivalmin;
    }

    public String getDepartureInfo() {
        return "Airline" + airline.getCode() + "Status" + status + "DepartureInfo" + departureairport;
    }

    public String getArrivalInfo() {
        return "Airline" + airline.getCode() + "Status" + status + "ArrivalInfo" + arrivalairport;
    }


    @Override
    public String toString() {
        return "Airline Code " + airline.getCode() + "\nStatus " + status + "\nDeparture Airport " + departureairport + "\nArrival Airport " + arrivalairport + "\nDeparture Hour " + departurehour + "\nDeparture Min " + departuremin + "\nArrival Hour " + arrivalhour + "\nArrival Min " + arrivalmin;
    }
}

