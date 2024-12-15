package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;
import br.com.felipedevbino.sistema_valores.Brl;

public class ModeloPartes {

	private Map<String, BigDecimal> partes;
	private ModeloParaDados modelo;
	private Brl real;
	
	public ModeloPartes() {
		partes = new LinkedHashMap<>();
		modelo = new ModeloParaDados();
		real = new Brl();
	}

	public void inserirParte(String parte, Double valor) {
		BigDecimal formatador = real.formatar(true, 5, valor);
		partes.put(parte, formatador);
	}

	public void deletarParte(String parte) {
		modelo.remover(parte, null, partes);
	}

	public void renomearParte(String novaParte, String parte) {
		modelo.renomear(novaParte, parte, null, partes);
	}

	public Map<String, BigDecimal> getPartes() {
		return partes;
	}

}
