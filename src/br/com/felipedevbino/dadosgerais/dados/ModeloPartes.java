package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.util.HashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloPartes {

	private Map<String, Double> partes;
	private ModeloParaDados modelo;

	public ModeloPartes() {
		partes = new HashMap<>();
		modelo = new ModeloParaDados();
	}

	public void inserirParte(String parte, Double valor) {
		partes.put(parte, valor);
	}

	public void deletarParte(String parte) {
		modelo.remover(parte, null, partes);	
	}

	public void renomearParte(String novaParte, String parte) {
		 modelo.renomear(novaParte, parte, null, partes);
		
	}
	
	public Map<String, Double> getPartes() {
		return partes;
	}

}
