package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.ContactResponse.ContactResponseBuilder;
import br.edu.ifpb.agenda.entities.Contact;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-18T17:30:09-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class ContactMapperImpl implements ContactMapper {

    private final UserMapper userMapper = Mappers.getMapper( UserMapper.class );

    @Override
    public Contact toModel(ContactRequest request) {
        if ( request == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setUser( userMapper.toModel( request.getUserRequest() ) );
        contact.setName( request.getName() );
        contact.setCpf( request.getCpf() );
        contact.setRg( request.getRg() );

        return contact;
    }

    @Override
    public ContactResponse toDTO(Contact entity) {
        if ( entity == null ) {
            return null;
        }

        ContactResponseBuilder contactResponse = ContactResponse.builder();

        contactResponse.userResponse( userMapper.toDTO( entity.getUser() ) );
        contactResponse.id( entity.getId() );
        contactResponse.name( entity.getName() );
        contactResponse.cpf( entity.getCpf() );
        contactResponse.rg( entity.getRg() );

        return contactResponse.build();
    }
}
