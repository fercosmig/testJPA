/**
 * 
 */
package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Contato;
import util.JPAUtil;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 26, 2019
 * @file Repository.ContatoRepository.java
 */
public class ContatoRepository {

	private static final Logger LOGGER = LogManager.getLogger(ContatoRepository.class.getName());

	/** Constructors */
	public ContatoRepository() {
		// TODO Auto-generated constructor stub
	}

	/** Methods */
	public static void create(Contato contato) {
		LOGGER.info("method create");
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(contato);
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			transaction.rollback();
			return;
		} finally {
			manager.close();
			// JPAUtil.close();
		}
	}

	public static Contato retrieveById(Integer id) {
		LOGGER.info("method retrieveById");
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			String sql = "SELECT c FROM Contato c WHERE c.id = :id";
			TypedQuery<Contato> query = manager.createQuery(sql, Contato.class);
			query.setParameter("id", id);
			Contato c = query.getSingleResult();
			return c;
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			manager.close();
			// JPAUtil.close();
		}
		return null;
	}

	public static List<Contato> retrieveAll() {
		LOGGER.info("method retrieveAll");
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			String sql = "SELECT c FROM Contato c WHERE c.status = true ORDER BY c.name ASC";
			TypedQuery<Contato> query = manager.createQuery(sql, Contato.class);
			List<Contato> contatos = query.getResultList();
			return contatos;
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			manager.close();
			// JPAUtil.close();
		}
		return null;
	}

	public static void update(Contato contato) {
		LOGGER.info("method update");
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(contato);
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error(e);
			transaction.rollback();
		} finally {
			manager.close();
			// JPAUtil.close();
		}
	}

	public static void delete(Contato contato) {
		LOGGER.info("method delete");
	}

}
