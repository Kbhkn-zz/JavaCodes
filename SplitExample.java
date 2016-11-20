package com.kbhkn;

import java.util.Hashtable;

/**
 * @author kbhkn
 */
public class SplitExample {
  public static final String TEST_DATA = "Gorev{coordinateId=6, userId=0, coordinateX='44', coordinateY='45', getTimeCoordinate=null, reachingTimeCoordinate=null, customerName='Cagdas', customerLastName='Kerem', customerTcNo='11111111111', cargoPay=120.0, delivery='edilmedi'}";

  //arg = TEST_DATA
  public static Hashtable<String,String> getHash(String arg){
    Hashtable<String, String> hash = new Hashtable<String, String>();

    String[] parts = arg.replaceAll("[{}]","_").replaceAll("['\\s+]", "").trim().split("_")[1].split(",");
    /**
     * Manually split the JSON data for Hash (Key, Value) pairing.
    */
    for (String s : parts) {
      hash.put(s.split("=")[0], s.split("=")[1]);
    }
    
    //Check Hash.
    System.out.println(hash.get("customerTcNo"));
    System.out.println(hash.get("coordinateY"));

    return hash;
  }
}
