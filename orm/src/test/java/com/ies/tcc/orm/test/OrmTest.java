package com.ies.tcc.orm.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import com.ies.tcc.jpa.model.Breed;
import com.ies.tcc.jpa.model.Dog;

public class OrmTest {

	@Test
	public void persistABreed() throws Exception {
		EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("orm-jpa-tutorial");
		EntityManager em = sessionFactory.createEntityManager();
		EntityTransaction tm = em.getTransaction();
		tm.begin();
		Breed collie = new Breed();
		collie.setName("Collie");
		em.persist(collie);
		Dog dina = new Dog();
		dina.setName("Dina");
		dina.setBreed(collie);
		em.persist(dina);
		em.flush();
		em.close();
		tm.commit();
		assertNotNull(collie.getId());
		assertNotNull(dina.getId());
	}

}
