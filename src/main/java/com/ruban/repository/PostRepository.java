package com.ruban.repository;

import com.ruban.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by antonruban on 13.05.17.
 */
public interface PostRepository extends JpaRepository<Twit, Long> {
}
