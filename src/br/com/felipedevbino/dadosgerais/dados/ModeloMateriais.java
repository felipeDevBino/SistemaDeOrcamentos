package br.com.felipedevbino.dadosgerais.dados;

import java.util.Map;
import java.math.BigDecimal;
import java.util.LinkedHashMap;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;
import br.com.felipedevbino.sistema_valores.Brl;

public class ModeloMateriais {

	public Map<String, BigDecimal> materiais;
	private ModeloParaDados modelo;
	private Brl real;

	public ModeloMateriais() {
		materiais = new LinkedHashMap<>();
		modelo = new ModeloParaDados();
		real = new Brl();
	}

	public void inserirMaterial(String material, Double valor) {
		BigDecimal formatador = real.formatar(false, 5, valor);
		materiais.put(material, formatador);
	}

	public void deletarMaterial(String material) {
		modelo.remover(material, null, materiais);
	}

	public void renomearMaterial(String novoNomeMaterial, String material) {
		modelo.renomear(novoNomeMaterial, material, null, materiais);
	}

	public Map<String, BigDecimal> getMateriais() {
		return materiais;
	}

}
