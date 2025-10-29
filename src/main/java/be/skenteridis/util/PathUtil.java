package be.skenteridis.util;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

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
