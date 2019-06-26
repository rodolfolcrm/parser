package com.ef.blockedaccess;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class BlockedAccessId implements Serializable {
    private String ip;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long accessCount;
}
