package com.nick.playground.testRun;

public class calculateChiniseStringByte {

    public static int charCodeAt(String string, int index) {
        return string.charAt(index);
    }

    public static void main(String[] args) {
        // read string from scanner
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter string: ");
        String chineseString = scanner.nextLine();

        // calculate the length of a chinese string
        int len = 0;
        for(int i = 0; i < chineseString.length(); i++) {
            int s = charCodeAt(chineseString, i);
            System.out.println("s = " + s);
            while (s > 0) {
                s = s >> 8;
                len++;
            }
        }
        System.out.println("The length of the chinese string is: " + len);
    }


}

