package be.skenteridis.util;

import java.io.File;

public class PathUtil {
    public static String getValidResourcesPath(String fileName) {
        File file;
        try {
            file = new File(PathUtil.class.getClassLoader().getResource(fileName).toURI());
            return file.getAbsolutePath();
        } catch (Exception e) {
            return fileName;
        }

    }
}
