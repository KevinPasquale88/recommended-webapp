package it.sysagent.recommended.recommendedwebapp.controller;

import it.sysagent.recommended.recommendedwebapp.dto.Comment;
import it.sysagent.recommended.recommendedwebapp.dto.Image;
import it.sysagent.recommended.recommendedwebapp.service.ImagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/images")
public class ImagingController {

    @Autowired
    private ImagingService imagingService;

    @GetMapping(value = "/random-image", produces = MediaType.APPLICATION_JSON_VALUE)
    public Image getRandomImage() throws IOException {
        String path = imagingService.get();
        InputStream in = new FileInputStream(path);
        return new Image(path, IOUtils.toByteArray(in));
    }

    @PutMapping(value = "/putComment")
    public void putComment(@RequestBody Comment comment) {
        imagingService.putComment(comment);
    }
}
