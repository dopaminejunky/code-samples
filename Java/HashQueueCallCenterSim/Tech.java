
/**
 * Technician class
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Tech {
    /** tech id number */
    private String id;
    /** first name */
    private String firstName;
    /** last name */
    private String lastName;
    /** user name */
    private String userName;
    /** day off */
    private int dayOff;
    /** busy flag */
    private boolean isBusy;
    
    /**
     * Constructor
     * @param id the id
     * @param firstName first name
     * @param lastName last name
     * @param userName user name
     * @param dayOff day off
     */
    public Tech( String id, String firstName, String lastName, String userName, int dayOff) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dayOff = dayOff;
        isBusy = false;
    }
    
    /**
     * Get tech's id
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Get tech's name
     * @return tech's name
     */
    public String getName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Get tech's user name
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }
    
    /** 
     * Get tech's day off
     * @return int indicating day off
     */
    public int getDayOff() {
        return dayOff;
    }
    
    /**
     * Set busy flag
     * @param busy boolean for busy status
     */
    public void setBusy(boolean busy) {
        isBusy = busy;
    }
    
    /**
     * Get tech's busy status
     * @return boolean busy status
     */
    public boolean getBusy() {
        return isBusy;
    }
}