package com.vibetrack.app.controller;

import com.vibetrack.app.model.Emotion;
import com.vibetrack.app.model.EmotionalCheckin;
import com.vibetrack.app.service.EmotionalCheckinService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmotionalCheckinController {

    private final EmotionalCheckinService service;

    public EmotionalCheckinController(EmotionalCheckinService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("emotions", Emotion.values());
        model.addAttribute("checkin", new EmotionalCheckin());
        return "index";
    }

    @PostMapping("/checkin")
    public String submitCheckin(@ModelAttribute EmotionalCheckin checkin, Model model) {
        service.checkin(checkin.getName(), checkin.getEmotion(), checkin.getNote());
        return "success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/team-vibe")
    public String teamVibe(Model model) {
        double mediaHoje = service.emotionsAverageToday();
        model.addAttribute("media", mediaHoje);

        return "team-vibe";
    }
}
