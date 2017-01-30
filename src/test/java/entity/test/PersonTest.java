package entity.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Person;
import entity.dao.PersonDAO;
import entity.dao.PersonDAOImpl;

public class PersonTest {
    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        PersonDAO personDao = (PersonDAO) context.getBean("personDao");
        
        Person person = new Person();
        person.setFirstName("Lena");
        person.setLastName("Gurevich");
        person.setHiredOn(new Date());
        person.setSalary(150000F);

        personDao.save(person);
        
        System.out.println(person);

        person.setSalary(160000F);

        personDao.update(person);
        
        System.out.println(person);
        
        person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setHiredOn(new Date());
        person.setSalary(150000F);

        personDao.save(person);
        
        Person p = personDao.finById(1);

        System.out.println(person);

        assertNotNull(p);

        Person person2 = new Person();
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setHiredOn(new Date());
        person2.setSalary(150000F);
        personDao.save(person2);
        
        p = personDao.finById(2);
        
        System.out.println(person);
        
        assertNotNull(p);
        
        List<Person> persons = personDao.getAll();
        
        System.out.println(persons);
        
        assertNotNull(persons);
        
        persons = personDao.findByLastName("Gur");
        
        System.out.println(persons);
        
        assertNotNull(persons);
        
        

    }
}
