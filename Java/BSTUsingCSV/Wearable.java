
/**
 * Write a description of class Wearable here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Wearable {
    /** ranking in master array */
    private int ranking;
    /** name of device */
    private String name;
    /** msrp */
    private double price;
    /** where device is worn */
    private String bodyLocation;
    /** type of device */
    private String category;
    /** company name */
    private String companyName;
    /** company website */
    private String companyUrl;
    /** company location */
    private String companyLocation;
    /** company city */
    private String companyCity;
    /** company US state or "non-US" if international */
    private String companyState;
    /** company country */
    private String companyCountry;
    /**
     * Constructor for objects of class Wearable
     * @param newRank the ranking in the master array
     * @param newName the name of the device
     * @param newPrice msrp of device
     * @param newBodyLocation where device is worn
     * @param newCategory type of device
     * @param newCompanyName the name of the company
     * @param newCompanyUrl company website
     * @param newCompanyLocation company location
     * @param newCompanyCity the company home city
     * @param newCompanyState US state or "non-US" if international
     * @param newCompanyCountry company country
     */
    public Wearable(int newRank, String newName, double newPrice, 
        String newBodyLocation,String newCategory, String newCompanyName,
        String newCompanyUrl, String newCompanyLocation, String newCompanyCity,
        String newCompanyState, String newCompanyCountry) {
            ranking = newRank;
            name = newName;
            price = newPrice;
            bodyLocation = newBodyLocation;
            category = newCategory;
            companyName = newCompanyName;
            companyUrl = newCompanyUrl;
            companyLocation = newCompanyLocation;
            companyCity = newCompanyCity;
            companyState = newCompanyState;
            companyCountry = newCompanyCountry;
        
    }

    /**
     * Get the ranking
     * @return the ranking
     */
    public int getRanking() {
        return ranking;
    }
    
    /**
     * Get the name
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the price
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Get body location
     * @return body location
     */
    public String getBodyLocation() {
        return bodyLocation;
    }
    
    /**
     * Get category
     * @return category information
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Get company name
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }
    
    /**
     * Get company URL
     * @return the company URL
     */
    public String getCompanyUrl() {
        return companyUrl;
    }
    
    /**
     * Get company location
     * @return the company location
     */
    public String getCompanyLocation() {
        return companyLocation;
    }
    
    /**
     * Get company city
     * @return the company home city
     */
    public String getCompanyCity() {
        return companyCity;
    }
    
    /**
     * Get company US state, or "non-US" if international
     * @return the company home state
     */
    public String getCompanyState() {
        return companyState;
    }
    
    /**
     * Get company country
     * @return the company home country
     */
    public String getCompanyCountry() {
        return companyCountry;
    }
    
    /**
     * To string method
     * @return string of wearable data
     */
    public String toString() {
        return ranking + "," + name + "," + companyUrl + "," + companyLocation + ","
                + companyCity + "," + companyState + "," + companyCountry;    
    }
}
