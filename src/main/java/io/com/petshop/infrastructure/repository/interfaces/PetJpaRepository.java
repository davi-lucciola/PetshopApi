package io.com.petshop.infrastructure.repository.interfaces;

import io.com.petshop.infrastructure.models.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<PetEntity, Long> {
}
