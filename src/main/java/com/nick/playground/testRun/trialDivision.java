package com.nick.playground.testRun;

public class trialDivision {
    public static void main(String[] args) {
        // reade price from scanner
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter price: ");
        int price = scanner.nextInt();

        // reade how many people from scanner
        System.out.print("Enter how many people: ");
        int people = scanner.nextInt();

        // calculate the price per person
        int pricePerPerson = price / people;

        // calculate the remainder
        int remainder = price % people;

        // print the result
        System.out.println("Price per person: " + pricePerPerson);
        System.out.println("Remainder: " + remainder);

    }
}
