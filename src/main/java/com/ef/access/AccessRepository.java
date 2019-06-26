package com.ef.access;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AccessRepository extends JpaRepository<Access, AccessId> {

    @Query("select new com.ef.access.BlockedStats(a.ip, count(a) as accessCount) from Access a " +
            "where a.date between :startDate and :endDate " +
            "group by a.ip " +
            "having count(a) > :threshold")
    List<BlockedStats> findBlockedIpsBy(LocalDateTime startDate, LocalDateTime endDate, Long threshold);

    List<Access> findByIp(String ip);
}
