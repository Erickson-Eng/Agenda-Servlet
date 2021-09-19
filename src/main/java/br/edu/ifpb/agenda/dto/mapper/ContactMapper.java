package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class})
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "user", source = "userResponse")
    Contact toModel(ContactRequest request);

    @Mapping(target = "userResponse", source = "user")
    ContactResponse toDTO(Contact entity);

    @Mapping(target = "user", source = "userResponse")
    Contact dtoToModel(ContactResponse response);
}
