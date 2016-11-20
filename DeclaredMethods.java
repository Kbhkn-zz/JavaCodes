package com.kbhkn;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by kbhkn on 27.10.2016 19:31.
 */

/**
  * Example: 
  * ThreadMXBean threadMXBean = ManagementFactory.newPlatformMXBeanProxy(remote, ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);
  * Read all thread information of the JVM and Show the information the methods contain.
  * 
  * printAllDeclaredMethodsWithValue(threadMXBean);
  *     getThreadCount = 20
  *     getPeakThreadCount = 20
  *     getTotalStartedThreadCount = 22
  *     getDaemonThreadCount = 19
*/


public class DeclaredMethods {
  /**
  * Show all methods with values, starting with getXXX.
  */
  public static void printAllDeclaredMethodsWithValue(Object obj){
    for (Method method : obj.getClass().getDeclaredMethods()) {
      method.setAccessible(true);

      if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
        Object value;
        
        try {
          value = method.invoke(obj);
        } catch (Exception e) {
          value = e;
        }

        System.out.println(String.format("%s = %s", method.getName(), value));
      }
    }
  }
}