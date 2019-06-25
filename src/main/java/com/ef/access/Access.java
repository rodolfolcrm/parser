package com.ef.access;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Access {
    private LocalDateTime date;
    private String ip;
    private String request;
    private String status;
    private String userAgent;
}
