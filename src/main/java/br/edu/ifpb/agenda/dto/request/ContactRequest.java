package br.edu.ifpb.agenda.dto.request;

import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.utils.InputManager;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ContactRequest {
    private String name;
    private String cpf;
    private String rg;

    private UserResponse userResponse;

    private List<AddressRequest> requestList = new ArrayList<>();
    public void setName(String name) {
        if (InputManager.validateName(name)){
            this.name = name;
        }

    }

    public void setCpf(String cpf) {
        if (InputManager.validateCPF(cpf)){
            this.cpf = cpf;
        }

    }

    public void setRg(String rg) {
        if (InputManager.validateRG(rg)){
            this.rg = rg;
        }
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public void setRequestList(List<AddressRequest> requestList) {
        this.requestList = requestList;
    }
}
