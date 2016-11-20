package com.kbhkn.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.kbhkn.CheckTCIdentificationNo;

public class UnitTestForTC {
  CheckTCIdentificationNo tc = null;

  public UnitTestForTC() {
    tc = new CheckTCIdentificationNo();
  }

  @Test
  public void test1() {
    // Atatürk'ün TC Kimlik Numarası.
    assertTrue(tc.isValid("10000000146"));
  }

  @Test
  public void test2() {
    assertFalse("T.C. identity number can't start with 0!", tc.isValid("05409523211"));
  }

  @Test
  public void test3() {
    assertFalse("It can only consist of numbers!", tc.isValid("254asd12333"));
  }

  @Test
  public void test4() {
    assertFalse("T.C. identity number should be 11 digits!", tc.isValid("123123"));
  }

  @Test
  public void test5() {
    assertTrue(tc.isValid("23455495894"));
  }

  /*
    @Test
    public void test6() {
     assertNotNull("It can't be null.", tc);
    }
  */
}