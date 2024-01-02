package com.springcourse.cruddemo.dao;

import com.springcourse.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        //Note the 'Student' in the query is actually the JPA Entity and not a Table name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //run the query
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String theLastName) {
        //create query
        TypedQuery<Student> findByLastNameQuery = entityManager.createQuery(
                                                "FROM Student where lastName = :theName", Student.class);

        //assign query parameter
        findByLastNameQuery.setParameter("theName", theLastName);

        //execute query
        return findByLastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student theStudent = findById(id);
        entityManager.remove(theStudent);
    }

}
