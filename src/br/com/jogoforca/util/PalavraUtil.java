package br.com.jogoforca.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Class PalavraUtil.
 */
public class PalavraUtil {
	
	/** The Constant ARQUIVO. */
	private final static String ARQUIVO = "dados.txt";
	
	
	/**
	 * Busca uma lista com todas palavras relacionadas
	 * com a categoria passada
	 *
	 * @param categoria String
	 * @return palavras String[] lista de palavras
	 */
	@SuppressWarnings("resource")
	public static String getPalavraArquivo(String categoria){
		String[] palavras = null;
		String textoAux = "";
		
			try { 
				Scanner texto = new Scanner(new FileReader(ARQUIVO)).useDelimiter("\n");
				while(texto.hasNext()){
					textoAux = texto.next();
					if(textoAux.startsWith(categoria)){						
						palavras = textoAux.replaceAll(categoria + ": ", "").replace("\r", "").split(",");
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return getPalavraRandom(palavras);
	}
	
	/**
	 * Seleciona uma palavra da lista randomicamente
	 *
	 * @param palavras String[] array de palavras
	 * @return String palavra
	 */
	protected static String getPalavraRandom(String[] palavras){
		int indice = (int)(Math.random() * palavras.length);    
		return palavras[indice]; 
	}
	
	/**
	 * Busca uma lista com todas categorias de acordo com o arquivo txt
	 *
	 * @return categorias List<String> lista com todas categorias
	 */
	@SuppressWarnings({ "resource" })
	public static List<String> getCategorias(){
		List<String> categorias = new ArrayList<String>();
		String[] categoria = null;
		try { 
			Scanner texto = new Scanner(new FileReader(ARQUIVO)).useDelimiter("\n");
			while(texto.hasNext()){
				String textoAux = texto.next();
				categoria = textoAux.split(":", 2);
				categorias.add(categoria[0]);
			}
			return categorias;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return categorias;
	}
	

}
