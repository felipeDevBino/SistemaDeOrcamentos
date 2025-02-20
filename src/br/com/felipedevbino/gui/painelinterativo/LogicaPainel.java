package br.com.felipedevbino.gui.painelinterativo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import br.com.felipedevbino.gui.funcoesgui.Interacao;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;

public class LogicaPainel {

	private List<String> nota;
	private Interacao interacao;
	private BuscarEtapa buscarEtapas;
	private JPanel painelDeDados;

	public LogicaPainel(JPanel painelDeDados) {
		nota = new ArrayList<>();
		interacao = new Interacao();
		buscarEtapas = new BuscarEtapa();
		this.painelDeDados = painelDeDados;
	}

	public ActionListener escolherAcao() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuDeAcoes menu = new MenuDeAcoes();
				menu.getJFrame().setVisible(true);
				
				switch (MenuDeAcoes.getAcao()) {
				case 1:
					renomearNoPainel();
					break;
				case 2:
					reposicionarNoPainel();
					break;
				case 3:
					removerNoPainel();
					break;
				default:
					break;
				}
			}
		};
	}
	
	private void renomearNoPainel() {
		System.out.println("renomeou");
	}

	private void reposicionarNoPainel() {
		System.out.println("reposicionou");
	}

	private void removerNoPainel() {
		System.out.println("removeu");
	}
	
	public List<String> getNota() {
		return nota;
	}

}
