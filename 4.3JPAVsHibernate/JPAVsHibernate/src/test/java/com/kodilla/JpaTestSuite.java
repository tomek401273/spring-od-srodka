package com.kodilla;

import com.kodilla.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootTest
class JpaTestSuite {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Test
    void shouldPersistCustomer() {
        //Given
        EntityManager em = emf.createEntityManager();
        Customer kodilla =
                new Customer(null, "Kodilla", "ul. Racławicka 13", "Wrocław");

        //When
        em.getTransaction().begin();
        em.persist(kodilla);
        em.flush();
        em.getTransaction().commit();

        //Then
        Long key = kodilla.getId();
        Customer readCustomer = em.find(Customer.class, key);
        em.close();
        Assertions.assertThat(readCustomer.getName()).isEqualTo(kodilla.getName());
    }

}
