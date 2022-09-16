package util;

public interface SerializationUtil {
    <T> void serialize(T object, String fileName);

    /*
    T - Класс который дессериализуем
    String fileName - Путь к файлу из которого достаем класс
     */
    <T> T deserialize(String fileName);
}
