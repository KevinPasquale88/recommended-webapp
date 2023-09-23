package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.ReviewsFromUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(RepositoryReviewsUsers.ENTITY)
public interface RepositoryReviewsUsers extends JpaRepository<ReviewsFromUsers, Long> {

    String ENTITY = "REVIEWS-FOR-USERS-REPOSITORY";

    @Query("SELECT u FROM ReviewsFromUsers u WHERE u.idReviewFromUser = ?1")
    List<ReviewsFromUsers> findByIdReviewFromUser(Long idReviewFromUser);
}
