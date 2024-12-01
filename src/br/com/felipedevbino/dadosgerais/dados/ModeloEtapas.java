package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.util.HashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloEtapas {

	private Map<String, Map<String, Double>> etapas;
	private Map<String, Double> copiaPartes;
	private ModeloParaDados modelo;

	public ModeloEtapas() {
		etapas = new HashMap<>();
		modelo = new ModeloParaDados();
	}

	public void inserirEtapa(String etapa, Map<String, Double> partes) {
		etapas.put(etapa, retornarNovasPartes(etapa, partes));
	}

	private Map<String, Double> retornarNovasPartes(String etapa, Map<String, Double> partes) {
		if (etapas.containsKey(etapa)) {
			copiaPartes = new HashMap<>(etapas.get(etapa));
		} else {
			copiaPartes = new HashMap<>();
		}
		if (partes != null) {
			copiaPartes.putAll(partes);
		}
		return copiaPartes;
	}

	public void deletarEtapa(String etapa) {
		modelo.remover(etapa, etapas);
	}

	public void renomearEtapa(String etapa, String nome) {
		modelo.renomear(nome, nome, etapas);
	}

	public Map<String, Map<String, Double>> getEtapas() {
		return etapas;
	}

}
