package com.ef.blockedaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockedAccessRepository extends JpaRepository<BlockedAccess, BlockedAccessId> {
    List<BlockedAccess> findByIp(String ip);
}
