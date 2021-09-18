package br.edu.ifpb.agenda.dao;

import br.edu.ifpb.agenda.dto.mapper.ContactMapper;
import br.edu.ifpb.agenda.dto.request.ContactRequest;
import br.edu.ifpb.agenda.dto.response.ContactResponse;
import br.edu.ifpb.agenda.entities.Contact;
import br.edu.ifpb.agenda.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ContactDAO {

    private final EntityManager em = JPAUtil.getEntityManager();
    private ContactMapper contactMapper;

    public void save(ContactRequest request){
        Contact entity = contactMapper.INSTANCE.toModel(request);
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            if (em.isOpen()){
                em.getTransaction().rollback();
            }
        }
    }

    public List<ContactResponse> listAll(Integer id){
        String consult = "select c from Contact c where c.user.id = :id";
        TypedQuery<Contact> query = em
                .createQuery(consult, Contact.class)
                .setParameter("id", id)
                .setMaxResults(20);
        List<Contact> contactList = query.getResultList();
        return contactList
                .stream()
                .map(contactMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
