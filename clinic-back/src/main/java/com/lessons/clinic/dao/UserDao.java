package com.lessons.clinic.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.lessons.clinic.domain.auth.UserDto;
import com.lessons.clinic.entities.User;

@Repository
public class UserDao {

	@PersistenceContext
    private EntityManager em;
	
	public Session getSession() {
	    Session session = em.unwrap(Session.class);
	    return session;
	  }

	
	public Optional<User> getByLogin(@NonNull String login) {
    	List<User> users = getSession().createQuery("from User where login = :login", User.class)
    	.setParameter("login", login).getResultList();
    	return users.stream().findFirst();
    }

}
