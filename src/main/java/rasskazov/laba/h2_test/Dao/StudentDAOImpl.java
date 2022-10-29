package rasskazov.laba.h2_test.Dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rasskazov.laba.h2_test.Entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO
{
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudents() {
        Query query = entityManager.createQuery("FROM Student");
        List<Student> allStudents = query.getResultList();
        log.info("getAllStudents" + allStudents);
        return allStudents;
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void deleteStudent(int id) {
        Query query = entityManager.createQuery("delete from Student where id =:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }
}