package com.ef.blockedaccess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@IdClass(BlockedAccessId.class)
public class BlockedAccess {
    @Id
    @Column(length = 15, nullable = false)
    private String ip;
    @Id
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Id
    @Column(nullable = false)
    private LocalDateTime endDate;
    @Id
    @Column(nullable = false)
    private Long accessCount;
}
