package com.ssafy.apolio.repository;

import com.ssafy.apolio.domain.Heart;
import com.ssafy.apolio.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    Long countByBlogId(Long blog_id);
    Optional<Heart> findByBlogIdAndUserId(Long blog_id, Long user_id);
}
