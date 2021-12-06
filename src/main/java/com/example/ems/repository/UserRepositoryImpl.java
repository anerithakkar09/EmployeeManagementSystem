package com.example.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.ems.model.User;

public class UserRepositoryImpl implements UserRepositoryCustom
{
	
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> userCriteriaQuery = cb.createQuery(User.class);
		Root<User> userRoot = userCriteriaQuery.from(User.class);
		Predicate predicate = cb.equal(userRoot.get("username"), username);
		userCriteriaQuery.where(predicate);
		TypedQuery<User> typedQuery = entityManager.createQuery(userCriteriaQuery);
		List<User> users = typedQuery.getResultList();
		return users == null || users.isEmpty() ? null : users.get(0);		
	}

}
