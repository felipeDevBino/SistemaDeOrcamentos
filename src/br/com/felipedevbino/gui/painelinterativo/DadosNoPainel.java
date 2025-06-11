package br.com.felipedevbino.gui.painelinterativo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.felipedevbino.dadosgerais.dados.ModeloEmpecilhos;
import br.com.felipedevbino.dadosgerais.dados.ModeloEtapas;
import br.com.felipedevbino.dadosgerais.dados.ModeloMateriais;
import br.com.felipedevbino.instancias.InstanceManager;
import br.com.felipedevbino.logicaexecucao.logicadados.etapas.BuscarEtapa;
import br.com.felipedevbino.logicaexecucao.logicadados.partes.BuscarParte;

public class DadosNoPainel {

	private Map<Integer, List<Component>> componentes;
	private List<Component> novosComponentes;
	private ModeloEtapas etapas = InstanceManager.getModeloEtapas();
	private ModeloMateriais materiais = InstanceManager.getModeloMateriais();
	private ModeloEmpecilhos empecilhos = InstanceManager.getModeloEmpecilhos();
	private JPanel painelDeDados;
	private LogicaPainel logicaPainel;
	private BuscarEtapa buscarEtapas;
	private BuscarParte buscarParte;
	private ImageIcon iconeEtapas;
	private ImageIcon iconePartes;
	private ImageIcon iconeDinheiro;
	private ImageIcon iconeMateriais;
	private ImageIcon iconeEmpecilhos;

	public DadosNoPainel(JPanel painelDeDados) {
		etapas = InstanceManager.getModeloEtapas();
		materiais = InstanceManager.getModeloMateriais();
		empecilhos = InstanceManager.getModeloEmpecilhos();
		this.painelDeDados = painelDeDados;
		buscarEtapas = new BuscarEtapa();
		buscarParte = new BuscarParte();
		componentes = new HashMap<>();
		novosComponentes = new ArrayList<>();
		iconeEtapas = new ImageIcon("src/resources/etapas.png");
		iconePartes = new ImageIcon("src/resources/partes.png");
		iconeDinheiro = new ImageIcon("src/resources/dinheiro.png");
		iconeMateriais = new ImageIcon("src/resources/materiais.png");
		iconeEmpecilhos = new ImageIcon("src/resources/empecilhos.png");
	}

	public void addEtapas() {

		adicionarTitulo("ETAPAS", 0);
		inserirEtapasComponentes();
		exibirComponentes();
		painelDeDados.revalidate();
		painelDeDados.repaint();

	}

	public void addMateriais() {

		adicionarTitulo("MATERIAIS", 1);
		inserirMateriaisComponentes();
		exibirComponentes();
		painelDeDados.revalidate();
		painelDeDados.repaint();

	}

	public void addEmpecilhos() {

		adicionarTitulo("EMPECILHOS", 2);
		inserirEmpecilhosComponentes();
		exibirComponentes();
		painelDeDados.revalidate();
		painelDeDados.repaint();

	}

	private ImageIcon definirIcone(int tipo, int largura, int altura) {
		Image imagem = null;
		
		if(tipo == 0) { //ETAPAS
			imagem = iconeEtapas.getImage().getScaledInstance(
					largura, altura, Image.SCALE_SMOOTH);

		}else if(tipo == 1) { //MATERIAIS
			imagem = iconeMateriais.getImage().getScaledInstance(
					largura, altura, Image.SCALE_SMOOTH);
			
		}else if(tipo == 2) { //EMPECILHOS
			imagem = iconeEmpecilhos.getImage().getScaledInstance(
					largura, altura, Image.SCALE_SMOOTH);
		
		}else if(tipo == 3) { //PARTES
			imagem = iconePartes.getImage().getScaledInstance(
					largura, altura, Image.SCALE_SMOOTH);
			
		}else if(tipo == 4) { //DINHEIRO
			imagem = iconeDinheiro.getImage().getScaledInstance(
					largura, altura, Image.SCALE_SMOOTH);
					
		}
				
		return new ImageIcon(imagem);
	}
	
	private JLabel obtemLabelFormatada(String texto, int tamanho) {

		JLabel label = new JLabel();
		label.setFont(new Font("Arial Black", Font.PLAIN, tamanho));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setText(texto);
		return label;

	}

	public void exibirComponentes() {

		painelDeDados.removeAll();

		// ETAPAS E PARTES
		if (!etapas.getEtapas().isEmpty()) {
			for (Component componente : componentes.get(0)) {
				painelDeDados.add(componente);
			}
		}

		// MATERIAIS
		if (!materiais.getMateriais().isEmpty()) {
			for (Component componente : componentes.get(1)) {
				painelDeDados.add(componente);
			}
		}

		// EMPECILHOS
		if (!empecilhos.getEmpecilhos().isEmpty()) {
			for (Component componente : componentes.get(2)) {
				painelDeDados.add(componente);
			}
		}

		painelDeDados.revalidate();
		painelDeDados.repaint();
		
	}

