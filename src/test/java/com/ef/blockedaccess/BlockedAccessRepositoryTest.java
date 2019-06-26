package com.ef.blockedaccess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static com.ef.Constants.IP;
import static com.ef.utils.DateUtils.todayAtZeroHour;
import static java.time.LocalDateTime.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockedAccessRepositoryTest {
    @Autowired
    private BlockedAccessRepository blockedAccessRepository;

    @Test
    public void
    should_save_blocked_access() {
        var blockedAccess = blockedAccess(todayAtZeroHour());
        var blockedAccessId = blockedAccessIdFrom(blockedAccess);
        blockedAccessRepository.save(blockedAccess);
        assertNotNull(blockedAccessRepository.findByIp(IP));
    }

    @Test
    public void
    should_not_save_repeated_blocked_access() {
        var blockedAccess = blockedAccess(now());
        blockedAccessRepository.saveAll(List.of(blockedAccess, blockedAccess, blockedAccess(now().plusHours(2))));
        assertEquals(2, blockedAccessRepository.findByIp(IP).size());
    }


    private BlockedAccessId blockedAccessIdFrom(BlockedAccess blockedAccess) {
        return BlockedAccessId.builder()
                .ip(blockedAccess.getIp())
                .startDate(blockedAccess.getStartDate())
                .endDate(blockedAccess.getEndDate())
                .accessCount(blockedAccess.getAccessCount())
                .build();
    }

    private BlockedAccess blockedAccess(LocalDateTime startDate) {
        return BlockedAccess.builder()
                .ip(IP)
                .startDate(startDate)
                .endDate(startDate.plusHours(1))
                .accessCount(200l).build();
    }
}