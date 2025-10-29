package be.skenteridis.util;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new Gson();
    private static final String filePath = PathUtil.getValidResourcesPath("cart.json");
    public static void save(List<?> products) {
        try(Writer writer = new FileWriter(filePath)) {
            gson.toJson(products, writer);
            System.out.println("File saved successfully!");
        } catch (Exception e) {
            System.out.println("Couldn't save file! " + e.getMessage());
        }
    }
    public static <T>List<T> load(Type type) {
        try(Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file! " + e.getMessage());
        }
    }
}
