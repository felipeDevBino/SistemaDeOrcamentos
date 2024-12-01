package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.util.HashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloMateriais {

	public Map<String, Double> materiais;
	private ModeloParaDados modelo;

	public ModeloMateriais() {
		materiais = new HashMap<>();
		modelo = new ModeloParaDados();
	}

	public void inserirMaterial(String material, Double valor) {
		materiais.put(material, valor);
	}

	public void deletarMaterial(String material) {
		modelo.remover(material, null, materiais);
	}

	public void renomearMaterial(String novoNomeMaterial, String material) {
		modelo.renomear(novoNomeMaterial, material, null, materiais);
	}

	public Map<String, Double> getMateriais() {
		return materiais;
	}
	
}
