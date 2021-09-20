package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.response.AddressResponse;
import br.edu.ifpb.agenda.dto.response.AddressResponse.AddressResponseBuilder;
import br.edu.ifpb.agenda.entities.Address;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-19T23:06:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    private final ContactMapper contactMapper = Mappers.getMapper( ContactMapper.class );

    @Override
    public Address toModel(AddressRequest request) {
        if ( request == null ) {
            return null;
        }

        Address address = new Address();

        address.setContact( contactMapper.toModel( request.getContactRequest() ) );
        address.setId( request.getId() );
        address.setStreet( request.getStreet() );
        address.setNumber( request.getNumber() );
        address.setComplement( request.getComplement() );
        address.setDistrict( request.getDistrict() );
        address.setCep( request.getCep() );
        address.setCity( request.getCity() );
        address.setState( request.getState() );

        return address;
    }

    @Override
    public AddressResponse toDTO(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressResponseBuilder addressResponse = AddressResponse.builder();

        addressResponse.contactResponse( contactMapper.toDTO( entity.getContact() ) );
        addressResponse.id( entity.getId() );
        addressResponse.street( entity.getStreet() );
        addressResponse.number( entity.getNumber() );
        addressResponse.complement( entity.getComplement() );
        addressResponse.district( entity.getDistrict() );
        addressResponse.cep( entity.getCep() );
        addressResponse.city( entity.getCity() );
        addressResponse.state( entity.getState() );

        return addressResponse.build();
    }
}
