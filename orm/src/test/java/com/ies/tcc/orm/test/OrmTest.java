package com.ies.tcc.orm.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class OrmTest {

	@Test
	public void persistABreed() throws Exception {
		EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("orm-jpa-tutorial");
		sessionFactory.createEntityManager();
	}

}
