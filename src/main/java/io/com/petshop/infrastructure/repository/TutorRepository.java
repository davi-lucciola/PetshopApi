package io.com.petshop.infrastructure.repository;

import io.com.petshop.infrastructure.models.entities.PetEntity;
import io.com.petshop.infrastructure.models.entities.TutorEntity;
import io.com.petshop.infrastructure.repository.interfaces.TutorJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorRepository {
    @Autowired
    private TutorJpaRepository tutorJpaRepository;

    public List<TutorEntity> findAll() {
        return tutorJpaRepository.findAll();
    }

    public TutorEntity findById(Long id) {
        return tutorJpaRepository.findById(id).orElse(null);
    }

    public TutorEntity saveAndFlush(TutorEntity tutor) {
        return tutorJpaRepository.saveAndFlush(tutor);
    }

    public void deleteTutorById(Long id) {
        tutorJpaRepository.deleteById(id);
    }
}
