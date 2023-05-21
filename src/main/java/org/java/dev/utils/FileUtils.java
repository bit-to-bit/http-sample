package org.java.dev.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.java.dev.service.HttpStatusChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpStatusChecker.class);

    public static void saveFile(String filePath, InputStream inputStream) {
        checkFileDirAndCreateDir(filePath);
        try {
            File file = new File(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(inputStream.readAllBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            LOG.warn("Error save file = {}", filePath);
        }
    }

    public static void checkFileDirAndCreateDir(String filePath) {
        File dir = new File(new File(filePath).getParent());
        if (!dir.exists() && !dir.mkdirs()) {
            LOG.warn("Error create dir = {}", dir.getAbsolutePath());
        }
    }
}
