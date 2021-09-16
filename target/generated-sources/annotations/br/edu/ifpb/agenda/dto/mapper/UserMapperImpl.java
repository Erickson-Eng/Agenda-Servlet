package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.UserRequest;
import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse.UserResponseBuilder;
import br.edu.ifpb.agenda.entities.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-15T23:44:19-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toModel(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( request.getUsername() );
        user.setUserPassword( request.getUserPassword() );
        user.setEmail( request.getEmail() );

        return user;
    }

    @Override
    public UserResponse toDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( entity.getId() );
        userResponse.username( entity.getUsername() );
        userResponse.userPassword( entity.getUserPassword() );
        userResponse.email( entity.getEmail() );

        return userResponse.build();
    }
}
