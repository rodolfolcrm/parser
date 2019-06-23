package com.ef.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static com.ef.parser.ParserRequest.Duration.DAYLI;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ParserServiceShould {

    private static final String PATH_TO_FILE = "src/test/resources/access.log";

    @InjectMocks
    private ParserService parserService;

    @Test
    public void execute() throws FileNotFoundException {
        parserService.execute(ParserRequest.builder()
                .pathToFile(PATH_TO_FILE)
                .startDate(LocalDateTime.of(2017, Month.JANUARY, 1, 13, 0))
                .duration(DAYLI)
                .threshold(100)
                .build());
    }
}