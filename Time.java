import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Time implements Runnable{
    private int hour,min;
    private Thread t;
    private AtomicInteger timeinint=new AtomicInteger(0);
    private int stat;


    public Time(int hour,int min,int stat) {
        this.hour=hour;
        this.min=min;
        this.stat=stat;

    }
    public void run() {
        System.out.println("Starting " );
        int x= hour*60+min;
        timeinint.set(x);

        try {
            while(true) {
                while(stat==1) {
                    timeinint.incrementAndGet();
                    //System.out.println("saat="+ ((timeinint.get()-(timeinint.get()%60))/60) + ":" + (timeinint.get()%60) );
                    Thread.sleep(1000);
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public int getHour() {
        return hour;
    }
    public int getStat() {
        return stat;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getmin() {
        return min;
    }

    public void setmin(int min) {
        this.min = min;
    }

    public void setStat(int i) {
        stat=i;

    }
    public String aString() {
        String x= new String(Integer.toString(hour)+":"+Integer.toString(min));
        return x;

    }

}

