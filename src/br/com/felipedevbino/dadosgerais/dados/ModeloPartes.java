package br.com.felipedevbino.dadosgerais.dados;

import java.util.ArrayList;
import java.util.List;

import br.com.felipedevbino.dadosgerais.ModeloParaDados;

public class ModeloPartes {

	public List<String> partes;
	private ModeloParaDados modelo;

	public ModeloPartes() {
		partes = new ArrayList<String>();
		modelo = new ModeloParaDados();
	}

	public void inserirParte(String parte) {
		partes.add(parte);
	}

	public boolean deletarParte(String parte) {
		if (modelo.remover(parte, partes)) {
			partes = modelo.getArrayStr();
			return true;
		}
		return false;
	}

	public boolean renomearParte(String novaParte, String parte) {
		if (modelo.renomear(novaParte, parte, partes)) {
			partes = modelo.getArrayStr();
			return true;
		}
		return false;
	}
	
	public List<String> getPartes() {
		return partes;
	}

}
