package com.kodilla;

import com.kodilla.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;

@SpringBootTest
public class SelectFromDbTest {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Test
    public void lazySelect() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Task> taskTypedQuery = entityManager.createQuery("SELECT t FROM Task t WHERE t.id=5", Task.class);

        EntityGraph<Task> entityGraph = entityManager.createEntityGraph(Task.class);
        entityGraph.addSubgraph("subTaskList");
        taskTypedQuery.setHint("javax.persistence.fetchgraph", entityGraph);

        Task task = taskTypedQuery.getSingleResult();
        System.out.println(task);
        readObjects(task.getSubTaskList());
    }

    public void readObjects(List<?> objects) {
        objects.forEach(System.out::println);
    }
}
