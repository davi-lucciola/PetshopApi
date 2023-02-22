package io.com.petshop.infrastructure.repository.interfaces;

import io.com.petshop.infrastructure.models.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorJpaRepository extends JpaRepository<TutorEntity, Long> {
}
