package com.vfreiman.lessons.hibernatejpaexamples.services;

import javassist.Loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FileService {
    public static String readFromResource(String resourceFullName) {
        URL resource = Loader.getSystemClassLoader().getResource(resourceFullName);
        return readFromFile(Objects.requireNonNull(resource).getFile());
    }

    public static String readFromFile(String path) {
        StringBuilder sb = new StringBuilder();

        try (InputStream is = new FileInputStream(new File(path));
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            while (isr.ready()) {
                int ch = isr.read();
                sb.append((char) ch);
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
