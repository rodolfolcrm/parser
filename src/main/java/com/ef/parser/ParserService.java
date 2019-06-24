package com.ef.parser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
@Slf4j
public class ParserService {

    public void execute(ParserRequest parserRequest) {
        try (Scanner sc = new Scanner(new File(parserRequest.getPathToFile()), StandardCharsets.UTF_8)) {
            while(sc.hasNextLine()) {
                var line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new ParserException(e);
        }
    }
}
