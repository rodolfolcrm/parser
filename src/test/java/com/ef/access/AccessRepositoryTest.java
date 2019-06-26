package com.ef.access;

import com.ef.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.ef.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessRepositoryTest {

    @Autowired
    private AccessRepository accessRepository;

    @Test
    public void
    should_save_access() {
        accessRepository.save(defaultAccess());
        assertTrue(accessRepository.findById(defaultAccessId()).isPresent());
    }

    @Test
    public void
    should_not_save_repeated_access() {
        accessRepository.saveAll(List.of(defaultAccess(), defaultAccess(), access("400")));
        assertEquals(2, accessRepository.findByIp(IP).size());
    }

    private AccessId defaultAccessId() {
        return accessId(STATUS);
    }

    private AccessId accessId(String status) {
        return AccessId.builder()
                .ip(IP)
                .date(DateUtils.convertFileDateTime(DATE))
                .status(status)
                .request(REQUEST)
                .userAgent(USER_AGENT)
                .build();
    }

    private Access defaultAccess() {
        return access(STATUS);
    }

    private Access access(String status) {
        return Access.builder()
                .ip(IP)
                .date(DateUtils.convertFileDateTime(DATE))
                .status(status)
                .request(REQUEST)
                .userAgent(USER_AGENT).build();
    }
}