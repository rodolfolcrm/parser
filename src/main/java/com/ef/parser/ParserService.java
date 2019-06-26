package com.ef.parser;

import com.ef.access.AccessService;
import com.ef.access.BlockedStats;
import com.ef.blockedaccess.BlockedAccess;
import com.ef.blockedaccess.BlockedAccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParserService {

    private AccessService accessService;
    private BlockedAccessService blockedAccessService;

    @Autowired
    public ParserService(AccessService accessService,
                         BlockedAccessService blockedAccessService) {
        this.accessService = accessService;
        this.blockedAccessService = blockedAccessService;
    }

    public void execute(ParserRequest parserRequest) {
        if (!StringUtils.isEmpty(parserRequest.getPathToFile())) {
            var accesses = accessService.loadFromFile(parserRequest.getPathToFile());
            accessService.saveAll(accesses);
        }

        var blockedStats = accessService.findBlockedIpsBy(parserRequest.getStartDate(),
                parserRequest.getEndDate(), parserRequest.getThreshold());

        logBlockedIps(parserRequest, blockedStats);

        var blockedAccesses = blockedStats.stream()
                .map(bs -> BlockedAccess.builder()
                        .ip(bs.getIp())
                        .accessCount(bs.getAccessCount())
                        .startDate(parserRequest.getStartDate())
                        .endDate(parserRequest.getEndDate())
                        .build())
                .collect(Collectors.toList());

        blockedAccessService.saveAll(blockedAccesses);
    }

    private void logBlockedIps(ParserRequest parserRequest, List<BlockedStats> blockedStats) {
        log.info("BLOCKED_IPS for parameters startDate: {}, endDate: {}, threshold: {}, blockedStats: {}",
                parserRequest.getStartDate(), parserRequest.getEndDate(), parserRequest.getThreshold(), blockedStats);
    }
}
