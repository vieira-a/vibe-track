package com.vibetrack.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.vibetrack.app.model.Emotion;
import com.vibetrack.app.model.EmotionalCheckin;
import com.vibetrack.app.repository.EmotionalCheckinRepository;

@Service
public class EmotionalCheckinService {
    private final EmotionalCheckinRepository repository;

    public EmotionalCheckinService(EmotionalCheckinRepository repository) {
        this.repository = repository;
    }

    public EmotionalCheckin checkin(String name, Emotion emotion, String note) {
        EmotionalCheckin emotionalCheckin = EmotionalCheckin.create(name, emotion, note);
        return this.repository.save(emotionalCheckin);
    }

    public double emotionsAverageToday() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(23, 59, 59, 999999999);
        Double media = repository.findAverageEmotionByDateRange(startOfDay, endOfDay);
        return media != null ? media : 0.0;
    }
}
