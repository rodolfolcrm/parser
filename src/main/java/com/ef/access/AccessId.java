package com.ef.access;

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
public class AccessId implements Serializable {
    private LocalDateTime date;
    private String ip;
    private String request;
    private String status;
    private String userAgent;
}
