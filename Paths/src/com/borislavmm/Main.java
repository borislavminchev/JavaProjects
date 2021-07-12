package com.borislavmm;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
        System.out.println("___________________");
//        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
        Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
        printFile(filePath);
        System.out.println("___________________");
        filePath = Paths.get("C:\\Users\\bmintchev\\IdeaProjects\\OutThere.txt");
        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path path3 = Paths.get("D:\\something\\something2\\thisfiledoesnotexist.txt");
        System.out.println(path3.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("files");
        System.out.println(Files.exists(path3));

    }

    public static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
