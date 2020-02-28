package com.example.mohamed.networksecurity.Algorithms;

/**
 * Created by mohamed on 10/19/2018.
 */

public class CeaserSipher {
    public static String getEncriptedText(int key, String inputString)
    {     inputString.toLowerCase();
        StringBuilder outputString = new StringBuilder();
        for(int i =0;i<inputString.length();i++)
        {
            if(inputString.charAt(i)==' ') {
                outputString.append(' ');
                continue;
            }
            else
            {
                char c =(char) ( ( ( (int)inputString.charAt(i) -  (int)'a' )+ key ) %26+'a');
                outputString.append(c+"");
            }

        }
        return  outputString.toString();
    }

    public static String getDecription(int key, String inputString)
    {
        inputString.toLowerCase();
        StringBuilder outputString = new StringBuilder();
        for(int i =0;i<inputString.length();i++)
        {
            if(inputString.charAt(i)==' ') {
                outputString.append(' ');
                continue;
            }
            else
            {      int numberIndex=(int)inputString.charAt(i) -  (int)'a' -key ;
                       numberIndex=numberIndex >=0 ? numberIndex:numberIndex+26;
                char c =(char) (  numberIndex  +'a');
                outputString.append(c+"");
            }

        }
        return  outputString.toString();
    }
}
