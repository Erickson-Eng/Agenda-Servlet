package br.edu.ifpb.agenda.dto.request;

import br.edu.ifpb.agenda.utils.InputManager;
import lombok.*;

@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String userPassword;
    private String email;

    public void setUsername(String username) {
        if (InputManager.validateUsername(username)){
            this.username = username;
        }
        else{
            throw new IllegalArgumentException("Username must contain between 4 and 10 characters.");
        }

    }

    public void setUserPassword(String userPassword) {
        if (InputManager.validatePassword(userPassword)){
            this.userPassword = userPassword;
        }else
            throw new IllegalArgumentException
                    ("The password must contain capital letters, numbers and special characters and also 8 or more characters");

    }

    public void setEmail(String email) {
        if (InputManager.validateEmail(email)){
            this.email = email;
        }else
            throw new IllegalArgumentException("invalid email");

    }
}
