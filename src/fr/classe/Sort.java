package fr.classe;

public interface Sort {

	/**
	 * retourne le nom du sort
	 * @return
	 */
	public String getNom();
	
	/**
	 * retourne la definition
	 * @return
	 */
	public String getDefinition();
	
	/**
	 * Le client lui-m�me ne sait pas ce que fait cette m�thode (smiley se gratte le menton)
	 * @return
	 */
	public String information();
}
