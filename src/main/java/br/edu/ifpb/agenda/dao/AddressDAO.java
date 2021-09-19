package br.edu.ifpb.agenda.dao;

import br.edu.ifpb.agenda.dto.mapper.AddressMapper;
import br.edu.ifpb.agenda.dto.request.AddressRequest;
import br.edu.ifpb.agenda.entities.Address;
import br.edu.ifpb.agenda.utils.JPAUtil;

import javax.persistence.EntityManager;

public class AddressDAO {

    private final EntityManager em = JPAUtil.getEntityManager();
    private AddressMapper addressMapper;

    public void save(AddressRequest request){
        Address entity = addressMapper.INSTANCE.toModel(request);
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
}
