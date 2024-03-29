package com.ef.access;

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
@IdClass(AccessId.class)
public class Access {
    @Id
    @Column(nullable = false)
    private LocalDateTime date;
    @Id
    @Column(length = 15, nullable = false)
    private String ip;
    @Id
    @Column(nullable = false)
    private String request;
    @Id
    @Column(length = 3, nullable = false)
    private String status;
    @Id
    @Column(nullable = false)
    private String userAgent;
}
