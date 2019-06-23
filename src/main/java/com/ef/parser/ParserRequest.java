package com.ef.parser;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ParserRequest {
    private String pathToFile;
    private LocalDateTime startDate;
    private Duration duration;
    private Integer threshold;

    public enum Duration {
        HOURLY,
        DAYLI
    }
}
