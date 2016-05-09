package br.com.jogoforca.play;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import br.com.jogoforca.TiposForca.ForcaLetraPorLetra;
import br.com.jogoforca.TiposForca.ForcaRevelaTodas;
import br.com.jogoforca.interfaces.Observable;
import br.com.jogoforca.interfaces.Observer;
import br.com.jogoforca.jogador.Jogador;
import br.com.jogoforca.util.PalavraUtil;

/**
 * The Class Game.
 */
public class Game {
	
	/**
	 * The main method.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		
		Observable jogador = new Jogador(); 
		List<String> categorias = PalavraUtil.getCategorias();
		Observer observer = null;
		String palavra = null;
		
		
		int op = menu();
			if(op == 1){
				palavra = PalavraUtil.getPalavraArquivo("animal");
			}
			
			else if(op == 2){
				int opCat = menuCategoria(categorias);
				palavra = PalavraUtil.getPalavraArquivo(categorias.get(opCat-1));
				
			} else {
				System.exit(0);
			}
			
		op = menuForca();
			if(op == 1){
				observer = new ForcaLetraPorLetra(palavra);
				jogador.registraObserver(observer);
			}
			else if (op == 2){
				observer = new ForcaRevelaTodas(palavra);
				jogador.registraObserver(observer);
			}
			
		while(observer.getErros() < 6 && observer.getMaxAcertos() != observer.getAcertos() ){
			
			System.out.println("\nTente uma letra: ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
			  
				jogador.notificaObservers(in.readLine());
				
		}
		
		if(observer.getErros() == 6){
			System.out.println("\nVocê perdeu!");
			System.out.println("Palavra: " + palavra);
			System.exit(0);
		}
		else {
			System.out.println("\n Parabéns voce ganhou!");
		}
			
		
	}
	
	/**
	 * Menu Principal
	 *
	 * @return the int
	 */
	public static int menu(){
		int op = 0;
		
		StringBuilder msg = new StringBuilder();
		msg.append("------------ JOGO DA FORCA --------------\n");
		msg.append("\n");
		msg.append("Escolha uma opção:\n");
		msg.append("1 - INICIAR JOGO\n");
		msg.append("2 - ESCOLHER CATEGORIA\n");
		msg.append("3 - SAIR");
		
		
		System.out.println(msg.toString());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
		  
		try {
			op = Integer.parseInt(in.readLine());
			if(op > 3 || op < 1){
				System.out.println("Opção invalida!\n");
				menu();
			}
		} catch (NumberFormatException | IOException e) {
			for (int i = 0; i < 100; ++i){    
			    System.out.println(); }
			System.out.println("Opção invalida!\n");
			menu();
		}
		
		return op;
		
	}
	
	/**
	 * Menu das categoria.
	 *
	 * @param cat the cat
	 * @return the int
	 */
	public static int menuCategoria(List<String> cat){
		int op = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Escolha uma categoria:\n");
		for(int i = 1; i <= cat.size(); i++){
			sb.append(i + " - " + cat.get(i-1) + "\n");
		}
		
		System.out.println(sb.toString());
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			op = Integer.parseInt(in.readLine());
			if(op > cat.size() || op < 1){
				System.out.println("Opção invalida!\n");
				menu();
			}
		} catch (NumberFormatException | IOException e) {
			for (int i = 0; i < 50; ++i){    
			    System.out.println(); }
			System.out.println("Opção invalida!\n");
			menu();
		}
		
		return op;
	}
	
	/**
	 * Menu dos tipos de forca.
	 *
	 * @return the int
	 */
	public static int menuForca(){
		int op = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Escolha o tipo de Forca:\n");
		sb.append("1 - Forca Letra por Letra\n");
		sb.append("2 - Forca Revela Todas");
		
		System.out.println(sb.toString());
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			op = Integer.parseInt(in.readLine());
			if(op != 2 && op != 1){
				System.out.println("Opção invalida!\n");
				menu();
			}
		} catch (NumberFormatException | IOException e) {
			for (int i = 0; i < 50; ++i){    
			    System.out.println(); }
			System.out.println("Opção invalida!\n");
			menu();
		}
		return op;
		
	}

}
