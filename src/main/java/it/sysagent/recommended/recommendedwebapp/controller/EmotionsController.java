package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.Emotions;
import it.sysagent.recommended.recommendedwebapp.service.EmotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emotions")
public class EmotionsController {

    private final EmotionsService emotionsService;

    @Autowired
    public EmotionsController(@Qualifier(EmotionsService.ENTITY) EmotionsService emotionsService) {
        this.emotionsService = emotionsService;
    }

    @GetMapping
    public List<Emotions> getEmotions() {
        return emotionsService.getEmotions();
    }

}
