package com.nick.playground.mainmethods;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DESorCBCEncryption {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -242);
        dt = c.getTime();

        System.out.println("Enter your orderId: ");
        Scanner scanner = new Scanner(System.in);
        String rgbData = scanner.nextLine();
        System.out.println("Your orderId is " + rgbData);

        scanner.close();
        // 8bytes long key required
        String Key = sdf.format(dt);
        System.out.println("Key : " + Key);
        // 8 bytes long iv required
        final String rgbIv = "TOHMOAEV";
        final String vValue = "F9BD2CE3B37B48D4327DAD6FC7893283";

        byte[] encryptedBytes = encryptDES(rgbData, Key, rgbIv);
        String enstr = Base64.encodeBase64String(encryptedBytes);
        System.out.println("path for OrderStatus : "
                + "https://hctapiweb.hct.com.tw/phone/searchGoods_Main.aspx?no="
                + enstr
                + "&v="
                + vValue);
    }

    public static byte[] encryptDES(String Message, String Key, String Iv) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(Key.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(Iv.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(Message.getBytes(StandardCharsets.UTF_8));
    }

}
