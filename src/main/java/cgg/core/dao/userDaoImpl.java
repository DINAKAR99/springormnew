package cgg.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cgg.core.entites.User;

@Component
public class userDaoImpl implements Userdao {
    @Autowired
    private SessionFactory s1;

    public SessionFactory getS1() {
        return s1;
    }

    public void setS1(SessionFactory s1) {
        this.s1 = s1;
    }

    public userDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    @Transactional
    public int createUser(User u1) {

        Session currentSession = s1.getCurrentSession();
        currentSession.persist(u1);
        return 1;

    }
}
