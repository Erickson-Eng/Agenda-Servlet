package br.edu.ifpb.agenda.dao;

import br.edu.ifpb.agenda.dao.exceptions.ObjectNotFound;
import br.edu.ifpb.agenda.dto.mapper.UserMapper;
import br.edu.ifpb.agenda.dto.request.UserRequest;
import br.edu.ifpb.agenda.dto.response.UserResponse;
import br.edu.ifpb.agenda.entities.User;
import br.edu.ifpb.agenda.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDAO {

    private UserMapper userMapper;

//    private final EntityManager em = JPAUtil.getEntityManager();

    public void save(UserRequest request){
        EntityManager em = JPAUtil.getEntityManager();
        User entity = userMapper.INSTANCE.toModel(request);
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            if (em.isOpen()){
                em.getTransaction().rollback();
            }
        }finally {
            em.close();
        }
    }
    public UserResponse authorizeAccessByEmail(String email, String userPassword){
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select u from User u where u.email= :email and u.userPassword= :userPassword";
        try{
            TypedQuery<User> query =
                    em.createQuery(consult, User.class)
                            .setParameter("email", email)
                            .setParameter("userPassword", userPassword);
            return UserMapper.INSTANCE.toDTO(query.getSingleResult());
        }
        catch (NoResultException e){
            throw new ObjectNotFound("email not registered or password incorrect");
        }finally {
            em.close();
        }
    }

    public UserResponse authorizeAccessByUsername(String username, String password){
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select u from User u where u.username= :username and u.userPassword= :userPassword";
        try{
            TypedQuery<User> query =
                    em.createQuery(consult, User.class)
                            .setParameter("username", username)
                            .setParameter("userPassword", password);
            return UserMapper.INSTANCE.toDTO(query.getSingleResult());
        }
        catch (NoResultException e){
            throw new ObjectNotFound("Username not registered or password incorrect");
        }finally {
            em.close();
        }
    }
    public UserResponse findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        String consult = "select u from User u where u.id = :id";
        try{
            TypedQuery<User> query = em.createQuery(consult, User.class)
                    .setParameter("id", id);
            return userMapper.INSTANCE.toDTO(query.getSingleResult());
        }catch (NoResultException e){
            throw new ObjectNotFound("Username not registered");
        }finally {
            em.close();
        }
    }
}
