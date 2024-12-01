package br.com.felipedevbino.dadosgerais.dados;

import java.util.HashMap;
import java.util.Map;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloDificuldade {

	private Map<Object, String> dificuldades;
	private ModeloParaDados modelo;

	public ModeloDificuldade() {
		dificuldades = new HashMap<>();
		modelo = new ModeloParaDados();
	}

	public void atribuirDificuldade(Object instancia, String dificuldade) {
		dificuldades.put(instancia, dificuldade);
	}

	public void deletarDificuldade(Object instancia, String dadoParaRemocao) {
		if (dificuldades.containsKey(dadoParaRemocao)) {
			dificuldades.remove(dadoParaRemocao);
		}
	}

	public void modificarDificuldade(Object instancia, String novaDificuldade) {
		modelo.modificar(instancia, novaDificuldade, dificuldades);
	}

	public Map<Object, String> getDificuldades() {
		return dificuldades;
	}

}
