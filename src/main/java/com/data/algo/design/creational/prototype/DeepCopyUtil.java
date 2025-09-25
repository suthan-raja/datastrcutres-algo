package com.data.algo.design.creational.prototype;


import java.io.*;

public class DeepCopyUtil {

    public static <T extends Serializable> T deepCopy(T obj) {
        try{
            // Write Object to byte stream
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();

            // Read object back from byte stream
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
