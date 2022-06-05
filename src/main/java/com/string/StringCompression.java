package com.string;

import java.util.Arrays;
  
//UnFinished 
public class StringCompression {

 public static void compressString (String string) 
 {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < string.length(); i++) {
        int count = 1;
        while (i + 1 < string.length()
                && string.charAt(i) == string.charAt(i + 1)) {
            count++;
            i++;
        }
        if (count > 1) {
            stringBuffer.append(count);
        }
        stringBuffer.append(string.charAt(i));
    }
    System.out.println("Compressed string: " + stringBuffer);
  } 
  
  
  public static void main(String[] args) {
    	compressString("hellooopppppp"); // Compressed string: he2l3o6p
  }
	

}
