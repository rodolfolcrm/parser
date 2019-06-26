package com.ef.access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class BlockedStats {
    private String ip;
    private Long accessCount;
}
