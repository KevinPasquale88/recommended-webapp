package it.sysagent.recommended.recommendedwebapp.repository;

import it.sysagent.recommended.recommendedwebapp.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReviews extends JpaRepository<ReviewsEntity,Long> {
}
