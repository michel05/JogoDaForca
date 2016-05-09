/**
 * 
 */
package br.com.jogoforca.util;

import java.util.List;

import br.com.jogoforca.interfaces.Iterator;
import br.com.jogoforca.interfaces.Observer;

/**
 * The Class ObserversIterator.
 *
 * @author Michel
 */
public class ObserversIterator implements Iterator {

	/** The observers. */
	List<Observer> observers;
	
	/** The posicao. */
	int posicao = 0;
	
	/**
	 * Instantiates a new observers iterator.
	 *
	 * @param observers the observers
	 */
	public ObserversIterator(List<Observer> observers) {
		this.observers = observers;
	}
	
	/** 
	 * Faz a verificação se existe um proximo valor na lista
	 * 
	 * @see br.com.jogoforca.interfaces.Iterator
	 * #hasNext()
	 */
	@Override
	public boolean hasNext() {
		if(posicao >= observers.size() || observers.get(posicao) == null){
			return false;
		}
		return true;
	}

	/**
	 * Pega o objeto atual da lista
	 * 
	 * @see br.com.jogoforca.interfaces.Iterator
	 * #next()
	 */
	@Override
	public Object next() {
		Observer observer = observers.get(posicao);
		posicao++;
		
		return observer;
	}

}
