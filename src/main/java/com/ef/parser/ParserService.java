package com.ef.parser;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class ParserService {

    private static final String UTF_8 = "UTF-8";

    public void execute(ParserRequest parserRequest) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(parserRequest.getPathToFile()), UTF_8)) {
            while(sc.hasNextLine()) {
                var line = sc.nextLine();
                System.out.println(line);
            }
        }
    }
}
