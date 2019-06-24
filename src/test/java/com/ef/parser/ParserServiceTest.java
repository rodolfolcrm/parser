package com.ef.parser;

import com.ef.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static com.ef.parser.ParserRequest.Duration.DAYLI;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ParserServiceTest {

    private static final String PATH_TO_FILE = "src/test/resources/access.log";
    private static final String PATH_FILE_NOT_EXISTS = "/path/file/not/exists";

    private static final String IP = "192.168.234.82";
    private static final String DATE = "2017-01-01 00:00:11.763";
    private static final String REQUEST = "GET / HTTP/1.1";
    private static final String STATUS = "200";
    private static final String USER_AGENT = "swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0";

    @InjectMocks
    private ParserService parserService;

    @Test
    public void execute() {
        parserService.execute(parserRequest(PATH_TO_FILE));
    }

    @Test(expected = ParserException.class)
    public void
    execute_throws_ParserException_when_file_not_found() {
        parserService.execute(parserRequest(PATH_FILE_NOT_EXISTS));
    }

    @Test
    public void convert() {
        String[] record = {DATE,
                IP,
                REQUEST,
                STATUS,
                USER_AGENT};
        var result = parserService.convert(record);
        assertThat(result.getDate(), is(DateUtils.convertFileDateTime(DATE)));
        assertThat(result.getIp(), is(IP));
        assertThat(result.getRequest(), is(REQUEST));
        assertThat(result.getStatus(), is(STATUS));
        assertThat(result.getUserAgent(), is(USER_AGENT));
    }

    private ParserRequest parserRequest(String pathToFile) {
        return ParserRequest.builder()
                .pathToFile(pathToFile)
                .startDate(LocalDateTime.of(2017, Month.JANUARY, 1, 13, 0))
                .duration(DAYLI)
                .threshold(100)
                .build();
    }
}