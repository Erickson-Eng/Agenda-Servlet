package br.edu.ifpb.agenda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private Integer id;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String cep;
    private String city;
    private String state;

    private ContactResponse contactResponse;
}
