package br.edu.ifpb.agenda.dao;

import br.edu.ifpb.agenda.dto.mapper.AddressMapper;
import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.dto.response.AddressResponse;
import br.edu.ifpb.agenda.entities.Address;
import br.edu.ifpb.agenda.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class AddressDAO {

//    private final EntityManager em = JPAUtil.getEntityManager();
    private AddressMapper addressMapper;

    public void save(AddressRequest request){
        EntityManager em = JPAUtil.getEntityManager();
        Address entity = addressMapper.INSTANCE.toModel(request);
        try {
            if (entity.getId() == null) {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
            } else {
                em.getTransaction().begin();
                em.merge(entity);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
    public void update(AddressRequest request) {
        EntityManager em = JPAUtil.getEntityManager();
        Address entity = addressMapper.INSTANCE.toModel(request);
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }


    public List<AddressResponse> findByIdUContact(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select a from Address a where a.contact.id = :id";
        TypedQuery<Address> query = em
                .createQuery(consult, Address.class)
                .setParameter("id",id)
                .setMaxResults(20);

        List<Address> addressList = query.getResultList();
        return addressList
                .stream()
                .map(addressMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());

    }

    public void deleteById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select c from Address c where c.id = :id";
        TypedQuery<Address> query = em
                .createQuery(consult, Address.class)
                .setParameter("id",id);
        Address address = query.getSingleResult();
        em.getTransaction().begin();
        em.remove(address);
        em.getTransaction().commit();
    }

    public AddressResponse findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select c from Address c where c.id = :id";
        TypedQuery<Address> query = em.createQuery(consult,Address.class)
                .setParameter("id", id);
        Address obj = query.getSingleResult();
        em.close();
        return addressMapper.INSTANCE.toDTO(obj);
    }
}

