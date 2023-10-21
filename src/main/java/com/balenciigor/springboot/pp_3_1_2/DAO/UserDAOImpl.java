package com.balenciigor.springboot.pp_3_1_2.DAO;
import com.balenciigor.springboot.pp_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.createQuery("DELETE from User u WHERE u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
