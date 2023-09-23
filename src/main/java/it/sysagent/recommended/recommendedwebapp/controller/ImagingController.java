package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.CommentEmotion;
import it.sysagent.recommended.recommendedwebapp.dto.Image;
import it.sysagent.recommended.recommendedwebapp.service.ImagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImagingController {

    private final ImagingService imagingService;

    @Autowired
    public ImagingController(@Qualifier(ImagingService.ENTITY) ImagingService imagingService) {
        this.imagingService = imagingService;
    }

    @GetMapping(value = "/random-image", produces = MediaType.APPLICATION_JSON_VALUE)
    public Image getRandomImage(@RequestHeader String jwt) throws IOException {
        return imagingService.getImages();
    }

    @PutMapping(value = "/putComment")
    public void putComment(@RequestHeader String jwt, @RequestBody CommentEmotion comment) {
        imagingService.putComment(jwt, comment);
    }
}
