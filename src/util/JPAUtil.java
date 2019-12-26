/**
 * 
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 24, 2019
 * @file util.JPAUtil.java
 */
public class JPAUtil {
	private static final Logger LOGGER = LogManager.getLogger(JPAUtil.class.getName());
	private static EntityManagerFactory factory;

	static {
		LOGGER.info("Criando um objeto factory de testJPAPU.");
		factory = Persistence.createEntityManagerFactory("testJPA-PU");
	}

	public static EntityManager getEntityManager() {
		LOGGER.info("Objeto factory retornando uma instância de EntityManager.");
		return factory.createEntityManager();
	}

	public static void close() {
		LOGGER.info("Fechando o objeto factory.");
		factory.close();
	}

}
