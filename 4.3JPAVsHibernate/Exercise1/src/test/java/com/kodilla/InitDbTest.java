package com.kodilla;

import com.kodilla.domain.Person;
import com.kodilla.domain.SubTask;
import com.kodilla.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootTest
public class InitDbTest {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void init() {
        Person thomas = new Person("thomas", "thomson");


        Task task = new Task("Learn Java", "in progress");
//        task.getPersonList().add(thomas);
//        thomas.getTaskList().add(task);


        SubTask subTask = new SubTask("Learn Hibernate", "in progress");
//        subTask.getPersonList().add(thomas);
//        thomas.getSubTaskList().add(task);
        subTask.getTaskList().add(task);
        task.getSubTaskList().add(subTask);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.persist(thomas);
        entityManager.persist(subTask);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
