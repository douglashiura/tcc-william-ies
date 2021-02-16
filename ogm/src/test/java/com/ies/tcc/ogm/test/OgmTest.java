package com.ies.tcc.ogm.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

import org.junit.Test;

import com.ies.tcc.jpa.model.Breed;
import com.ies.tcc.jpa.model.Dog;

public class OgmTest {

	@Test
	public void persistABreed() throws Exception {
		// accessing JBoss's Transaction can be done differently but this one works
		// nicely
		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();

		// build the EntityManagerFactory as you would build in in Hibernate ORM
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogm-jpa-tutorial");

		// Persist entities the way you are used to in plain JPA
		tm.begin();
		EntityManager em = emf.createEntityManager();
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
		emf.close();
		assertNotNull(collie.getId());
		assertNotNull(dina.getId());
	}
}
