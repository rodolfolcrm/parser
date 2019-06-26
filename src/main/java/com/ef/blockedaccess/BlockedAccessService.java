package com.ef.blockedaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlockedAccessService {

    private BlockedAccessRepository blockedAccessRepository;

    @Autowired
    public BlockedAccessService(BlockedAccessRepository blockedAccessRepository) {
        this.blockedAccessRepository = blockedAccessRepository;
    }

    @Transactional
    public void saveAll(List<BlockedAccess> blockedAccesses) {
        blockedAccessRepository.saveAll(blockedAccesses);
    }
}
