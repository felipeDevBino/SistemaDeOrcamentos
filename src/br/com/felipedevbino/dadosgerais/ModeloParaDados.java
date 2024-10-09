package br.com.felipedevbino.dadosgerais;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ModeloParaDados {

	private List<String> arrayStrCopia;
	private Map<String, List<String>> hashMapStrCopia;
	private Map<String, Double> hashMapDoubleCopia;
	private Map<Object, String> hashMapObject;

	public ModeloParaDados() {
		arrayStrCopia = new ArrayList<String>();
		hashMapStrCopia = new HashMap<String, List<String>>();
		hashMapDoubleCopia = new HashMap<String, Double>();
		hashMapObject = new HashMap<Object, String>();
	}

	/**
	 * Método para deletar itens de ArrayLists de Strings
	 * 
	 * @param dadoParaRemocao
	 * @param dados
	 */
	public boolean remover(String dadoParaRemocao, List<String> dados) {
		int posicao = 0;
		for (String dado : dados) {
			if (dado.equals(dadoParaRemocao)) {
				dados.remove(posicao);
				arrayStrCopia = dados;
				return true;
			}
			posicao++;
		}
		return false;
	}

	/**
	 * Método para deletar itens de HashMaps (String, List de Strings) & (String,
	 * Double)
	 * 
	 * @param dadoParaRemocao
	 * @param dados
	 * @return
	 */
	public boolean remover(String dadoParaRemocao, Map<String, List<String>> dadosStr,
			Map<String, Double> dadosDouble) {
		if (dadosStr.containsKey(dadoParaRemocao)) {
			dadosStr.remove(dadoParaRemocao);
			hashMapStrCopia = dadosStr;
			return true;

		} else if (dadosDouble.containsKey(dadoParaRemocao)) {
			dadosDouble.remove(dadoParaRemocao);
			hashMapDoubleCopia = dadosDouble;
			return true;
		}
		return false;
	}

	/**
	 * Método para renomear itens de ArrayLists de Strings
	 * 
	 * @param novoNome
	 * @param dadoParaRenomear
	 * @param dados
	 */
	public boolean renomear(String novoNome, String dadoParaRenomear, List<String> dados) {
		int posicao = 0;
		for (String dado : dados) {
			if (dado.equals(dadoParaRenomear)) {
				dados.remove(posicao);
				dados.add(posicao, novoNome);
				arrayStrCopia = dados;
				return true;
			}
			posicao++;
		}
		return false;
	}

	/**
	 * Método para renomear itens de HashMaps (String, List de Strings) & (String,
	 * Double)
	 * 
	 * @param novoItem
	 * @param dadoParaRenomear
	 * @param dados
	 */
	public boolean renomear(String novoNome, String dadoParaRenomear, Map<String, List<String>> dadosStr,
			Map<String, Double> dadosDouble) {

		if (dadosStr.containsKey(dadoParaRenomear)) {
			List<String> copiaValor = dadosStr.get(dadoParaRenomear);
			dadosStr.remove(dadoParaRenomear);
			dadosStr.put(novoNome, copiaValor);
			hashMapStrCopia = dadosStr;
			return true;
			
		} else if (dadosDouble.containsKey(dadoParaRenomear)) {
			double copiaValor = dadosDouble.get(dadoParaRenomear);
			dadosDouble.remove(dadoParaRenomear);
			dadosDouble.put(novoNome, copiaValor);
			hashMapDoubleCopia = dadosDouble;
			return true;
			
		}
		return false;
	}

	/**
	 * Método para modificar itens de um HashMap de (Object, String)
	 * 
	 * @param instancia
	 * @param novaDificuldade
	 * @param dadosObject
	 */
	public boolean modificar(Object instancia, String novaDificuldade, Map<Object, String> dadosObject) {
		if (dadosObject.get(instancia) != null) {
			dadosObject.replace(instancia, novaDificuldade);
			return true;
		}
		return false;
	}

	/**
	 * Retorna Array de String, definindo o conteúdo da variável a se atribuir, o
	 * valor copiado das operações do array cópia da classe ModeloParaDados
	 * 
	 * @return
	 */
	public List<String> getArrayStr() {
		return arrayStrCopia;
	}

	/**
	 * Retorna HashMap de ArrayList<String>, definindo o conteúdo da variável a se
	 * atribuir, o valor copiado das operações do hash map cópia da classe
	 * ModeloParaDados
	 * 
	 * @return
	 */
	public Map<String, List<String>> getHashMapStr() {
		return hashMapStrCopia;
	}

	/**
	 * Retorna HashMap de Integer, definindo o conteúdo da variável a se atribuir, o
	 * valor copiado das operações do hash map cópia da classe ModeloParaDados
	 * 
	 * @return
	 */
	public Map<String, Double> getHashMapDouble() {
		return hashMapDoubleCopia;
	}

	/**
	 * Retorna HashMap de Object, definindo o conteúdo da variável a se atribuir, o
	 * valor copiado das operações do hash map cópia da classe ModeloParaDados
	 * 
	 * @return
	 */
	public Map<Object, String> getHashMapObject() {
		return hashMapObject;
	}

}
