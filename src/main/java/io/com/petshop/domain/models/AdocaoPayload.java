package io.com.petshop.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoPayload {

    @NonNull
    private Long petId;
    private Long tutorId;
}
