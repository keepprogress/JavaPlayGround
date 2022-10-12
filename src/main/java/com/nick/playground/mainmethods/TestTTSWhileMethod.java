package com.nick.playground.mainmethods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestTTSWhileMethod {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(
                new FileReader("C:/users/t3261/documents/fakeTTSResponse.txt"));
        String response;
        while ((response = reader.readLine()) != null){

            //回傳格式
            //msgId  + statusCode + statusTime，中間以tab隔開
            //0311216947	6	20060623103807
            String[] arr= response.split("\t");
            for(int i=0; i<arr.length; i++){
                if(i==1){ //statusCode
                    System.out.println(arr[1]);
                }else if(i==2){ //statusTime
                    System.out.println(arr[2]);
                }
            }
        }
    }
}
