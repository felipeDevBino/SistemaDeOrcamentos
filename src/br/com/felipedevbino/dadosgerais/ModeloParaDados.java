package br.com.felipedevbino.dadosgerais;

import java.util.List;
import java.util.Map;

public class ModeloParaDados {

	/**
	 * Método para deletar itens de ArrayLists de Strings.
	 * 
	 * @param dadoParaRemocao
	 * @param dados
	 */
	public void remover(String dadoParaRemocao, List<String> dados) {
		int contador = 0;
		for (String dado : dados) {
			if (dado.equals(dadoParaRemocao)) {
				dados.remove(contador);
			}
			contador++;
		}
	}

	/**
	 * Método para deletar itens de HashMaps (String, List de Strings) & (String,
	 * Double).
	 * 
	 * @param dadoParaRemocao
	 * @param dados
	 * @return
	 */
	public void remover(String dadoParaRemocao, Map<String, List<String>> dadosStr,
			Map<String, Double> dadosDouble) {
		if (dadosStr.containsKey(dadoParaRemocao)) {
			dadosStr.remove(dadoParaRemocao);

		} else if (dadosDouble.containsKey(dadoParaRemocao)) {
			dadosDouble.remove(dadoParaRemocao);
		}
	}

	/**
	 * Método para deletar itens de HashMaps (String, Map<String, Double>).
	 * 
	 * @param dadoParaRemocao
	 * @param dadosDoubleMap
	 * @return
	 */
	public void remover(String dadoParaRemocao, Map<String, Map<String, Double>> dadosDoubleMap) {
		if (dadosDoubleMap.containsKey(dadoParaRemocao)) {
			dadosDoubleMap.remove(dadoParaRemocao);
		}
	}

	/**
	 * Método para renomear itens de ArrayLists de Strings.
	 * 
	 * @param novoNome
	 * @param dadoParaRenomear
	 * @param dados
	 */
	public void renomear(String novoNome, String dadoParaRenomear, List<String> dados) {
		int posicao = 0;
		for (String dado : dados) {
			if (dado.equals(dadoParaRenomear)) {
				dados.remove(posicao);
				dados.add(posicao, novoNome);
			}
			posicao++;
		}
	}

	/**
	 * Método para renomear itens de HashMaps (String, List de Strings) & (String,
	 * Double).
	 * 
	 * @param novoItem
	 * @param dadoParaRenomear
	 * @param dados
	 */
	public void renomear(String novoNome, String dadoParaRenomear, Map<String, List<String>> dadosStr,
			Map<String, Double> dadosDouble) {

		if (dadosStr.containsKey(dadoParaRenomear)) {
			List<String> copiaValor = dadosStr.get(dadoParaRenomear);
			dadosStr.remove(dadoParaRenomear);
			dadosStr.put(novoNome, copiaValor);

		} else if (dadosDouble.containsKey(dadoParaRenomear)) {
			double copiaValor = dadosDouble.get(dadoParaRenomear);
			dadosDouble.remove(dadoParaRenomear);
			dadosDouble.put(novoNome, copiaValor);

		}
	}
	
	/**
	 * Método para renomear itens de HashMaps (String, Map<String, Double>).
	 * 
	 * @param novoNome
	 * @param dadoParaRenomear
	 * @param dadosDoubleMap
	 */
	public void renomear(String novoNome, String dadoParaRenomear, Map<String, Map<String, Double>> dadosDoubleMap) {
		if(dadosDoubleMap.containsKey(dadoParaRenomear)) { 
			Map<String, Double> dadosDoubleMapCopia = dadosDoubleMap.get(dadoParaRenomear);
			dadosDoubleMap.remove(dadoParaRenomear);
			dadosDoubleMap.put(novoNome, dadosDoubleMapCopia);
		}
	}

	/**
	 * Método para modificar itens de um HashMap de (Object, String).
	 * 
	 * @param instancia
	 * @param novaDificuldade
	 * @param dadosObject
	 */
	public void modificar(Object instancia, String novaDificuldade, Map<Object, String> dadosObject) {
		if (dadosObject.get(instancia) != null) {
			dadosObject.replace(instancia, novaDificuldade);
		}
	}

}
