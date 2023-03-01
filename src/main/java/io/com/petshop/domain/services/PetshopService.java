package io.com.petshop.domain.services;

import io.com.petshop.domain.models.AdocaoPayload;
import io.com.petshop.domain.models.responses.BasicResponse;
import io.com.petshop.infrastructure.entities.PetEntity;
import io.com.petshop.infrastructure.entities.TutorEntity;
import io.com.petshop.infrastructure.repository.PetRepository;
import io.com.petshop.infrastructure.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PetshopService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public BasicResponse adotarPet(AdocaoPayload adotarPayload) {
        if (adotarPayload.getPetId() == null) {
            return new BasicResponse(
                    "PET_ID_NULO",
                    "O Pet id é obrigatório.");
        }

        PetEntity pet = petRepository.findById(adotarPayload.getPetId());

        if (pet == null) {
            return new BasicResponse(
                    "PET_NAO_CADASTRADO",
                    "Esse pet não está cadastrado.");
        }

        if (pet.getTutor() != null) {
            return new BasicResponse(
                    "PET_TEM_TUTOR",
                    "Esse pet já tem tutor e não pode ser adotado");
        }

        TutorEntity tutor = tutorRepository.findById(adotarPayload.getTutorId());

        if (tutor == null) {
            return new BasicResponse(
                    "TUTOR_NAO_CADASTRADO",
                    "Esse tutor não está cadastrado.");
        }

        pet.setTutor(tutorRepository.findById(tutor.getId()));
        petRepository.saveAndFlush(pet);

        return new BasicResponse(
                "PET_ADOCAO",
                 "O " + pet.getEspecie() + " " + pet.getNome() +
                         " foi adotado com sucesso por " + tutor.getNome());
    }
}
