import java.util.*;

/**
 * Implementation of the Sieve
 * @author Roger Robertson
 * @version Standard
 */

public class MySieve implements Sieve {
  
  java.util.ArrayList<Integer> numberList = new ArrayList<Integer>();
  java.util.ArrayList<Integer> primesList = new ArrayList<Integer>();
 
  
  public java.util.ArrayList<Integer> getPrimes(int n) {
    
    double m = Math.sqrt(n);
    // fill the list
    // start at 2
    for(int i = 2; i<=n; i++) {
      numberList.add(i);
    }
    // check list for primes
    int currentPrime = numberList.get(0);
    // less that M
    while(currentPrime <= m) {
      primesList.add(currentPrime);
    for(int i = 0; i<numberList.size(); i++) {
      // if evenly divisible by current prime
     if(numberList.get(i) % currentPrime == 0) {
       // number is not prime; remove from list
       numberList.remove(i);
     }
     }
     // new first prime
     currentPrime = numberList.get(0);
     }
    // add remaining numberList to primesList
    for(int x =0; x<numberList.size(); x++) {
      primesList.add(numberList.get(x));
    }
    // IMPORTANT otherwise there's a bunch of garbage on subsequent runs
    numberList.clear();
 
  return primesList;
  
    }



}
 
  