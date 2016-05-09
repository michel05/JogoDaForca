package br.com.jogoforca.TiposForca;

import java.util.ArrayList;
import java.util.List;

import br.com.jogoforca.interfaces.Observer;
import br.com.jogoforca.interfaces.StrategyForca;

/**
 * The Class ForcaLetraPorLetra.
 */
public class ForcaLetraPorLetra extends ForcaBase {

	/** The letras corretas. */
	List<Character> letrasCorretas = new ArrayList<Character>();
		
	/**
	 * Instantiates a new forca letra por letra.
	 * Seta o Nome padrao da Forca.
	 * Seta a quantidade máxima de acertos de acordo com a palavra
	 *
	 * @param palavra the palavra
	 */
	public ForcaLetraPorLetra(String palavra) {
		super(palavra);
		setNome("Forca Letra por Letra");
		setMaxAcertos(getPalavraSemEspaco(palavra).length());
	}

	/**
	 * Monta palavra oculta mostrando os as letras acertadas
	 */
	protected void montaPalavraOculta(){
		List<Character> letrasCorretasAux = new ArrayList<Character>();
		letrasCorretasAux.addAll(letrasCorretas);
		StringBuilder sb = new StringBuilder();
		
		for(int j = 0; j < getPalavra().length(); j++) {
			if ( ' ' == getPalavra().charAt(j)) {
				sb.append("  ");
			}
			else if(letrasCorretasAux.contains(getPalavra().charAt(j))
					&& !letrasCorretasAux.isEmpty()){
				sb.append(getPalavra().charAt(j) + " ");
				letrasCorretasAux.remove((Character) getPalavra().charAt(j));
			} else {
				sb.append("_ ");
			}
		}

		setDesenhoForcaPalavra(sb.toString());
	}
	
	/** 
	 * @see br.com.jogoforca.interfaces.StrategyForca
	 * #tentaLetra(char)
	 */
	@Override
	public boolean tentaLetra(char letra) {
		boolean flag = false;
		int ocorrenciaTotal = qtdeOcorrencia(letra);
		int ocorrencia = 0;
		for(int i = 0; i < getPalavra().length(); i++) {
			if (!flag){
				if (getPalavra().charAt(i) == letra) {
					 ocorrencia++;
					if (ocorrencia > ocorrenciaTotal) { 
						letrasCorretas.add(letra);	
						flag = true;
					}
				}
			}
		}
		
		montaPalavraOculta();
		return flag;
	}

	/**
	 * Qtde ocorrencia de uma letra nas Letras já ustilizadas.
	 *
	 * @param letra the letra
	 * @return the int
	 */
	protected int qtdeOcorrencia(char letra) {
		int ocorrencia = 0;
		for( int i = 0; i < getLetrasUsadas().size(); i++) {
			if(getLetrasUsadas().get(i).equals(letra)) {
				ocorrencia++;
			}
		}
		return ocorrencia;
	}
	
	/**
	 * Realiza a jogada desenhando a forca atualizada 
	 * 
	 * @see br.com.jogoforca.interfaces.StrategyForca
	 * #fazerJogada(char)
	 */
	@Override
	public String fazerJogada(char letra) {
		forca = new StringBuilder();
		
		if(!tentaLetra(letra)) {
			setChancesRestantes(getChancesRestantes() - 1);
			setErros(getErros() + 1);
		} else {
			setAcertos(getAcertos() + 1);
		}
		
		getLetrasUsadas().add(letra);
		
		forca.append(desenhaForca(getErros()));
		forca.append(getDesenhoForcaPalavra());
		
		return forca.toString();
	}

	
	/* (non-Javadoc)
	 * @see br.com.jogoforca.interfaces.Observer#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return getNome();
	}

	/**
	 * Atualiza o Desenho da Forca de acordo com a jogada atual
	 * 
	 * @see br.com.jogoforca.interfaces.Observer#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		String tentativa = (String) obj;
		if(tentativa.length() > 1){
			if(this.tentaPalavra(tentativa)){
				setDesenhoForca("\n");
				setAcertos(getMaxAcertos());
			}
			else {
				setErros(6);
			}
		}
		else {
			setDesenhoForca(this.fazerJogada(tentativa.charAt(0)));
			System.out.println(getDesenhoForca());
		}
	}

}
