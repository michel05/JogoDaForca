package br.com.jogoforca.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface StrategyForca.
 */
public interface StrategyForca {
 
	/**
	 * Tenta letra.
	 *
	 * @param letra the letra
	 * @return true, if successful
	 */
	public boolean tentaLetra(char letra);

	/**
	 * Fazer jogada.
	 *
	 * @param letra the letra
	 * @return the string
	 */
	public String fazerJogada(char letra);

	/**
	 * Desenha forca.
	 *
	 * @return the string
	 */
	public String desenhaForca();
	
	/**
	 * Desenha forca.
	 *
	 * @param erros the erros
	 * @return the string
	 */
	public String desenhaForca(int erros);
}
