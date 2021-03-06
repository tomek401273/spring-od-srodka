package com.kodilla.integration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileTransformer {

    public String transFormFile(String fileName) throws IOException {
        List<String> lines= Files.readAllLines(Paths.get(fileName));
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = lines.size() - 1; i >= 0; i--) {
             stringBuilder.append(lines.get(i)+"\n");

        }
//        return stringBuilder.toString();
        logNewFile(fileName);
        return fileName;
    }

    public void logNewFile(String fileName) throws IOException {
        Path path = Paths.get("1.3Integration/exercise1/src/main/resources/data/output/log.txt");
        Files.write(path, extractFileName(fileName), StandardOpenOption.APPEND);
    }

    public byte[] extractFileName(String path){
        String[] splits = path.split("/");
        return (splits[splits.length-1]+"\n").getBytes();
    }

}
