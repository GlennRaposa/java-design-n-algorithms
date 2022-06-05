package com.string;

import java.util.Arrays;

public class RemovingWhiteSpaces
{
	
	 // removes spaces from given string
    public static String removeSpaces(String str)
    {
        char[] charArray = str.toCharArray();
         
        int numSpaces = 0; // number of spaces before 'i'th character  
        for (int i = 0; i < charArray.length; i++)
        {
            // count number of spaces
            if (charArray[i] == ' ') 
            {
                numSpaces += 1;
            }
            // put 'i'th character into its correct position after removing spaces before it
            else
            {
                charArray[i-numSpaces] = charArray[i];
            }
        }
         
        // all the spaces are moved towards the end of the string. 
        // Create new string by using non-space characters
        System.out.println(Arrays.toString(charArray)+"  numsapces:"+numSpaces);
        charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);
        return new String(charArray);
    }
     
     
    public static void main(String[] args)
    {
        String strWithSpaces    = "  Hi there, how  are you   doing? ";
        String strWithoutSpaces = removeSpaces(strWithSpaces);
         
        System.out.println(strWithoutSpaces);
    }
    
    
 
}
