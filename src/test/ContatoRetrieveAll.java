/**
 * 
 */
package test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Repository.ContatoRepository;
import model.Contato;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 26, 2019
 * @file test.ContatoRetrieveAll.java
 */
public class ContatoRetrieveAll {
	private static final Logger LOGGER = LogManager.getLogger(ContatoRetrieveAll.class.getName());

	/**
	 * 
	 */
	public ContatoRetrieveAll() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		LOGGER.info("Listando contatos.");

		List<Contato> lc = ContatoRepository.retrieveAll();
		for (Contato c : lc) {
			System.out.print(c.getId());
			System.out.print(" :: ");
			System.out.print(c.getName());
			System.out.print(" :: ");
			System.out.print(c.getEmail());
			System.out.print(" :: ");
			System.out.print(c.getPhone());
			System.out.print(" :: ");
			System.out.print(c.getStatus());
			System.out.print(" :: ");
			System.out.println(c.getRegistrationDate());
		}
	}
}
