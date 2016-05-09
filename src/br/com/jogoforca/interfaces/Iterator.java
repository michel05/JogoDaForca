package br.com.jogoforca.interfaces;

/**
 * The Interface Iterator.
 */
public interface Iterator {

	/**
	 * Checks for next.
	 *
	 * @return true, if successful
	 */
	boolean hasNext();
	
	/**
	 * Next.
	 *
	 * @return the object
	 */
	Object next();
}
