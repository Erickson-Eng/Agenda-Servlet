package br.edu.ifpb.agenda.dto.request;

import br.edu.ifpb.agenda.utils.InputManager;
import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {


    @Setter
    private Integer id;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String cep;
    private String city;
    private String state;

    @Setter
    private ContactRequest contactRequest;

    public void setStreet(String street) {
        this.street = street;

    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDistrict(String district) {
        if (InputManager.validateName(district)){
            this.district = district;
        }
    }

    public void setCep(String cep) {
        String expression = "^[0-9]{5}-[0-9]{3}";
        if (cep.matches(expression)){
            this.cep = cep;
        }

    }

    public void setCity(String city) {
        if (InputManager.validateName(city))
        {
            this.city = city;
        }
    }

    public void setState(String state) {
        String expression = "^[A-Z]{2}";
        if (state.matches(expression))
        {
            this.state = state;
        }
    }

//    public void setContactRequest(ContactRequest contactRequest) {
//        this.contactRequest = contactRequest;
//    }
}
