package br.com.felipedevbino.instancias;

import br.com.felipedevbino.dadosgerais.dados.ModeloDificuldade;
import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;

public class InstanceManager {

	private static ModeloEtapas modeloEtapas = new ModeloEtapas();
	private static ModeloEmpecilhos modeloEmpecilhos = new ModeloEmpecilhos();
	private static ModeloMateriais modeloMateriais = new ModeloMateriais();
	private static ModeloDificuldade modeloDificuldades = new ModeloDificuldade();
	
	public static ModeloEtapas getModeloEtapas() {
		return modeloEtapas;
	}
	
	public static ModeloMateriais getModeloMateriais() {
		return modeloMateriais;
	}
	
	public static ModeloEmpecilhos getModeloEmpecilhos() {
		return modeloEmpecilhos;
	}
	
	public static ModeloDificuldade getModeloDificuldades() {
		return modeloDificuldades;
	}
	
}
