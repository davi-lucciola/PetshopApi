package io.com.petshop.infrastructure.repository;

import io.com.petshop.infrastructure.models.entities.PetEntity;
import io.com.petshop.infrastructure.repository.interfaces.PetJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepository {
    @Autowired
    private PetJpaRepository petJpaRepository;

    public List<PetEntity> findAll() {
        return petJpaRepository.findAll();
    }

    public PetEntity saveAndFlush(PetEntity pet) {
        return petJpaRepository.saveAndFlush(pet);
    }
}
