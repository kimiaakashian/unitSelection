package org.example.service.user;

import jakarta.validation.ConstraintViolation;
import org.example.base.service.BaseServiceImpl;
import org.example.model.Users;
import org.example.repository.user.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.Set;


public class UserServiceImpl extends BaseServiceImpl<Users, Long, UserRepository> implements UserService {
    public UserServiceImpl(UserRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public void signUpUsers(Users users) {

        repository.saveOrUpdate(users);

    }

    public Users findByUserName(String username) {
        Users user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.createQuery("FROM Users u WHERE u.username = :username", Users.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
