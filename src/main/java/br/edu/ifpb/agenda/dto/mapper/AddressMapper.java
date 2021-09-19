package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.response.AddressResponse;
import br.edu.ifpb.agenda.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ContactMapper.class})
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "contact", source = "contactRequest")
    Address toModel(AddressRequest request);
    @Mapping(target = "contactResponse", source = "contact")
    AddressResponse toDTO(Address entity);
}
