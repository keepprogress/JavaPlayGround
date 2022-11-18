package com.nick.playground.mainmethods;

public class TestSplit {
    public static void main(String[] args) {
        String s = "1-12";
        String s2 = "1";
        System.out.println(s.split("-")[0]);
        System.out.println(s2.split("-")[0]);
        System.out.println(s.split("-")[1]);
        if(s2.split("-").length > 1) {
            System.out.println(s2.split("-")[1]);
        } else {
            System.out.println("No second element");
        }
        System.out.println(s.split("-")[0].equals("1"));
        System.out.println(s2== "1");
    }
    // commit cat
}
