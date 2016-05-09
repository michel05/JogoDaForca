package br.com.jogoforca.interfaces;

/**
 * The Interface Observer.
 */
public interface Observer {
	 
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Gets the erros.
	 *
	 * @return the erros
	 */
	public int getErros();
	
	/**
	 * Gets the max acertos.
	 *
	 * @return the max acertos
	 */
	public int getMaxAcertos();
	
	/**
	 * Gets the acertos.
	 *
	 * @return the acertos
	 */
	public int getAcertos();
	
	/**
	 * Update.
	 *
	 * @param obj the obj
	 */
	public void update(Object obj);
	
}
