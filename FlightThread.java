
public class FlightThread implements Runnable {

    Flight flight1;
    Time time;
    public void getInfo(Flight flight) {
        System.out.println(" "+flight.getStatus() );
    }

    public void run() {

        System.out.println(" asdqweasdqwe" );

        try {
            System.out.println(" asdqweasdqwe" );
            while(flight1.getStatus()==2) {
                int x=time.getHour()*60+time.getmin();
                int y=flight1.getDeparturehour()*60+flight1.getDeparturemin();
                if(x<=y)
                    flight1.setStatus(3);
                Thread.sleep(2000);

            }

            while(flight1.getStatus()==3) {
                int x=time.getHour()*60+time.getmin();
                int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                if(x>=y-10)
                    flight1.setStatus(4);
                Thread.sleep(2000);

            }

            while(flight1.getStatus()==4) {
                int x=time.getHour()*60+time.getmin();
                int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                System.out.println("On the quee for landing");
                if(x>=y)
                    flight1.setStatus(5);
                Thread.sleep(2000);
            }
            if(flight1.getStatus()==4) {
                System.out.println(flight1.toString()+"  has landed");
            }

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }}




}
