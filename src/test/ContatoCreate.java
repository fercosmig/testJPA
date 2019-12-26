/**
 * 
 */
package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Repository.ContatoRepository;
import model.Contato;

/**
 * @author Fernando Costa Migliorini
 * @email fercosmig@gmail.com
 * @since Dec 26, 2019
 * @file test.ContatoCreate.java
 */
public class ContatoCreate {
	private static final Logger LOGGER = LogManager.getLogger(ContatoCreate.class.getName());

	/**
	 * 
	 */
	public ContatoCreate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOGGER.info("Iniciando o processo.");
		Contato contato = new Contato();
		contato.setName("Sandra");
		contato.setEmail("sandra@bla.com");
		contato.setPhone("11 99999-9999");
		ContatoRepository.create(contato);
		LOGGER.info("Contato Inserido com sucesso!");
	}

}
