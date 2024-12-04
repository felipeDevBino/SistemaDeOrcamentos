package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.util.LinkedHashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloEmpecilhos {

	private Map<String, Double> empecilhos;
	private ModeloParaDados modelo;

	public ModeloEmpecilhos() {
		empecilhos = new LinkedHashMap<>();
		modelo = new ModeloParaDados();
	}

	public void inserirEmpecilho(String empecilho, Double custo) {
		empecilhos.put(empecilho, custo);
	}

	public void deletarEmpecilho(String empecilho) {
		modelo.remover(empecilho, null, empecilhos);
	}

	public void renomearEmpecilho(String novoEmpecilho, String empecilho) {
		modelo.renomear(novoEmpecilho, empecilho, null, empecilhos);
	}

	public Map<String, Double> getEmpecilhos() {
		return empecilhos;
	}

}
