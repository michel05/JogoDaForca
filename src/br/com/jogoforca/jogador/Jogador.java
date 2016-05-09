package br.com.jogoforca.jogador;

import java.util.ArrayList;
import java.util.List;

import br.com.jogoforca.interfaces.Iterator;
import br.com.jogoforca.interfaces.Observable;
import br.com.jogoforca.interfaces.Observer;
import br.com.jogoforca.interfaces.StrategyForca;
import br.com.jogoforca.util.ObserversIterator;

/**
 * The Class Jogador.
 */
public class Jogador implements Observable {

	/** The observers. */
	private List<Observer> observers;
	
	/** The jogo forca. */
	StrategyForca jogoForca;
	
	
	/**
	 * Instantiates a new jogador.
	 */
	public Jogador() {
		observers = new ArrayList<Observer>();
	}
	
	/* 
	 * @see br.com.jogoforca.interfaces.Observable#registraObserver(br.com.jogoforca.interfaces.Observer)
	 */
	@Override 
	public void registraObserver(Observer obs) {
		observers.add(obs);
	}

	/* 
	 * @see br.com.jogoforca.interfaces.Observable#removeObserver(br.com.jogoforca.interfaces.Observer)
	 */
	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}

	/* 
	 * @see br.com.jogoforca.interfaces.Observable
	 * #notificaObservers(java.lang.Object)
	 */
	@Override
	public void notificaObservers(Object obj) {
		Iterator obsIterator = new ObserversIterator(observers);
		while (obsIterator.hasNext()) {
			Observer obs = (Observer) obsIterator.next();
			obs.update(obj);
		}
	}
	
}
