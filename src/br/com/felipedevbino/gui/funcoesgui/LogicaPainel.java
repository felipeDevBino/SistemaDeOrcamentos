package br.com.felipedevbino.gui.funcoesgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;

public class LogicaPainel {

	private List<String> nota;
	private BuscarEtapa buscarEtapas;
	private JPanel painelDeDados;
	
	public LogicaPainel(JPanel painelDeDados) {
		nota = new ArrayList<>();
		buscarEtapas = new BuscarEtapa();
		this.painelDeDados = painelDeDados;
	}
	
	public ActionListener escolherAcao() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//remover
				//renomear
				//reposicionar
			}
		};
	}
	
	public void removerNoPainel() {
		
	}
	
	public void renomearNoPainel() {
		
	}
	
	public void reposicionarNoPainel() {
		
	}
	
	public List<String> getNota() {
		return nota;
	}
	
}
