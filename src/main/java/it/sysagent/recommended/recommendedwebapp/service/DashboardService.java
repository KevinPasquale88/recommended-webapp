package it.sysagent.recommended.recommendedwebapp.service;

import it.sysagent.recommended.recommendedwebapp.dto.ImageStatistics;
import it.sysagent.recommended.recommendedwebapp.dto.Statistics;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsEntity;
import it.sysagent.recommended.recommendedwebapp.entity.ReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.entity.UsersEntity;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviews;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryReviewsUsers;
import it.sysagent.recommended.recommendedwebapp.repository.RepositoryUsers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DashboardService {

    @Autowired
    private RepositoryReviewsUsers repositoryReviewsUsers;

    @Autowired
    private RepositoryUsers repositoryUsers;

    @Autowired
    private RepositoryReviews repositoryReviews;

    public List<ImageStatistics> get() {
        Map<String, List<Statistics>> dictionary = new HashMap<>();
        List<ReviewsEntity> reviews = repositoryReviews.findAll();

        for (ReviewsEntity review : reviews) {
            Statistics statistic = new Statistics();
            statistic.setReview(review.getReview());
            statistic.setEmotion(review.getDescription());
            List<ReviewsUsers> connects = repositoryReviewsUsers.findByIdreviews_images(review.getIdreviews_images());
            if (connects != null && connects.size() == 1) {
                Optional<UsersEntity> user = repositoryUsers.findById(connects.get(0).getId_user());
                user.ifPresent(usersEntity -> statistic.setUser(usersEntity.getUser()));
            }
            if (statistic.getUser() != null) {
                if (dictionary.containsKey(review.getImage())) {
                    dictionary.get(review.getImage()).add(statistic);
                } else {
                    dictionary.put(review.getImage(), List.of(statistic));
                }
            }
        }

        return dictionary.entrySet().stream().map(elem -> {
            ImageStatistics statistics = new ImageStatistics();
            try {
                InputStream in = new FileInputStream(elem.getKey());
                statistics.setImage(IOUtils.toByteArray(in));
                statistics.setNameImage(elem.getKey());
            } catch (IOException e) {
                log.error(ExceptionUtils.getStackTrace(e));
            }
            statistics.setStatisticsList(elem.getValue());
            return statistics;
        }).collect(Collectors.toList());
    }
}
