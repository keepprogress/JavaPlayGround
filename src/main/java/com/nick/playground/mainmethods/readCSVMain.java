package com.nick.playground.mainmethods;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class readCSVMain {
    public static void main(String[] args) {

        // read CSV file to check newline in CSV file from C:\Users\T3261\Downloads\S_2000042255I001_20220811.csv
        String filePath = "C:\\Users\\T3261\\Downloads\\tmp001.xlsx";
        String line = "";
        String cvsSplitBy = "|";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "UTF-8"));) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                for (int i = 0; i < country.length; i++) {
                    System.out.print(replaceBreakLineWithComma(country[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String replaceBreakLineWithComma(String str) {
        return str
                .replaceAll("\n", ",")
                .replaceAll("\r", ",")
                .replaceAll("\r\n", ",");
    }
}
