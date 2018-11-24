
/**
 * Write a description of class Main here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class Main {
    
    
    public static void main(String[] args) {
        Wearables testWear = new Wearables();
        //System.out.println(testWear.getWearableAtIndex(235).getName());
        testWear.generateCsv(testWear.getRankingPositionData(), "ranking");
        testWear.generateCsv(testWear.getPricingData(), "pricing");
        testWear.generateCsv(testWear.getCoNameData(), "coname");
    }
}
