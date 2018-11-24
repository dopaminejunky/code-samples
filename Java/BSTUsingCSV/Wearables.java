import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
/**
 * Write a description of class Wearables here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Wearables {
    /** master array of wearable devices */
    private Wearable[] wearableArray;
    /** list of devices sorted by rank */
    private UniqueTree<Integer> ranking;
    /** list of devices sorted by price */
    private NonUniqueTree<Double> price;
    /** list of devices sorted by company name */
    private NonUniqueTree<String> companyName;
    /**
     * Constructor for objects of class Wearables
     */
    public Wearables() {
        ranking = new UniqueTree<>();
        price = new NonUniqueTree<>();
        companyName = new NonUniqueTree<>();
            try {
                Scanner scan = new Scanner(new File("Wearables.txt"));
                scan.useDelimiter("@|\n");
                wearableArray = new Wearable[582];
                int count = 0;
                scan.nextLine();
                scan.nextLine();
                while (scan.hasNext()) {
                    wearableArray[count] = new Wearable(scan.nextInt(), scan.next(), scan.nextDouble(),
                        scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
                        scan.next(), scan.next(), scan.next());
                    ranking.add(wearableArray[count].getRanking(), count);
                    price.add(wearableArray[count].getPrice(), count);
                    companyName.add(wearableArray[count].getCompanyName(), count);
                    count++;
                }
        } catch (FileNotFoundException e) {
            // do nothing; empty array means something went wrong
        }
    }

    /**
     * Get a wearable by index
     * @param index the wearable index
     * @return the wearable
     */
    public Wearable getWearableAtIndex(int index) {
        return wearableArray[index];
    }
    
    
    /**
     * Get the ranking data as an array
     * @return positions sorted by rank
     */
    public int[] getRankingPositionData() {
        return ranking.getPositionData();
    }
    
    /**
     * Get the pricing data as an array
     * @return positions sorted by price
     */
    public int[] getPricingData() {
        return price.getPositionData();
    }
    
    /**
     * Get company name data as an array
     * @return positions sorted by company name
     */
    public int[] getCoNameData() {
        return companyName.getPositionData();
    }
    
    /**
     * Generate a CSV file based on data
     * @param data the data to be written
     * @param filename name of output file
     * @return boolean for success or failure
     */
    public boolean generateCsv(int[] data, String filename) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(filename + ".csv"));
            for (int count = 0; count < data.length - 2; count++) {
                out.print(wearableArray[data[count]].toString() + "\n" );
            }
            out.print(wearableArray[data[data.length -1]]);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
}
