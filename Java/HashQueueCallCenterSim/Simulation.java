import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
/**
 * Simulation class
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Simulation {
    /** initial number of callers */
    private int initialQueue;
    /** how long before a new call */
    private long callInterval;
    /** number of calls to simulate */
    private int iterations;
    /** callers */
    private ArrayList<Caller> callers;
    /** techs */
    private ArrayList<Tech> techs;
    /** callers in queue */
    private HashQueue<Caller> callQueue;
    /** available techs */
    private HashQueue<Tech> techQueue;
    
    /**
     * Constructor
     */
    public Simulation () {
        System.out.print("\u000c");
        System.out.println("--::WELCOME TO THE SOPHOCLES CALL CENTER SIM::--");
        System.out.println("How many callers are in the queue?");
        Scanner userScan = new Scanner(System.in);    
        while (!userScan.hasNextInt()) {
            try {
                initialQueue = userScan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Invalid input; please enter a positive integer.");
                userScan.nextLine();
            }
        }
        userScan.nextLine();
        System.out.println("How many milliseconds between calls?");
        while (!userScan.hasNextLong()) {
            try {
                callInterval = userScan.nextLong();
            } catch (InputMismatchException e) {
                System.err.println("Invalid entry, please try again.");
                userScan.nextLine();
            }
        }
        userScan.nextLine();
        System.out.println("How many iterations would you like?");
        while (!userScan.hasNextInt()) {
            try {    
                iterations = userScan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Invalid entry, please try again.");
                userScan.nextLine();
            }
        }
        userScan.close();
        Timer timer = new Timer();
        TimerTask task = new Task();
        timer.schedule(task, callInterval);
        
        callers = new ArrayList<>();
        techs = new ArrayList<>();
        
        try {
            Scanner callScan = new Scanner(new File("callers.csv"));
            callScan.useDelimiter(",|\n");
            callScan.nextLine();
            while (callScan.hasNext()) {
                callers.add(new Caller(callScan.nextInt(), callScan.next(), 
                    callScan.next(), callScan.next(), callScan.next())); 
            }
            callScan.close();
        } catch (FileNotFoundException e) {
            
        }
        
        try {
            Scanner techScan = new Scanner(new File("techs.csv"));
            techScan.useDelimiter(",|\n");
            techScan.nextLine();
            while (techScan.hasNext()) {
                techs.add(new Tech(techScan.next(), techScan.next(), 
                    techScan.next(), techScan.next(), techScan.nextInt()));
            }
            techScan.close();
        } catch (FileNotFoundException e) {
            
        }
        
        int callerCount = 0;
        while (callerCount != initialQueue) {
            callQueue.add(callers.get((int)Math.random() * callers.size()));
        }
    }
    
    /**
     * Pair a tech with a caller; mark both as busy
     * @param tech the tech
     * @param caller the caller
     */
    public void pair(Tech tech, Caller caller) {
        
    }
    
    public void insert(Tech tech) {
        
    }
    
    public void insert(Caller caller) {
        
    }
    
    public void remove(Tech tech) {
        
    }
    
    public void remove(Caller caller) {
        
    }
    
    private class Task extends TimerTask {
        public void run() {
            
        }
    }
}