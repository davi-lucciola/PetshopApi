package io.com.petshop.infrastructure.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String especie;

    @Column
    private String raca;

    @Column
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorEntity tutor;
}
