package br.edu.ifpb.agenda.dto.mapper;

import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.request.UserRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.dto.response.ContactResponse.ContactResponseBuilder;
import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.dto.response.UserResponse.UserResponseBuilder;
import br.edu.ifpb.agenda.entities.Contact;
import br.edu.ifpb.agenda.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-18T17:33:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toModel(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setContactList( contactRequestListToContactList( request.getContactRequestList() ) );
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

        userResponse.responseList( contactListToContactResponseList( entity.getContactList() ) );
        userResponse.id( entity.getId() );
        userResponse.username( entity.getUsername() );
        userResponse.userPassword( entity.getUserPassword() );
        userResponse.email( entity.getEmail() );

        return userResponse.build();
    }

    protected Contact contactRequestToContact(ContactRequest contactRequest) {
        if ( contactRequest == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setName( contactRequest.getName() );
        contact.setCpf( contactRequest.getCpf() );
        contact.setRg( contactRequest.getRg() );

        return contact;
    }

    protected List<Contact> contactRequestListToContactList(List<ContactRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Contact> list1 = new ArrayList<Contact>( list.size() );
        for ( ContactRequest contactRequest : list ) {
            list1.add( contactRequestToContact( contactRequest ) );
        }

        return list1;
    }

    protected ContactResponse contactToContactResponse(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactResponseBuilder contactResponse = ContactResponse.builder();

        contactResponse.id( contact.getId() );
        contactResponse.name( contact.getName() );
        contactResponse.cpf( contact.getCpf() );
        contactResponse.rg( contact.getRg() );

        return contactResponse.build();
    }

    protected List<ContactResponse> contactListToContactResponseList(List<Contact> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactResponse> list1 = new ArrayList<ContactResponse>( list.size() );
        for ( Contact contact : list ) {
            list1.add( contactToContactResponse( contact ) );
        }

        return list1;
    }
}