	private void inserirEtapasComponentes() {
		int contadorDeEtapas = 1;
		int contadorDePartes = 1;

		List<String> etapasOrdenadas = new ArrayList<>(etapas.getEtapas().keySet());
		etapasOrdenadas.sort(Comparator.naturalOrder());

		for (String etapaAtual : etapasOrdenadas) {

			JLabel infoEtapas = obtemLabelFormatada(("ETAPA " + contadorDeEtapas), 25);
			infoEtapas.setIcon(definirIcone(0, 24, 24));
			infoEtapas.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(infoEtapas);

			novosComponentes.add(Box.createVerticalStrut(15));
			
			JButton etapa = capturarDadoComoBotao(etapaAtual);
			etapa.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(etapa);
			
			novosComponentes.add(Box.createVerticalStrut(15));
			
			List<String> partesOrdenadas = new ArrayList<>(etapas.getPartesDeEtapa(etapaAtual).keySet());
			partesOrdenadas.sort(Comparator.naturalOrder()); 
			
			for (String parteAtual : partesOrdenadas) {

				novosComponentes.add(Box.createVerticalStrut(15));

				JLabel infoPartes = obtemLabelFormatada(("PARTE " + contadorDePartes), 19);
				infoPartes.setIcon(definirIcone(3, 24, 24));
				infoPartes.setAlignmentX(Component.CENTER_ALIGNMENT);
				novosComponentes.add(infoPartes);

				novosComponentes.add(Box.createVerticalStrut(15));
				
				JButton parte = capturarDadoComoBotao(parteAtual);
				parte.setAlignmentX(Component.CENTER_ALIGNMENT);
				novosComponentes.add(parte);
				
				novosComponentes.add(Box.createVerticalStrut(15));

				JLabel infoValor = obtemLabelFormatada("VALOR:", 19);
				infoValor.setIcon(definirIcone(4, 24, 24));
				infoValor.setAlignmentX(Component.CENTER_ALIGNMENT);
				novosComponentes.add(infoValor);

				novosComponentes.add(Box.createVerticalStrut(15));
				
				JButton valor = capturarDadoComoBotao(
						(etapas.getValorParteEtapa(etapaAtual, parteAtual).toString() + "R$"));
				valor.setAlignmentX(Component.CENTER_ALIGNMENT);
				novosComponentes.add(valor);

				novosComponentes.add(Box.createVerticalStrut(15));
				
				contadorDePartes++;

			}

			contadorDePartes = 1;
			contadorDeEtapas++;

			novosComponentes.add(Box.createVerticalStrut(25));
		}

		componentes.put(0, new ArrayList<>(novosComponentes));
		novosComponentes.clear();

	}

	private void inserirMateriaisComponentes() {
		int contadorDeMateriais = 1;

		List<String> materiaisOrdenados = new ArrayList<>(materiais.getMateriais().keySet());
		materiaisOrdenados.sort(Comparator.naturalOrder());

		for (String materialAtual : materiaisOrdenados) {
			
			JLabel infoMateriais = obtemLabelFormatada(("MATERIAL " + contadorDeMateriais), 25);
			infoMateriais.setIcon(definirIcone(1, 24, 24));
			infoMateriais.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(infoMateriais);

			novosComponentes.add(Box.createVerticalStrut(15));
			
			JButton material = capturarDadoComoBotao(materialAtual);
			material.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(material);

			novosComponentes.add(Box.createVerticalStrut(15));
			
			JLabel infoValor = obtemLabelFormatada("VALOR:", 19);
			infoValor.setIcon(definirIcone(4, 24, 24));
			infoValor.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(infoValor);
			
			novosComponentes.add(Box.createVerticalStrut(15));

			JButton valor = capturarDadoComoBotao(materiais.getMateriais().get(materialAtual).toString() + "R$");
			valor.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(valor);

			contadorDeMateriais++;
			novosComponentes.add(Box.createVerticalStrut(25));

		}

		componentes.put(1, new ArrayList<>(novosComponentes));
		novosComponentes.clear();
		
	}

	private void inserirEmpecilhosComponentes() {
		int contadorDeEmpecilhos = 1;

		List<String> empecilhosOrdenados = new ArrayList<>(empecilhos.getEmpecilhos().keySet());
		empecilhosOrdenados.sort(Comparator.naturalOrder());

		for (String empecilhoAtual : empecilhosOrdenados) {

			JLabel infoEmpecilhos = obtemLabelFormatada(("EMPECILHO " + contadorDeEmpecilhos), 25);
			infoEmpecilhos.setIcon(definirIcone(2, 24, 24));
			infoEmpecilhos.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(infoEmpecilhos);
			
			novosComponentes.add(Box.createVerticalStrut(15));

			JButton empecilho = capturarDadoComoBotao(empecilhoAtual);
			empecilho.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(empecilho);

			novosComponentes.add(Box.createVerticalStrut(15));
			
			JLabel infoValor = obtemLabelFormatada("VALOR:", 19);
			infoValor.setIcon(definirIcone(4, 24, 24));
			infoValor.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(infoValor);

			novosComponentes.add(Box.createVerticalStrut(15));
			
			JButton valor = capturarDadoComoBotao(empecilhos.getEmpecilhos().get(empecilhoAtual).toString() + "R$");
			valor.setAlignmentX(Component.CENTER_ALIGNMENT);
			novosComponentes.add(valor);

			contadorDeEmpecilhos++;
			novosComponentes.add(Box.createVerticalStrut(25));

		}

		componentes.put(2, new ArrayList<>(novosComponentes));
		novosComponentes.clear();

	}

	private void adicionarTitulo(String titulo, int tipo) {

		novosComponentes.add(Box.createVerticalStrut(30));

		JLabel item = obtemLabelFormatada(titulo, 30);
		item.setIcon(definirIcone(tipo, 27, 27));
		novosComponentes.add(item);
		
		novosComponentes.add(Box.createVerticalStrut(30));

	}

	private JButton capturarDadoComoBotao(String dado) {

		JButton botao = new JButton();
		botao.setFont(new Font("Arial", Font.PLAIN, 17));
		botao.setAlignmentX(Component.CENTER_ALIGNMENT);
		botao.setText(dado);

		botao.addActionListener(e -> mostrarMenu(botao));

		return botao;

	}

	private void mostrarMenu(JButton botao) {

		MenuDeAcoes menu = new MenuDeAcoes(painelDeDados, botao);
		menu.getJFrame().setVisible(true);

	}

}
