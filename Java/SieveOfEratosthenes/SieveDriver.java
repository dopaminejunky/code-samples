/**
 * The driver for the Sieve 
 * @author Dan Jinguji
 * @author Roger Robertson
 * @version Standard
 */

public class SieveDriver {
   
   private java.util.Scanner scan;
   private Sieve theSieve;
   

   
   /**
    * The constructor
    */
   public SieveDriver() {
     scan = new java.util.Scanner(System.in);
     theSieve = new MySieve();
   }
   
   /*
    * The go function
    * Implements scanner
    * Gets upper bound
    * Calls print function on upper bound and list of primes
    */
   public void go() {
      
      java.util.List<Integer> primes;
      
     
      int n = getNumber();
      // update for continual input prompts
      if(n == 0){
        System.exit(0);
      } else {
      while(n != 0) {
      primes = theSieve.getPrimes(n);
      printPrimes(n, primes);
      n = getNumber();
      }
      }
   }
      
   
   /**
    * Scanner implementation
    * @return n the upper bound
    */
   public int getNumber() {
      System.out.print("Enter the upper bound:  (0 to exit)");
      // input validation
      while (!scan.hasNextInt()) { scan.next();
      System.out.println("Invalid input. Enter the upper bound: (0 to exit)");
      }
      int n = scan.nextInt();
      while(n != 0 && n < 2) {
        System.out.println("Invalid input. Enter the upper bound: (0 to exit)");
        n = scan.nextInt();
      } 
      return n;
   }
   
   /**
    * Print function
    * @param bound the upper bound
    * @param primesList
    * the primes list
    */
   public void printPrimes(int n, java.util.List<Integer> primesList) {
      System.out.println("The primes up to " + n + " are:");
      java.util.Iterator<Integer> it = primesList.iterator();
      int i = 0;
      while(it.hasNext()) {
          System.out.print(it.next() + " ");
          i++;
          if( i % 12 == 0) {
            System.out.println();
          }
      }
      System.out.println();
      // percentage that are prime
      double size = (primesList.size()* 100)/n;
      System.out.println(Math.round(size)
                           + "% of the numbers between 1 and " 
                           + n + " are prime.");
      System.out.println();
      primesList.clear();
      
   }
   
   /**
    * The main function
    * @param args the command line arguments
    */
   public static void main(String[] args) {
   
      new SieveDriver().go();
      
   }
   
}