package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
public class ImagingService {

    List<String> images = new ArrayList<>();

    @Autowired
    public ImagingService() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        listFilesForFolder(new File(classloader.getResource("images").getFile()));
    }

    public String get() {
        Random random = new Random();
        int elem = random.nextInt(images.size());
        String image = images.get(elem);
        images.remove(image);
        return image;
    }

    private void listFilesForFolder(final File folder) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                images.add(fileEntry.getAbsolutePath());
            }
        }
    }

    public void putComment(Comment comment){

    }
}
