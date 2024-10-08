package br.com.felipedevbino.dadosgerais.dados;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloEtapas {

	private Map<String, List<String>> etapas;
	private ModeloParaDados modelo;

	public ModeloEtapas() {
		etapas = new HashMap<String, List<String>>();
		modelo = new ModeloParaDados();
	}

	public void inserirEtapa(String etapa, List<String> partes) {
		etapas.put(etapa, partes);
	}

	public boolean deletarEtapa(String etapa) {
		if (modelo.remover(etapa, etapas, null)) {
			etapas = modelo.getHashMapStr();
			return true;
		}
		return false;
	}

	public boolean renomearEtapa(String etapa, String nome) {
		if (modelo.renomear(etapa, nome, etapas, null)) {
			etapas = modelo.getHashMapStr();
			return true;
		}
		return false;
	}

	public Map<String, List<String>> getEtapas() {
		return etapas;
	}
	
}
