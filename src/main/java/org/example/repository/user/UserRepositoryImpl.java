package org.example.repository.user;

import org.example.base.repository.BaseRepositoryImpl;
import org.example.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserRepositoryImpl extends BaseRepositoryImpl<Users,Long> implements UserRepository {
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }



}
