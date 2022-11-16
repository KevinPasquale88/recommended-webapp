package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.Comment;
import it.sysagent.recommended.recommendedwebapp.service.ImagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImagingController {

    @Autowired
    ImagingService imagingService;

    @GetMapping("/random-image")
    public String getRandomImage(){
        return imagingService.get();
    }

    @PutMapping("/putComment")
    public void putComment(Comment comment){
        imagingService.putComment(comment);
    }
}
