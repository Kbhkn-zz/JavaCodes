package com.kbhkn.utility;

public class CheckTCIdentificationNo {
  final static String TC_IDENTIFICATION_NO_PATTERN = "^[1-9]{1}[0-9]{10}$";

  public boolean isValid(String tcKimlikNo) {
    if (!tcKimlikNo.matches(TC_IDENTIFICATION_NO_PATTERN))
      return false;

    int totalOddIndex = 0, totalEvenIndexs = 0, total = 0;
    int digit10 = Character.getNumericValue(tcKimlikNo.charAt(9));
    int digit11 = Character.getNumericValue(tcKimlikNo.charAt(10));
    int value = -1;
    
    for (int i = 0; i < 9; i++) {
      value = Character.getNumericValue(tcKimlikNo.charAt(i));

      if (i % 2 == 0)
        totalOddIndex += value;
      else
        totalEvenIndexs += value;

      total += value;
    }

    int newDigit10 = ((totalOddIndex * 7) - totalEvenIndexs) % 10;

    return (digit10 == newDigit10) && (digit11 == (total + newDigit10) % 10);
  }
}