package com.kbhkn;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * @author kbhkn
 */
public class JavaOptionalExample {
  private final static Integer[] INT_ARRAY = { null, 4, 1, 2, null, 12, null, 5, 3 };
  
  volatile static Integer power = 5;
  volatile static Integer power2 = null;

  public static void main(String[] args) {
    printByArray(INT_ARRAY);

    //Throw NullPointerException
    printByArray(new Integer[]{});
    
    getSumByArrayWithPowered(Optional.ofNullable(INT_ARRAY), Optional.ofNullable(power));
    
    //Throw Exception..
    getSumByArrayWithPowered(Optional.ofNullable(INT_ARRAY), Optional.ofNullable(power2));
  }

  public static void printByArray(Integer[] arr) {
    Arrays.asList
      (
        //Array is null or null Object ? Example (null, new Integer[]{})
        Optional.ofNullable(arr).orElseThrow(() -> new NullPointerException("Array can't be null. "))
      )
      .stream()// to stream ;)
      .filter(Objects::nonNull)//One of the elements may be null. Example (new Integer[]{1 ,2, null, 3, 4})
      .sorted()//I like it..
      .forEach(System.out::println);//Show all the elements in the list.
  }

  public static int getSumByArrayWithPowered(Optional<Integer[]> arr, Optional<Integer> power) {
    if (arr.isPresent() && power.isPresent()) {// check it, is null ?
      return Arrays.asList(arr.get())//get array and convert list.
          .stream()
          .filter(Objects::nonNull)
          .map(x -> x = (int) Math.pow(x, power.get()))// each elements multiplied by whatever number.
          .reduce(0, Integer::sum);// Finally, sum the list.
    }
    
    throw new NullPointerException("Array or power can't be null!");
  }
}
