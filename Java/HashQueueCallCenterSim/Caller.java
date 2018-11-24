/**
 * Caller class
 * @author Roger Robertson Jr.
 * @version 0.1
 */

public class Caller {
    /** caller id number */
    private int id;
    /** first name */
    private String firstName;
    /** last name */
    private String lastName;
    /** email address */
    private String email;
    /** phone number */
    private String phone;
    /** flag indicating if a caller has been paired with a tech */
    private boolean isBusy;
    
    /**
     * Caller constructor
     * @param id the id
     * @param firstName caller's first name
     * @param lastName caller's last name
     * @param email caller's email address
     * @param phone caller's phone number
     */
    public Caller(int id, String firstName, String lastName, String email, String phone) {
        this. id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        isBusy = false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return firstName + " " + lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setBusy(boolean busy) {
        isBusy = busy;
    }
    
    public boolean getBusy() {
        return isBusy;
    }
}