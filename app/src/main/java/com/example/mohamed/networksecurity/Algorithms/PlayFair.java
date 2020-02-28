package com.example.mohamed.networksecurity.Algorithms;

import android.inputmethodservice.Keyboard;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by mohamed on 11/9/2018.
 */
    // 1 - create the key
    // 2- prepare the plain text
    // 3- convert plaintext to ciphertext
public class PlayFair {
    final static private int ROW=0;
    final static private int COLUMN=1;

    public static String Encript(String key, String plainText)
    {
       ArrayList<Character> myKey= crateMatrix(key);
       plainText=preparePlainText(plainText);
        String cipherText = convertPlainTextToCipherText(plainText,myKey);
        return cipherText;

    }

    private static ArrayList<Character> crateMatrix(String key) {
        ArrayList<Character> finalKey = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            if (finalKey.contains((Character) key.charAt(i)) == false) {
                finalKey.add(key.charAt(i));
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (!finalKey.contains((i))) {
                finalKey.add(i);
            }
        }
        finalKey.remove('i');
        return finalKey;
    }

    private static String preparePlainText(String plainText) {
        StringBuilder finalPlainText= new StringBuilder();
        plainText= plainText.replace('i','j');
        for (int i = 0; i < plainText.length(); i += 2) {
            finalPlainText.append(plainText.charAt(i));
            if((i+1)<plainText.length()) {
                if (plainText.charAt(i) == plainText.charAt(i + 1)) {
                    finalPlainText.append('x');
                }
                finalPlainText.append(plainText.charAt(i+1));
            }
        }
        if(finalPlainText.toString().length()%2==1) {
            finalPlainText.append('x');
        }
         return  finalPlainText.toString();
     }
     private static String convertPlainTextToCipherText(String plainText,ArrayList<Character> key)
     {
         int [] firstCharPosition= new int[2];
         int [] secondCharPosition= new int[2];
         StringBuilder chiperText = new StringBuilder();

         for(int i =0;i<plainText.length();i+=2)
         {
                firstCharPosition= getPosition(plainText.charAt(i),key);
                secondCharPosition= getPosition(plainText.charAt(i+1),key);
                String ouputTwoChar =crateText(firstCharPosition,secondCharPosition,key);
               chiperText.append(ouputTwoChar );

          }
          return chiperText.toString();
     }

     private static int [] getPosition(char c ,ArrayList<Character> key)
     {
         int index = key.indexOf(c);
         int [] position = new int[2];
         position[ROW]=index/5;
         position[COLUMN]=index%5;

         return position;
     }
     private static String crateText(int[] firstChar,int [] secondChar,ArrayList<Character> key)
     {      int firstposition , secondposition;
           StringBuilder builder = new StringBuilder();
         if(firstChar[ROW]==secondChar[ROW])
         {     firstChar[COLUMN]++;
             secondChar[COLUMN]++;
          if(firstChar[COLUMN]==5)
              firstChar[COLUMN]=0;
          if(secondChar[COLUMN]==5)
              secondChar[COLUMN]=0;
         }
         else if(firstChar[COLUMN]==secondChar[COLUMN])
         {      firstChar[ROW]++;
              secondChar[ROW]++;
             if(firstChar[ROW]==5)
                 firstChar[ROW]=0;
             if(secondChar[ROW]==5)
                 secondChar[ROW]=0;

         }
         else
         {
              int temp =firstChar[COLUMN];
              firstChar[COLUMN]=secondChar[COLUMN];
              secondChar[COLUMN]=temp;

         }
         firstposition= firstChar[ROW]*5+firstChar[COLUMN];
         secondposition=secondChar[ROW]*5+secondChar[COLUMN];
         builder.append(key.get(firstposition));
         builder.append(key.get(secondposition));
         return builder.toString();
     }
}
