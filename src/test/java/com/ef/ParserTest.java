package com.ef;

import com.ef.parser.ParserRequest;
import com.ef.parser.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ef.Constants.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
    @Mock
    private ParserService parserService;

    @InjectMocks
    private Parser parser;

    @Test
    public void
    run_with_args() {
        parser.run(PATH_TO_FILE, START_DATE_2017_01_01_13H, HOURLY_VALUE, THRESHOLD_200);
        verify(parserService).execute(ParserRequest.builder()
                .pathToFile(PATH_TO_FILE)
                .startDate(LocalDateTime.parse(START_DATE_2017_01_01_13H, DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss")))
                .duration(ParserRequest.Duration.HOURLY)
                .threshold(Long.valueOf(THRESHOLD_200))
                .build());
    }

}
