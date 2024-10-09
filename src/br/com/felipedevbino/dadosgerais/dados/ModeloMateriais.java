package br.com.felipedevbino.dadosgerais.dados;

import java.util.List;
import java.util.ArrayList;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloMateriais {

	public List<String> materiais;
	private ModeloParaDados modelo;

	public ModeloMateriais() {
		materiais = new ArrayList<String>();
		modelo = new ModeloParaDados();
	}

	public void inserirMaterial(String material) {
		materiais.add(material);
	}

	public boolean deletarMaterial(String material) {
		if (modelo.remover(material, materiais)) {
			materiais = modelo.getArrayStr();
			return true;
		}
		return false;
	}

	public boolean renomearMaterial(String novoNomeMaterial, String material) {
		if (modelo.renomear(novoNomeMaterial, material, materiais)) {
			materiais = modelo.getArrayStr();
			return true;
		}
		return false;
	}

	public List<String> getMateriais() {
		return materiais;
	}
	
}
