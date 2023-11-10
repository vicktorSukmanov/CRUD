package web.dao;

import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getListUser(){
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void createUser(User user){
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public void updateUser(User user){
        entityManager.merge(user);
        entityManager.flush();
    }
    @Override
    public User readUser(long id){

        return entityManager.find(User.class, id);

    }
    @Override
    public void deleteUser(long id){
        User user = readUser(id);
        if(user==null){
            throw new NumberFormatException("User not find!!!");
        }
        entityManager.remove(user);
        entityManager.flush();

    }
}
