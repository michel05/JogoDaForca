/**
 * 
 */
package br.com.jogoforca.testes;

import org.junit.Ignore;
import org.junit.Test;

import br.com.jogoforca.TiposForca.ForcaBase;
import br.com.jogoforca.TiposForca.ForcaRevelaTodas;

// TODO: Auto-generated Javadoc
/**
 * The Class ForcaTestes.
 *
 * @author Michel
 */
public class ForcaTestes {

	
	/**
	 * Teste especifico para a Classe ForcaRevelaTodas, para 
	 * verificar a qtde max de acertos, levando em conta caracteres repetidos
	 * pois será considerado a ocorrencia de todas letras na palavra como acerto.
	 * 
	 */
	@Ignore
	@Test
	public void testeMaxAcertos(){
		ForcaRevelaTodas revelatodas = new ForcaRevelaTodas("professor");
		revelatodas.setMaxAcertos("professor");
		System.out.println(revelatodas.getMaxAcertos());
	}
	
	/**
	 * Verifica se o desenho esta de acordo passando a quantidade
	 * de erros, 6 é o maximo de erros
	 */
	@Ignore
	@Test
	public void testeDesenhoForca(){
		ForcaBase forca = new ForcaBase("carpinteiro");
		System.out.println(forca.desenhaForca(3));
	}
	
	/**
	 * tenta palavra inteira.
	 * true para verdadeiro e false para falso
	 * 
	 */
	@Ignore
	@Test
	public void tentaPalavra(){
		ForcaBase forca = new ForcaBase("carpinteiro");
		System.out.println(forca.tentaPalavra("professor"));
	}
	
	/**
	 * tenta uma letra.
	 * true para verdadeiro e false para falso
	 * 
	 */
	@Test
	public void tentaletra(){
		ForcaBase forca = new ForcaRevelaTodas("professor");
		System.out.println(forca.tentaLetra('x'));
	}
	
	
	
	
	
	

}
