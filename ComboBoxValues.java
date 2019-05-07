import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

import javax.swing.*;

public class ComboBoxValues extends JFrame {

    FlightSchedule flight = new FlightSchedule();
    Flight flight1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JTextField text;
    private JTextArea text1;
    private JTextField text2;
    Time time;
    JComboBox combo;
    JComboBox combo2;
    JComboBox combo3;
    JComboBox combo4;
    JComboBox combo5;
    JComboBox combo6;
    JComboBox combo7;
    JComboBox combo8;// panel2 2
    JComboBox combo9; // panel2 2
    JButton Start; // panel2 2
    JButton Pause;// panel2 2
    JButton Stop;// panel2 2
    JButton Resume;
    JButton display; // panel 3 3
    JButton display1;
    JButton saveToDisk;
    JTextArea text5;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComboBoxValues frame = new ComboBoxValues();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public ComboBoxValues() {
        JTabbedPane tappedPane = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        panel5=new JPanel();
        Thread t=new Thread(new TimeThread());
        //Thread f=new Thread(new FlightThread(flight1));

        tappedPane.add(panel2,"Set Time");
        tappedPane.add(panel1,"Control Flights");
        tappedPane.add(panel3,"Display");
        tappedPane.add(panel4,"Display Time");
        tappedPane.add(panel5, "Flight Logs");
        add(tappedPane);
        // setContentPane(panel1);
        tappedPane.setBackground(Color.DARK_GRAY);
        panel1.setBackground(Color.DARK_GRAY);
        panel2.setBackground(Color.DARK_GRAY);
        panel3.setBackground(Color.DARK_GRAY);
        panel4.setBackground(Color.DARK_GRAY);
        panel5.setBackground(Color.DARK_GRAY);
        GridLayout gbl_contentPane = new GridLayout();
        panel1.setLayout(new GridLayout(4, 4));
        setTitle("Flight Tracker");
        panel5.setLayout(new GridLayout(25,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        combo8=new JComboBox();
        combo8.addItem("Hour");
        for(int i=0;i<24;i++)
        {
            combo8.addItem(i);
        }
        panel2.add(combo8,BorderLayout.LINE_START);
        combo9=new JComboBox();
        combo9.addItem("Minute");
        for(int i=0;i<60;i++)
        {
            combo9.addItem(i);
        }
        panel2.add(combo9,BorderLayout.LINE_START);
        combo7 = new JComboBox();
        combo7.addItem("Airline Codes");
        for (int i = 300; i <= 310; i++) {
            combo7.addItem(i);
        }
        panel1.add(combo7, BorderLayout.LINE_START);
        combo = new JComboBox();
        combo.addItem("Departure Airports");
        combo.addItem(Airports.ADANA);
        combo.addItem(Airports.ISTANBUL);
        combo.addItem(Airports.ANKARA);
        combo.addItem(Airports.ERZURUM);
        combo.addItem(Airports.DIYARBAKIR);
        panel1.add(combo, BorderLayout.LINE_START);
        combo2 = new JComboBox();
        combo2.addItem("Arrival Airports");
        combo2.addItem(Airports.ADANA);
        combo2.addItem(Airports.ISTANBUL);
        combo2.addItem(Airports.ANKARA);
        combo2.addItem(Airports.ERZURUM);
        combo2.addItem(Airports.DIYARBAKIR);
        panel1.add(combo2, BorderLayout.LINE_START);
        combo3 = new JComboBox();
        combo3.addItem("Departure Hour");
        for (int i = 1; i <= 24; i++)
            combo3.addItem(i);
        panel1.add(combo3, BorderLayout.CENTER);
        combo4 = new JComboBox();
        combo4.addItem("Departure Minute");
        for (int i = 1; i <= 60; i++)
            combo4.addItem(i);
        panel1.add(combo4, BorderLayout.CENTER);
        combo5 = new JComboBox();
        combo5.addItem("Arrival Hour ");
        for (int i = 1; i <= 24; i++)
            combo5.addItem(i);
        panel1.add(combo5, BorderLayout.LINE_END);
        combo6 = new JComboBox();
        combo6.addItem("Arrival Min");
        for (int i = 1; i <= 60; i++)
            combo6.addItem(i);
        panel1.add(combo6, BorderLayout.LINE_END);
        Start =new JButton("Start"); // PANEL 2
        Pause =new JButton("Pause");
        Stop =new JButton("Stop");
        Resume=new JButton("Resume");
        panel2.add(Start,BorderLayout.SOUTH);
        panel2.add(Pause,BorderLayout.SOUTH);
        panel2.add(Resume,BorderLayout.SOUTH);
        panel2.add(Stop,BorderLayout.SOUTH); // PANEL 2
        JButton add = new JButton("Add"); // PANEL 1
        panel1.add(add, BorderLayout.WEST); // PANEL 1
        display =new JButton("Display");
        saveToDisk=new JButton("SaveToDisk");
        panel3.add(saveToDisk);
        panel3.add(display,BorderLayout.NORTH);
        display1 =new JButton("Display");
        text1=new JTextArea("Time");
        panel4.add(text1,BorderLayout.LINE_START);
        panel4.add(display1,BorderLayout.CENTER);// PANEL 3;
        text2=new JTextField();
        pack();
        display.addActionListener(new ActionListener() { // DISPLAY BUTONU ICIN ACTIONLISTENER
            @Override
            public void actionPerformed(ActionEvent e) {

                for(Flight aflight : flight.getList()) {
                    text5=new JTextArea(aflight.toString());
                    panel3.add(text5);
                }

            }
        });

        saveToDisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    for(Flight aflight : flight.getList()) {
                        File dosya = new File("/Users/bugratuncer/Desktop/dosya.txt");
                        FileWriter yazici = new FileWriter(dosya, true);
                        BufferedWriter yaz = new BufferedWriter(yazici);
                        yaz.write(aflight.toString());
                        yaz.close();
                    }}
                catch(IOException a)
                {
                    a.printStackTrace();
                }

            }
        });

        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int hour = (int) (combo8.getSelectedItem());
                int min = (int) (combo9.getSelectedItem());
                time = new Time(hour,min,1);
                t.start();

            }});

        Pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time.setStat(0);
            }});

        Resume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time.setStat(1);
            }});

        Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }});

        display1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text1.setText("   "+Integer.toString(time.getHour())+":"+Integer.toString(time.getmin())+"   ");
            }});

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String AirlineCode = (combo7.getSelectedItem().toString());
                String Departure = (combo.getSelectedItem().toString());
                String Arrival = (combo2.getSelectedItem().toString());
                Integer DepartureHour = (Integer)(combo3.getSelectedItem());
                int DepartureMin = (int) (combo4.getSelectedItem());
                int ArrivalHour = (int) (combo5.getSelectedItem());
                int ArrivalMin = (int) (combo6.getSelectedItem());
                Airline airline= new Airline(AirlineCode);
                int status = 2; // S = Scheduled C = Cancelled
                flight1 = new Flight(airline,status, Departure, DepartureHour,DepartureMin,Arrival,ArrivalHour,ArrivalMin);
                int flightNumber = 100 + (int) (Math.random() * 300);
                flight.addFlight(flight1);
                text5=new JTextArea(flight1.toString());
                //flight.display();
                //f.start();
                (new Thread(new FlightThread(flight1))  ).start();
            }

        });

    }
    public class TimeThread implements Runnable {
        private AtomicInteger timeinint=new AtomicInteger(0);

        @Override
        public void run() {
            System.out.println("Starting " );
            int x= time.getHour()*60+time.getmin();
            timeinint.set(x);

            try {
                while(1==1) {
                    while(time.getStat()==1) {
                        timeinint.incrementAndGet();
                        System.out.println("Hour="+ ((timeinint.get()-(timeinint.get()%60))/60) + ":" + (timeinint.get()%60) );
                        time.setHour(((timeinint.get()-(timeinint.get()%60))/60));
                        time.setmin((timeinint.get()%60));
                        Thread.sleep(1000);
                    }
                    time.setmin((timeinint.get()%60));
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }

        }}

    public class FlightThread implements Runnable {

        int i,j,k,l,m;

        public Flight flight1;

        public FlightThread(Flight flight1) {
            this.flight1=flight1;
        }

        public void getInfo(Flight flight) {

            System.out.println(" "+flight.getStatus() );
        }

        public void run() {
            i=j=k=l=m=0;
            //System.out.println("Thread Run" );
            try {

             //   System.out.println(" Try ici" );
                while(flight1.getStatus()==2) {
                    if(i==0) {
                        //System.out.println(flight1.getDepartureairport()+"dan"+flight1.getArrivalairport()+"a"+flight1.getDeparturehour()+
                        //		":"+flight1.getDeparturemin()+" kalkıs saatli Ucus planlı bekliyor" );
                        text2=new JTextField();
                        text2.setBackground(Color.gray);
                        text2.setText("From : "+flight1.getDepartureairport()+" To : "+flight1.getArrivalairport()+" Hour : "+flight1.getDeparturehour()+
                                " Min : "+flight1.getDeparturemin()+" the plane is waiting to take off.");
                        panel5.add(text2);}
                    i=1;
                    int x=time.getHour()*60+time.getmin();
                    int y=flight1.getDeparturehour()*60+flight1.getDeparturemin();
                    if(x>=y)
                        flight1.setStatus(3);
                    Thread.sleep(7000);

                }

                while(flight1.getStatus()==3) {
                    if(j==0) {
                        //	System.out.println(flight1.getDepartureairport()+"dan"+flight1.getArrivalairport()+"a"+flight1.getDeparturehour()+
                        //		":"+flight1.getDeparturemin()+" kalkıs saatli Ucak havalanmistir" );
                        text2=new JTextField();
                        text2.setBackground(Color.green);
                        text2.setText("From : "+flight1.getDepartureairport()+" To : "+flight1.getArrivalairport()+" Hour : "+flight1.getDeparturehour()+
                                " Min : "+flight1.getDeparturemin()+" the plane has taken off.");
                        panel5.add(text2);}
                    j=1;
                    int x=time.getHour()*60+time.getmin();
                    int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                    if(x>=y-10)
                        flight1.setStatus(4);
                    Thread.sleep(7000);

                }

                while(flight1.getStatus()==4) {
                    int x=time.getHour()*60+time.getmin();
                    int y=flight1.getArrivalhour()*60+flight1.getArrivalmin();
                    if(k==0) {
                        text2=new JTextField();
                        text2.setBackground(Color.orange);
                        text2.setText("From : "+flight1.getDepartureairport()+" To : "+flight1.getArrivalairport()+" Hour : "+flight1.getDeparturehour()+
                                " Min : "+flight1.getDeparturemin()+" the plane is waiting for landing.");
                        panel5.add(text2);}k=1;


                    // System.out.println("On the queue for landing");
                    if(x>=y)
                        flight1.setStatus(5);
                    Thread.sleep(7000);
                }
                if(flight1.getStatus()==5) {
                    //System.out.println(flight1.getDepartureairport()+"dan"+flight1.getArrivalairport()+"a"+flight1.getDeparturehour()+
                    //	":"+flight1.getDeparturemin()+" kalkıs saatli Ucak inis yapmistir." );
                    text2=new JTextField();
                    text2.setBackground(Color.blue);
                    text2.setText("From : "+flight1.getDepartureairport()+" To : "+flight1.getArrivalairport()+" Hour : "+flight1.getDeparturehour()+
                            " Min : "+flight1.getDeparturemin()+" the plane landed.");
                    panel5.add(text2);
                }

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }}
    }
}
