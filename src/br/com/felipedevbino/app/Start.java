package br.com.felipedevbino.app;

import br.com.felipedevbino.gui.SistemaDeOrcamentos;
import br.com.felipedevbino.instancias.InstanceManager;

public class Start {

	/**
	 * @felipeDevBino
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		InstanceManager.inicializaOrcamentos();
		SistemaDeOrcamentos orcamento = InstanceManager.getSistemaDeOrcamentos();
		SistemaDeOrcamentos.main(args);
		//TODO
	}

}
