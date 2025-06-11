package br.com.felipedevbino.gui.painelinterativo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.logicadados.etapas.BuscarEtapa;

public class LogicaPainel {

	private List<String> nota;
	private Interacao interacao;
	private BuscarEtapa buscarEtapas;

	public LogicaPainel() {
		nota = new ArrayList<>();
		interacao = new Interacao();
		buscarEtapas = new BuscarEtapa();
	}
	
	//UTILIZAR CRITÉRIO DE VERIFICAÇÃO SOBRE (NOME / VALOR)
	protected void renomearNoPainel(JButton dado) {
		String valor = "";
		
		do {
			
			valor = interacao.inserirDadoDeTexto("Insira o novo nome/valor:");
			
			if(!valor.isBlank()) {
			
				dado.setText(valor);
			
			}else {
			
				interacao.mostrarMensagemDeErro("ERRO! INSIRA UM DADO DE TEXTO VÁLIDO.");

			}
			
		} while(valor.isBlank());
		
	}

	protected void reposicionarNoPainel(JButton dado) {
		//TODO
	}

	private void moverComponente() {
		//TODO
	}
	
	protected void removerNoPainel() {
		System.out.println("removeu");
	}
	
	public List<String> getNota() {
		return nota;
	}

}
