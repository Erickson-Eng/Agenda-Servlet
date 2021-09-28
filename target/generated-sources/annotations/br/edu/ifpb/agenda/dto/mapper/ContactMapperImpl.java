package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.request.ContactRequest.ContactRequestBuilder;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.ContactResponse.ContactResponseBuilder;
import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.entities.Contact;
import br.edu.ifpb.agenda.entities.User;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-28T13:36:19-0300",
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

        contact.setUser( userResponseToUser( request.getUserResponse() ) );
        contact.setId( request.getId() );
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

    @Override
    public Contact dtoToModel(ContactResponse response) {
        if ( response == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setUser( userResponseToUser( response.getUserResponse() ) );
        contact.setId( response.getId() );
        contact.setName( response.getName() );
        contact.setCpf( response.getCpf() );
        contact.setRg( response.getRg() );

        return contact;
    }

    @Override
    public ContactRequest responseToRequest(ContactResponse response) {
        if ( response == null ) {
            return null;
        }

        ContactRequestBuilder contactRequest = ContactRequest.builder();

        contactRequest.id( response.getId() );
        contactRequest.name( response.getName() );
        contactRequest.cpf( response.getCpf() );
        contactRequest.rg( response.getRg() );
        contactRequest.userResponse( response.getUserResponse() );

        return contactRequest.build();
    }

    protected User userResponseToUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User user = new User();

        user.setId( userResponse.getId() );
        user.setUsername( userResponse.getUsername() );
        user.setUserPassword( userResponse.getUserPassword() );
        user.setEmail( userResponse.getEmail() );

        return user;
    }
}
