package io.com.petshop.domain.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoPayload {

    @NotNull(message = "O campo \"petId\" não pode ser nulo")
    private Long petId;

    @NotNull(message = "O campo \"tutorId\" não pode ser nulo")
    private Long tutorId;
}
