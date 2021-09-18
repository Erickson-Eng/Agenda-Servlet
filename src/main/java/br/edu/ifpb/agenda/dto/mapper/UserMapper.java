package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.UserRequest;
import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "contactList", source = "contactRequestList")
    User toModel(UserRequest request);
    @Mapping(target = "responseList", source = "contactList")
    UserResponse toDTO(User entity);
}
