package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;
import br.com.felipedevbino.sistema_valores.Brl;

public class ModeloEmpecilhos {

	private Map<String, BigDecimal> empecilhos;
	private Brl real;
	private ModeloParaDados modelo;

	public ModeloEmpecilhos() {
		empecilhos = new LinkedHashMap<>();
		modelo = new ModeloParaDados();
		real = new Brl();
	}

	public void inserirEmpecilho(String empecilho, Double custo) {
		BigDecimal formatador = real.formatar(false, 5, custo);
		empecilhos.put(empecilho, formatador);
	}

	public void deletarEmpecilho(String empecilho) {
		modelo.remover(empecilho, null, empecilhos);
	}

	public void renomearEmpecilho(String novoEmpecilho, String empecilho) {
		modelo.renomear(novoEmpecilho, empecilho, null, empecilhos);
	}

	public Map<String, BigDecimal> getEmpecilhos() {
		return empecilhos;
	}

}
