package io.com.petshop.infrastructure.repository;

import io.com.petshop.domain.models.dtos.PetDTO;
import io.com.petshop.infrastructure.entities.PetEntity;
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

    public PetEntity findById(Long id) {
        return petJpaRepository.findById(id).orElse(null);
    }

    public PetEntity saveAndFlush(PetEntity pet) {
        if (pet.getId() != null) {
            pet = this.findById(pet.getId());
        }
        return petJpaRepository.saveAndFlush(pet);
    }

    public void deletePetById(Long id) {
        petJpaRepository.deleteById(id);
    }
}
