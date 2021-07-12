package com.timbuchalka;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    public boolean accept(Path path) throws IOException {
//                        return (Files.isRegularFile(path));
//                    }
//                };

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);

        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try{
            Path tempFile = Files.createTempFile("myapp" , ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores){
            System.out.println(store);
            System.out.println(store.name());
        }
        System.out.println("*******************");

        //i don't need this
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths){
            System.out.println(path);
        }

        System.out.println("--Walking Tree for Dir2--");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");

        try{
            Files.walkFileTree(dir2Path, new PrintNames());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--Cop yDir2 to Dir4\\Dir2Copy");
        Path copyPath =  FileSystems.getDefault().getPath("FileTree", "Dir4", "Dir2Copy");
        try{
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        File file = new File("C:\\Users\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("C:\\Users");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("C:\\Users");
        Path child = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(child));


        File workinDirectory = new File("").getAbsoluteFile();
        System.out.println(workinDirectory.getAbsoluteFile());

        System.out.println("--print Dir2 content using list() --");
        File dir2File = new File(workinDirectory, "\\FileTree\\dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i <dir2Contents.length ; i++) {
            System.out.println(dir2Contents[i]);
        }

        System.out.println("--print Dir2 content using listFiles() --");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i <dir2Files.length ; i++) {
            System.out.println(dir2Files[i].getName());
        }


    }
}
