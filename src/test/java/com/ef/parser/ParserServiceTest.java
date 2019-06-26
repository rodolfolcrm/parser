package com.ef.parser;

import com.ef.access.AccessService;
import com.ef.blockedaccess.BlockedAccessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static com.ef.Constants.PATH_TO_FILE;
import static com.ef.parser.ParserRequest.Duration.DAILY;

@RunWith(MockitoJUnitRunner.class)
public class ParserServiceTest {

    @Mock
    private AccessService accessService;

    @Mock
    private BlockedAccessService blockedAccessService;

    @InjectMocks
    private ParserService parserService;

    @Test
    public void execute() {
        parserService.execute(parserRequest(PATH_TO_FILE));
    }

    private ParserRequest parserRequest(String pathToFile) {
        return ParserRequest.builder()
                .pathToFile(pathToFile)
                .startDate(LocalDateTime.of(2017, Month.JANUARY, 1, 13, 0))
                .duration(DAILY)
                .threshold(100l)
                .build();
    }
}