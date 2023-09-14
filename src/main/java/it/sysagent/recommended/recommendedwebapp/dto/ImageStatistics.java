package it.sysagent.recommended.recommendedwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageStatistics {

    private String nameImage;

    private byte[] image;

    private List<Statistics> statisticsList;
}


