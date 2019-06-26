package com.ef.parser;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static com.ef.parser.ParserRequest.Duration.DAILY;

@Data
@Builder
public class ParserRequest {
    private String pathToFile;
    private LocalDateTime startDate;
    private Duration duration;
    private Long threshold;

    public LocalDateTime getEndDate() {
        return getDuration().equals(DAILY) ? startDate.plusDays(1) : startDate.plusHours(1);
    }

    public enum Duration {
        HOURLY,
        DAILY
    }
}
