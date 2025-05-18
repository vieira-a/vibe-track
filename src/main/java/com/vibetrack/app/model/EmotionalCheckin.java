package com.vibetrack.app.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmotionalCheckin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    private String note;

    private LocalDateTime date;

    public EmotionalCheckin(
            String name,
            Emotion emotion,
            String note,
            LocalDateTime date) {

        this.name = name;
        this.emotion = emotion;
        this.note = note;
        this.date = date;
    }

    public EmotionalCheckin() {
    }

    public static EmotionalCheckin create(
            String name,
            Emotion emotion,
            String note) {

        return new EmotionalCheckin(
                name,
                emotion,
                note,
                LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public String getNote() {
        return note;
    }

}
