package com.lessons.clinic.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.lessons.clinic.dao.UserDao;
import com.lessons.clinic.domain.auth.UserDto;
import com.lessons.clinic.entities.User;
import com.lessons.clinic.utils.HibernateUtil;

@Service
public class UserService {
	
	@PersistenceContext
    private EntityManager em;
	private final UserDao userDao;
	
	public Session getSession() {
	    Session session = em.unwrap(Session.class);
	    return session;
	  }

    public UserService(UserDao userDao) {
    	this.userDao = userDao;
    }

    public Optional<UserDto> getByLogin(@NonNull String login) {
    	Optional<User> user = userDao.getByLogin(login);
    	return user.isPresent() ? Optional.ofNullable(user.get().fromEntity()) : Optional.empty();
    }

}
