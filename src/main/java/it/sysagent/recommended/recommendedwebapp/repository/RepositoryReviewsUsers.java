package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.ReviewsUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryReviewsUsers extends JpaRepository<ReviewsUsers,Long> {

    @Query("SELECT u FROM ReviewsUsers u WHERE u.idreviews_images = ?1")
    List<ReviewsUsers> findByIdreviews_images(Long idreviews_images);
}
