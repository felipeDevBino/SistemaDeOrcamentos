package br.com.felipedevbino.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.felipedevbino.gui.funcoesgui.Interacao;

public class Arquivo {

	private File arquivo;
	private Interacao interacao;

	protected Arquivo() {
		interacao = new Interacao();
	}
	
	protected void gerarArquivo(String nomeArquivo, String caminho) {
		
		arquivo = new File(caminho + nomeArquivo);

		if (arquivo.exists()) {
			interacao.mostrarMensagemDeAviso(String.format("DADOS SALVOS EM:\n(%s)", arquivo.getPath().toString()));
			return;
		}

		try {

			arquivo.createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}

		interacao.mostrarMensagemDeInformacao(
				String.format("ARQUIVO GERADO COM SUCESSO EM:\n(%s)", arquivo.getPath().toString()));

	}

	protected void inserirNoArquivoPermanen(String conteudo) {

		if (arquivo != null && arquivo.exists() && arquivo.canWrite()) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
				if(arquivo.length() > 0) {
					writer.write(System.lineSeparator());
				}
				writer.write(conteudo);

			} catch (IOException e) {
				e.printStackTrace();
				interacao.mostrarMensagemDeErro("ERRO AO TENTAR ESCREVER NO ARQUIVO.");
			}
		}

	}

	protected void inserirNoArquivoSobres(String conteudo) {

		if (arquivo != null && arquivo.exists() && arquivo.canWrite()) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
				if(arquivo.length() > 0) {
					writer.write(System.lineSeparator());
				}
				writer.write(conteudo);

			} catch (IOException e) {
				e.printStackTrace();
				interacao.mostrarMensagemDeErro("ERRO AO TENTAR ESCREVER NO ARQUIVO.");
			}
		}

	}
	
	protected String getConteudoArquivo() {
		
		StringBuilder conteudo = new StringBuilder();
		
		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			
			while((linha = leitor.readLine()) != null) {
				conteudo.append(linha).append(System.lineSeparator());
			}
			
			return conteudo.toString();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
