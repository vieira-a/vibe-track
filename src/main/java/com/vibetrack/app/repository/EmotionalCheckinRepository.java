package com.vibetrack.app.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vibetrack.app.model.EmotionalCheckin;

@Repository
public interface EmotionalCheckinRepository extends JpaRepository<EmotionalCheckin, UUID> {
    @Query("SELECT AVG(CASE " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.HAPPY THEN 5 " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.PRODUCTIVE THEN 4 " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.NEUTRAL THEN 3 " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.TIRED THEN 2 " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.SAD THEN 1 " +
            "WHEN e.emotion = com.vibetrack.app.model.Emotion.STRESSED THEN 0 " +
            "END) " +
            "FROM EmotionalCheckin e WHERE e.date >= :start AND e.date <= :end")
    Double findAverageEmotionByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
