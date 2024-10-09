package br.com.felipedevbino.dadosgerais.dados;

import java.util.HashMap;
import java.util.Map;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloDificuldade {

	private Map<Object, String> dificuldades;
	private ModeloParaDados modelo;

	public ModeloDificuldade() {
		dificuldades = new HashMap<Object, String>();
		modelo = new ModeloParaDados();
	}

	public void atribuirDificuldade(Object instancia, String dificuldade) {
		dificuldades.put(instancia, dificuldade);
	}

	public boolean deletarDificuldade(Object instancia, String dadoParaRemocao) {
		if (dificuldades.containsKey(instancia)) {
			dificuldades.remove(instancia);
			return true;
		}
		return false;
	}

	public boolean modificarDificuldade(Object instancia, String novaDificuldade) {
		if (modelo.modificar(instancia, novaDificuldade, dificuldades)) {
			dificuldades = modelo.getHashMapObject();
			return true;
		}
		return false;
	}

	public Map<Object, String> getDificuldades() {
		return dificuldades;
	}
	
}
