package br.edu.ifpb.agenda.dto.request;

import br.edu.ifpb.agenda.utils.InputManager;
import lombok.*;


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

    private UserRequest userRequest;

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

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }
}
