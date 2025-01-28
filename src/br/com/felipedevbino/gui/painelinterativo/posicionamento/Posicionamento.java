package br.com.felipedevbino.gui.painelinterativo.posicionamento;

public class Posicionamento {

	public final int larguraNoPainel = 150;
	public int alturaNoPainel = 30;
	public final int larguraDoObjeto = 655;
	public final int alturaDoObjeto = 15;
	private int alturaOriginalNoPainel = alturaNoPainel;

	public void incrementarParaOProximoTitulo() {
		//TODO
	}
	
	public void incrementarParaOProximoBotao() {
		//TODO
	}
	
	public void setValorOriginalAltura(int valor) {
		alturaOriginalNoPainel = valor;
	}

	public int getValorOriginalAltura() {
		return alturaOriginalNoPainel;
	}
	
	public void restaurarValoresDeTopo() {
		alturaOriginalNoPainel = 30;
		alturaNoPainel = alturaOriginalNoPainel;
	}
	
	
}
