package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloEtapas {

	private Map<String, Map<String, BigDecimal>> etapas;
	private Map<String, BigDecimal> copiaPartes;
	private ModeloParaDados modelo;

	public ModeloEtapas() {
		etapas = new LinkedHashMap<>();
		modelo = new ModeloParaDados();
	}

	public void inserirEtapa(String etapa, Map<String, BigDecimal> partes) {
		etapas.put(etapa, retornarNovasPartes(etapa, partes));
	}

	private Map<String, BigDecimal> retornarNovasPartes(String etapa, Map<String, BigDecimal> partes) {
		if (etapas.containsKey(etapa)) {
			copiaPartes = new LinkedHashMap<>(etapas.get(etapa));
		} else {
			copiaPartes = new LinkedHashMap<>();
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

	public Map<String, Map<String, BigDecimal>> getEtapas() {
		return etapas;
	}


}
