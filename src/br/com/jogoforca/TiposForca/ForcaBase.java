package br.com.jogoforca.TiposForca;

import java.util.ArrayList;
import java.util.List;

import br.com.jogoforca.interfaces.Observer;
import br.com.jogoforca.interfaces.StrategyForca;

/**
 * The Class ForcaBase.
 */
public class ForcaBase implements StrategyForca, Observer {

	/** The nome. */
	private String nome;
	
	/** The acertos. */
	private int acertos;
	
	/** The erros. */
	private int erros;
	
	/** The palavra. */
	private String palavra;
	
	/** The max acertos. */
	private int maxAcertos;
	
	/** The desenho forca palavra. */
	private String desenhoForcaPalavra;
	
	/** The desenho forca. */
	private String desenhoForca;
	
	/** The chances restantes. */
	private int chancesRestantes;
	
	/** The forca. */
	StringBuilder forca;
	
	/** The letras usadas. */
	private List<Character> letrasUsadas;
	
	/**
	 * Instantiates a new forca base.
	 *
	 * @param palavra the palavra
	 */
	public ForcaBase(String palavra){
		setPalavra(palavra);
		setErros(0);
		setChancesRestantes(5);
		setAcertos(0);
		setLetrasUsadas(new ArrayList<Character>());
		System.out.println(desenhaForca());
	}
	
	/**
	 * Gets the palavra sem espaco. Método é necessário para palavras compostas
	 *
	 * @param palavra the palavra
	 * @return the palavra sem espaco
	 */
	public String getPalavraSemEspaco(String palavra) {
		return palavra.replaceAll(" ", "");
	}
	
	/**
	 * Desenha forca Inicial.
	 *
	 * @return the string
	 */
	public String desenhaForca(){
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------\n");
		sb.append("|                         |\n");
		sb.append("|              -----------|\n");
		sb.append("|              |          |\n");
		sb.append("|                         |\n");
		sb.append("|                         |\n");
		sb.append("|                         |\n");
		sb.append("|                         |\n");
		sb.append("|_________________________|\n");
		sb.append("\n");
		
		for(int i = 0; i < getPalavra().length(); i++){
			if( ' ' == getPalavra().charAt(i)){
				sb.append("  ");
			}
			else{
				sb.append("_ ");
			}
		}		
		return sb.toString();
		
	}
	
	/**
	 * Desenha forca de acordo com a quantidade de erros.
	 *
	 * @param erros qtde de erros
	 * @return String Desenho da forca
	 */
	public String desenhaForca(int erros){
		StringBuilder sb = new StringBuilder();

		sb.append("Para arriscar a palavra completa apenas digite seu palpite\n");
		sb.append("Erros: " + erros +" \t Chances Restantes: " + getChancesRestantes() + "\n");
		sb.append("--------------------------\n");
		sb.append("|                         |\n");
		sb.append("|              -----------|\n");
		sb.append("|              |          |\n");
		if(erros >= 1){
			sb.append("|              O          |\n");
			if (erros >= 2){
				if (erros >= 4){ 
					sb.append("|             /|\\         |\n");
				}
				else if (erros >= 3){
						sb.append("|             /|          |\n");
				} else {
					sb.append("|              |          |\n");
				}
				if (erros >= 5){
					if (erros >= 6){
						sb.append("|             / \\         |\n");
					} else {
						sb.append("|             /           |\n");
					}
				} else{
						sb.append("|                         |\n");
						sb.append("|_________________________|\n");
					}
			} else{
				sb.append("|                         |\n");
				sb.append("|                         |\n");
				sb.append("|_________________________|\n");
			}
		} else{
			sb.append("|                         |\n");
			sb.append("|                         |\n");
			sb.append("|                         |\n");
			sb.append("|_________________________|\n");
		}
		
		
		sb.append("\n");
			
		setDesenhoForca(sb.toString());	
		return getDesenhoForca();
	}
	
	/**
	 * Tenta palavra com todas as letras.
	 *
	 * @param palavra the palavra
	 * @return true, if successful
	 */
	public boolean tentaPalavra(String palavra){
		if(palavra.equals(getPalavra())){
			return true;
		}
		return false;
	}

	/**
	 * Gets the acertos.
	 *
	 * @return the acertos
	 */
	public int getAcertos() {
		return acertos;
	}

	/**
	 * Sets the acertos.
	 *
	 * @param acertos the new acertos
	 */
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	/**
	 * Gets the erros.
	 *
	 * @return the erros
	 */
	public int getErros() {
		return erros;
	}

	/**
	 * Sets the erros.
	 *
	 * @param erros the new erros
	 */
	public void setErros(int erros) {
		this.erros = erros;
	}

	/**
	 * Gets the palavra.
	 *
	 * @return the palavra
	 */
	public String getPalavra() {
		return palavra;
	}

	/**
	 * Sets the palavra.
	 *
	 * @param palavra the new palavra
	 */
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	/**
	 * Gets the max acertos.
	 *
	 * @return the max acertos
	 */
	public int getMaxAcertos() {
		return maxAcertos;
	}

	/**
	 * Sets the max acertos.
	 *
	 * @param maxAcertos the new max acertos
	 */
	public void setMaxAcertos(int maxAcertos) {
		this.maxAcertos = maxAcertos;
	}

	/**
	 * Gets the desenho forca palavra.
	 *
	 * @return the desenho forca palavra
	 */
	public String getDesenhoForcaPalavra() {
		return desenhoForcaPalavra;
	}

	/**
	 * Sets the desenho forca palavra.
	 *
	 * @param desenhoForcaPalavra the new desenho forca palavra
	 */
	public void setDesenhoForcaPalavra(String desenhoForcaPalavra) {
		this.desenhoForcaPalavra = desenhoForcaPalavra;
	}

	/**
	 * Gets the desenho forca.
	 *
	 * @return the desenho forca
	 */
	public String getDesenhoForca() {
		return desenhoForca;
	}

	/**
	 * Sets the desenho forca.
	 *
	 * @param desenhoForca the new desenho forca
	 */
	public void setDesenhoForca(String desenhoForca) {
		this.desenhoForca = desenhoForca;
	}

	/**
	 * Gets the chances restantes.
	 *
	 * @return the chances restantes
	 */
	public int getChancesRestantes() {
		return chancesRestantes;
	}

	/**
	 * Sets the chances restantes.
	 *
	 * @param chancesRestantes the new chances restantes
	 */
	public void setChancesRestantes(int chancesRestantes) {
		this.chancesRestantes = chancesRestantes;
	}

	/**
	 * Gets the forca.
	 *
	 * @return the forca
	 */
	public StringBuilder getForca() {
		return forca;
	}

	/**
	 * Sets the forca.
	 *
	 * @param forca the new forca
	 */
	public void setForca(StringBuilder forca) {
		this.forca = forca;
	}

	/**
	 * Gets the letras usadas.
	 *
	 * @return the letras usadas
	 */
	public List<Character> getLetrasUsadas() {
		return letrasUsadas;
	}

	/**
	 * Sets the letras usadas.
	 *
	 * @param letrasUsadas the new letras usadas
	 */
	public void setLetrasUsadas(List<Character> letrasUsadas) {
		this.letrasUsadas = letrasUsadas;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tentaLetra(char letra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String fazerJogada(char letra) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
