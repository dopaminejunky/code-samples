/**
 * A program to give statistics about a text
 * @author Dan Jinguji
 * @author Roger Robertson
 * @version Standard
 */

import java.util.*;

public class WordCount {
  
  /**
   * The statistic algorithm
   * @param text The text file to read through
   */
  public static void tokenCount(String text) {
    
    java.util.Scanner scan;
    java.util.HashMap<String, Integer> map;
    
    // open the file for reading using Scanner
    // try to process input
    try {
      scan = new java.util.Scanner(new java.io.File(text));
    
    map = new java.util.HashMap<>();
    // process the file, token by token
    while(scan.hasNext()) {
      String token = scan.next();
      // check if token exists
      if(map.containsKey(token)) {
        map.put(token, map.get(token) +1);
      } else {
      // new token entry
      map.put(token, 1);
      }
    }
      
    
    // close the file
    scan.close();
    // output statistics
    System.out.println(text+ " : " + map.size() + " tokens");
    System.out.println();
    Set<String> keySet = map.keySet();
    Iterator<String> it = keySet.iterator();
    while(it.hasNext()){
      String token = it.next();
      int i = map.get(token);
      if(i >=2) {
    System.out.println(i + "  : " + token);
      }
    }
    System.out.println();
    System.out.println();
  }  // catch invalid input and return error message
    catch(java.io.FileNotFoundException e) {
      System.out.println(text + " not found.");
      System.out.println();
      
    }
  }
  
  /**
   * The main method
   * Handles multiple arguments
   * @param args command line arguments
   */
  public static void main(String[] args) {
    for(int i=0; i<args.length; i++) {
       tokenCount(args[i]);
    }
    
  }
  
}
