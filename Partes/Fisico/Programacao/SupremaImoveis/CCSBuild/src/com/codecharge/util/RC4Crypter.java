//ccsRc4 implementation class @0-D73EE79D

package com.codecharge.util;

public class RC4Crypter {

    int[] cipherBox = new int[256];

    int[] cipherKeyArray = new int[256];
    
    
    public String encrypt (String key, String data ) {
        return toHex (apply(key, data));
    }
    
    public String decrypt (String key, String data ) {
        return apply(key, toStr (data));
    }   

    private String apply(String cipherKey, String unencodedText) {
        int z = 0;
        int t = 0;
        int i = 0;
        int cipherBy = 0;
        int tempInt = 0;
        String cipher = "";
        char cipherText;

        initKey(cipherKey);

        for (int a = 0; a < unencodedText.length(); a++) {

            i = (i + 1) % 256;
            t = (t + cipherBox[i]) % 256;
            tempInt = cipherBox[i];
            cipherBox[i] = cipherBox[t];
            cipherBox[t] = tempInt;

            z = cipherBox[(cipherBox[i] + cipherBox[t]) % 256];
            cipherText = unencodedText.charAt(a);
            cipherBy = (int) cipherText ^ z;
            cipher = cipher + (char) cipherBy;
        }
        return cipher;

    }

    private void initKey(String thisKey) {
        cipherBox = new int[256];
        cipherKeyArray = new int[256];

        int keyLength = 0;
        int dataSwap;
        int b;
        int asciiVal = 0;
        char asciiChar;
        keyLength = thisKey.length();

        for (int a = 0; a < 255; a++) {
            asciiChar = thisKey.charAt(a % keyLength);
            asciiVal = (int) asciiChar;
            cipherKeyArray[a] = asciiVal;
            cipherBox[a] = a;
        }
        b = 0;
        for (int a = 0; a < 255; a++) {

            b = (b + cipherBox[a] + cipherKeyArray[a]) % 256;
            dataSwap = cipherBox[a];
            cipherBox[a] = cipherBox[b];
            cipherBox[b] = dataSwap;
        }
    }
    
    
    
    
    private static String toHex (String ss) {
        String s = "";
        for (int i = 0; i < ss.length(); i++) {
            int ia = ss.charAt(i);
            int z1 = ia % 16;
            int z2 = (ia - z1)/16;
            s = s + getHexChar(z2)+getHexChar(z1);
        }
        return s;
    }
    
    private static char getHexChar (int a) {
        if (a >= 0 && a <=9 ) return (""+a).charAt(0);
        if (a==10) return 'A';
        if (a==11) return 'B';
        if (a==12) return 'C';
        if (a==13) return 'D';
        if (a==14) return 'E';
        if (a==15) return 'F';
        return 0;
    }
    
    private static String toStr(String s) {
        String ss = "";
        for (int i = 0; i < s.length(); i=i+2) {
            int c1 = toInt (s.charAt(i));
            int c2 = toInt (s.charAt(i+1));
            ss = ss + (char) (c1*16+c2);
        }
        return ss;
    } 
    
    private static int toInt (char a) {
        if (a == '0') return 0;
        if (a == '1') return 1;
        if (a == '2') return 2;
        if (a == '3') return 3;
        
        if (a == '4') return 4;
        if (a == '5') return 5;
        if (a == '6') return 6;
        if (a == '7') return 7;
        
        if (a == '8') return 8;
        if (a == '9') return 9;
        if (a == 'A' || a == 'a') return 10;
        if (a == 'B' || a == 'b') return 11;
        
        if (a == 'C' || a == 'c') return 12;
        if (a == 'D' || a == 'd') return 13;
        if (a == 'E' || a == 'e') return 14;
        if (a == 'F' || a == 'f') return 15;

        return a;
    } 

} 




//End ccsRc4 implementation class

