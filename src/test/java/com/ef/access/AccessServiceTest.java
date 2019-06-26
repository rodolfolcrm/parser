package com.ef.access;

import com.ef.exceptions.ParserException;
import com.ef.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static com.ef.Constants.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AccessServiceTest {

    @InjectMocks
    private AccessService accessService;

    @Test(expected = ParserException.class)
    public void
    execute_throws_ParserException_when_file_not_found() {
        var accessList = accessService.loadFromFile(PATH_FILE_NOT_EXISTS);
        assertNotNull(accessList);
    }

    @Test
    public void convert() {
        String[] record = {DATE, IP, REQUEST, STATUS, USER_AGENT};
        var result = accessService.convert(record);
        assertThat(result.getDate(), is(DateUtils.convertFileDateTime(DATE)));
        assertThat(result.getIp(), is(IP));
        assertThat(result.getRequest(), is(REQUEST));
        assertThat(result.getStatus(), is(STATUS));
        assertThat(result.getUserAgent(), is(USER_AGENT));
    }
}
