package com.myoluk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "log_event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogEvent {

    @SequenceGenerator(name = "LogEvent", sequenceName = "log_event_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LogEvent")
    @Id
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "service")
    private String service;

    @Column(name = "level")
    private String level;

    @Column(name = "message")
    private String message;
}
