package br.com.jogoforca.interfaces;

/**
 * The Interface Observable.
 */
public interface Observable {
	 
	/**
	 * Registra observer.
	 *
	 * @param obs the obs
	 */
	public void registraObserver(Observer obs);
	
	/**
	 * Removes the observer.
	 *
	 * @param obs the obs
	 */
	public void removeObserver(Observer obs);
	
	/**
	 * Notifica observers.
	 *
	 * @param obj the obj
	 */
	public void notificaObservers(Object obj);
}
