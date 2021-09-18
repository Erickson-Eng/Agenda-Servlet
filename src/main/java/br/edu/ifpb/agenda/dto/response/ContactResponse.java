package br.edu.ifpb.agenda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    private Integer id;
    private String name;
    private String cpf;
    private String rg;

    private UserResponse userResponse;
}
