package entity.dao;

import java.util.List;

import entity.Person;

public interface PersonDAO {

	void save(Person person);
	void update(Person person);
	void delete(Person person);
	Person finById(Integer id);
	
	List<Person> getAll();
	
	List<Person> findByLastName(String lastName);
	
}
