package com.kodilla.integration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileTransformer {

    public String transFormFile(String fileName) throws IOException {
        List<String> lines= Files.readAllLines(Paths.get(fileName));
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = lines.size() - 1; i >= 0; i--) {
             stringBuilder.append(lines.get(i)+"\n");

        }
        return stringBuilder.toString();
    }
}
