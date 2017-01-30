package entity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Person;

@Repository(value="personDao")
public class PersonDAOImpl implements PersonDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void save(Person person) {
		entityManager.persist(person);
	}


	@Transactional
	public void update(Person person) {
		entityManager.merge(person);
	}

	@Transactional
	public void delete(Person person) {
		entityManager.remove(person);
	}

	public Person finById(Integer id) {
		return entityManager.createQuery("from Person where id=:id", Person.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	public List<Person> getAll() {
		return entityManager.createQuery("from Person", Person.class)
				.getResultList();
	}

	public List<Person> findByLastName(String lastName) {
		return entityManager.createQuery("from Person where lastName like :lastName", Person.class)
				.setParameter("lastName", lastName + "%")
				.getResultList();
	}

}
