package com.data.algo.something;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Base64;

@Component
public class Com {

    public static void main(String[] args) throws IOException {

        /*FileInputStream stream = new FileInputStream("kk.txt");
        byte[] bytes = stream.readAllBytes();
        stream.close();

//        FileInputStream stream = new FileInputStream("A000009_photo.png");
//        byte[] bytes = stream.readAllBytes();
//        stream.close();
        String encodeBase64Url = Base64.getUrlEncoder().encodeToString(bytes);
        System.out.println("encodeBase64Url: " + encodeBase64Url);
        String decodeBase64Url = Base64.getEncoder().encodeToString(bytes);
        System.out.println("decodeBase64: " + decodeBase64Url);

*/
        FileInputStream sd = new FileInputStream(new File("viber_image_2025-08-28_02-30-36-191.jp2"));
        byte[] readed = sd.readAllBytes();
        sd.close();
        byte[] newReaded = hexToByte(new String(readed));
//        System.out.println(Hex.t);
        FileOutputStream out = new FileOutputStream("image.jp2");
        out.write(newReaded);
        out.close();
    }

    private static byte[] hexToByte(String keyData) {
        byte[] val = new byte[keyData.length() / 2];
        for (int i = 0; i < val.length; i++) {
            int index = i * 2;
            val[i] = (byte) Integer.parseInt(keyData.substring(index, index + 2), 16);
        }
        return val;
    }

}
