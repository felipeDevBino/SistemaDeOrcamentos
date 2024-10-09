package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.util.HashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloEmpecilhos {

	private Map<String, Double> empecilhos;
	private ModeloParaDados modelo;

	public ModeloEmpecilhos() {
		empecilhos = new HashMap<String, Double>();
		modelo = new ModeloParaDados();
	}

	public void inserirEmpecilho(String empecilho, Double custo) {
		empecilhos.put(empecilho, custo);
	}

	public boolean deletarEmpecilho(String empecilho) {
		if (modelo.remover(empecilho, null, empecilhos)) {
			empecilhos = modelo.getHashMapDouble();
			return true;
		}
		return false;
	}

	public boolean renomearEmpecilho(String novoEmpecilho, String empecilho) {
		if (modelo.renomear(novoEmpecilho, empecilho, null, empecilhos)) {
			empecilhos = modelo.getHashMapDouble();
			return true;
		}
		return false;
	}

	public Map<String, Double> getEmpecilhos() {
		return empecilhos;
	}
	
}
