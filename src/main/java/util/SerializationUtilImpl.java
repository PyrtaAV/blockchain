package util;

import java.io.*;

public class SerializationUtilImpl implements SerializationUtil {
    @Override
    public <T> void serialize(T object, String fileName) {
        try (var fileOutput = new FileOutputStream(fileName); var outputStream = new ObjectOutputStream(fileOutput)) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public <T> T deserialize(String fileName) {
        try (var fileInput = new FileInputStream(fileName); var inputStream = new ObjectInputStream(fileInput)) {
            return (T) inputStream.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
