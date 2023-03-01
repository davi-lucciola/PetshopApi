package io.com.petshop.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoPayload {

    private Long petId;
    private Long tutorId;
}
