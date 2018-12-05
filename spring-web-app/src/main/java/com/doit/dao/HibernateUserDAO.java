package com.doit.dao;

import com.doit.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Vadym Mitin
 */
@Component
public class HibernateUserDAO implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<User> getAll() {
        return currentSession().createQuery("from User", User.class).list();
    }

    @Override
    public User getUserByEmail(String email) {

        Session session = currentSession();

        Query<User> query = session.createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);

        List<User> list = query.list();
        Optional<User> any = list.stream().findAny();
        return any.orElse(null);
    }

    @Override
    public void addUserToDB(User user) {
        currentSession().save(user);
    }
}
