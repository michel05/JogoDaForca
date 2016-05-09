package br.com.jogoforca.TiposForca;

/**
 * The Class ForcaRevelaTodas.
 */
public class ForcaRevelaTodas extends ForcaBase {

	/**
	 * Chama contrutor para setar valores padroes.
	 * Seta o Nome padrao da Forca.
	 * Seta a quantidade máxima de acertos de acordo com a palavra
	 *
	 * @param palavra the palavra
	 */
	public ForcaRevelaTodas(String palavra) {
		super(palavra);
		setNome("Forca Revela Todas");
		setMaxAcertos(getPalavraSemEspaco(palavra));
	}

	/** 
	 * @see br.com.jogoforca.interfaces.StrategyForca#fazerJogada(char)
	 */
	public String fazerJogada(char letra) {
		forca = new StringBuilder();
		
		boolean flag = false;
			if(getLetrasUsadas().contains(letra)){
				forca.append("Letra já usada!! \n\n");
				flag = true;
			}
		
		if(!flag){ 
			if(!tentaLetra(letra)){
				setChancesRestantes(getChancesRestantes() - 1);
				setErros(getErros() + 1);
			}
		}
		getLetrasUsadas().add(letra);		
		forca.append(desenhaForca(getErros()));
		forca.append(getDesenhoForcaPalavra());
		
		return forca.toString();
	}
	
	/** Verifica ocorrencia de uma letra. 
	 * Caso encontre uma palavra é acrescido a variável acertos
	 * e seta a flag para true.
	 * Se retornar true é porque foi encontrada uma letra
	 * 
	 * @param letra letra a ser verificada
	 * @return boolean true/false
	 */
	public boolean tentaLetra(char letra) {
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for(int i = 0; i < getPalavra().length(); i++) {
			if( ' ' == getPalavra().charAt(i)) {
				sb.append("  ");
			}
			else{
				 if(getLetrasUsadas().contains(getPalavra().charAt(i))){
						sb.append(getPalavra().charAt(i) + " ");
				 }
				
				 else if(getPalavra().charAt(i) == letra) {
					sb.append(letra + " ");	
					flag = true;
					setAcertos(getAcertos() +1);
					
				}
				else{
					sb.append("_ ");
				}
			}		
		}
		
		setDesenhoForcaPalavra(sb.toString());
		return flag;
	}
	
	/**
	 * Sets the max acertos.
	 * Método específico para verificar quantidade de 
	 * caracteres que não se repetem na palavra para
	 * setar a quantidade de acertos
	 *
	 * @param palavra the new max acertos
	 */
	public void setMaxAcertos(String palavra){
		String aux = palavra;
		int count = 0;
		if(palavra.contains("ss")){
			count++;
		}
		if(palavra.contains("rr")){
			count++;
		}
        aux = aux.replaceAll ("(([A-Za-z])(\\2)+)", "$2");  
		super.setMaxAcertos(aux.length() + count);
	}

	/**
	 * @see br.com.jogoforca.interfaces.Observer#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return getNome();
	}

	/** 
	 * @see br.com.jogoforca.interfaces.Observer#update(java.lang.Object)
	 * Executa a jogada sendo passada a letra
	 * 
	 * @param obj String letra a ser passada
	 * 
	 */
	@Override
	public void update(Object obj) {
		String tentativa = (String) obj;
		if(tentativa.length() > 1){
			if(this.tentaPalavra(tentativa)){
				setDesenhoForca("\n ");
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
